/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob05 {
    public static void main(String[] args) throws IOException {
                
        File diccionari = new File("./src/prog/ud/pkg11/DOCS/Diccionari");
        boolean mkdirDic = diccionari.mkdir();        
        char[] alfabeto = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
        FileWriter fw = null;
        File diccionario = null;
        Scanner sc = null;
        
        for (char i : alfabeto){
            try {
                fw = new FileWriter("./src/prog/ud/pkg11/DOCS/Diccionari/"+i+".txt");   
                diccionario = new File("./src/prog/ud/pkg11/DOCS/diccionario.txt");
                                
                sc = new Scanner(diccionario);
                
                while(sc.hasNextLine()){
                    String linea = sc.nextLine();
                    if (linea.charAt(0) == i){
                        fw.write(linea+"\n");
                    }
                }
                
                sc.close();
                fw.close();
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }               
        }
        
    }
}
