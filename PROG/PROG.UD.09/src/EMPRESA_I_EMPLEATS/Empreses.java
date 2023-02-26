/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EMPRESA_I_EMPLEATS;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author jmore
 */
public class Empreses {
    private final String nom;
    private final String cif;
    private String telefon;
    private String adreça;
    ArrayList<Empleats> llistaEmpleats;
    
    //constructor
    public Empreses(String nom, String cif){
        this.nom=nom;
        this.cif=cif;
        llistaEmpleats = new ArrayList<Empleats>();
    }
    
    //METODES
    
    //metode per afegir empleats
    public void afegirEmpleats(Empleats afegit){
        llistaEmpleats.add(afegit);
        System.out.println("S'ha afegit al "+this.nom+":");
        afegit.mostra();
    }
    
    //metode per eliminar empleats
    public void eliminarEmpleats(Empleats eliminat){
        llistaEmpleats.remove(eliminat);
        System.out.println("S'ha eliminat del "+this.nom+":");
        eliminat.mostra();
    }
    
    //metode per mostrar per pantalla la informació de tots els empleats
    public void informeTotsEmpleats(){
        Iterator iter = llistaEmpleats.iterator();
        System.out.println("Informe de tots els empleats del "+this.nom+":");
        while(iter.hasNext()){
            Empleats empleat = (Empleats) iter.next();
            empleat.mostra();
        }
        System.out.println("Fi de l'informe\n");
    }
    
    //metode per mostrar el DNI, sou brut y net de tots els empleats
    public void informeSouEmpleats(){
        Iterator iter = llistaEmpleats.iterator();
        System.out.println("Informe per DNI, sou brut i net de tots els empleats del "+this.nom+": ");
        while(iter.hasNext()){
            Empleats empleat = (Empleats) iter.next();
            System.out.printf("DNI: %s. Sou brut: %.2f euros. Sou net %.2f euros",empleat.getDNI(),empleat.getSouBrut(),empleat.getSouNet());
            System.out.println("");
        }
        System.out.println("Fi de l'informe\n");
    }
    
    //metode per calcular la suma total dels sous brut de tots els empleats
    public double calculaSousBruts(){
        double sumaSousBruts = 0;
        Iterator iter = llistaEmpleats.iterator();
        while (iter.hasNext()){
            Empleats empleat = (Empleats) iter.next();
            sumaSousBruts += empleat.getSouBrut();
        }
        
        return sumaSousBruts;
    }
    
    //metode per calcular la suma total del sous nets de tots els empleats
    public double calculaSousNets(){
        double sumaSousNets = 0;
        Iterator iter = llistaEmpleats.iterator();
        while (iter.hasNext()){
            Empleats empleat = (Empleats) iter.next();
            sumaSousNets += empleat.getSouNet();
        }
        
        return sumaSousNets;
    }
    
    //GETTERS I SETTERS
    
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

    public String getNom() {
        return nom;
    }

    public String getCif() {
        return cif;
    }
}
