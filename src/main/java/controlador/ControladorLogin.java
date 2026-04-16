/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package controlador;

import dao.LoginDAO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import vista.Login;
import vista.MainFrame;
import app.ContextoAplicacion;

/**
 *
 * @author Star_
 */
public class ControladorLogin {
    
    private Login vista;
    private LoginDAO dao;

    public ControladorLogin(Login vista, LoginDAO dao){
        this.vista = vista;
        this.dao = dao;
    }

    public void validarUsuario(String usuario, String contrasena){
        
        if(usuario == null || usuario.trim().isEmpty() ||  
           contrasena == null || contrasena.trim().isEmpty()){
            vista.mostrarError("Debe completar usuario y contraseña");
            return; 
        }

        try {
           
            boolean valido = dao.validarUsuario(usuario.trim(), contrasena.trim());

            if (valido) {
                vista.mostrarExito("¡Bienvenido al sistema, " + usuario + "!");                        
                vista.dispose(); 
                
               
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new MainFrame(new ContextoAplicacion()).setVisible(true);
                    }
                });

            } else {
                vista.mostrarError("Usuario o contraseña incorrectos.");
            }
            
        } catch(SQLException e) {
            vista.mostrarError("Error al conectar con la base de datos.");
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    public LoginDAO getDao() {
        return dao;
    }
}