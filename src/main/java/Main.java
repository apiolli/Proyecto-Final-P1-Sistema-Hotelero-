
import java.sql.Connection;
import javax.swing.SwingUtilities;
import vista.Login;
import vista.MainFrame;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        
                // Login
//                java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
                
                // MainFrame
            SwingUtilities.invokeLater(() -> {
                new MainFrame().setVisible(true);
        });
            
        ConexionSQL con = new ConexionSQL();
        con.getConexion();
                


    }
    
}
