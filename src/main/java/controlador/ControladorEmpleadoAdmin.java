/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.EmpleadoAdminDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import modelo.personas.Empleado;
import vista.gestionUsuarios.DiagAggUsuarioAdmin;
import vista.gestionUsuarios.DiagEditarUsuarioAdmin;
import vista.gestionUsuarios.PanelGestionUsuarios;
/**
 *
 * @author Star_
 */
public class ControladorEmpleadoAdmin {
    private PanelGestionUsuarios vista;
    private DiagAggUsuarioAdmin diagAgg;
    private DiagEditarUsuarioAdmin diagEdit;
    private EmpleadoAdminDAO dao;
    private Timer timer;
    
    public ControladorEmpleadoAdmin(PanelGestionUsuarios vista, EmpleadoAdminDAO dao){
      this.vista=vista;
      this.dao=dao;
    }
    
    public void registrarEmpleadoAdmin(){
        String nombre = diagAgg.getNombre();
        String apellido = diagAgg.getApellido();
        String cargo = diagAgg.getCargo();
        String usuario = diagAgg.getUsuario();
        String contrasena = diagAgg.getContrasena();
        String nivelAcceso = diagAgg.getNivelAcceso();
        
        try{
         int respuesta = dao.guardar(new Empleado(nombre,apellido,cargo,usuario,contrasena,nivelAcceso));
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
        String nombre = diagEdit.getNombre();
        String apellido = diagEdit.getApellido();
        String cargo = diagEdit.getCargo();
        String usuario = diagEdit.getUsuario();
        String contrasena = diagEdit.getContrasena();
        String nivelAcceso = diagEdit.getNivelAcceso();
        
        try{
         int respuesta = dao.editarEmpleadoAdmin(new Empleado(nombre,apellido,cargo,usuario,contrasena,nivelAcceso));
            if(respuesta > 0){
            diagEdit.mostrarExito("El usuario se ha editado con éxito");
        }
            else{
                diagEdit.mostrarError("No se ha podido editar el usuario");
            }
        }catch(SQLException e){
           System.out.println(e.getMessage());
           diagEdit.mostrarError("Ha ocurrido un error al editar al usuario, intente nuevamente");
        }
        
    }
    
    public void eliminarEmpleadoAdmin(int id){
      try{
          boolean eliminado= dao.eliminarEmpleadoAdmin(id);
          
          if(eliminado){
              vista.mostrarExito("Usuario eliminado");
          }else{
              vista.mostrarError("Error al eliminar usuario");
          }
      }catch(SQLException e){
          vista.mostrarError("Ha ocurrido un error al eliminar el usuario, intente nuevamente");
          
      }
    }
    
    public void buscarEmpleadoAdmin(JTextField usuario, JTable tabla){
        try{
            
            ArrayList<Object[]> usuarioEmpleado = dao.buscarEmpleadoAdmin(usuario.getText());
            DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
            modeloTabla.setRowCount(0);
            
            for (Object[] nombre : usuarioEmpleado) {
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
    public void setDiagEdit(DiagEditarUsuarioAdmin diagEdit){
        this.diagEdit=diagEdit;
    }
    
    
    public EmpleadoAdminDAO getDao() {
        return dao;
    }
    
    
    
    
    
}
