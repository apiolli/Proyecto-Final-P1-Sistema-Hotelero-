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

    public ControladorChecks(PanelCheckInOut vista, CheckDAO dao) {
        this.vista = vista;
        this.dao = dao;
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
            // Gestionar Reserva
        }
 
    }
    
    public void seleccionarCheckIn() {
        int fila = vista.getTablaCheckin().getSelectedRow();
        if (fila == -1) {
            vista.mostrarError("Seleccione una reserva de la tabla primero.");
            return;
        }
        int id = (int) vista.getTablaCheckin().getValueAt(fila, 0);
        vista.setIdTabla(id);
            
        String[] opciones = {"Hacer Checkin", "Gestionar CheckIn"};

        int respuesta = JOptionPane.showOptionDialog(
            null,                          
            "¿Qué deseas hacer?",          
            "Opciones de CheckIn",         
            JOptionPane.DEFAULT_OPTION,    
            JOptionPane.QUESTION_MESSAGE,  
            null,                          
            opciones,                      
            opciones[0]                    
        );

        if (respuesta == 0) {
            hacerCheckIn(id);
        } else if (respuesta == 1) {
            // Gestionar Reserva
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
    
    
}
