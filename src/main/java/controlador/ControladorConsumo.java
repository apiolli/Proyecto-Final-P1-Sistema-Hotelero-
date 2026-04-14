package controlador;

import dao.CheckDAO;
import dao.ConsumosDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Timer;
import modelo.Consumo;
import vista.consumo.DiagAggConsumo;
import vista.consumo.PanelConsumo;

public class ControladorConsumo {
    private ConsumosDAO dao;
    private PanelConsumo vista;
    private DiagAggConsumo diagAggConsumo;
    private CheckDAO checkDAO;
    private Timer timer;

    public ControladorConsumo(PanelConsumo vista, ConsumosDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }
    
    public void buscarReserva() {
        int noHabitacion = Integer.parseInt(diagAggConsumo.getCmbHab().getSelectedItem().toString());

        try {
            Object[] reserva = checkDAO.buscarReserva(noHabitacion);

            if (reserva != null) {
                diagAggConsumo.getTxtIDreserva().setText(String.valueOf(reserva[0])); // id
                diagAggConsumo.getTxtHuesped().setText((String) reserva[1]);          // huesped
            } else {
                diagAggConsumo.mostrarError("No se encontró reserva activa para esa habitación");
            }
        } catch (SQLException e) {
            diagAggConsumo.mostrarError("Error al buscar la reserva");
            System.out.println(e.getMessage());
        }
    }
    
    public void iniciar() {
        try {
            diagAggConsumo.getCmbHab().removeAllItems();
            ArrayList<Integer> habitaciones = checkDAO.cargarHabitacionesOcupadas();
            for (Integer hab : habitaciones) {
                diagAggConsumo.getCmbHab().addItem(String.valueOf(hab));
            }
        } catch (SQLException e) {
            diagAggConsumo.mostrarError("Error al cargar habitaciones");
        }
    }
    
    public void agregarConsumo() {
        int idReserva = Integer.valueOf(diagAggConsumo.getTxtIDreserva().getText());
        String descripcion = diagAggConsumo.getTxtDescripcion().getText();
        int cantidad = Integer.valueOf(diagAggConsumo.getSpCantidad().getValue().toString());
        double precio = Double.valueOf(diagAggConsumo.getTxtPrecio().getText());
        
        System.out.println("ID Reserva: " + idReserva);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);
        
        Consumo consumo = new Consumo(idReserva, descripcion, cantidad, precio);
        try {
            int respuesta = dao.guardar(consumo);
            if (respuesta > 0) {
                diagAggConsumo.mostrarExito("Consumo agregado con exito");
            }
            else {
                System.out.println(respuesta);
            }

        } catch (SQLException e) {
            diagAggConsumo.mostrarError("Ha ocurrido un error con la base de datos.");
            System.out.println(e.getMessage());
        }
        
        
    }
   

    public void setDiagAggConsumo(DiagAggConsumo diagAggConsumo) {
        this.diagAggConsumo = diagAggConsumo;
    }

    public void setCheckDAO(CheckDAO checkDAO) {
        this.checkDAO = checkDAO;
    }
    
    
    
    
    
    
}
