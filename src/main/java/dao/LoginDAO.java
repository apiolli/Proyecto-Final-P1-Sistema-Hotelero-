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
import javax.swing.JOptionPane;
import modelo.interfaces.Mensajes;
/**
 *
 * @author Star_
 */
public class LoginDAO {

    private Connection con;
    
    public LoginDAO(Connection con){
        this.con=con;
    }
    
    public int validarUsuario(Empleado empleado) throws SQLException{
        String sql = "SELECT usuario,contrasena from Usuarios WHERE usuario=?,contrasena=?";
        try (PreparedStatement ps= con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                rs.getString("usuario");
                rs.getString("contrasena");
            }
        }
        return -1;
    }
}
