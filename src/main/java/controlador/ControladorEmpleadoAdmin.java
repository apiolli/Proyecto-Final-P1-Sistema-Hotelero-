/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EmpleadoAdminDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.personas.Empleado;
import vista.gestionUsuarios.DiagAggUsuarioAdmin;
import vista.gestionUsuarios.PanelGestionUsuarios;
/**
 *
 * @author Star_
 */
public class ControladorEmpleadoAdmin {
    private PanelGestionUsuarios vista;
    private DiagAggUsuarioAdmin diagAgg;
    private EmpleadoAdminDAO dao;
    private Timer timer;
    
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
        String nivelAcceso = diagAgg.getNivelAcceso();
        
        try{
         int respuesta = dao.guardar(new Empleado(nombre,apellido,nacionalidad,documento,
         fechaNacimiento,telefono,cargo,sueldo,usuario,contrasena,fechaIngreso,nivelAcceso));
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
    public void editarEmpleadoAdmin(){
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
        String nivelAcceso = diagAgg.getNivelAcceso();
        
        try{
         int respuesta = dao.editarEmpleadoAdmin(new Empleado(nombre,apellido,nacionalidad,documento,
         fechaNacimiento,telefono,cargo,sueldo,usuario,contrasena,fechaIngreso,nivelAcceso));
            if(respuesta > 0){
            diagAgg.mostrarExito("El usuario se ha editado con éxito");
        }
            else{
                diagAgg.mostrarError("No se ha podido editar el usuario");
            }
        }catch(SQLException e){
           System.out.println(e.getMessage());
           diagAgg.mostrarError("Ha ocurrido un error al editar al usuario, intente nuevamente");
        }
        
    }
    
    public void buscarEmpleadoAdmin(JTextField usuario, JTable tabla){
        try{
            
            ArrayList<Object[]> nombreEmpleado = dao.buscarEmpleadoAdmin(usuario.getText());
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.setRowCount(0);
            
            for (Object[] nombre : nombreEmpleado) {
                modeloTabla.addRow(nombre);
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar los usuarios");
        }
    }

    
    public void cargarTabla(JTable tabla) {
        try{
            ArrayList<Object[]> usuarios = dao.cargarEmpleadoAdmin();
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.setRowCount(0);
            
            for (Object[] user : usuarios) {
                modeloTabla.addRow(user);
            }
            
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            vista.mostrarError("Error al cargar los usuarios");
        }
    }
    
    public void iniciar(JTable tabla) {
        cargarTabla(tabla);
        
        timer = new Timer(5000, e -> cargarTabla(tabla));
        timer.start();
    }

    public void setDiagAgg(DiagAggUsuarioAdmin diagAgg) {
        this.diagAgg = diagAgg;
    }
    
    
    public EmpleadoAdminDAO getDao() {
        return dao;
    }
    
    
    
    
    
}
