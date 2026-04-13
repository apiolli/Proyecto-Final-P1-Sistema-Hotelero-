package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Gestionable;
import modelo.Habitacion;
import modelo.HabitacionDeluxe;
import modelo.HabitacionDoble;
import modelo.HabitacionIndividual;
import modelo.HabitacionSuite;

public class HabitacionDAO implements Gestionable<Habitacion> {

    private Connection con;

    public HabitacionDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int guardar(Habitacion hab) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Habitacion (noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono) VALUES(?, ?, ?, ?, ?, ?, ?)"
        );
        ps.setInt(1, hab.getNumHabitacion());
        ps.setString(2, hab.getTipo());
        ps.setString(3, hab.getEstado());
        ps.setDouble(4, hab.getPrecioNoche());
        ps.setString(5, hab.getNivel());
        ps.setInt(6, hab.getCapacidad());
        ps.setString(7, hab.getTelefonoHabitacion());
        return ps.executeUpdate();
    }

    public ArrayList<Habitacion> cargarHabitaciones() throws SQLException {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT noHabitacion, tipo, estado FROM habitacion");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String tipo = rs.getString("tipo");
            int num = rs.getInt("noHabitacion");
            String estado = rs.getString("estado");
            switch (tipo) {
                case "Individual" -> habitaciones.add(new HabitacionIndividual(num, tipo, estado));
                case "Doble" -> habitaciones.add(new HabitacionDoble(num, tipo, estado));
                case "Suite" -> habitaciones.add(new HabitacionSuite(num, tipo, estado));
                case "Deluxe" -> habitaciones.add(new HabitacionDeluxe(num, tipo, estado));
            }
        }
        return habitaciones;
    }

    public int buscarIdPorNumero(int noHabitacion) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT id FROM habitacion WHERE noHabitacion = ?");
        ps.setInt(1, noHabitacion);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        return -1;
    }

    public ArrayList<Integer> buscarDisponiblesPorTipo(String tipo) throws SQLException {
        ArrayList<Integer> disponibles = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement(
            "SELECT noHabitacion FROM habitacion WHERE estado = 'Disponible' AND tipo = ?"
        );
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            disponibles.add(rs.getInt("noHabitacion"));
        }
        return disponibles;
    }
}