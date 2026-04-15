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
            } else {
                diagAgg.mostrarError("No se ha podido registrar el usuario");
            }
        }catch(SQLException e){
           System.out.println(e.getMessage());
           diagAgg.mostrarError("Ha ocurrido un error al registrar al usuario, intente nuevamente");
        }
    }

    public void editarEmpleadoAdmin() {
        int id = diagEdit.getIdUsuario(); 
        
        String nombre = diagEdit.getNombre();
        String apellido = diagEdit.getApellido();
        String cargo = diagEdit.getCargo();
        String usuario = diagEdit.getUsuario();
        String contrasena = diagEdit.getContrasena();
        String nivelAcceso = diagEdit.getNivelAcceso();
        
        try {
            
            int respuesta = dao.editar(new Empleado(id, nombre, apellido, cargo, usuario, contrasena, nivelAcceso));
            
            if (respuesta > 0) {
                diagEdit.mostrarExito("¡Usuario actualizado correctamente!");
            } else {
                diagEdit.mostrarError("No se pudo actualizar el usuario.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            diagEdit.mostrarError("Error de base de datos al editar.");
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
    
    public void cargarDatosParaEdicion(int id) {
        try {
         
            Empleado empleado = dao.buscarPorId(id); 
            
            if (empleado != null) {
                diagEdit.setNombre(empleado.getNombre());
                diagEdit.setApellido(empleado.getApellido());
                diagEdit.setCargo(empleado.getCargo());
                diagEdit.setUsuario(empleado.getUsuario());
                diagEdit.setContrasena(empleado.getContrasena());
                diagEdit.setNivelAcceso(empleado.getNivelAcceso());
            }
        } catch (SQLException e) {
            System.err.println("Error al cargar usuario: " + e.getMessage());
            diagEdit.mostrarError("Error al cargar los datos del usuario.");
        }
    }
}