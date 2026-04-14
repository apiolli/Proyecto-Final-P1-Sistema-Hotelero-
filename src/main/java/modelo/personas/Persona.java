package modelo.personas;

public abstract class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String documentoIdentidad;
    private long fechaDeNacimiento;
    private String telefono;

    public Persona(String nombre, String apellido, String nacionalidad, String documentoIdentidad, long fechaDeNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public long getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getId() {
        return id;
    }
}