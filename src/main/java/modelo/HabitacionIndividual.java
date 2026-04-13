package modelo;

public class HabitacionIndividual extends Habitacion {

    public HabitacionIndividual(int numHabitacion, String tipo, String estado, double precioNoche, String nivel, int capacidad, String telefonoHabitacion) {
        super(numHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefonoHabitacion);
    }

    public HabitacionIndividual(int numHabitacion, String tipo, String estado) {
        super(numHabitacion, tipo, estado);
    }

    public HabitacionIndividual(int id, int numHabitacion) {
        super(id, numHabitacion);
    }

    public HabitacionIndividual(int id, String nivel, int numHabitacion, String tipo, String estado, double precioNoche, int capacidad, String telefonoHabitacion) {
        super(id, nivel, numHabitacion, tipo, estado, precioNoche, capacidad, telefonoHabitacion);
    }
    
    
}