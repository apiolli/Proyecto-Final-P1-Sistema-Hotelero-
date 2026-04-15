package modelo.personas;

import modelo.personas.Persona;

public class Empleado extends Persona {
    private String cargo;
    private String usuario;
    private String contrasena;
    private String nivelAcceso;
    
    public Empleado(String nombre, String apellido, String cargo,String usuario,String contrasena,String nivelAcceso) {
        super(nombre,apellido);
        this.cargo=cargo;
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.nivelAcceso=nivelAcceso;
    }
    
    public String getCargo(){
        return cargo;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getContrasena(){
        return contrasena;
    }
    public String getNivelAcceso(){
        return nivelAcceso;
    }  
    
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
     public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    } 
    public void setNivelAcceso(String nivelAcceso){
        this.nivelAcceso=nivelAcceso;
    }
   
    
    
}
