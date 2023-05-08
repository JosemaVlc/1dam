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
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob03 {
    public static void main(String[] args){
        ArrayList <String> lineas = new ArrayList<>();

        File fa = new File("./src/prog/ud/pkg11/DOCS/usa_personas.txt");
        
        Scanner lector = null;

        try{
            lector = new Scanner(fa);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        while(lector.hasNextLine()){
            String linea = lector.nextLine();
            lineas.add(linea);
        }

        Collections.sort(lineas);
        
        FileWriter fb = null;
        
        try{
            fb = new FileWriter("./src/prog/ud/pkg11/DOCS/usa_personas_sorted.txt");
        
            for(String i:lineas){
                fb.write(i+"\n");
            }
            
            fb.close();
            
        }catch (IOException e){
            e.printStackTrace();
        }
        
    }
}
