package modelo;

public class HabitacionDoble extends Habitacion{

    public HabitacionDoble(int numHabitacion, String tipo, String estado, double precioNoche, String nivel, int capacidad, String telefonoHabitacion) {
        super(numHabitacion, tipo, estado, precioNoche, nivel, capacidad, telefonoHabitacion);
    }

    public HabitacionDoble(int numHabitacion, String tipo, String estado) {
        super(numHabitacion, tipo, estado);
    }
    
       
}
