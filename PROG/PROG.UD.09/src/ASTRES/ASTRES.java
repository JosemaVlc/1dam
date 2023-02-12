/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASTRES;

/**
 *
 * @author jmore
 */
public abstract class ASTRES {
    
    private int masa, diametre_mitja, periode_rotacio_eix, periode_translacio, distancia_mitjana;
    
    public ASTRES(int masa, int diametre_mitja, int periode_rotacio_eix, int periode_translacio, int distancia_mitjana){
        
        this.masa=masa;
        this.diametre_mitja=diametre_mitja;
        this.periode_rotacio_eix=periode_rotacio_eix;
        this.periode_translacio=periode_translacio;
        this.distancia_mitjana=distancia_mitjana;
    }
    
    public abstract void muestra();
    
    public int getMasa(){
        
        return this.masa;
        
    }
    public int getDiametre_mitja(){
        
        return this.diametre_mitja;
        
    }
    public int getPeriode_rotacio_eix(){
        
        return this.periode_rotacio_eix;
        
    }
    
    public int getPeriode_translacio(){
        
        return this.periode_translacio;
        
    }
    
    public int getDistancia_mitjana(){
        
        return this.distancia_mitjana;
        
    }
    
}
