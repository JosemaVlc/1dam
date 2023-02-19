package MASCOTES;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public abstract class Mascotas {
    protected String nombre;
    protected int edad;
    protected String fechaNacimiento;
    protected String estado;
    
    public Mascotas(String nombre, int edad, String fechaNacimiento, String estado){
        this.edad = edad;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract void muestra();

    public abstract void habla();
    
    public void cumpleaños(){
        System.out.println("Mi cumpleaños es el "+fechaNacimiento);
    }
    
    enum estado{
        sano, enfermo;
    }
    public void morir(ArrayList referencias[]){
        
    }
}
