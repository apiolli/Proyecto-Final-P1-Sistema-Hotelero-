/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import modelo.Administrador;
import modelo.Gestionable;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Connection;

/**
 *
 * @author Star_
 */
public class AdministradorDAO implements Gestionable<Administrador> {
    
    private Connection con;
    public AdministradorDAO(Administrador administrador){
        this.con = con;
    }
    
    @Override
    public int guardar(Administrador administrador) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Administrador"
        + "(nombre,apellido,nacionalidad,documento_identidad,fecha_nacimiento,telefono,"
        + "usuario,contrasena) VALUES(?,?,?,?,?,?,?,?)");
        ps.setString(1, administrador.getNombre());
        ps.setString(2, administrador.getApellido());
        ps.setString(3, administrador.getNacionalidad());
        ps.setString(4, administrador.getDocumentoIdentidad());
        ps.setLong(5, administrador.getFechaDeNacimiento());
        ps.setString(6, administrador.getTelefono());
        ps.setString(7, administrador.getUsuario());
        ps.setString(8, administrador.getContrasena());
        
        return ps.executeUpdate();
    }
    
}
