/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

import java.util.ArrayList;

/**
 *
 * @author jmore
 */
public class Perro extends Mascotas {
    private String raza;
    private boolean pulgas;
    
    public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean pulgas){
        super (nombre, edad, estado, fechaNacimiento);
        this.pulgas = pulgas;
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }
            
    @Override
    public void muestra(){
        if (pulgas == true){
            System.out.println("El perro pulgoso de la raza "+ this.raza + " llamado "+ this.nombre +" con una edad de "+ this.edad + " y nacido el " + this.fechaNacimiento + " esta " + this.estado);
        }else{
            System.out.println("El lustroso perro de la raza "+ this.raza + " llamado "+ this.nombre +" con una edad de "+ this.edad + " y nacido el " + this.fechaNacimiento + " esta " + this.estado);
        }
}
    @Override
    public void habla(){
        System.out.println("Guau Guau!!!");
    }
}
