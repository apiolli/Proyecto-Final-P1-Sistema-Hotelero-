package app;

import conexion.Conexion;
import dao.HabitacionDAO;
import dao.HuespedDAO;
import java.sql.Connection;


public class ContextoAplicacion {
    private static HuespedDAO huespedDAO;
    private static HabitacionDAO habitacionDAO;

    public ContextoAplicacion() {
        Connection con = Conexion.getConexion();
        huespedDAO = new HuespedDAO(con);
        habitacionDAO = new HabitacionDAO(con);
    }

    public HuespedDAO getHuespedDAO() {
        return huespedDAO;
    }

    public HabitacionDAO getHabitacionDAO() {
        return habitacionDAO;
    }


}
