/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EmpleadoAdminDAO;
import java.sql.SQLException;
import modelo.Empleado;
import vista.DiagAggUsuarioAdmin;
import vista.PanelGestionUsuarios;
/**
 *
 * @author Star_
 */
public class ControladorEmpleadoAdmin {
    private PanelGestionUsuarios vista;
    private DiagAggUsuarioAdmin diagAgg;
    private EmpleadoAdminDAO dao;
    
    public ControladorEmpleadoAdmin(PanelGestionUsuarios vista, EmpleadoAdminDAO dao){
      this.vista=vista;
      this.dao=dao;
    }
    
    public void registrarEmpleadoAdmin(){
        String documento = diagAgg.getDocumento();
        String nombre = diagAgg.getNombre();
        String apellido = diagAgg.getApellido();
        long fechaNacimiento = diagAgg.getFechaNacimiento();
        String nacionalidad = diagAgg.getNacionalidad();
        String cargo = diagAgg.getCargo();
        double sueldo = Double.parseDouble(diagAgg.getSueldo());
        String telefono = diagAgg.getTelefono();
        String usuario = diagAgg.getUsuario();
        String contrasena = diagAgg.getContrasena();
        long fechaIngreso = diagAgg.getFechaIngreso();
        
        try{
         int respuesta = dao.guardar(new Empleado(nombre,apellido,nacionalidad,documento,
         fechaNacimiento,telefono,cargo,sueldo,usuario,contrasena,fechaIngreso));
            if(respuesta > 0){
            diagAgg.mostrarExito("El usuario se ha agregado con exito");
        }
            else{
                diagAgg.mostrarError("No se ha podido registrar el usuario");
            }
        }catch(SQLException e){
           System.out.println(e.getMessage());
           diagAgg.mostrarError("Ha ocurrido un error al registrar al usuario, intente nuevamente");
        }
        
    }

    public EmpleadoAdminDAO getDao() {
        return dao;
    }

    public void setDiagAgg(DiagAggUsuarioAdmin diagAgg) {
        this.diagAgg = diagAgg;
    }
    
    
    
}
