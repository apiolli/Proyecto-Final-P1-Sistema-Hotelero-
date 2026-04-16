package modelo.reservas;

import modelo.personas.Huesped;
import modelo.habitaciones.Habitacion;

public class Checkout extends CheckIn {
    
    
    public Checkout(Huesped huesped, Habitacion habitacion, long fechaEntrada, long fechaSalida, int numPersonas, double dineroAbonado) {
        super(huesped, habitacion, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);
    }
    
}
