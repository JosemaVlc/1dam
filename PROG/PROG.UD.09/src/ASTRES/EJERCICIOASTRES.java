/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ASTRES;

import PRODUCTE.PRODUCTE;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jmore
 */
public class EJERCICIOASTRES {
    public static void main(String[] args) {
        
        PLANETAS mercurio = new PLANETAS(3285, 4879, 59, 87,77, 58,"Eliptica", 0);
        PLANETAS venus = new PLANETAS(4867,12104,-243,225,41,108,"Eliptica",0);
        PLANETAS tierra = new PLANETAS(6,12742,1,365,0,150,"Eliptica",1);
        PLANETAS marte = new PLANETAS(2,140,1,687,78,228,"Eliptica",2);
        
        ArrayList sistema_solar = new ArrayList();
        
        sistema_solar.add(mercurio);
        sistema_solar.add(venus);
        sistema_solar.add(tierra);
        sistema_solar.add(marte);
        
        System.out.println("- Lista con "+sistema_solar.size()+" elementos");
        Iterator iter = sistema_solar.listIterator();
        while(iter.hasNext()){
            PLANETAS planeta =(PLANETAS)iter.next();
            planeta.muestra();
        }
    }
}
