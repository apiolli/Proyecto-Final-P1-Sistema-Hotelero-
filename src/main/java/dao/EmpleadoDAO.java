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

/**
 *
 * @author Star_
 */
public class EmpleadoDAO implements Gestionable<Empleado> {
    
    private Connection con;
    public EmpleadoDAO(Connection con){
        this.con=con;
    }
    
    @Override
    public int guardar(Empleado empleado) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Empleado"
        + "(nombre,apellido,nacionalidad,documento_identidad,fecha_nacimiento,telefono,"
        + "cargo,sueldo,usuario,contrasena,fecha_ingreso) "
        + "VALUES(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getNacionalidad());
        ps.setString(4, empleado.getDocumentoIdentidad());
        ps.setLong(5, empleado.getFechaDeNacimiento());
        ps.setString(6, empleado.getTelefono());
        ps.setString(7, empleado.getCargo());
        ps.setDouble(8, empleado.getSueldo());
        ps.setString(9, empleado.getUsuario());
        ps.setString(10, empleado.getContrasena());
        ps.setLong(11, empleado.getFechaIngreso());
        return ps.executeUpdate();
        
    }
    
}
