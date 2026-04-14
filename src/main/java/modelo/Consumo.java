package modelo;

public class Consumo {
    private int id;
    private int idReserva;
    private String descripcion;
    private int cantidad;
    private double precio; 

    public Consumo() {}

    public Consumo(int idReserva, String descripcion, int cantidad, double precio) {
        this.idReserva = idReserva;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Consumo(String descripcion, int cantidad, double precio) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    
    
    
    
    
    
}
