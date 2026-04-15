package modelo.personas;

public class Empleado extends Persona {
    
    private int id; // <--- Agregamos el ID para poder editarlo en la BD
    private String cargo;
    private String usuario;
    private String contrasena;
    private String nivelAcceso;
    
    
    public Empleado(String nombre, String apellido, String cargo, String usuario, String contrasena, String nivelAcceso) {
        super(nombre, apellido); // Llama a la clase Persona
        this.cargo = cargo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nivelAcceso = nivelAcceso;
    }

   
    public Empleado(int id, String nombre, String apellido, String cargo, String usuario, String contrasena, String nivelAcceso) {
        super(nombre, apellido); // Llama a la clase Persona
        this.id = id;            // Guarda el ID
        this.cargo = cargo;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nivelAcceso = nivelAcceso;
    }
    
    
    @Override
    public int getId() {
        return id;
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
    
    // --- SETTERS ---
    public void setId(int id) {
        this.id = id;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    } 
    public void setNivelAcceso(String nivelAcceso){
        this.nivelAcceso = nivelAcceso;
    }
}