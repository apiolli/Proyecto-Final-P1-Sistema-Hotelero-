/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Star_
 */
public class Administrador extends Persona{
    private String usuario;
    private String contrasena;
    
    public Administrador(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono,
        String usuario, String contrasena) {
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, telefono);
        this.usuario=usuario;
        this.contrasena=contrasena;
    }
    
    public String getUsuario(){
        return usuario;
    }
    public String getContrasena(){
        return contrasena;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setContrasena(String contrasena){
        this.contrasena=contrasena;
    }
    
}
