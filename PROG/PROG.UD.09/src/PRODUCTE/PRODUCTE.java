/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRODUCTE;

/**
 *
 * @author jmore
 */
public class PRODUCTE {
    String nom;
    int quantitat;
    public PRODUCTE(String nom, int quantitat) {
        this.nom = nom;
        this.quantitat = quantitat;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public void setQuantitat(int quantitat){
        this.quantitat=quantitat;
    }
    public String getNom(){
        return this.nom;
    }
    public int getQuantitat(){
        return this.quantitat;
    }
}
