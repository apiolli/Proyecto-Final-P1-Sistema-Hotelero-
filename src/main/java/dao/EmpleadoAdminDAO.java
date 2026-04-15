/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import modelo.personas.Empleado;
import modelo.interfaces.Gestionable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Star_
 */
public class EmpleadoAdminDAO implements Gestionable<Empleado> {
    
    private Connection con;
    public EmpleadoAdminDAO(Connection con){
        this.con=con;
    }
    
    @Override
    public int guardar(Empleado empleado) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios(nombre,apellido,cargo,usuario,contrasena,nivel_acceso)"
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(7, empleado.getCargo());
        ps.setString(9, empleado.getUsuario());
        ps.setString(10, empleado.getContrasena());
        ps.setString(12, empleado.getNivelAcceso());
        return ps.executeUpdate();      
    }
    
    public ArrayList<Object[]> buscarEmpleadoAdmin(String usuario) throws SQLException{
        ArrayList<Object[]> lista = new ArrayList<>();
        String sql= "SELECT id_usuario,nombre,apellido,cargo,usuario,contrasena,nivel_acceso FROM Usuarios where usuario=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            lista.add(new Object[]{
              rs.getInt("id_usuario"),
              rs.getString("nombre"),
              rs.getString("apellido"),
              rs.getString("cargo"),
              rs.getString("usuario"),
              rs.getString("contrasena"),   
              rs.getString("nivel_acceso")
            });
            return lista;
        }
       
        return null;
    }
    
    public Empleado eliminarEmpleadoAdmin(Empleado empleado) throws SQLException{
        String sql = "DELETE FROM Usuarios WHERE usuario=?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, empleado.getUsuario());
 
        int respuesta = ps.executeUpdate();
        
        if(respuesta > 0){
            return empleado;
        } else{
         return null;   
        }
      }
    } 
    
    public int editarEmpleadoAdmin(Empleado empleado) throws SQLException{
        PreparedStatement ps = con.prepareStatement("UPDATE Usuario SET nombre=?,apellido=?,cargo=?,usuario=?,contrasena=?,nivel_acceso=?");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(7, empleado.getCargo());
        ps.setString(9, empleado.getUsuario());
        ps.setString(10, empleado.getContrasena());
        ps.setString(12, empleado.getNivelAcceso());
        
        int respuesta = ps.executeUpdate();
        
        if(respuesta>0){
            return respuesta;
        }
        return -1;
    }
    
    public ArrayList<Object[]> cargarEmpleadoAdmin() throws SQLException {  
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("select id_usuario,nombre,apellido,cargo,usuario,contrasena,nivel_acceso from Usuarios");            
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("cargo"),
                rs.getString("usuario"),
                rs.getString("contrasena"),
                rs.getString("nivel_acceso")
            });
        }
         
        return lista;
        
    }
}
