package controlador;

import dao.HabitacionDAO;
import java.sql.SQLException;
import modelo.Habitacion;
import modelo.HabitacionDeluxe;
import modelo.HabitacionDoble;
import modelo.HabitacionIndividual;
import modelo.HabitacionSuite;
import vista.DiagAggConsumo;
import vista.DiagAggHabitacion;
import vista.DiagEditarHabitacion;
import vista.PanelHabitaciones;

public class ControladorHabitacion {
    private DiagAggHabitacion dialogo;
    private DiagEditarHabitacion diagEditar;
    private HabitacionDAO dao;
    private PanelHabitaciones vista;

    public ControladorHabitacion(PanelHabitaciones vista, HabitacionDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public ControladorHabitacion(HabitacionDAO dao) {
        this.dao = dao;
    }
    

    public void agregarHabitacion() {
        int noHabitacion = dialogo.getNumeroHab();
        String tipo = dialogo.getTipo();
        String estado = dialogo.getEstado();
        double precioNoche = dialogo.getPrecio();
        String nivel = dialogo.getNivel();
        int capacidad = dialogo.getCapacidad();
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
                dialogo.mostrarExito("La habitacion ha sido agregada con exito!");
                cargarHabitaciones();
            } else {
                dialogo.mostrarError("Error al agregar la habitacion, ingrese nuevamente los datos");
            }

        } catch (SQLException e) {
            dialogo.mostrarError("Ha ocurrido un error al registrar la habitacion.");
            System.out.println(e.getMessage());
        }
    }

    public void cargarHabitaciones() {
        try {
            var lista = dao.cargarHabitaciones();
            vista.cargarHabitaciones(lista);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar las habitaciones");
        }
    }
    
    public void llenarDatos(int num) {
        try {
            Habitacion hab = dao.buscarHabitacion(num);
            diagEditar.getTxtNumero().setText(String.valueOf(hab.getNumHabitacion()));
            diagEditar.getTxtPrecio().setText(String.valueOf(hab.getPrecioNoche()));
            diagEditar.getCmbEstado().setSelectedItem(hab.getEstado());
            diagEditar.getCmbTipo().setSelectedItem(hab.getTipo());
            diagEditar.getSpNivel().setValue(Integer.valueOf(hab.getNivel()));
            diagEditar.getSpCapacidad().setValue(Integer.valueOf(hab.getCapacidad()));
            diagEditar.getTxtID().setText(String.valueOf(hab.getId()));
            diagEditar.getTxtTelefono().setText(hab.getTelefonoHabitacion());
            
        } catch (SQLException e) {
            vista.mostrarError("Error al mostrar los datos");
            System.out.println(e.getMessage());
        }
    }
    
    public void eliminarHabitacion() {
        int noHabitacion = Integer.valueOf(diagEditar.getTxtNumero().getText());

        try {
            int respuesta = dao.eliminar(noHabitacion);

            if (respuesta > 0) {
                diagEditar.mostrarExito("La habitacion ha sido eliminada con exito!");
                cargarHabitaciones();
            } else {
                diagEditar.mostrarError("La habitacion no existe.");
            }

        } catch (SQLException e) {
            diagEditar.mostrarError("Ha ocurrido un error al registrar la habitacion.");
            System.out.println(e.getMessage());
        }
    }
    
    public void editarHabitacion() {
        int numero = Integer.valueOf(diagEditar.getTxtNumero().getText());
        double precio = Double.valueOf(diagEditar.getTxtPrecio().getText());
        String estado = diagEditar.getCmbEstado().getSelectedItem().toString();
        String tipo = diagEditar.getCmbTipo().getSelectedItem().toString();
        String nivel = diagEditar.getSpNivel().getValue().toString();
        int capacidad = Integer.valueOf(diagEditar.getSpCapacidad().getValue().toString());
        int id = Integer.valueOf(diagEditar.getTxtID().getText());
        String telefono = diagEditar.getTxtTelefono().getText();
        
        
        try {
            int respuesta = 0;
            switch (tipo) {
                case "Individual" -> respuesta = dao.editar(new HabitacionIndividual(id, nivel, numero, tipo, estado, precio, capacidad, telefono));
                case "Doble" -> respuesta = dao.editar(new HabitacionDoble(id, nivel, numero, tipo, estado, precio, capacidad, telefono));
                case "Suite" -> respuesta = dao.editar(new HabitacionSuite(id, nivel, numero, tipo, estado, precio, capacidad, telefono));
                case "Deluxe" -> respuesta = dao.editar(new HabitacionDeluxe(id, nivel, numero, tipo, estado, precio, capacidad, telefono));
            }

            if (respuesta > 0) {
                diagEditar.mostrarExito("La habitacion ha sido editada con exito!");
                cargarHabitaciones();
            } else {
                diagEditar.mostrarError("Error al editar la habitacion, ingrese nuevamente los datos");
                System.out.println(estado);
                System.out.println(respuesta);
            }

        } catch (SQLException e) {
            diagEditar.mostrarError("Ha ocurrido un error de SQL.");
            System.out.println(e.getMessage());
        }
        
    }

    public void setDialogo(DiagAggHabitacion dialogo) {
        this.dialogo = dialogo;
    }

    public void setDiagEditar(DiagEditarHabitacion diagEditar) {
        this.diagEditar = diagEditar;
    }
    
    
    
    
}