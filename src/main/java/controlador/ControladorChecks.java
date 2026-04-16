package controlador;

import dao.CheckDAO;
import dao.HabitacionDAO;
import dao.HuespedDAO;
import dao.ReservaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import vista.checkInOut.DiagRegistrarCheckIn;
import vista.checkInOut.PanelCheckInOut;

public class ControladorChecks {
    private CheckDAO dao;
    private PanelCheckInOut vista;
    private Timer timer;
    private HuespedDAO huespedDAO;
    private HabitacionDAO habitacionDAO;
    private ReservaDAO reservaDAO;
    private vista.checkInOut.DiagEditarCheckIn diagEditarCheckIn;

    public ControladorChecks(PanelCheckInOut vista, CheckDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }
    
    public void abrirEdicionCheckIn(int idReserva) {
        try {
    
            Object[] datos = dao.obtenerDatosCompletosPorId(idReserva);
            
            if (datos != null) {
                java.awt.Frame parent = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(vista);
                vista.checkInOut.DiagEditarCheckIn dialog = new vista.checkInOut.DiagEditarCheckIn(parent, true);
                
                this.diagEditarCheckIn = dialog; 
                dialog.setControlador(this); 
                String doc = (String) datos[0];
                String huesped = (String) datos[1];
                java.util.Date fEntrada = (java.util.Date) datos[2];
                java.util.Date fSalida = (java.util.Date) datos[3];
                int personas = (int) datos[4];
                String hab = (String) datos[5];
                double abono = (double) datos[6];
                
         
                dialog.cargarDatos(idReserva, doc, huesped, fEntrada, fSalida, personas, hab, abono);
                dialog.setVisible(true);
                
             
            } else {
                vista.mostrarError("No se encontraron los datos de la estadía.");
            }
        } catch (SQLException e) {
            vista.mostrarError("Error al consultar la base de datos: " + e.getMessage());
        }
    }

    public void setHuespedDAO(HuespedDAO huespedDAO) { this.huespedDAO = huespedDAO; }
    public void setHabitacionDAO(HabitacionDAO habitacionDAO) { this.habitacionDAO = habitacionDAO; }
    public void setReservaDAO(ReservaDAO reservaDAO) { this.reservaDAO = reservaDAO; }
    
    public void cargarCheckIns(JTable tabla) {   
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            
            ArrayList<Object[]> lista = dao.cargarCheckin(vista.getIdTabla());
            for (Object[] reserva : lista) {
                modeloTabla.addRow(reserva);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar los datos");
        }

    }
    
    public void iniciarCheckin(JTable tabla) {
        cargarCheckIns(tabla);
        
        timer = new Timer(5000, e -> cargarCheckIns(tabla));
        timer.start();
    }
    
    public void cargarCheckouts(JTable tabla) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);

        try {
            
            ArrayList<Object[]> lista = dao.hacerCheckout(vista.getIdTabla());
            for (Object[] reserva : lista) {
                modeloTabla.addRow(reserva);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar los datos");
        }
    }
    
    public void iniciarCheckouts(JTable tabla) {
        cargarCheckouts(tabla);
        
        timer = new Timer(5000, e -> cargarCheckouts(tabla));
        timer.start();
    }
    
    public void hacerCheckIn(int id) {
        
        try {
            boolean ocupada = dao.habitacionEstaOcupada(id);
            if (ocupada) {
                vista.mostrarError("No se puede hacer Check-In: la habitación ya está Ocupada.");
                return;
            }

            int respuesta = dao.ejecutarCheckin(id);
            
            if (respuesta > 0) {
                vista.mostrarExito("Check In Realizado! \n Habitacion marcada como ocupada.");
            }
            else {
                vista.mostrarError("No se ha podido realizar el checkin.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error critico del sistema");
        }
        
    }
    
    public void hacerCheckOut(int id) {
        
        try {
            int respuesta = dao.ejecutarCheckOut(id);
            
            if (respuesta > 0) {
                vista.mostrarExito("Check Out Realizado! \nHabitacion marcada como Disponible\nFacturacion pendiente.");
            }
            else {
                vista.mostrarError("No se ha podido realizar el checkin.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error critico del sistema");
        }
        
    }
    
    public void seleccionarCheckOut() {
        int fila = vista.getTablaCheckout().getSelectedRow();
        if (fila == -1) {
            vista.mostrarError("Seleccione una reserva de la tabla primero.");
            return;
        }
        int id = (int) vista.getTablaCheckout().getValueAt(fila, 0);
        vista.setIdTabla(id);


        String[] opciones = {"Hacer CheckOut", "Gestionar CheckOut"};

        int respuesta = JOptionPane.showOptionDialog(
            null,                          
            "¿Qué deseas hacer?",          
            "Opciones de CheckOut",        
            JOptionPane.DEFAULT_OPTION,    
            JOptionPane.QUESTION_MESSAGE,  
            null,                          
            opciones,                      
            opciones[0]                    
        );

        if (respuesta == 0) {
            hacerCheckOut(id);
        } else if (respuesta == 1) {
            
        }
 
    }
    
   public void seleccionarCheckIn() {
       
        javax.swing.JTable tabla = vista.getTablaCheckin();
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            return; 
        }

        
        int idReserva = (int) tabla.getValueAt(fila, 0);

      
        Object[] opciones = {"Hacer Checkin", "Gestionar CheckIn"};

     
        int seleccion = javax.swing.JOptionPane.showOptionDialog(
                vista,
                "¿Qué deseas hacer?",
                "Opciones de CheckIn",
                javax.swing.JOptionPane.DEFAULT_OPTION,
                javax.swing.JOptionPane.QUESTION_MESSAGE,
                new javax.swing.ImageIcon(getClass().getResource("/img/check-in.png")), // Opcional: tu icono
                opciones,
                opciones[0]
        );

     
        if (seleccion == 0) {
         
            System.out.println("Haciendo checkin directo para el ID: " + idReserva);
            
        } else if (seleccion == 1) {
           
            abrirEdicionCheckIn(idReserva);
        }
    }
    public void abrirDialogCrearCheckIn() {
        DiagRegistrarCheckIn diag = new DiagRegistrarCheckIn(
            (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(vista), true
        );

        diag.setFechaEntradaHoy();

        ControladorReserva controladorReserva = new ControladorReserva(null, reservaDAO);
        
        controladorReserva.setHuespedDAO(huespedDAO);
        controladorReserva.setHabitacionDAO(habitacionDAO);
        controladorReserva.setDiagCheckIn(diag);
        diag.setControlador(controladorReserva);
        diag.setVisible(true);
    }
    
    // --- METODOS DE EDICION Y CHECKOUT ---
    public boolean editarCheckIn(int idReserva, int idHabitacionAntigua) {
        try {
            long fechaEntrada = diagEditarCheckIn.getFechaEntrada();
            long fechaSalida = diagEditarCheckIn.getFechaSalida();
            int numPersonas = diagEditarCheckIn.getSpNoPersonas();
            int noHabitacionNueva = Integer.parseInt(diagEditarCheckIn.getHabDisponibles());
            double dineroAbonado = diagEditarCheckIn.getDineroAbonado();
            
            int idHabitacionNueva = habitacionDAO.buscarIdPorNumero(noHabitacionNueva);
            
            if (idHabitacionNueva != idHabitacionAntigua) {
                habitacionDAO.actualizarEstado(idHabitacionAntigua, "Disponible");
                habitacionDAO.actualizarEstado(idHabitacionNueva, "Ocupada");
            }

            int respuesta = dao.editar(idReserva, idHabitacionNueva, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);
            
            if (respuesta > 0) {
                vista.mostrarExito("Check-In actualizado correctamente.");
                return true;
            }
            return false;
            
        } catch (java.sql.SQLException e) {
            vista.mostrarError("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public void procesarCheckOut(int idReserva, int idHabitacion) {
        try {
            dao.actualizarEstadoReserva(idReserva, "Completada");
            habitacionDAO.actualizarEstado(idHabitacion, "Disponible");
            vista.mostrarExito("Check-Out completado. Habitación liberada.");
            // iniciar(vista.getTablaCheckout()); // Recarga la tabla si tienes este método
        } catch (java.sql.SQLException e) { 
            vista.mostrarError("Error al realizar el Check-Out: " + e.getMessage());
        }
    }

  
    public void buscarHuespedCheckIn(javax.swing.JTextField nombre, javax.swing.JTextField apellido, javax.swing.JTextField documento, javax.swing.JTextField id) {
        try {
            int idHuesped = huespedDAO.buscarIdPorDocumento(documento.getText());
            if (idHuesped == -1) {
                diagEditarCheckIn.mostrarError("No existe un huésped con ese documento.");
                return;
            }
            documento.setEditable(false);
            modelo.personas.Huesped hues = huespedDAO.buscarNombreApellido(idHuesped);
            nombre.setText(hues.getNombre());
            apellido.setText(hues.getApellido());
            id.setText(String.valueOf(idHuesped));
        } catch (java.sql.SQLException e) {
            diagEditarCheckIn.mostrarError("Error al buscar huésped.");
        }
    }

    public void buscarHabitacionesDisponiblesCheckIn() {
        try {
            String tipo = diagEditarCheckIn.getTipoHab();
            int numPersonas = diagEditarCheckIn.getSpNoPersonas();
            java.util.ArrayList<Integer> disponibles = habitacionDAO.buscarDisponiblesPorTipoYCapacidad(tipo, numPersonas);
            if (disponibles.isEmpty()) {
                diagEditarCheckIn.mostrarError("No hay habitaciones disponibles.");
                diagEditarCheckIn.cargarHabitacionesDisponibles(new java.util.ArrayList<>());
                return;
            }
            diagEditarCheckIn.cargarHabitacionesDisponibles(disponibles);
        } catch (java.sql.SQLException e) {
            diagEditarCheckIn.mostrarError("Error al buscar habitaciones.");
        }
    }
    
    
    
    
}
