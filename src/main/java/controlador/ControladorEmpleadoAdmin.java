/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EmpleadoAdminDAO;
import java.sql.SQLException;
import modelo.Empleado;
import vista.DiagAggUsuarioAdmin;
/**
 *
 * @author Star_
 */
public class ControladorEmpleadoAdmin {
    private DiagAggUsuarioAdmin vista;
    private EmpleadoAdminDAO dao;
    
    public ControladorEmpleadoAdmin(DiagAggUsuarioAdmin vista, EmpleadoAdminDAO dao){
      this.vista=vista;
      this.dao=dao;
    }
    
    public void registrarEmpleadoAdmin(){
        String documento = vista.getDocumento();
        String nombre = vista.getNombre();
        String apellido = vista.getApellido();
        long fechaNacimiento = vista.getFechaNacimiento();
        String nacionalidad = vista.getNacionalidad();
        String cargo = vista.getCargo();
        double sueldo = Double.parseDouble(vista.getSueldo());
        String telefono = vista.getTelefono();
        String usuario = vista.getUsuario();
        String contrasena = vista.getContrasena();
        long fechaIngreso = vista.getFechaIngreso();
        
        try{
         int respuesta = dao.guardar(new Empleado(nombre,apellido,nacionalidad,documento,
         fechaNacimiento,telefono,cargo,sueldo,usuario,contrasena,fechaIngreso));
            if(respuesta > 0){
            vista.mostrarExito("El usuario se ha agregado con exito");
        }
            else{
                vista.mostrarError("No se ha podido registrar el usuario");
            }
        }catch(SQLException e){
           System.err.println(e.getMessage());
           vista.mostrarError("Ha ocurrido un error al registrar al usuario, intente nuevamente");
        }
        
    }
    
}
