package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.personas.Empleado; 

/**
 *
 * @author Star_
 */
public class LoginDAO {

    private Connection con;
    
    public LoginDAO(Connection con){
        this.con = con;
    }

    
    public Empleado validarUsuario(String usuario, String contrasena) throws SQLException {
        
       
        String sql = "SELECT * FROM Usuarios WHERE usuario = ? AND contrasena = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasena);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
           
                    return new Empleado(
                        rs.getInt("id_usuario"), 
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("cargo"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("nivel_acceso") 
                    );
                }
            }
        }
        return null; 
    }
}