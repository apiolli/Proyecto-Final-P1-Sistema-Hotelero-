package modelo.habitaciones;

import modelo.habitaciones.Habitacion;

public class HabitacionDeluxe extends Habitacion {

    public HabitacionDeluxe(int numHabitacion, String tipo, String estado, double precioNoche, String nivel, int capacidad, String telefonoHabitacion) {
        super(numHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefonoHabitacion);
    }

    public HabitacionDeluxe(int numHabitacion, String tipo, String estado) {
        super(numHabitacion, tipo, estado);
    }

    public HabitacionDeluxe(int id, int numHabitacion) {
        super(id, numHabitacion);
    }

    public HabitacionDeluxe(int id, String nivel, int numHabitacion, String tipo, String estado, double precioNoche, int capacidad, String telefonoHabitacion) {
        super(id, nivel, numHabitacion, tipo, estado, precioNoche, capacidad, telefonoHabitacion);
    }
    
    
}