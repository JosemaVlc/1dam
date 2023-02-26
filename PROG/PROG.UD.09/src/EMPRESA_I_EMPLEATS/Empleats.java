/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EMPRESA_I_EMPLEATS;

/**
 *
 * @author jmore
 */
public class Empleats {
    
    // Atributs
    private final String nom;
    private final String DNI;
    private double souBrut;
    private int edat;
    private String telefon;
    private String adreça;
    
    //Constructor de dos atributs
    public Empleats(String nom, String DNI){
        this.nom=nom;
        this.DNI=DNI;
    }
    
    //Constructor de tres atributs
    public Empleats(String nom, String DNI, double souBrut){
        this.nom=nom;
        this.DNI=DNI;
        this.souBrut=souBrut;
    }
    
    //METODES
    
    //metode que imprimeix per pantalla la informacio d'un empleat
    public void mostra(){
        System.out.println("Empleat en DNI "+this.DNI+" anomenat "+this.nom);
    }
    
    //metode per calcular el sou net a partir del sou brut anual d'un empleat
    public double getSouNet(){
        //calcula el sou brut anual
        double souBrutAnual = this.souBrut*12;
        double irpf;
        double deduccions;
        double souNet;
        //discrimina el tipus de irpf
        if (souBrutAnual < 12000){
            irpf = 20;
        }else if (souBrutAnual >= 12000 && souBrutAnual < 25000){
            irpf = 30;
        }else{
            irpf = 40;
        }
        //aplica el irpf
        deduccions = (this.souBrut*irpf)/100;
        souNet = this.souBrut - deduccions;
        
        return souNet;
    }

    //GETTER I SETTERS
    
    public double getSouBrut() {
        return souBrut;
    }

    public void setSouBrut(double souBrut) {
        this.souBrut = souBrut;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdreça() {
        return adreça;
    }

    public void setAdreça(String adreça) {
        this.adreça = adreça;
    }
    
    public String getDNI(){
        return this.DNI;
    }
    
    public String getNom(){
        return this.nom;
    }
    
}
