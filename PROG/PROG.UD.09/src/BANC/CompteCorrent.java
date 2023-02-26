/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BANC;

/**
 *
 * @author jmore
 */
public class CompteCorrent extends CompteBancari {
    //constructor
    public CompteCorrent(String IBAN, double saldo){
        super(IBAN, saldo);
    }
    
    //retorna la info del compte
    @Override
    public String toString(){
        return "Compte Estalvi IBAN: "+ this.getIBAN() +" Saldo: "+ this.getSaldo();
    }    
    //calcula interessos y els ingresa
    @Override
    public void calcularInteressos(){
        double interessos = this.getSaldo() * BANC.CompteBancari.interesAnualBasic / 100;
        System.out.println("S'ha fet el ingres dels seguents interesos:\nInteressos aplicats: "+BANC.CompteBancari.interesAnualBasic+"%%\nQuantia ingresada: "+interessos+"eur.");
        ingressar(interessos);
        
    }
}
