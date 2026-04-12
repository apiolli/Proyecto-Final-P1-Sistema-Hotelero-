/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Gestionable;
import modelo.Huesped;

public class HuespedDAO implements Gestionable<Huesped>{
    
    private Connection con;
    public HuespedDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public int guardar(Huesped huesped) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Huesped (nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono) VALUES(?, ?, ?, ?, ?, ?)");
        ps.setString(1, huesped.getNombre());
        ps.setString(2, huesped.getApellido());
        ps.setString(3, huesped.getNacionalidad());
        ps.setString(4, huesped.getDocumentoIdentidad());
        ps.setDate(5, new Date(huesped.getFechaDeNacimiento()));
        ps.setString(6, huesped.getTelefono());
            
        return ps.executeUpdate();
  
    }
    

}
