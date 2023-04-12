/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ExerciciA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Fica una ruta");
            String ruta = sc.nextLine();
            
            if (ruta == ""){
                System.out.println("Adeu");
                break;
            }
            File f = new File (ruta);
            try{
                mostraInfoRuta(f, true);
            }
            catch (FileNotFoundException e){
                System.err.println(e);
            }
        } while (true);
    }

    private static void mostraInfoRuta(File ruta, boolean info) throws FileNotFoundException{
        
        if (ruta.exists()){
            if (ruta.isFile()){
                System.out.println("[A]" + ruta.getName());
            }
            if (ruta.isDirectory()){
                File directori[] = ruta.listFiles();
                Arrays.sort(directori);
                if (directori.length > 1){
                    for( int f = 0 ; f < directori.length ; f++ ){
                        if (directori[f].isDirectory()){
                            System.out.println("[*]" +directori[f].getName());
                        }
                    }
                    for( int f = 0 ; f < directori.length ; f++ ){
                        if (directori[f].isFile()){
                            System.out.print("[A]" +directori[f].getName());
                            if (info == true){
                                System.out.print(" - "+directori[f].length()+" bytes");
                            }
                            System.out.println("");
                        }
                    }
                }
            }
        }else{
            throw new FileNotFoundException ("L'arxiu no existeix");
        }
    }    
}
