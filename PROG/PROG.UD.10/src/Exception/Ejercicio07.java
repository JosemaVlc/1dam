/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

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
public class Ejercicio07 {
    public static void main(String[] args) {
        //inicialitze la arraylist, scanner y variables
        ArrayList<Gat> llista = new ArrayList(5);
        Scanner entrada = new Scanner(System.in);
        String nom;
        int edat;
        
        //Creacio de gats
        for (int i = 0; i < 5;) {
            try{
                System.out.println("Escriu el nom del gat que vols introduir");
                nom = entrada.nextLine();
                
                System.out.println("Escriu la edat del gat que vols introduir");
                edat = entrada.nextInt();
                
                Gat callejero = new Gat(nom, edat);
                entrada.nextLine();
                llista.add(callejero); 
                i++;
            }catch(InputMismatchException e){
                System.out.println(e);
                entrada.nextLine();
            }
        }
            
        //visualitzar tots els gats
        System.out.println("--------------Llistat dels "+llista.size()+" gatos--------------");
        Iterator iter = llista.listIterator();
        while(iter.hasNext()){
            Gat callejero = (Gat)iter.next();
            callejero.imprimir();
        }
    }
}
