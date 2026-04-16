package modelo.reservas;

import modelo.reservas.Reserva;
import modelo.personas.Huesped;
import modelo.habitaciones.Habitacion;

public class CheckIn extends Reserva {
    
    private long horaCheckin;

    public CheckIn(Huesped huesped, Habitacion habitacion, long fechaEntrada, long fechaSalida, int numPersonas, double dineroAbonado) {
        super(huesped, habitacion, fechaEntrada, fechaSalida, numPersonas, dineroAbonado);
    }
     
    
}
