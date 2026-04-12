/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Star_
 */
public class HabitacionDoble extends Habitacion{
    private String tipoCama;
    
    public HabitacionDoble(String nivel, int numHabitacion, String tipo, String estado, double precioNoche, 
        int capacidad, String telefonoHabitacion, String servicios, String tipoCama) {
        super(nivel, numHabitacion, tipo, estado, precioNoche, capacidad, telefonoHabitacion, servicios);
        this.tipoCama=tipoCama;
    }
    public String getTipoCama(){
        return tipoCama;
    }
    
}
