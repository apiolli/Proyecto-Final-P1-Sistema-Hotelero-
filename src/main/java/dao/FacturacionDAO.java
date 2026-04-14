/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
                "SELECT r.id, CONCAT(h.nombre,' ',h.apellido) AS huesped, hab.noHabitacion " +
                                "FROM reservas r " +
                                "INNER JOIN Huesped h ON r.id_huesped = h.id " +
                                "INNER JOIN Habitacion hab ON r.id_habitacion = hab.id " +
                                "WHERE r.estado = 'Completada'");
                            
       ArrayList<Object[]> lista = new ArrayList<>();
       ResultSet rs = ps.executeQuery();
       
        while (rs.next()) {
            lista.add( new Object[]{
                rs.getInt("id"),
                rs.getString("huesped"), 
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

}
