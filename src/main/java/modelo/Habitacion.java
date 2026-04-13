package modelo;

public abstract class Habitacion {
    private int id;
    private String nivel;
    private int numHabitacion;
    private String tipo;
    private String estado;
    private double precioNoche;
    private int capacidad;
    private String telefonoHabitacion;

    public Habitacion(int numHabitacion, String tipo, String estado, double precioNoche, String nivel, int capacidad, String telefonoHabitacion) {
        this.nivel = nivel;
        this.numHabitacion = numHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.precioNoche = precioNoche;
        this.capacidad = capacidad;
        this.telefonoHabitacion = telefonoHabitacion;
    }

    public Habitacion(int id, String nivel, int numHabitacion, String tipo, String estado, double precioNoche, int capacidad, String telefonoHabitacion) {
        this.id = id;
        this.nivel = nivel;
        this.numHabitacion = numHabitacion;
        this.tipo = tipo;
        this.estado = estado;
        this.precioNoche = precioNoche;
        this.capacidad = capacidad;
        this.telefonoHabitacion = telefonoHabitacion;
    }
    

    public Habitacion(int numHabitacion, String tipo, String estado) {
        this.numHabitacion = numHabitacion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Habitacion(int id, int numHabitacion) {
        this.id = id;
        this.numHabitacion = numHabitacion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTelefonoHabitacion() {
        return telefonoHabitacion;
    }

    public void setTelefonoHabitacion(String telefonoHabitacion) {
        this.telefonoHabitacion = telefonoHabitacion;
    }

    public int getId() {
        return id;
    }
}