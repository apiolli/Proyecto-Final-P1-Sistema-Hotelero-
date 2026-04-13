package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}