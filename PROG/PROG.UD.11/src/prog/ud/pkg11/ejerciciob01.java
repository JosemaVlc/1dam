/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob01 {
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<Integer> lista = new ArrayList<>();
            
        File f = new File ("E:\\ASIGNATURAS\\PROG\\PROG.UD.11\\src\\prog\\ud\\pkg11\\DOCS\\numeros.txt");
        Scanner lector = new Scanner(f);
        
        while(lector.hasNext()){
            lista.add(lector.nextInt());
        }
        
        Collections.sort(lista);
        
        System.out.print("El valor maximo almacenado en el archivo es: ");
        System.out.print(lista.get(lista.size() - 1) + "\n");
        
        System.out.print("El valor minimo almacenado en el archivo es: ");
        System.out.print(lista.get(0) + "\n");
        lector.close();
    }
}
