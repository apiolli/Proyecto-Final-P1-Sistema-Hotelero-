/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package controlador;

import dao.LoginDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.personas.Empleado;
import vista.Login;
/**
 *
 
@author Star_*/
public class ControladorLogin {
    private Login vista;
    private LoginDAO dao;


    public ControladorLogin(Login vista, LoginDAO dao){
        this.vista=vista;
        this.dao=dao;
    }

    public void validarUsuario(String usuario, String contrasena){
        if(usuario==null|| usuario.trim().isEmpty()||  
        contrasena==null|| contrasena.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe completar usuario y contraseña", "Ventana de validación", JOptionPane.ERROR_MESSAGE);
        }

        try{
            Empleado emp = new Empleado();
            emp.setUsuario(usuario.trim());
            emp.setContrasena(contrasena.trim());

            boolean valido = dao.validarUsuario(emp);

            if(valido){
                vista.mostrarExito("Login validado"); 
            }else{
                vista.mostrarError("Fallo de autenticación");
            }
        }catch(SQLException e){
            vista.mostrarError("Error de validación, intente nuevamente");
            System.out.println("Error SQL" + e.getMessage());
        }
    }

    public LoginDAO getDao() {
        return dao;
    }
}