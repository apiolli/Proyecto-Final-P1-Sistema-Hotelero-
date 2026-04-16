package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.interfaces.Gestionable;
import modelo.reservas.Reserva;

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
    
  
    public ArrayList<Object[]> obtenerReservasPorEstado(String estado) throws SQLException {  
        ArrayList<Object[]> lista = new ArrayList<>();
        
    
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre, ' ', h.apellido) AS huesped,"
                + " r.num_personas AS total_personas, hab.noHabitacion AS habitacion, r.fecha_entrada, r.fecha_salida, "
                + "r.fecha_reserva, r.estado, r.dineroAbonado FROM reservas r INNER JOIN Huesped h ON r.id_huesped = "
                + "h.id INNER JOIN Habitacion hab ON r.id_habitacion = hab.id WHERE r.estado = ? ORDER BY r.fecha_entrada;");            
        
     
        ps.setString(1, estado);
        
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
    // --------------------------------------------

    /**
     * Después de crear la reserva vía CheckIn directo,
     * la pone en estado 'Activa' y marca la habitación como 'Ocupada'.
     */
    public void marcarCheckInInmediato(int idReserva, int idHabitacion) throws java.sql.SQLException {
        java.sql.PreparedStatement ps = con.prepareStatement(
            "UPDATE reservas SET estado = 'Activa' WHERE id = ?"
        );
        ps.setInt(1, idReserva);
        ps.executeUpdate();

        java.sql.PreparedStatement ps2 = con.prepareStatement(
            "UPDATE Habitacion SET estado = 'Ocupada' WHERE id = ?"
        );
        ps2.setInt(1, idHabitacion);
        ps2.executeUpdate();
    }
       
}