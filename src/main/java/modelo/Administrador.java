/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Star_
 */
public class Administrador extends Empleado{
        private int nivelAdmin;
        
        public Administrador(String nombre, String apellido, String nacionalidad, 
        String documentoIdentidad, long fechaDeNacimiento, String telefono,String cargo,
        double sueldo,String usuario, String contrasena, long fechaIngreso, int nivelAdmin) {
        
        super(nombre, apellido, nacionalidad, documentoIdentidad, fechaDeNacimiento, 
        telefono,cargo,sueldo,usuario,contrasena,fechaIngreso);
        
        this.nivelAdmin=nivelAdmin;
    }
        public int getNivelAdmin(){
            return nivelAdmin;
        }
        public void setNivelAdmin(int nivelAdmin){
            this.nivelAdmin=nivelAdmin;
        }
    

    
}
