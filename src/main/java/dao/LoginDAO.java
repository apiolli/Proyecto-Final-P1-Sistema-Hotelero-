/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Star_
 */
public class LoginDAO {

    private Connection con;
    
    public LoginDAO(Connection con){
        this.con = con;
    }

    public boolean validarUsuario(String usuario, String contrasena) throws SQLException {
        
        String sql = "SELECT 1 FROM Usuarios WHERE usuario = ? AND contrasena = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {

                return rs.next(); 
            }
        }
    }
}