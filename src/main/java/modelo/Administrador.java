package modelo;

public class Administrador extends Persona{
    private String usuario;
    private String contrasena;
    
    public Administrador(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono,
        String usuario, String contrasena) {
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono);
        this.usuario=usuario;
        this.contrasena=contrasena;
    }
    
    public String getUsuario(){
        return usuario;
    }
    public String getContrasena(){
        return contrasena;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    
}
