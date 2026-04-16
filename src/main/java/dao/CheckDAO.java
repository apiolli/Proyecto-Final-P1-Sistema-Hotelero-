package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
            "UPDATE reservas r " +
            "JOIN habitacion h ON h.id = r.id_habitacion " +
            "SET r.estado = 'Completada', h.estado = 'Disponible' " +
            "WHERE r.id = ?"
        );
        ps.setInt(1, idReserva);
        return ps.executeUpdate();
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
    
   public ArrayList<Integer> cargarHabitacionesConReserva() throws SQLException {
    ArrayList<Integer> lista = new ArrayList<>();
    
    String sql = "SELECT h.noHabitacion " +
                 "FROM Habitacion h " +
                 "INNER JOIN reservas r ON h.id = r.id_habitacion " +
                 "WHERE r.estado = 'Activa'"; 

    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        
        while (rs.next()) {
            lista.add(rs.getInt("noHabitacion"));
        }
    }
    return lista;
}

    public boolean habitacionEstaOcupada(int idReserva) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "SELECT h.estado FROM Habitacion h " +
            "INNER JOIN reservas r ON r.id_habitacion = h.id " +
            "WHERE r.id = ?"
        );
        ps.setInt(1, idReserva);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return "Ocupada".equalsIgnoreCase(rs.getString("estado"));
        }
        return false;
    }
    
}
