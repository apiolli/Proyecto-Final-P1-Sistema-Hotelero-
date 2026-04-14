/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.CheckDAO;
import dao.HabitacionDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import vista.DiagAggHabitacion;
import vista.DiagEditarHabitacion;
import vista.PanelCheckInOut;
import vista.PanelHabitaciones;

/**
 *
 * @author DELL
 */
public class ControladorChecks {
//    private DiagAggHabitacion dialogo;
//    private DiagEditarHabitacion diagEditar;
    private CheckDAO dao;
    private PanelCheckInOut vista;
    private Timer timer;

    public ControladorChecks(PanelCheckInOut vista, CheckDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }
    
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
    
    
}
