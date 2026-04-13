package modelo;

public class Empleado extends Persona {
    private String cargo;
    private double sueldo;
    private String usuario;
    private String contrasena;
    private long fechaIngreso;
    
    public Empleado(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono,
        String cargo, double sueldo, String usuario, String contrasena, long fechaIngreso) {
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono);
        this.cargo=cargo;
        this.sueldo=sueldo;
        this.usuario=usuario;
        this.contrasena=contrasena;
        this.fechaIngreso=fechaIngreso;
    }
    
    public String getCargo(){
        return cargo;
    }
    public double getSueldo(){
        return sueldo;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getContrasena(){
        return contrasena;
    }
    public long getFechaIngreso(){
        return fechaIngreso;
    }
    
    public void SetCargo(String cargo){
        this.cargo=cargo;
    }
    public void setSueldo(double sueldo){
        this.sueldo=sueldo;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
}
