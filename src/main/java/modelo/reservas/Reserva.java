package modelo.reservas;

import modelo.personas.Huesped;
import modelo.habitaciones.Habitacion;

public class Reserva {
    private Huesped huesped;
    private Habitacion habitacion;
    private long fechaEntrada;
    private long fechaSalida;
    private int numPersonas;
    private double dineroAbonado;

    public Reserva(Huesped huesped, Habitacion habitacion, long fechaEntrada, long fechaSalida, int numPersonas, double dineroAbonado) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numPersonas = numPersonas;
        this.dineroAbonado = dineroAbonado;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public long getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(long fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public long getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(long fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public double getDineroAbonado() {
        return dineroAbonado;
    }

    public void setDineroAbonado(double dineroAbonado) {
        this.dineroAbonado = dineroAbonado;
    }
}