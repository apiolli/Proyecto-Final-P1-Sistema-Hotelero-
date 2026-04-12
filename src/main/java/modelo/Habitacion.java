/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import conexion.Conexion;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public abstract class Habitacion {
    private String nivel;
    private int numHabitacion;
    private String tipo;
    private String estado;
    private double precioNoche;
    private int capacidad;
    private String telefonoHabitacion;
    private String servicios;
    
    public Habitacion(String nivel, int numHabitacion, String tipo, String estado,
        double precioNoche, int capacidad, String telefonoHabitacion, String servicios){
        this.nivel=nivel;
        this.numHabitacion=numHabitacion;
        this.tipo=tipo;
        this.estado=estado;
        this.precioNoche=precioNoche;
        this.capacidad=capacidad;
        this.telefonoHabitacion=telefonoHabitacion;
        this.servicios=servicios;
    }
    
    public String getNivel() {
        return nivel;
    }
    public int getNumHabitacion(){
        return numHabitacion;
    }
    public String getTipo(){
        return tipo;
    }
    public String getEstado(){
        return estado;
    }
    public double getPrecioNoche(){
        return precioNoche;
    }
    public int getCapacidad(){
        return capacidad;
    }
    public String getTelefonoHabitacion(){
        return telefonoHabitacion;
    }
    public String getServicios(){
        return servicios;
    }
    
    public void setNivel(String nivel){
        this.nivel=nivel;
    }
    public void setNumHabitacion(int numHabitacion){
        this.numHabitacion=numHabitacion;
    }
    public void setTipo(String tipo){
        this.tipo=tipo;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public void setPrecioNoche(double precioNoche){
        this.precioNoche=precioNoche;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public void setTelefonoHabitacion(String telefonoHabitacion){
        this.telefonoHabitacion=telefonoHabitacion;
    }
}
