package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.ReporteFactura;
import modelo.personas.Huesped;

public class FacturacionDAO {
    private Connection con;

    public FacturacionDAO(Connection con) {
        this.con = con;
    }
    
    public ArrayList<Object[]> cargarReservasCompletadas() throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "SELECT r.id, h.nombre, h.apellido, hab.noHabitacion " +
                                "FROM reservas r " +
                                "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                                "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                                "WHERE r.estado = 'Completada'");
                            
       ArrayList<Object[]> lista = new ArrayList<>();
       ResultSet rs = ps.executeQuery();
       
        while (rs.next()) {
            lista.add( new Object[]{
                rs.getInt("id"),
                rs.getString("nombre"), 
                rs.getString("apellido"), 
                rs.getInt("noHabitacion")
            });
        }
         
        return lista;
    }
    
    public ReporteFactura cargarDatosReserva(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
                "SELECT r.id, h.nombre, h.apellido, " +
                        "h.telefono, " +
                        "h.documentoIdentidad " +
                        "FROM reservas r " +
                        "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                        "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                        "WHERE r.id = ?");
       ps.setInt(1, id);
       ResultSet rs = ps.executeQuery();
       
        if (rs.next()) {
            return new ReporteFactura(
                rs.getInt("id"), new Huesped(rs.getString("nombre"), rs.getString("apellido"), rs.getString("documentoIdentidad"), rs.getString("telefono")),
                new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
        }
         
        return null;
    }
    
    public ArrayList<Object[]> cargarDetalleFactura(int idReserva) throws SQLException {
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT c.cantidad, c.descripcion, c.precio AS precio_unitario, " +
            "0 AS descuento, " +
            "ROUND(c.precio * 0.18, 2) AS itbis, " +
            "ROUND((c.precio * c.cantidad) + (c.precio * c.cantidad * 0.18), 2) AS total " +
            "FROM consumos c WHERE c.id_reserva = ? " +
            "UNION ALL " +
            "SELECT DATEDIFF(r.fecha_salida, r.fecha_entrada), 'Noches de hotel', " +
            "hab.precioNoche, 0, " +
            "ROUND(hab.precioNoche * 0.18, 2), " +
            "ROUND(DATEDIFF(r.fecha_salida, r.fecha_entrada) * hab.precioNoche * 1.18, 2) " +
            "FROM reservas r " +
            "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
            "WHERE r.id = ?"
        );

        ps.setInt(1, idReserva);
        ps.setInt(2, idReserva); 
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("cantidad"),
                rs.getString("descripcion"),
                rs.getDouble("precio_unitario"),
                rs.getDouble("descuento"),
                rs.getDouble("itbis"),
                rs.getDouble("total")
                
            });
        }
        return lista;
    }

    public int registrarVenta(ReporteFactura reporte) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO ReporteFactura (id_reserva, huesped, habitacion, " +
            "subtotal, itbis, descuento, total, forma_pago) VALUES (?,?,?,?,?,?,?,?)"
        );
        ps.setInt(1, reporte.getIdReserva());
        ps.setString(2, reporte.getHuesped().getNombre() + " " + reporte.getHuesped().getApellido());
        ps.setInt(3, reporte.getHabitacion());
        ps.setDouble(4, reporte.getSubtotal());
        ps.setDouble(5, reporte.getItbis());
        ps.setDouble(6, reporte.getDescuento());
        ps.setDouble(7, reporte.getTotal());
        ps.setString(8, reporte.getFormaPago());
        
        return ps.executeUpdate();
    }
    
    public int eliminarReserva(int idReserva) throws SQLException {
        PreparedStatement ps1 = con.prepareStatement(
            "DELETE FROM consumos WHERE id_reserva = ?"
        );
        ps1.setInt(1, idReserva);
        ps1.executeUpdate();

        PreparedStatement ps2 = con.prepareStatement(
            "DELETE FROM reservas WHERE id = ?"
        );
        ps2.setInt(1, idReserva);
        return ps2.executeUpdate();
    }
}
