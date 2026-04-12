/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import modelo.Empleado;
import modelo.Gestionable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Star_
 */
public class EmpleadoDAO implements Gestionable<Empleado> {
    
    private Connection con;
    public EmpleadoDAO(Connection con){
        this.con=con;
    }
    
    @Override
    public int guardar(Empleado clase) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
