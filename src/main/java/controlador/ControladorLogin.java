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
                
                vista.dispose(); 
                
                
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        MainFrame main = new MainFrame(new ContextoAplicacion());
                        main.configurarAccesos(emp.getNivelAcceso(), emp.getNombre());
                        
                        main.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); 
                        main.setVisible(true);
                        main.toFront(); 
                        main.requestFocus(); 
                   
                        JOptionPane.showMessageDialog(
                            main, 
                            "¡Bienvenido al sistema, " + emp.getNombre() + "!", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                });
                

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