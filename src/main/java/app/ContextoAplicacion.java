package app;

import conexion.Conexion;
import dao.EmpleadoAdminDAO;
import dao.HabitacionDAO;
import dao.HuespedDAO;
import dao.ReservaDAO;
import java.sql.Connection;

public class ContextoAplicacion {
    private static HuespedDAO huespedDAO;
    private static HabitacionDAO habitacionDAO;
    private static ReservaDAO reservaDAO;
    private static EmpleadoAdminDAO adminDAO;

    public ContextoAplicacion() {
        Connection con = Conexion.getConexion();
        huespedDAO = new HuespedDAO(con);
        habitacionDAO = new HabitacionDAO(con);
        reservaDAO = new ReservaDAO(con);
        adminDAO = new EmpleadoAdminDAO(con);
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

    public static EmpleadoAdminDAO getAdminDAO() {
        return adminDAO;
    }
    
    
}