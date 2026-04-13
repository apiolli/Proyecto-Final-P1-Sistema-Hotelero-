package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Gestionable;
import modelo.Huesped;

public class HuespedDAO implements Gestionable<Huesped> {

    private Connection con;

    public HuespedDAO(Connection con) {
        this.con = con;
    }

    @Override
    public int guardar(Huesped huesped) throws SQLException {
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Huesped (nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono) VALUES(?, ?, ?, ?, ?, ?)"
        );
        ps.setString(1, huesped.getNombre());
        ps.setString(2, huesped.getApellido());
        ps.setString(3, huesped.getNacionalidad());
        ps.setString(4, huesped.getDocumentoIdentidad());
        ps.setDate(5, new Date(huesped.getFechaDeNacimiento()));
        ps.setString(6, huesped.getTelefono());
        return ps.executeUpdate();
    }

    public int buscarIdPorDocumento(String documento) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT id FROM Huesped WHERE documentoIdentidad = ?");
        ps.setString(1, documento);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        return -1;
    }

    public Huesped buscarNombreApellido(int id) throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT nombre, apellido FROM Huesped WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Huesped(rs.getString("nombre"), rs.getString("apellido"));
        }
        return null;
    }
}