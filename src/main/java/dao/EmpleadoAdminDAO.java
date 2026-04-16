package dao;

import java.sql.SQLException;
import modelo.personas.Empleado;
import modelo.interfaces.Gestionable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class EmpleadoAdminDAO implements Gestionable<Empleado> {
    
    private Connection con;
    public EmpleadoAdminDAO(Connection con){
        this.con=con;
    }
    
    @Override
    public int guardar(Empleado empleado) throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios(nombre,apellido,cargo,usuario,contrasena,nivel_acceso)"
        + "VALUES(?,?,?,?,?,?)");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getCargo());
        ps.setString(4, empleado.getUsuario());
        ps.setString(5, empleado.getContrasena());
        ps.setString(6, empleado.getNivelAcceso());
        return ps.executeUpdate();      
    }
    
    public ArrayList<Object[]> buscarEmpleadoAdmin(String usuario) throws SQLException{
        ArrayList<Object[]> lista = new ArrayList<>();
        String sql= "SELECT id_usuario,nombre,apellido,cargo,usuario,contrasena,nivel_acceso FROM Usuarios where usuario=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            lista.add(new Object[]{
              rs.getInt("id_usuario"),
              rs.getString("nombre"),
              rs.getString("apellido"),
              rs.getString("cargo"),
              rs.getString("usuario"),
              rs.getString("contrasena"),   
              rs.getString("nivel_acceso")
            });
            return lista;
        }
       
        return null;
    }
    
    public boolean eliminarEmpleadoAdmin(int id) throws SQLException{
        String sql = "DELETE FROM Usuarios WHERE id_usuario=?";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, id);
 
        int filas = ps.executeUpdate();
        return filas > 0;
        }
    } 
    
    public int editarEmpleadoAdmin(Empleado empleado) throws SQLException{
        PreparedStatement ps = con.prepareStatement("UPDATE Usuarios SET nombre=?,apellido=?,cargo=?,usuario=?,contrasena=?,nivel_acceso=?");
        ps.setString(1, empleado.getNombre());
        ps.setString(2, empleado.getApellido());
        ps.setString(3, empleado.getCargo());
        ps.setString(4, empleado.getUsuario());
        ps.setString(5, empleado.getContrasena());
        ps.setString(6, empleado.getNivelAcceso());
        
        int respuesta = ps.executeUpdate();
        
        if(respuesta>0){
            return respuesta;
        }
        return -1;
    }
    
    public ArrayList<Object[]> cargarEmpleadoAdmin() throws SQLException {  
        ArrayList<Object[]> lista = new ArrayList<>();
        PreparedStatement ps = con.prepareStatement("select id_usuario,nombre,apellido,cargo,usuario,contrasena,nivel_acceso from Usuarios");            
        ResultSet rs = ps.executeQuery();
            
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getInt("id_usuario"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("cargo"),
                rs.getString("usuario"),
                rs.getString("contrasena"),
                rs.getString("nivel_acceso")
            });
        }
         
        return lista;
        
    }
    
    public modelo.personas.Empleado buscarPorId(int id) throws java.sql.SQLException {
        
        String sql = "SELECT * FROM Usuarios WHERE id_usuario = ?"; 
        
        try (java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (java.sql.ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new modelo.personas.Empleado(
                        rs.getInt("id_usuario"), 
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("cargo"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("nivel_acceso")
                    );
                }
            }
        }
        return null;
    }

   
    public int editar(modelo.personas.Empleado empleado) throws java.sql.SQLException {
        
        String sql = "UPDATE Usuarios SET nombre = ?, apellido = ?, cargo = ?, usuario = ?, contrasena = ?, nivel_acceso = ? WHERE id_usuario = ?";
        
        try (java.sql.PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCargo());
            ps.setString(4, empleado.getUsuario());
            ps.setString(5, empleado.getContrasena());
            ps.setString(6, empleado.getNivelAcceso());
            ps.setInt(7, empleado.getId()); 
            
            return ps.executeUpdate();
        }
    }
}
