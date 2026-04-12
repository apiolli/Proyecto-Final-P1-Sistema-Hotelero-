import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionSQL {

    private Connection con;

    public Connection getConexion() {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));

            String url  = props.getProperty("db.url");
            String usuario = props.getProperty("db.usuario");
            String contra = props.getProperty("db.contra");

            con = DriverManager.getConnection(url, usuario, contra);
            System.out.println("Conexión exitosa");

        } catch (IOException e) {
            System.out.println("No se encontró config.properties");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }

        return con;
    }
}