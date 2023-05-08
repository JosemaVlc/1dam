/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob02 {
    public static void main(String[] args) throws FileNotFoundException {
        
        ArrayList<String>listaAlumnos = new ArrayList<>();
        
        File f = new File("./src/prog/ud/pkg11/DOCS/alumnos_notas.txt");
        Scanner lector = new Scanner(f);
        
        while(lector.hasNextLine()){
            String[] elemento = lector.nextLine().split(" ");
            String nombre = elemento[0];
            String apellido = elemento[1];
            double media = 0;
            for (int i = 2; i < elemento.length; i++){
                media += Integer.parseInt(elemento[i]);
            }
            media = media/(elemento.length - 2);
            listaAlumnos.add(String.valueOf(media) + " " + nombre + " " + apellido);                        
        }
            
        Collections.sort(listaAlumnos, Collections.reverseOrder());
        
        for(String i : listaAlumnos){
            String[] elemento = i.split(" ");  
            
            if ("10.0".equals(elemento[0])){
                System.out.println(i);
            }
        }
        for(String i : listaAlumnos){
            String[] elemento = i.split(" ");
            
            if (!"10.0".equals(elemento[0])){
                System.out.println(i);
            }
        }
        
    }
}
