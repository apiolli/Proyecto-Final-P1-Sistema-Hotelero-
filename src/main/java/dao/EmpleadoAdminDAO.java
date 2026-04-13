/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import modelo.Empleado;
import modelo.Gestionable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios"
        + "(nombre,apellido,nacionalidad,documento_identidad,fecha_nacimiento,telefono,"
        + "cargo,sueldo,usuario,contrasena,fecha_ingreso) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getNacionalidad());
        ps.setString(4, empleado.getDocumentoIdentidad());
        ps.setDate(5, new Date(empleado.getFechaDeNacimiento()));
        ps.setString(6, empleado.getTelefono());
        ps.setString(7, empleado.getCargo());
        ps.setDouble(8, empleado.getSueldo());
        ps.setString(9, empleado.getUsuario());
        ps.setString(10, empleado.getContrasena());
        ps.setDate(11, new Date(empleado.getFechaIngreso()));
        return ps.executeUpdate();      
    }
    
    public Empleado buscarEmpleadoAdminPorCorreo(String correo) throws SQLException{
        String sql= "SELECT id, nombre, usuario, contrasena FROM Usuarios where correo=?";
        
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, correo);
            
            try(ResultSet rs= ps.executeQuery()){
                if(rs.next()){
                    rs.getInt("id");
                    rs.getString("nombre");
                    rs.getString("usuario");
                    rs.getString("contrasena");
                    
                }
            }
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
        PreparedStatement ps = con.prepareStatement("UPDATE Usuario SET nombre=? ,apellido=?,nacionalidad=?,"
        + "documento_identidad=?,fecha_nacimiento=?,telefono=?,cargo=?,sueldo=?,usuario=?,contrasena=?,fecha_ingreso=?");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getNacionalidad());
        ps.setString(4, empleado.getDocumentoIdentidad());
        ps.setDate(5, new Date(empleado.getFechaDeNacimiento()));
        ps.setString(6, empleado.getTelefono());
        ps.setString(7, empleado.getCargo());
        ps.setDouble(8, empleado.getSueldo());
        ps.setString(9, empleado.getUsuario());
        ps.setString(10, empleado.getContrasena());
        ps.setDate(11, new Date(empleado.getFechaIngreso()));
        
        int respuesta = ps.executeUpdate();
        
        if(respuesta>0){
            return respuesta;
        }
        return -1;
    }
}
