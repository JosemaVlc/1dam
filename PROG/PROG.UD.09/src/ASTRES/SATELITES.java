/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASTRES;

/**
 *
 * @author jmore
 */
public class SATELITES extends ASTRES {
    
    int distancia_planeta, orbita_planetaria;
    String planeta_pertenece;
    
    public SATELITES(int masa, int diametre_mitja, int periode_rotacio_eix, int periode_translacio, int distancia_mitjana, int distancia_planeta, int orbita_planetaria, String planeta_pertenece){
        
        super(masa, diametre_mitja, periode_rotacio_eix, periode_translacio, distancia_mitjana);
        
        this.distancia_planeta=distancia_planeta;
        this.orbita_planetaria=orbita_planetaria;
        this.planeta_pertenece=planeta_pertenece;
    
    }

    public void setDistancia_planeta(int distancia_planeta){
        
        this.distancia_planeta=distancia_planeta;
        
    }
    
    public void setOrbita_planetaria(int orbita_planetaria){
        
        this.orbita_planetaria=orbita_planetaria;
        
    }
    
    public void setPlaneta_pertenece(String planeta_pertenece){
        
        this.planeta_pertenece=planeta_pertenece;
        
    }
    public int getDistancia_planeta(){
        
        return this.distancia_planeta;
        
    }
    
    public int getOrbita_planetaria(){
        
        return this.orbita_planetaria;
        
    }
    
    public String getPlaneta_pertenece(){
        
        return this.planeta_pertenece;
        
    }

    @Override
    public void muestra() {
        
        System.out.println("hola");
        
    }
 
}
