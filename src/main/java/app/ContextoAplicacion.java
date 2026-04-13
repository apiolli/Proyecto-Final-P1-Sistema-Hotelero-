package app;

import conexion.Conexion;
import dao.HabitacionDAO;
import dao.HuespedDAO;
import dao.ReservaDAO;
import java.sql.Connection;

public class ContextoAplicacion {
    private static HuespedDAO huespedDAO;
    private static HabitacionDAO habitacionDAO;
    private static ReservaDAO reservaDAO;

    public ContextoAplicacion() {
        Connection con = Conexion.getConexion();
        huespedDAO = new HuespedDAO(con);
        habitacionDAO = new HabitacionDAO(con);
        reservaDAO = new ReservaDAO(con);
    }

    public HuespedDAO getHuespedDAO() {
        return huespedDAO;
    }

    public HabitacionDAO getHabitacionDAO() {
        return habitacionDAO;
    }

    public ReservaDAO getReservaDAO() {
        return reservaDAO;
    }
}