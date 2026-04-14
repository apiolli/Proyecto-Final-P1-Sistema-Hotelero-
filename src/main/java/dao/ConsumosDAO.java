package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Consumo;
import modelo.interfaces.Gestionable;

public class ConsumosDAO implements Gestionable<Consumo>{
    private Connection con;
    
    public ConsumosDAO(Connection con) {
        this.con = con;
    }
    
    @Override
    public int guardar(Consumo consumo) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO consumos (id_reserva, descripcion, cantidad, precio) VALUES (?,?,?,?)");
        ps.setInt(1, consumo.getIdReserva());
        ps.setString(2, consumo.getDescripcion());
        ps.setInt(3, consumo.getCantidad());
        ps.setDouble(4, consumo.getPrecio());
        return ps.executeUpdate();
        
    }
    
    public ArrayList<Object[]> cargarConsumos(int idReserva) throws SQLException { 
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("SELECT id, descripcion, cantidad, precio FROM consumos WHERE id_reserva = ?");     
        ps.setInt(1, idReserva);
        ResultSet rs = ps.executeQuery();
        
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id"),
                rs.getString("descripcion"),
                rs.getInt("cantidad"),
                rs.getDouble("precio"),
            });
        }
         
        return lista;
    }
    
    public int eliminar(int idConsumo) throws SQLException { 
        PreparedStatement ps = con.prepareStatement("DELETE FROM consumos WHERE id = ?");
        ps.setInt(1, idConsumo);
            
        return ps.executeUpdate();
    }
    
    public int eliminarTodos(int idReserva) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM consumos WHERE id_reserva = ?");
        ps.setInt(1, idReserva);
            
        return ps.executeUpdate();
    }
    

}
