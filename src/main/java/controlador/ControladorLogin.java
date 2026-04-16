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

    public void validarUsuario(String usuario, String contrasena) {

        if (usuario == null || usuario.trim().isEmpty()
                || contrasena == null || contrasena.trim().isEmpty()) {
            vista.mostrarError("Debe completar usuario y contraseña");
            return;
        }

        try {
  
            modelo.personas.Empleado emp = dao.validarUsuario(usuario.trim(), contrasena.trim());
            
            if (emp != null) {
                // 1. Cerramos el login (vista actual)
                vista.dispose(); 
                
                // 2. Creamos y mostramos el MainFrame
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        MainFrame main = new MainFrame(new ContextoAplicacion());
                        main.configurarAccesos(emp.getNivelAcceso(), emp.getNombre());
                        
                        main.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); 
                        main.setVisible(true); // Hacemos visible el sistema
                        main.toFront(); 
                        main.requestFocus(); 
                        
                        // 3. Mostramos el mensaje AQUÍ ADENTRO, amarrado a 'main'
                        // Así, cuando le des "OK", te quedarás en el MainFrame
                        JOptionPane.showMessageDialog(
                            main, 
                            "¡Bienvenido al sistema, " + emp.getNombre() + "!", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                });
                
                // (OJO: Borra o comenta la línea antigua de vista.mostrarExito que tenías aquí abajo)

            } else {
                vista.mostrarError("Usuario o contraseña incorrectos.");
            }

        } catch (SQLException e) {
            vista.mostrarError("Error al conectar con la base de datos.");
            System.err.println("Error SQL: " + e.getMessage());
        }
    }

    public LoginDAO getDao() {
        return dao;
    }
}