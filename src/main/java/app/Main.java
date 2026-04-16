package app;

import vista.Login;
import controlador.ControladorLogin;

public class Main {
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login vistaLogin = new Login();
                
                java.sql.Connection con = conexion.Conexion.getConexion();
                
                dao.LoginDAO daoLogin = new dao.LoginDAO(con);

                ControladorLogin controlador = new ControladorLogin(vistaLogin, daoLogin);
                               
                vistaLogin.setControlador(controlador);
            
                vistaLogin.setVisible(true);
            }
        });
    }
}