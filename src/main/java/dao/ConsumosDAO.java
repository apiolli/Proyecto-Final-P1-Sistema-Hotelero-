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
    
    public ArrayList<modelo.Producto> listarProductosCatálogo() throws SQLException {
        ArrayList<modelo.Producto> lista = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, precio FROM productos";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new modelo.Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio")
                ));
            }
        }
        return lista;
    }
    
    // --- ESTE ES EL MÉTODO CORREGIDO ---
    public boolean guardarProductoCatalogo(modelo.Producto producto) throws java.sql.SQLException {
        String sql = "INSERT INTO productos (nombre, precio, categoria) VALUES (?, ?, ?)";
        try (java.sql.PreparedStatement ps = con.prepareStatement(sql)) { // Se usa "con"
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getCategoria());
            return ps.executeUpdate() > 0;
        }
    }
    
    // --- NUEVO MÉTODO PARA FILTRAR ---
    public ArrayList<modelo.Producto> listarProductosPorCategoria(String categoria) throws SQLException {
        ArrayList<modelo.Producto> lista = new ArrayList<>();
        String sql;
        
        // Si elige "Todas", buscamos sin filtro. Si no, filtramos por la columna.
        if (categoria.equals("Todas")) {
            sql = "SELECT id_producto, nombre, precio FROM productos";
        } else {
            sql = "SELECT id_producto, nombre, precio FROM productos WHERE categoria = ?";
        }
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Si hay un filtro, le inyectamos la categoría al WHERE
            if (!categoria.equals("Todas")) {
                ps.setString(1, categoria);
            }
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new modelo.Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio")
                    ));
                }
            }
        }
        return lista;
    }
}