/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

/**
 *
 * @author jmore
 */
public class Gato extends Mascotas {
    private String color;
    private boolean peloLargo;
    
    
    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo){
        super (nombre, edad, fechaNacimiento, estado);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }
    
    @Override
    public void muestra(){
        if (peloLargo == true){
            System.out.println("Gato de pelo largo color "+ this.color + " llamado "+ this.nombre +" con una edad de "+ this.edad + " y nacido el " + this.fechaNacimiento + " esta " + this.estado);
        }else{
            System.out.println("Gato de pelo corto color "+ this.color + " llamado "+ this.nombre +" con una edad de "+ this.edad + " y nacido el " + this.fechaNacimiento + " esta " + this.estado);
        }        
    }
    
    @Override
    public void habla(){
            System.out.println("Miau!!!!");
    }
    
}
