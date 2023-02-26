/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BANC;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public abstract class CompteBancari {
    final String IBAN;
    private double saldo;
    public static final double interesAnualBasic = 3;
    
    //constructor
    public CompteBancari(String IBAN, double saldo){
        this.IBAN = IBAN;
        this.saldo = saldo;
    }
    
    //devuelve el IBAN
    public String getIBAN() {
        return IBAN;
    }
    
    //devuelve el saldo actual
    public double getSaldo() {
        return saldo;
    }
    
    //ingresa la cuantia ingresada
    public void ingressar(double quantitat) {
        afegir(quantitat);
        System.out.println("S'ha realitzat l'ingres de "+quantitat+"eur.");
    }
    
    //extrae la cuantia ingresada
    public void retirar(double quantitat) {
        afegir(quantitat*-1);
        System.out.println("S'ha realitzat la retirada de "+quantitat+"eur.");
    }
    
    //transpasa fondos d'un compte a altre
    public void traspassar(double quantitat, CompteBancari receptor) {
        receptor.afegir(quantitat);
        afegir(quantitat*-1);
        System.out.println("S'ha realitzat el traspas de "+quantitat+"eur. a al compte "+receptor.getIBAN());
    }
    
    //añade la cuantia si es positiva y extrae si es negativa
    private void afegir(double quantitat){
        this.saldo += quantitat;
    }
    
    public abstract void calcularInteressos();
}
