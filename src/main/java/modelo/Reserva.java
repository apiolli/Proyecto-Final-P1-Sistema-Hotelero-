/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author DELL
 */
public class Reserva {
    private String idReserva;
    private long fechaReserva;
    Huesped huesped; 
    private String nombreHuesped;
    private double dineroAbonado;
    private String estado;
    
    
    
    public Reserva(String idReserva, long fechaReserva, String nombreHuesped,
        double dineroAbonado, String estado){  
        this.idReserva=idReserva;
        this.fechaReserva=fechaReserva;
        this.nombreHuesped = huesped.getNombre();
        this.dineroAbonado=dineroAbonado;
        this.estado=estado;
    }
    
    public String getIdReserva(){
        return idReserva;
    }
    public long getFechaReserva(){
        return fechaReserva;
    }
    public String getNombreHuesped(){
        return nombreHuesped;
    }
    public double getDineroAbonado(){
        return dineroAbonado;
    }
    public String getEstado(){
        return estado;
    }
    
    public void setIdReserva(String idReserva){
        this.idReserva=idReserva;
    }
    public void setFechaReserva(long fechaReserva){
        this.fechaReserva=fechaReserva;
    }
    public void setDineroAbonado(double dineroAbonado){
       this.dineroAbonado=dineroAbonado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
               
}
