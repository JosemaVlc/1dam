/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

/**
 *
 * @author jmore
 */
public abstract class Aves extends Mascotas{
    protected String pico;
    protected boolean vuela;
    
    public Aves(String nombre, int edad, String estado, String fechaNacimiento, boolean vuela, String pico){
        super (nombre, edad, estado, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }

    public String getPico() {
        return pico;
    }

    public void setPico(String pico) {
        this.pico = pico;
    }

    public boolean isVuela() {
        return vuela;
    }

    public void setVuela(boolean vuela) {
        this.vuela = vuela;
    }
    
    enum pico {
        corto, largo;
    }

    public abstract void volar();
}
