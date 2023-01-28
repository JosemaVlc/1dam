/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author jmore
 */
public class Article {
    private String nom;
    private double preu;
    private double iva = 1.21;
    private int cuantsQueden;     
    
    public Article(String nom, double preu, double iva, int stock){
        this.nom = nom;
        if (preu > 0){ //preu deu ser major a 0€
            this.preu = preu;
        }else{
            System.out.println("El preu no pot ser negatiu ni de 0€");
        }
        if (iva == 4 || iva == 10 || iva == 21){ //el iva pot ser super reduit 4%, reduit 10% o general 21%
            this.iva = (iva/100)+1;
        }else{
            System.out.println("El iva no correspon al normalitzat a Espanya, se aplicará el 21%");
        }
        if (stock >= 0){ //no pot ser stock negatiu
            this.cuantsQueden = stock;
        }else{
            System.out.println("El stock mai pot ser menor a 0");
        }
    }
    
    public double getPVP(){
        double pvp = this.preu * this.iva;
        return pvp;
    }
    
    public void imprimeix(){
        System.out.printf("\nEl article %s te de preu %.2fe., te un IVA del %.0f%%, es queda en %.2fe. i en stock tenim %dud.\n", this.nom, this.preu, ((this.iva-1)*100), getPVP(), this.cuantsQueden);
    }
    
    public double getPVPDescompte(int descompte){
        double pvp = this.preu * this.iva;
        double pvpDescompte = (pvp * descompte) / 100;
        return pvpDescompte;
    }
    
    public boolean vendre(int x){
        boolean venta = false;
        
        if (this.cuantsQueden>=x){
            this.cuantsQueden = this.cuantsQueden-x;
            venta = true;
        }else{
            System.out.println("No hi ha Stock suficient, com a maxim es pot vendre "+cuantsQueden+" unitats");
        }
        
        return venta;
    }
    
    public boolean emmagatzema(int x){
        boolean recepcion = false;
        if (x>0){
            this.cuantsQueden += x;
            recepcion = true;
        }else{
            System.out.println("No es posible disponer de mas de 100 unidades en tu stock por lo que no ha sido posible realizar la recepcion");
        }
        return recepcion;
    }
    
    public String getNom(){
        return nom;
    }
    
    public double getPreu(){
        return preu;
    }
    
    public double getIva(){
        return iva;
    }
    
    public int getStock(){
        return cuantsQueden;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public void setPreu(double preu){
        if (preu > 0){
            this.preu = preu;
        }else{
            System.out.println("El preu no pot ser menor a 0e, el preu es mantindra en "+this.preu+"e");
        }
    }
    
    public void setIva(double iva){
        if (iva == 4 || iva == 10 || iva == 21){
            this.iva = (iva/100)+1;
        }else{
            System.out.println("El iva pot ser 4%, 10% o 21%, el iva es mantindra en "+((this.iva*100)-100)+"%");
        }
    }
    
    public void setStock(int stock){
        if (stock >= 0){
            this.cuantsQueden = stock;
        }else{
            System.out.println("El stock no pot ser menor a 0, per aixo es mantindra en "+this.cuantsQueden+"ud");
        }
    }
}
