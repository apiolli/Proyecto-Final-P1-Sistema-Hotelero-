/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class CheckDAO {
    
    private Connection con;

    public CheckDAO(Connection connection) {
        this.con = connection;
    }
   
    public ArrayList<Object[]> cargarCheckin(int idReserva) throws SQLException {
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre,' ',h.apellido) AS huesped, " +
                        "hab.noHabitacion, r.fecha_entrada, r.fecha_salida, " +
                        "r.num_personas, r.dineroAbonado " +
                        "FROM reservas r " +
                        "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                        "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                        "WHERE r.estado = 'Pendiente';");     
        
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id"),
                rs.getString("huesped"),
                rs.getInt("noHabitacion"),
                rs.getDate("fecha_entrada"),
                rs.getDate("fecha_salida"),
                rs.getInt("num_personas"),
                rs.getDouble("dineroAbonado"),
            });
        }
         
        return lista;
    
    }
    
    public int ejecutarCheckin(int idReserva) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE reservas r " +
            "JOIN habitacion h ON h.id = r.id_habitacion " +
            "SET r.estado = 'Activa', h.estado = 'Ocupada' " +
            "WHERE r.id = ?"
        );
        ps.setInt(1, idReserva);
        return ps.executeUpdate();
    }
    
    public ArrayList<Object[]> hacerCheckout(int idReserva) throws SQLException {
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre,' ',h.apellido) AS huesped, " +
                            "r.fecha_entrada, r.fecha_salida, " +
                            "COALESCE(SUM(c.precio), 0) AS consumos, " +
                            "r.dineroAbonado " +
                            "FROM reservas r " +
                            "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                            "LEFT JOIN consumos c ON r.id = c.id_reserva " +
                            "WHERE r.estado = 'Activa' " +
                            "GROUP BY r.id;");     
        
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id"),
                rs.getString("huesped"),
                rs.getDate("fecha_entrada"),
                rs.getDate("fecha_salida"),
                rs.getDouble("consumos"),
                rs.getDouble("dineroAbonado"),
            });
        }
         
        return lista;
    
    }
    
    public int ejecutarCheckOut(int idReserva) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "UPDATE reservas SET estado = 'Completada' WHERE id = ?"
        );
        ps.setInt(1, idReserva);
        return ps.executeUpdate();
    }
    
    public ArrayList<Object[]> generarFactura(int idReserva) throws SQLException {
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre,' ',h.apellido) AS huesped, " +
                    "r.fecha_entrada, r.fecha_salida, " +
                    "DATEDIFF(r.fecha_salida, r.fecha_entrada) AS noches, " +
                    "hab.precioNoche, " +
                    "DATEDIFF(r.fecha_salida, r.fecha_entrada) * hab.precioNoche AS total_noches, " +
                    "COALESCE(SUM(c.precio), 0) AS total_consumos, " +
                    "r.dineroAbonado, " +
                    "(DATEDIFF(r.fecha_salida, r.fecha_entrada) * hab.precioNoche) " +
                    "+ COALESCE(SUM(c.precio), 0) - r.dineroAbonado AS saldo_pendiente " +
                    "FROM reservas r " +
                    "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                    "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                    "LEFT JOIN consumos c ON r.id = c.id_reserva " +
                    "WHERE r.estado = 'Completada' " +
                    "GROUP BY r.id;");     
        
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id"),
                rs.getString("huesped"),
                rs.getDate("fecha_entrada"),
                rs.getDate("fecha_salida"),
                rs.getInt("noches"),
                rs.getDouble("precioNoche"),
                rs.getDouble("total_noches"),
                rs.getDouble("total_consumos"),
                rs.getDouble("dineroAbonado"),
                rs.getDouble("saldo_pendiente")
            });
        }
         
        return lista;
    
    }
    
    public Object[] buscarReserva(int noHabitacion) throws SQLException { 
        PreparedStatement ps = con.prepareStatement("SELECT r.id, CONCAT(h.nombre,' ',h.apellido) AS huesped " +
                "FROM reservas r " +
                "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                "WHERE hab.noHabitacion = ? " +
                "AND r.estado = 'Activa'");
        
        ps.setInt(1, noHabitacion);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Object[] {rs.getInt("id"),
                        rs.getString("huesped")
                    };
                    
        }
        
        return null;
    
    }
    
    public ArrayList<Integer> cargarHabitacionesOcupadas() throws SQLException {
        ArrayList<Integer> ocupadas = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT noHabitacion FROM habitacion WHERE estado = 'Ocupada'"
        );
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ocupadas.add(rs.getInt("noHabitacion"));
        }
        return ocupadas;
    }
    
}
