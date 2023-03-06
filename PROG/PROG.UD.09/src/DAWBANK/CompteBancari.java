/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAWBANK;
import java.util.ArrayList;
import java.util.InputMismatchException;
/**
 *
 * @author jmore
 */
public class CompteBancari {
    //INICIALIZACIONES DE CLASE
    final static private double saldoMinim = -50;
    final static private double movimentMaxim = 3000;
    final static private int maximMoviments = 100;
    
    //INICIALIZACIONES CONSTANTES
    final private String IBAN;
    final private String titular;   
    
    //INICIALIZACIONES VARIABLES
    private double saldo;
    private double[] moviment;
    private int movimentsHistorics;
    
    //CONSTRUCTORES
    public CompteBancari(String IBAN, String titular) throws InputMismatchException{
        InputMismatchException ibanInvalid = new InputMismatchException("El IBAN introduit no es valid");
        InputMismatchException titularInvalid = new InputMismatchException("El titular introduit no es valid");
        
        if (IBAN.matches("[a-zA-Z]{2}[0-9]{22}")){
            this.IBAN=IBAN;
        }else{
            throw(ibanInvalid);
        }
        if (titular.matches("^[a-zA-Z]+(([ ][a-zA-Z])?[a-zA-Z]*)*$")){
            this.titular=titular;
        }else{
            throw(titularInvalid);
        }
        this.saldo = 0;
        this.movimentsHistorics = 0;
        this.moviment = new double[maximMoviments];
    }
    
    //GETTERS

    public String getIBAN() {
        return IBAN;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    //METODES
    
    //MOSTRARA L'IBAN, EL TITULAR Y EL SALDO
    public String dadesDelCompte(){
        return String.format("L'IBAN numero %S es un compte pertenecent al titular %S i te un saldo de %.2feur.",this.IBAN,this.titular,this.saldo);
    }

    //MOSTRARA ELS MOVIMENTS REALITZATS
    public String llistatMoviments(){
        
        return String.format("L'IBAN numero %S es un compte pertenecent al titular %S i te un saldo de %.2feur.",this.IBAN,this.titular,this.saldo);
    }
    
    //REALITZARA L'INGRES SI ES POSIBLE
    public void ingres(double quantitat)throws InputMismatchException{
        InputMismatchException quantitatInvalida = new InputMismatchException("No es pot ingresar un valor de 0 o negatiu");
        
        if (quantitat>0){
            afegir(quantitat);
        }else{
            throw (quantitatInvalida);
        }
    }
    
    //REALITZARA LA RETIRADA SI ES POSIBLE
    public void retirada(double quantitat)throws InputMismatchException{
        InputMismatchException quantitatInvalida = new InputMismatchException("No es pot retirar un valor de 0 o negatiu");
        
        if (quantitat>0){
            afegir(quantitat*-1);
        }else{
            throw (quantitatInvalida);
        }
    }
    
    //AFEGIR LA CUANTIA SI ES POSITIVA I EXTRAU LA CUANTIA SI ES NEGATIVA
    private void afegir(double quantitat){
        if (this.saldo+quantitat>saldoMinim){
            if (quantitat<movimentMaxim){
                this.saldo += quantitat;
                this.moviment[movimentsHistorics] = quantitat;
                ++movimentsHistorics;
            }else{
                System.out.println("AVÍS: Notificar a hisenda");
            }
        }else{
            System.out.println("AVÍS: Saldo negatiu");
        }
    }
    
    
    
    
    

    
}
    
