package modelo;

public class Huesped extends Persona {

    public Huesped(String nombre, String apellido, String nacionalidad, String documentoIdentidad, long fechaDeNacimiento, String telefono) {
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono);
    }

    public Huesped(String nombre, String apellido, int id) {
        super(nombre, apellido, id);
    }

    public Huesped(String nombre, String apellido) {
        super(nombre, apellido, 0);
    }
}