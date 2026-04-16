package conexion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static Connection con;

    public static Connection getConexion() {
        try {
            // Si la conexión está cerrada o es nula, intentamos conectar
            if (con == null || con.isClosed()) {
                Properties props = new Properties();
                
                // INTENTO 1: Buscar archivo externo al lado del .jar
                try (InputStream input = new FileInputStream("config.properties")) {
                    props.load(input);
                    System.out.println("Configuración cargada desde archivo externo.");
                } catch (IOException e) {
                    // INTENTO 2: Buscar dentro del JAR (src/main/resources)
                    try (InputStream input = Conexion.class.getClassLoader().getResourceAsStream("config.properties")) {
                        if (input != null) {
                            props.load(input);
                            System.out.println("Configuración cargada desde recursos internos.");
                        } else {
                            // INTENTO 3: Datos manuales (PLAN B FINAL)
                            System.out.println("Usando configuración por defecto (Hardcoded).");
                            props.setProperty("db.url", "jdbc:mysql://localhost:3306/hotel?useSSL=false&allowPublicKeyRetrieval=true");
                            props.setProperty("db.usuario", "root");
                            props.setProperty("db.contra", "2007"); // Pon tu clave aquí si tienes
                        }
                    }
                }

                String url = props.getProperty("db.url");
                String usuario = props.getProperty("db.usuario");
                String contra = props.getProperty("db.contra");

                // Cargamos el driver explícitamente para evitar errores en el JAR
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