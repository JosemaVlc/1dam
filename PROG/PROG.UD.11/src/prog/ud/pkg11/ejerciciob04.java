/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob04 {
    public static void main(String[] args){
        ArrayList <String> nombres = new ArrayList<>();
        ArrayList <String> apellidos = new ArrayList<>();
        ArrayList <String> nombresCompletos = new ArrayList<>();
        
        File fnombres = new File("./src/prog/ud/pkg11/DOCS/usa_nombres.txt");
        File fapellidos = new File("./src/prog/ud/pkg11/DOCS/usa_apellidos.txt");
        FileWriter fNombresCompletos = null;
        
        Scanner lecturaNombres = null;
        Scanner lecturaApellidos = null;
        Scanner opc = new Scanner(System.in);
        
        // Lectura y añadido de todos los nombres a un array list
        try {
            lecturaNombres = new Scanner(fnombres);            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        while(lecturaNombres.hasNextLine()){
            String nombre = lecturaNombres.nextLine();            
            nombres.add(nombre);
        }   
        
        // Lectura y añadido de todos los apellidos a una arraylist
        try {
            lecturaApellidos = new Scanner(fnombres);            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        while(lecturaApellidos.hasNextLine()){
            String apellido = lecturaApellidos.nextLine();            
            apellidos.add(apellido);
        }
        
        System.out.print("Cuantos nombres aleatorios quieres? ->");
        int nNombres = opc.nextInt();
        
        Random random = new Random();
             
        int nInsertados = 0;
        
        while (nNombres > 0){
            int indiceAleatorioNombres = random.nextInt(nombres.size());
            String nombreAleatorio = nombres.get(indiceAleatorioNombres);

            int indiceAleatorioApellidos = random.nextInt(apellidos.size());
            String apellidoAleatorio = apellidos.get(indiceAleatorioApellidos);

            String nombreCompleto = nombreAleatorio + " " + apellidoAleatorio;
            nombresCompletos.add(nombreCompleto);
            
            nNombres--;
            nInsertados++;
        }
        
        try {
            fNombresCompletos = new FileWriter("./src/prog/ud/pkg11/DOCS/usa_personas.txt", true);
            
            for (String i : nombresCompletos){
                fNombresCompletos.write(i + "\n");
            }
            
            fNombresCompletos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        
        System.out.println(nInsertados + " Nombres completos han sido insertados.");
    }
}
