package app;

import conexion.Conexion;
import dao.HuespedDAO;
import java.sql.Connection;


public class ContextoAplicacion {
    private static HuespedDAO huespedDAO;

    public ContextoAplicacion() {
        Connection con = Conexion.getConexion();
        huespedDAO = new HuespedDAO(con);
    }

    public HuespedDAO getHuespedDAO() {
        return huespedDAO;
    }

}
