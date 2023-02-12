/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASTRES;

/**
 *
 * @author jmore
 */
public class PLANETAS extends ASTRES {
    private int distancia_sol, satelites;
    private String orbita_sol;
    
    public PLANETAS(int masa, int diametre_mitja, int periode_rotacio_eix, int periode_translacio, int distancia_mitjana, int distancia_sol, String orbita_sol, int satelites){
        
        super(masa, diametre_mitja, periode_rotacio_eix, periode_translacio, distancia_mitjana);
        
        this.distancia_sol=distancia_sol;
        this.orbita_sol=orbita_sol;
        this.satelites=satelites;
    }

    public void setDistancia_sol(int distancia_sol){
        
        this.distancia_sol=distancia_sol;
        
    }
    
    public void setOrbita_sol(String orbita_sol){
        
        this.orbita_sol=orbita_sol;
        
    }
    
    public void setSatelites(int satelites){
        
        this.satelites=satelites;
        
    }
    public int getDistancia_sol(){
        
        return this.distancia_sol;
        
    }
    
    public String getOrbita_sol(){
        
        return this.orbita_sol;
        
    }
    
    public int getSatelites(){
        
        return this.satelites;
        
    }
    
    @Override
    public void muestra(){
        
        System.out.println("Este planeta está a "+this.distancia_sol+"km del sol y tiene "+this.satelites);
        if (this.satelites>0){
            for (int i = 0; i < this.satelites; i++) {
                
            }
        }
    }
    
}
