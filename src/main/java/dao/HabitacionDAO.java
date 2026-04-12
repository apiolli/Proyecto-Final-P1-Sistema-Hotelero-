package dao;

import java.awt.List;
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

public class HabitacionDAO implements Gestionable<Habitacion>{
    private Connection con;

    public HabitacionDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int guardar(Habitacion hab) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Habitacion (noHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefono) VALUES(?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, hab.getNumHabitacion());
        ps.setString(2, hab.getTipo());
        ps.setString(3, hab.getEstado());
        ps.setDouble(4, hab.getPrecioNoche());
        ps.setString(5, hab.getNivel());
        ps.setInt(6, hab.getCapacidad());
        ps.setString(7, hab.getTelefonoHabitacion());
            
        return ps.executeUpdate();
    }
    
    public ArrayList<Habitacion> cargarHabitaciones() throws SQLException{   
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("select noHabitacion, tipo, estado from habitacion;");            
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            switch (rs.getString("tipo")) {
                case "Individual" -> habitaciones.add(new HabitacionIndividual(rs.getInt("noHabitacion"), rs.getString("tipo"), rs.getString("estado")));
                case "Doble" -> habitaciones.add(new HabitacionDoble(rs.getInt("noHabitacion"), rs.getString("tipo"), rs.getString("estado")));
                case "Suite" -> habitaciones.add(new HabitacionSuite(rs.getInt("noHabitacion"), rs.getString("tipo"), rs.getString("estado")));
                case "Deluxe" -> habitaciones.add(new HabitacionDeluxe(rs.getInt("noHabitacion"), rs.getString("tipo"), rs.getString("estado")));

            }
        }
        
        return habitaciones;
        

    }
    
    
    
}
