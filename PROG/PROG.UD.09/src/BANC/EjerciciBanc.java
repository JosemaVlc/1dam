/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BANC;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author jmore
 */
public class EjerciciBanc {
    public static void main(String[] args) {
        //crear arraylist de cuentas bancarias
        ArrayList <CompteBancari> llistaComptes = new ArrayList<CompteBancari>();
        
        //creamos dos cuentas corrientes y dos cuentas de ahorros
        CompteCorrent a = new CompteCorrent("ES00618",7.28);
        CompteCorrent b = new CompteCorrent("ES00188",359);
        CompteEstalvi c = new CompteEstalvi("ES00807",580);
        CompteEstalvi d = new CompteEstalvi("ES00807",180);
        
        //añadimos los objetos a la arraylist
        llistaComptes.add(a);
        llistaComptes.add(b);
        llistaComptes.add(c); 
        llistaComptes.add(d);
        llistaComptes.add(new CompteEstalvi("ES00481",133)); //tambien podemos crear objetos a la vez que metemos datos
        
        System.out.println(a.toString());
        
        a.ingressar(1300);
        System.out.println(a.toString());
        
        a.retirar(1000);
        System.out.println(a.toString());
        System.out.println(c.toString());
        a.traspassar(30, c);
        System.out.println(a.toString());
        System.out.println(c.toString());
        
        a.calcularInteressos();
        System.out.println(a.toString());
        
        c.calcularInteressos();
        System.out.println(c.toString());
        
        d.calcularInteressos();
        System.out.println(a.toString());
                
        
        
        
    }
    
}
