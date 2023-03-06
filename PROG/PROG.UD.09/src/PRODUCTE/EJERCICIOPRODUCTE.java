/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRODUCTE;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author jmore
 */
public class EJERCICIOPRODUCTE {
    public static void main(String[] args) {
        //Crea 5 instancias de la Class Producte
        PRODUCTE uno = new PRODUCTE("ratones",5);
        PRODUCTE dos = new PRODUCTE("monitores",10);
        PRODUCTE tres = new PRODUCTE("teclado",3);
        PRODUCTE cuatro = new PRODUCTE("regletas",7);
        PRODUCTE cinco = new PRODUCTE ("altavoces", 1);
        
        //Crea un ArrayList        
        ArrayList<PRODUCTE> llista = new ArrayList();
        
        //Afig les 5 instancies de producte al arraylist
        llista.add(uno);
        llista.add(dos);
        llista.add(tres);
        llista.add(cuatro);
        llista.add(cinco);
        
        //Visualiza el contingut del arraylist utilizant iterator
        System.out.println("- Lista con "+llista.size()+" elementos");
        Iterator iter = llista.listIterator();
        while(iter.hasNext()){
            PRODUCTE p =(PRODUCTE)iter.next();
            System.out.println(p.getNom()+" : "+p.getQuantitat());
        }
        
        //Elimina dos elements del arraylist
        llista.remove(0);
        llista.remove(0);
        
        //inserta un nuevo objeto producto en medio de la lista
        PRODUCTE seis = new PRODUCTE ("alfombrilla",2);
        llista.add(2, seis);
        
        //visualiza de nuevo el contenido de arraylista utilizando iterator
        System.out.println("- Lista con "+llista.size()+" elementos");
        iter = llista.listIterator();
        while(iter.hasNext()){
            PRODUCTE p =(PRODUCTE)iter.next();
            System.out.println(p.getNom()+" : "+p.getQuantitat());
        }
        
        //Elimina todos los valores del arraylist
        llista.clear();
        System.out.println("- Lista con "+llista.size()+" elementos");
        
    }
}
