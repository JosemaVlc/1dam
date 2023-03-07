/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 *
 * @author jmore
 * 
 * Implementa una classe Gat amb els atributs nom i edat, un constructor amb paràmetres, els
getters i setters, a més d'un mètode imprimir() per a mostrar les dades d'un gat. El nom d'un
gat ha de tindre almenys 3 caràcters i l'edat no pot ser negativa. Per això, tant en el
constructor com en els setters, hauràs de comprovar que els valores siguen vàlids i llançar un
‘Exception’ si no ho són. Després, fes una classe principal amb main per a fer proves:
instància diversos objectes Gat i utilitza els seus setters, provant diferents valors
(alguns vàlids i altres incorrectes). Maneja les excepcions.
 * 
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        //inicialitze la arraylist
        ArrayList llistaGats = new ArrayList();      
            
        //CREACIO DE GATS 
            Gat callejero1 = new Gat("Pe",7);
            llistaGats.add(callejero1);
        
        try{
            Gat callejero2 = new Gat("Pi",45);
            llistaGats.add(callejero2);
        }catch (InputMismatchException e){
            System.out.println(e);
        }

        try{
            Gat callejero3 = new Gat("Narajin",-3);
            llistaGats.add(callejero3);
        }catch (InputMismatchException e){
            System.out.println(e);
        }

        try{
            Gat callejero4 = new Gat("Narajito",7);
            llistaGats.add(callejero4);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
        
        Gat callejero5 = new Gat("Patatita",2);
        
        //IMPRIMEIX INFO
        System.out.println("- Lista con "+llistaGats.size()+" elementos");
        Iterator iter = llistaGats.listIterator();
        while(iter.hasNext()){
            Gat callejero =(Gat)iter.next();
            callejero.imprimir();
        }
        
        //UTILITZACIO DE SETTERS
        //prueba de setNom
        try{
            callejero5.setNom("Pi");
        }catch (InputMismatchException e){
            System.out.println(e);
        }
        try{
            callejero5.setNom("Pino");
        }catch (InputMismatchException e){
            System.out.println(e);
        }
        //prueba de setEdat
        try{
            callejero5.setEdat(-3);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
        try{
            callejero5.setEdat(7);
        }catch (InputMismatchException e){
            System.out.println(e);
        }
        
        callejero5.imprimir();
    }
}
