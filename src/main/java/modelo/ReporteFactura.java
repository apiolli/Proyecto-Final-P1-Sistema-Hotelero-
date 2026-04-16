package modelo;

import java.util.ArrayList;
import modelo.personas.Huesped;

public class ReporteFactura {
    private int id;
    private int idReserva;
    private Huesped huesped;
    private int habitacion;
    private double subtotal;
    private double itbis;
    private double descuento;
    private double total;
    private String formaPago;
    private String fechaVenta;
    
    private ArrayList<Object[]> detalle;

    public ReporteFactura(int idReserva, Huesped huesped, String fechaVenta) {
        this.idReserva = idReserva;
        this.huesped = huesped;
        this.fechaVenta = fechaVenta;
    }

    public ReporteFactura() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getItbis() {
        return itbis;
    }

    public void setItbis(double itbis) {
        this.itbis = itbis;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public ArrayList<Object[]> getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList<Object[]> detalle) {
        this.detalle = detalle;
    }
   
    
    
    
    
}
