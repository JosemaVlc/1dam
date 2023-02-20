/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

/**
 *
 * @author jmore
 */
public class Loro extends Aves{
    private String origen;
    private boolean habla;
    
    public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, String origen, boolean habla){
        super(nombre, edad, estado, fechaNacimiento, true, pico);
        this.origen = origen;
        this.habla = habla;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public boolean isHabla() {
        return habla;
    }

    public void setHabla(boolean habla) {
        this.habla = habla;
    }    
    
    public void saluda(){
        if (habla == true){
            System.out.println("Hola, holita vecinito. ARrrgG!!!");
        }else{
            System.out.println("ARrrgG!!!");
        }
    }
    
    @Override
    public void muestra(){
        System.out.println("El loro de pico "+this.pico+" llamado "+ this.nombre +" de origen "+ this.origen + " con una edad de "+ this.edad + " años y nacido el " + this.fechaNacimiento + " esta " + this.estado);
    }
    
    @Override
    public void habla(){
        if (habla == true){
            System.out.println("Soy un lorito bonito. ARrrgG!!!");
        }else{
            System.out.println("ARrrgG!!!");
        }
    }
    
    @Override
    public void volar(){
        System.out.println("****Lorito sobrevuela la habitacion****");
    }
    
}
