package modelo;

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
}