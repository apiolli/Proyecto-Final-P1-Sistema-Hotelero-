/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import modelo.Gestionable;
import modelo.Reserva;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author DELL
 */
public class ReservaDAO implements Gestionable <Reserva> {
    
    private Connection con;
        public ReservaDAO (Connection con){
            this.con=con;
        }
    
    @Override
    public int guardar(Reserva reserva) throws SQLException {
       PreparedStatement ps = con.prepareStatement("INSERT INTO reservas"
       + "(id_reserva,nombre_huesped,total_personas,num_habitacion,fecha_entrada,fecha_salida,"
       + "fecha_reserva,dinero_abonado,estado) VALUES(?,?,?,?,?,?,?,?,?)");
        ps.setString(1, reserva.getIdReserva());
        ps.setString(2, reserva.getNombreHuesped());
        ps.setInt(3, reserva.getTotalPersonas());
        ps.setInt(4, reserva.getNumHabitacion());
        ps.setLong(5, reserva.getFechaEntrada());
        ps.setLong(6, reserva.getFechaSalida());
        ps.setLong(7, reserva.getFechaReserva());
        ps.setDouble(8, reserva.getDineroAbonado());
        ps.setString(9, reserva.getEstado());
       return ps.executeUpdate();
    }
    
}
