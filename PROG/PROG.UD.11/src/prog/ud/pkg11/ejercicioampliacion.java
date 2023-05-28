/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicioampliacion {
    public static void main(String[] args) throws IOException {
        ArrayList <String> alLineas = new ArrayList();
        ArrayList <String> alPalabras = new ArrayList();
        ArrayList <String> alCaracteres = new ArrayList();
        ArrayList <String> alRepeticiones = new ArrayList();
        
        File carpeta = new File("./src/prog/ud/pkg11/DOCS/LECTURAS");
        
        File[] archivos = carpeta.listFiles();
        
        Random random = new Random();
        
        int archivoAleatorio = random.nextInt(archivos.length);
        
        File archivo = new File("./"+archivos[archivoAleatorio]);
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linea;
            while ((linea=br.readLine())!=null){
                alLineas.add(linea);
                
                String[] palabras =  linea.split(" ");
                alPalabras.addAll(Arrays.asList(palabras));
                
                String[] caracteres = linea.split("");
                alCaracteres.addAll(Arrays.asList(caracteres));          
            }
            
            System.out.println("En el documento " + archivo.getName() + " hay " + alLineas.size() + " lineas, " + alPalabras.size() + " palabras y " + alCaracteres.size() + " caracteres");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
