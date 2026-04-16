package controlador;

import dao.HabitacionDAO;
import dao.HuespedDAO;
import dao.ReservaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.personas.Huesped;
import vista.reservas.DiagCrearReserva;
import vista.reservas.DiagEditarReserva; 
import vista.habitaciones.DiagEditarHabitacion;
import vista.reservas.PanelReservas;
import vista.checkInOut.DiagRegistrarCheckIn;

public class ControladorReserva {

    private DiagCrearReserva diagCrear;
    private DiagEditarReserva diagEditarReserva; 
    private DiagEditarHabitacion diagEditar;
    private DiagRegistrarCheckIn diagCheckIn;
    private PanelReservas vista;
    private ReservaDAO dao;
    private HuespedDAO huespedDAO;
    private HabitacionDAO habitacionDAO;
    private Timer timer;

    public ControladorReserva(PanelReservas vista, ReservaDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public boolean crearReserva() {
        try {
            int idHuesped = diagCrear.getTxtID();
            String numHabSeleccionada = diagCrear.getHabDisponibles();
            int noHabitacion = Integer.parseInt(numHabSeleccionada);
            int numPersonas = diagCrear.getSpNoPersonas();

            int capacidadMaxima = habitacionDAO.obtenerCapacidad(noHabitacion);

            if (numPersonas > capacidadMaxima) {
                vista.mostrarError("Esa cantidad (" + numPersonas + ") excede la capacidad de la habitación (Máximo: " + capacidadMaxima + ").");
                return false; 
            }
            
            int idHabitacion = habitacionDAO.buscarIdPorNumero(noHabitacion);
            if (idHabitacion == -1) {
                vista.mostrarError("No se encontró el ID de la habitación seleccionada");
                return false;
            }

            long fechaEntrada = diagCrear.getFechaEntrada();
            long fechaSalida = diagCrear.getFechaSalida();
            double dineroAbonado = diagCrear.getDineroAbonado();

            int respuesta = dao.guardarConIds(idHuesped, idHabitacion, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);

            if (respuesta > 0) {
                vista.mostrarExito("Reserva creada correctamente");
                iniciar(vista.getTablaReservas()); // Actualiza la tabla automáticamente
                return true; 
            } else {
                vista.mostrarError("No se pudo crear la reserva");
                return false; 
            }

        } catch (NumberFormatException e) {
            System.err.println("Error de formato: " + e.getMessage());
            vista.mostrarError("Datos numéricos inválidos");
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            vista.mostrarError("Error al conectar con la base de datos");
            return false;
        }
    }

    public void buscarHuesped(JTextField nombre, JTextField apellido,
                              JTextField documento, JTextField id) {
        try {
            int idHuesped = huespedDAO.buscarIdPorDocumento(documento.getText());
            if (idHuesped == -1) {
                vista.mostrarError("No existe un huésped con ese documento");
                return;
            }
            documento.setEditable(false);

            Huesped hues = huespedDAO.buscarNombreApellido(idHuesped);
            if (hues == null) {
                vista.mostrarError("Error al obtener datos del huésped");
                return;
            }

            nombre.setText(hues.getNombre());
            apellido.setText(hues.getApellido());
            id.setText(String.valueOf(idHuesped));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            vista.mostrarError("Error al buscar huésped");
        }
    }

   public void buscarHabitacionesDisponibles() {
        try {
            String tipo = diagCrear.getTipoHab();
            int numPersonas = diagCrear.getSpNoPersonas();

            ArrayList<Integer> disponibles = habitacionDAO.buscarDisponiblesPorTipoYCapacidad(tipo, numPersonas);

            if (disponibles.isEmpty()) {
                vista.mostrarError("No hay habitaciones de tipo " + tipo + " con capacidad para " + numPersonas + " personas.");
                
                diagCrear.cargarHabitacionesDisponibles(new ArrayList<>()); 
                return;
            }

            diagCrear.cargarHabitacionesDisponibles(disponibles);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            vista.mostrarError("Error al buscar habitaciones disponibles.");
        }
    }

    public void cargarReservas(JTable tabla) {
       
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Nadie puede escribir directamente en la tabla
            }
        };
        
        modeloTabla.setColumnIdentifiers(new Object[]{
            "ID", "Huesped", "Total personas", "Habitacion", 
            "Fecha entrada", "Fecha salida", "Fecha reserva", "Estado", "Dinero abonado"
        });

        tabla.setModel(modeloTabla);
        modeloTabla.setRowCount(0);

        try {
            ArrayList<Object[]> lista = dao.cargarReservas();
            for (Object[] reserva : lista) {
                modeloTabla.addRow(reserva);
            }
            
            vista.actualizarContador(modeloTabla.getRowCount());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar los datos");
        }
    }
    
    public void iniciar(JTable tabla) {
        cargarReservas(tabla);
        
        timer = new Timer(5000, e -> cargarReservas(tabla));
        timer.start();
    }
    

    public void setDiagCrear(DiagCrearReserva diagCrear) {
        this.diagCrear = diagCrear;
    }

    public void setDiagCheckIn(DiagRegistrarCheckIn diagCheckIn) {
        this.diagCheckIn = diagCheckIn;
    }

    public void setDiagEditar(DiagEditarHabitacion diagEditar) {
        this.diagEditar = diagEditar;
    }

    public boolean crearReservaCheckIn() {
        
        
        try {
            int idHuesped = diagCheckIn.getTxtID();
            String numHabSeleccionada = diagCheckIn.getHabDisponibles();
            int noHabitacion = Integer.parseInt(numHabSeleccionada);
            int numPersonas = diagCheckIn.getSpNoPersonas();

            int capacidadMaxima = habitacionDAO.obtenerCapacidad(noHabitacion);
            if (numPersonas > capacidadMaxima) {
                diagCheckIn.mostrarError("Esa cantidad (" + numPersonas + ") excede la capacidad de la habitación (Máximo: " + capacidadMaxima + ").");
                return false;
            }

            int idHabitacion = habitacionDAO.buscarIdPorNumero(noHabitacion);
            if (idHabitacion == -1) {
                diagCheckIn.mostrarError("No se encontró el ID de la habitación seleccionada.");
                return false;
            }

            boolean ocupada = habitacionDAO.estaOcupada(idHabitacion);
            if (ocupada) {
                diagCheckIn.mostrarError("La habitación seleccionada ya está Ocupada.");
                return false;
            }

            long fechaEntrada = diagCheckIn.getFechaEntrada();
            long fechaSalida  = diagCheckIn.getFechaSalida();
            double dineroAbonado = diagCheckIn.getDineroAbonado();

            int respuesta = dao.guardarConIds(idHuesped, idHabitacion, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);

            if (respuesta > 0) {
                dao.marcarCheckInInmediato(respuesta, idHabitacion);
                diagCheckIn.mostrarExito("CheckIn registrado correctamente.");
                return true;
            } else {
                diagCheckIn.mostrarError("No se pudo registrar el CheckIn.");
                return false;
            }

        } catch (NumberFormatException e) {
            diagCheckIn.mostrarError("Datos numéricos inválidos.");
            return false;
        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
            diagCheckIn.mostrarError("Error al conectar con la base de datos.");
            return false;
        }
    }

    public void buscarHabitacionesDisponiblesCheckIn() {
        try {
            String tipo = diagCheckIn.getTipoHab();
            int numPersonas = diagCheckIn.getSpNoPersonas();

            ArrayList<Integer> disponibles = habitacionDAO.buscarDisponiblesPorTipoYCapacidad(tipo, numPersonas);

            if (disponibles.isEmpty()) {
                diagCheckIn.mostrarError("No hay habitaciones de tipo " + tipo + " con capacidad para " + numPersonas + " personas.");
                diagCheckIn.cargarHabitacionesDisponibles(new ArrayList<>());
                return;
            }

            diagCheckIn.cargarHabitacionesDisponibles(disponibles);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            diagCheckIn.mostrarError("Error al buscar habitaciones disponibles.");
        }
    }

    public void buscarHuespedCheckIn(javax.swing.JTextField nombre, javax.swing.JTextField apellido,
                                      javax.swing.JTextField documento, javax.swing.JTextField id) {
        try {
            int idHuesped = huespedDAO.buscarIdPorDocumento(documento.getText());
            if (idHuesped == -1) {
                diagCheckIn.mostrarError("No existe un huésped con ese documento.");
                return;
            }
            documento.setEditable(false);

            modelo.personas.Huesped hues = huespedDAO.buscarNombreApellido(idHuesped);
            if (hues == null) {
                diagCheckIn.mostrarError("Error al obtener datos del huésped.");
                return;
            }

            nombre.setText(hues.getNombre());
            apellido.setText(hues.getApellido());
            id.setText(String.valueOf(idHuesped));

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            diagCheckIn.mostrarError("Error al buscar huésped.");
        }
    }

    public void setHuespedDAO(HuespedDAO huespedDAO) {
        this.huespedDAO = huespedDAO;
    }

    public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
        this.habitacionDAO = habitacionDAO;
    }
    
    public void filtrarReservas(String estado) {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }

        JTable tabla = vista.getTablaReservas();
        
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) { 
                return false; 
            }
        };
        
        modeloTabla.setColumnIdentifiers(new Object[]{
            "ID", "Huesped", "Total personas", "Habitacion", 
            "Fecha entrada", "Fecha salida", "Fecha reserva", "Estado", "Dinero abonado"
        });

        tabla.setModel(modeloTabla);
        modeloTabla.setRowCount(0);

        try {
            ArrayList<Object[]> lista = dao.obtenerReservasPorEstado(estado); 
            
            for (Object[] reserva : lista) {
                modeloTabla.addRow(reserva);
            }
            
            vista.actualizarContador(modeloTabla.getRowCount());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al filtrar las reservas: " + e.getMessage());
        }
    }

    
    // --- REEMPLAZA ESTE MÉTODO EN TU ControladorReserva ---
    public void abrirEdicionReserva(int id, String huesped, java.util.Date fEntrada, java.util.Date fSalida, int personas, String hab, double abono) {
    if (timer != null && timer.isRunning()) timer.stop(); 
    
    java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(vista);
    DiagEditarReserva dialog = new DiagEditarReserva(parent, true);
    this.diagEditarReserva = dialog; 
    dialog.setControlador(this);
    
    try {
        // Buscamos el documento que no estaba en la tabla
        String documento = dao.obtenerDocumentoPorReserva(id);
        
        // Enviamos los datos a la ventana, incluyendo el documento recuperado
        dialog.cargarDatos(id, documento, huesped, fEntrada, fSalida, personas, hab, abono);
    } catch (SQLException e) {
        vista.mostrarError("Error al recuperar el documento: " + e.getMessage());
    }
    
    dialog.setVisible(true);
    iniciar(vista.getTablaReservas()); 
    }
    public boolean editarReserva(int idReserva) {
        try {
            long fechaEntrada = diagEditarReserva.getFechaEntrada();
            long fechaSalida = diagEditarReserva.getFechaSalida();
            int numPersonas = diagEditarReserva.getSpNoPersonas();
            int noHabitacion = Integer.parseInt(diagEditarReserva.getHabDisponibles());
            double dineroAbonado = diagEditarReserva.getDineroAbonado();
            
            int capacidadMaxima = habitacionDAO.obtenerCapacidad(noHabitacion);
            if (numPersonas > capacidadMaxima) {
                vista.mostrarError("La cantidad excede la capacidad máxima (" + capacidadMaxima + " personas).");
                return false; 
            }

            int idHabitacion = habitacionDAO.buscarIdPorNumero(noHabitacion);
            
            int respuesta = dao.editar(idReserva, idHabitacion, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);
            
            if (respuesta > 0) {
                vista.mostrarExito("Reserva actualizada correctamente.");
                return true;
            } else {
                vista.mostrarError("No se pudo actualizar la reserva.");
                return false;
            }
            
        } catch (SQLException e) {
            vista.mostrarError("Error de base de datos al actualizar: " + e.getMessage());
            return false;
        }
    }

    public void eliminarReserva(int idReserva) {
        try {
            int respuesta = dao.eliminar(idReserva);
            
            if (respuesta > 0) {
                vista.mostrarExito("Reserva eliminada con éxito.");
                iniciar(vista.getTablaReservas()); 
            } else {
                vista.mostrarError("No se encontró la reserva en la base de datos.");
            }
        } catch (SQLException e) { 
            vista.mostrarError("Error de base de datos al eliminar: " + e.getMessage());
        }
    }
    
    public void buscarHabitacionesDisponiblesEdicion() {
        try {
            String tipo = diagEditarReserva.getTipoHab();
            int numPersonas = diagEditarReserva.getSpNoPersonas(); 

            ArrayList<Integer> disponibles = habitacionDAO.buscarDisponiblesPorTipoYCapacidad(tipo, numPersonas);

            if (disponibles.isEmpty()) {
                vista.mostrarError("No hay habitaciones de tipo " + tipo + " para " + numPersonas + " personas.");
                diagEditarReserva.cargarHabitacionesDisponibles(new ArrayList<>()); 
                return;
            }

            diagEditarReserva.cargarHabitacionesDisponibles(disponibles);

        } catch (SQLException e) {
            vista.mostrarError("Error al buscar habitaciones.");
        }
    }
}