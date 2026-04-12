/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public abstract class Persona {
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String documentoIdentidad;
    private long fechaDeNacimiento;
    private String telefono;

    public Persona(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.documentoIdentidad = documentoIdentidad;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }
    public long getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad=nacionalidad;
    }
    public void setDocumentoIdentidad(String documentoIdentidad){
        this.documentoIdentidad=documentoIdentidad;
    }
    public void setFechaNacimiento(long fechaNacimiento){
        this.fechaDeNacimiento=fechaNacimiento;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
      
}
