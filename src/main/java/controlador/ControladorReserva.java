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
import vista.habitaciones.DiagEditarHabitacion;
import vista.reservas.PanelReservas;

public class ControladorReserva {

    private DiagCrearReserva diagCrear;
    private DiagEditarHabitacion diagEditar;
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

            // --- VALIDACIÓN DE CAPACIDAD ---
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
            ArrayList<Integer> disponibles = habitacionDAO.buscarDisponiblesPorTipo(tipo);

            if (disponibles.isEmpty()) {
                vista.mostrarError("No hay habitaciones disponibles de tipo: " + tipo);
                return;
            }

            diagCrear.cargarHabitacionesDisponibles(disponibles);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            vista.mostrarError("Error al buscar habitaciones disponibles");
        }
    }

    public void cargarReservas(JTable tabla) {
    
    DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Esto bloquea todas las celdas de todas las columnas
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

    public void setDiagEditar(DiagEditarHabitacion diagEditar) {
        this.diagEditar = diagEditar;
    }

    public void setHuespedDAO(HuespedDAO huespedDAO) {
        this.huespedDAO = huespedDAO;
    }

    public void setHabitacionDAO(HabitacionDAO habitacionDAO) {
        this.habitacionDAO = habitacionDAO;
    }
}