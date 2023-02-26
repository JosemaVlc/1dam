/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BANC;

/**
 *
 * @author jmore
 */
public class CompteEstalvi extends CompteBancari{
    final double saldoMinim = 500;
    
    //constructor
    public CompteEstalvi(String IBAN, double saldo){
        super(IBAN, saldo);
    }
    
    //retorna la info del compte
    @Override
    public String toString(){
        return "Compte Estalvi IBAN: "+ this.getIBAN() +" Saldo: "+ this.getSaldo();
    }
    
    //calcula interessos
    @Override
    public void calcularInteressos(){
        double interessos;
        if (this.getSaldo() < this.saldoMinim){
            double percent = BANC.CompteBancari.interesAnualBasic/2;
            interessos = this.getSaldo() * (percent) / 100;
        }else{
            interessos = this.getSaldo() * (BANC.CompteBancari.interesAnualBasic*2) / 100;
        }
        System.out.println("S'ha fet el ingres dels seguents interesos:\nInteressos aplicats: "+BANC.CompteBancari.interesAnualBasic+"%%\nQuantia ingresada: "+interessos+"eur.");
        ingressar(interessos);
    }    
}
