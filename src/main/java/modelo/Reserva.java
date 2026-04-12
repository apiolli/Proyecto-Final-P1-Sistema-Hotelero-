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
    Huesped huesped; 
    private String nombreHuesped;
    private int totalPersonas;
    private int numHabitacion;
    private long fechaEntrada;
    private long fechaSalida;
    private long fechaReserva;
    private double dineroAbonado;
    private String estado;
    private int totalReservas;
    
    
    
    public Reserva(String idReserva, String nombreHuesped,int totalPersonas, int numHabitacion,long fechaEntrada,
        long fechaSalida, long fechaReserva, double dineroAbonado, String estado){  
        this.idReserva=idReserva;
        this.nombreHuesped = huesped.getNombre();
        this.totalPersonas=totalPersonas;
        this.numHabitacion=numHabitacion;
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida=fechaSalida;
        this.fechaReserva=fechaReserva;
        this.dineroAbonado=dineroAbonado;
        this.estado=estado;
        totalReservas+=1;
    }
    
    public String getIdReserva(){
        return idReserva;
    }
    public String getNombreHuesped(){
        return nombreHuesped;
    }
    public int getTotalPersonas(){
        return totalPersonas;
    }
    public int getNumHabitacion(){
        return numHabitacion;
    }
    public long getFechaEntrada(){
        return fechaEntrada;
    }
    public long getFechaSalida(){
        return fechaSalida;
    }
    public long getFechaReserva(){
        return fechaReserva;
    } 
    public double getDineroAbonado(){
        return dineroAbonado;
    }
    public String getEstado(){
        return estado;
    }
    public int getTotalReservas(){
        return totalReservas;
    }
    
    public void setIdReserva(String idReserva){
        this.idReserva=idReserva;
    }
    public void setTotalPersonas(int totalPersonas){
        this.totalPersonas=totalPersonas;
    }
    public void setNumHabitacion(int numHabitacion){
        this.numHabitacion=numHabitacion;
    }
    public void setFechaEntrada(long fechaEntrada){
        this.fechaEntrada=fechaEntrada;
    }
    public void setFechaSalida(long fechaSalida){
        this.fechaSalida=fechaSalida;
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
