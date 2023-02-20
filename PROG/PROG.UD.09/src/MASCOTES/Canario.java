/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

/**
 *
 * @author jmore
 */
public class Canario extends Aves{
    private String color;
    private boolean canta;
    
    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, String color, boolean canta){
        super(nombre, edad, estado, fechaNacimiento, true, pico);
        this.color = color;
        this.canta = canta;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCanta() {
        return canta;
    }

    public void setCanta(boolean canta) {
        this.canta = canta;
    }
    
    
    @Override
    public void muestra(){
        System.out.println("El canario de pico "+this.pico+" llamado "+ this.nombre +" de color "+ this.color + " con una edad de "+ this.edad + " años y nacido el " + this.fechaNacimiento + " esta " + this.estado);
    }
    
    @Override
    public void habla() {
        if (canta == true){
            System.out.println("Por el amooor de esa mujeeeeer, somos dos hombres con un mismo destinooo!!!");
        }else{
            System.out.println("Pio!!! \n****Pia pero no canta****");
        }
    }
    
    @Override
    public void volar(){
        System.out.println("****El canario sobrevuela la habitacion****");
    }
}
