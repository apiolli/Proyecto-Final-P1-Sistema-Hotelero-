/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Star_
 */
public class HabitacionSuite extends Habitacion{
    private String tipoCama;
    private String equipoExtra;
    
    public HabitacionSuite(String nivel, int numHabitacion, String tipo, String estado, double precioNoche, 
        int capacidad, String telefonoHabitacion, String servicios, String tipoCama, String equipoExtra) {
        super(nivel, numHabitacion, tipo, estado, precioNoche, capacidad, telefonoHabitacion, servicios);
        this.tipoCama=tipoCama;
        this.equipoExtra=equipoExtra;
    }
    
    public String getTipoCama(){
        return tipoCama;
    }
    public String getEquipoExtra(){
        return equipoExtra;
    }
    
    public void setTipoCama(String tipoCama){
        this.tipoCama=tipoCama;
    }
    public void setEquipoExtra(String equipoExtra){
        this.equipoExtra=equipoExtra;
    }
    
    
}
