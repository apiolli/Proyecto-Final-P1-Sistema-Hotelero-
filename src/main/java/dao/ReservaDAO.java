package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Gestionable;
import modelo.Reserva;

public class ReservaDAO implements Gestionable<Reserva> {

    private Connection con;

    public ReservaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int guardar(Reserva reserva) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, num_personas, dineroAbonado) VALUES(?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, reserva.getHuesped().getId());
        ps.setInt(2, reserva.getHabitacion().getId());
        ps.setDate(3, new Date(reserva.getFechaEntrada()));
        ps.setDate(4, new Date(reserva.getFechaSalida()));
        ps.setInt(5, reserva.getNumPersonas());
        ps.setDouble(6, reserva.getDineroAbonado());
        return ps.executeUpdate();
    }

    public int guardarConIds(int idHuesped, int idHabitacion, long fechaEntrada,
                             long fechaSalida, int numPersonas, double dineroAbonado) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida, num_personas, dineroAbonado) VALUES(?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, idHuesped);
        ps.setInt(2, idHabitacion);
        ps.setDate(3, new Date(fechaEntrada));
        ps.setDate(4, new Date(fechaSalida));
        ps.setInt(5, numPersonas);
        ps.setDouble(6, dineroAbonado);
        return ps.executeUpdate();
    }
    
    public ArrayList<Object[]> cargarReservas() throws SQLException {  
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre, ' ', h.apellido) AS huesped,"
                + " r.num_personas AS total_personas, hab.noHabitacion AS habitacion, r.fecha_entrada, r.fecha_salida, "
                + "r.fecha_reserva, r.estado, r.dineroAbonado FROM reservas r INNER JOIN Huesped h ON r.id_huesped = "
                + "h.id INNER JOIN Habitacion hab ON r.id_habitacion = hab.id ORDER BY r.fecha_entrada;");            
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id"),
                rs.getString("huesped"),
                rs.getInt("total_personas"),
                rs.getInt("habitacion"),
                rs.getDate("fecha_entrada"),
                rs.getDate("fecha_salida"),
                rs.getDate("fecha_reserva"),
                rs.getString("estado"),
                rs.getDouble("dineroAbonado")
            });
        }
         
        return lista;
        
    }
}