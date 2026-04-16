/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
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
 
@author Star_*/
public class LoginDAO {

    private Connection con;
    public LoginDAO(Connection con){
        this.con=con;
    }

    public boolean validarUsuario(Empleado empleado) throws SQLException{
    String sql = "SELECT 1 FROM Usuarios WHERE usuario=? AND contrasena=?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, empleado.getUsuario());
        ps.setString(2, empleado.getContrasena());

        try (ResultSet rs = ps.executeQuery()) {
           return rs.next();
            }
        }

    }
}