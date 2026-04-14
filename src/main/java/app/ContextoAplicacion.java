package app;

import conexion.Conexion;
import dao.CheckDAO;
import dao.ConsumosDAO;
import dao.EmpleadoAdminDAO;
import dao.FacturacionDAO;
import dao.HabitacionDAO;
import dao.HuespedDAO;
import dao.ReservaDAO;
import java.sql.Connection;

public class ContextoAplicacion {
    private static HuespedDAO huespedDAO;
    private static HabitacionDAO habitacionDAO;
    private static ReservaDAO reservaDAO;
    private static EmpleadoAdminDAO adminDAO;
    private static CheckDAO checkDAO;
    private static ConsumosDAO consumosDAO;
    private static FacturacionDAO facturacionDAO;

    public ContextoAplicacion() {
        Connection con = Conexion.getConexion();
        huespedDAO = new HuespedDAO(con);
        habitacionDAO = new HabitacionDAO(con);
        reservaDAO = new ReservaDAO(con);
        adminDAO = new EmpleadoAdminDAO(con);
        checkDAO = new CheckDAO(con);
        consumosDAO = new ConsumosDAO(con);
        facturacionDAO = new FacturacionDAO(con);
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

    public EmpleadoAdminDAO getAdminDAO() {
        return adminDAO;
    }

    public CheckDAO getCheckDAO() {
        return checkDAO;
    }

    public ConsumosDAO getConsumosDAO() {
        return consumosDAO;
    }

    public FacturacionDAO getFacturacionDAO() {
        return facturacionDAO;
    }
    
    
    
    
    
    
    
    
}