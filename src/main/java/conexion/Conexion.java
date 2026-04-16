package conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexion {
    private static Connection con;

    public static Connection getConexion() {
        try {
            if (con == null || con.isClosed()) {
                Properties props = new Properties();
                
                try (InputStream input = new FileInputStream("config.properties")) {
                    props.load(input);
                    System.out.println("Configuración cargada desde archivo externo.");
                } catch (IOException e) {
                    try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties")) {
                        if (input != null) {
                            props.load(input);
                            System.out.println("Configuración cargada desde recursos internos.");
                        } else {
                            System.out.println("Usando configuración por defecto (Hardcoded).");
                            props.setProperty("db.url", "jdbc:mysql://localhost:3306/hotel?useSSL=false&allowPublicKeyRetrieval=true");
                            props.setProperty("db.usuario", "root");
                            // Ingrese su contraseña aqui
                            props.setProperty("db.contra", "cesar02"); 
                        }
                    }
                }

                String url = props.getProperty("db.url");
                String usuario = props.getProperty("db.usuario");
                String contra = props.getProperty("db.contra");

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, usuario, contra);
                System.out.println("Conexión exitosa a: " + url);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver de MySQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error general en la conexión");
            e.printStackTrace();
        }
        return con;
    }
}