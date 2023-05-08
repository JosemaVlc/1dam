/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jmore
 */
public class ejerciciob07 {
    public static void main(String[] args) {
        ArrayList <String> alLineas = new ArrayList();
        ArrayList <String> alPalabras = new ArrayList();
        ArrayList <String> alCaracteres = new ArrayList();
        ArrayList <String> alRepeticiones = new ArrayList();
        
        File carpeta = new File("./src/prog/ud/pkg11/DOCS/LECTURAS");
        
        File[] archivos = carpeta.listFiles();
        
        Random random = new Random();
        
        int archivoAleatorio = random.nextInt(archivos.length);
        
        File archivo = new File("./"+archivos[archivoAleatorio]);
        
        try {
            Scanner lectura = new Scanner(archivo);
            while (lectura.hasNextLine()){
                String linea = lectura.nextLine();
                alLineas.add(linea);
                
                String[] palabras =  linea.split(" ");
                alPalabras.addAll(Arrays.asList(palabras));
                
                String[] caracteres = linea.split("");
                alCaracteres.addAll(Arrays.asList(caracteres));          
            }
            
            /*boolean yaEsta = false;
            
            for(String i : alPalabras){
                String palabra = i;
                int nVeces = 0;
                for (String k : alRepeticiones){
                    if (i.equals(k)){
                        yaEsta = true;
                    }
                }
                if (!yaEsta){                    
                    for(String j : alPalabras) {
                        if (i.equals(j)){
                            nVeces++;
                        }
                    }
                }
                    
                }
                String palabraVeces = palabra + " " + nVeces;
                
            }*/
            
            System.out.println("En el documento " + archivo.getName() + " hay " + alLineas.size() + " lineas, " + alPalabras.size() + " palabras y " + alCaracteres.size() + " caracteres");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }

    public ejerciciob07() {
    }
}
