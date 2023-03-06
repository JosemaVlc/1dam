/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.InputMismatchException;

/**
 *
 * @author jmore
 */
public class Gat {
    private String nom;
    private int edat;
    
    //CONSTRUCTOR
    public Gat(String nom, int edat)throws InputMismatchException{
        InputMismatchException nomCorto = new InputMismatchException("No s'ha creat el gat "+nom+" per tindre el nom masa curt");
        InputMismatchException edatNegativa = new InputMismatchException("No s'ha creat el gat "+nom+" per tindre l'edat negativa");
        
        if (nom.length()<3){
            throw(nomCorto);
        }        
        if (edat<0){
            throw(edatNegativa);
        }
        
        this.nom = nom;
        this.edat = edat;
        
        System.out.println("S'ha creat el gat "+this.nom+" sense problemes");
    }
    
    //GETTER I SETTERS
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) throws InputMismatchException{
        InputMismatchException nomCorto = new InputMismatchException("Nom masa curt, no va a cambiar de "+this.nom+" a "+nom);
        if (nom.length()<3){
            throw(nomCorto);
        }
        System.out.println("S'ha cambiat el gat "+this.nom+" a "+nom+" sense problemes");
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) throws InputMismatchException{
        InputMismatchException edatNegativa = new InputMismatchException("L'edat de "+this.nom+" no pot ser negativa");
        if (edat<0){
            throw(edatNegativa);
        }
        System.out.println("S'ha cambiat del gat "+this.nom+" la edat de "+this.edat+" a "+edat+" anys sense problemes");
        this.edat = edat;
    }
    
    //Metode per mostrar les dades d'un gat
    public void imprimir(){
        System.out.printf("El gat s'anomena %s i te una edat de %d anys\n",this.nom, this.edat);
    }
}
