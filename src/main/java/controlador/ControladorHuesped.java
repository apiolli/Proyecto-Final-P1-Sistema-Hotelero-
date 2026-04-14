package controlador;

import dao.HuespedDAO;
import java.sql.SQLException;
import modelo.personas.Huesped;
import vista.reservas.DiagRegistrarHuesped;

public class ControladorHuesped {
    private DiagRegistrarHuesped vista;
    private HuespedDAO dao;

    public ControladorHuesped(DiagRegistrarHuesped vista, HuespedDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }
    
    public void registrarHuesped() {
        String nombre = vista.getNombre();
        String apellido = vista.getApellido();
        String nacionalidad = vista.getNacionalidad();
        String documentoIdentidad = vista.getDocumento();
        long fecha = vista.getFechaNacimiento();
        String telefono = vista.getTelefono();
        
        try {
            int respuesta = dao.guardar(new Huesped(nombre, apellido, nacionalidad, documentoIdentidad, fecha, telefono));
            if (respuesta > 0) {
                vista.mostrarExito("El cliente se ha agregado con exito!");
            }
            else {
                vista.mostrarError("No se ha podido registrar el cliente");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            vista.mostrarError("Ha ocurrido un error al agregar el cliente, intente nuevamente");

        }
    }
}
