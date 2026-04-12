package controlador;

import dao.HabitacionDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;
import modelo.HabitacionDeluxe;
import modelo.HabitacionDoble;
import modelo.HabitacionIndividual;
import modelo.HabitacionSuite;
import vista.DiagAggHabitacion;
import vista.PanelHabitaciones;

public class ControladorHabitacion {
    private DiagAggHabitacion dialogo;
    private HabitacionDAO dao;
    private PanelHabitaciones vista;

    public ControladorHabitacion(PanelHabitaciones vista, HabitacionDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }
    
    public void agregarHabitacion() {
        int noHabitacion = dialogo.getNumeroHab();
        String tipo = dialogo.getTipo();
        String estado = dialogo.getEstado();
        double precioNoche = dialogo.getPrecio();
        String nivel = dialogo.getNivel();
        int capacidad  = dialogo.getCapacidad();
        String telefono = dialogo.getTelefono();
        
        try {
            int respuesta = 0;
            switch (tipo) {
                case "Individual" -> respuesta = dao.guardar(new HabitacionIndividual(noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono));
                case "Doble" -> respuesta = dao.guardar(new HabitacionDoble(noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono));
                case "Suite" -> respuesta = dao.guardar(new HabitacionSuite(noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono));
                case "Deluxe" -> respuesta = dao.guardar(new HabitacionDeluxe(noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono));
            }
            
            if (respuesta > 0) {
                dialogo.mostrarExito("La habitacion ha sigo agregada con exito!");
                cargarHabitaciones();
            }
            else {
                dialogo.mostrarError("Error al agregar la habitacion, ingrese nuevamente los datos");
            }
            
        } catch (SQLException e) {
            dialogo.mostrarError("Ha ocurrido un error al registrar la habitacion.");
            System.out.println(e.getMessage());
        }
        
    }
    
    public void cargarHabitaciones() {
        try {
            var lista =  dao.cargarHabitaciones();
            vista.cargarHabitaciones(lista);

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar las habitaciones");
        }
    }

    public void setDialogo(DiagAggHabitacion dialogo) {
        this.dialogo = dialogo;
    }
    
    
    
    
}
