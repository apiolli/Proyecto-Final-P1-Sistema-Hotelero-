/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author DELL
 */
public class HabitacionDeluxe extends Habitacion{

    public HabitacionDeluxe(int numHabitacion, String tipo, String estado, double precioNoche, String nivel, int capacidad, String telefonoHabitacion) {
        super(numHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefonoHabitacion);
    }

    public HabitacionDeluxe(int numHabitacion, String tipo, String estado) {
        super(numHabitacion, tipo, estado);
    }
    

    
}
