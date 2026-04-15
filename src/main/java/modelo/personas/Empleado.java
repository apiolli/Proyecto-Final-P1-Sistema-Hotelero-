package modelo.personas;

import modelo.personas.Persona;

public class Empleado extends Persona {
    private String cargo;
    private double sueldo;
    private String usuario;
    private String contrasena;
    private long fechaIngreso;
    private String nivelAcceso;
    
    public Empleado(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono,
        String cargo, double sueldo, String usuario, String contrasena, long fechaIngreso, String nivelAcceso) {
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono);
        this.cargo=cargo;
        this.sueldo=sueldo;
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.fechaIngreso=fechaIngreso;
        this.nivelAcceso=nivelAcceso;
    }
    
    public String getCargo(){
        return cargo;
    }
    public double getSueldo(){
        return sueldo;
    }
    public String getContrasena(){
        return contrasena;
    }
    public long getFechaIngreso(){
        return fechaIngreso;
    }
    public String getNivelAcceso(){
        return nivelAcceso;
    }
    
    public void SetCargo(String cargo){
        this.cargo=cargo;
    }
    public void setSueldo(double sueldo){
        this.sueldo=sueldo;
    }
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
    
    public void setNivelAcceso(String nivelAcceso){
        this.nivelAcceso=nivelAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
