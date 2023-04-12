/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prog.ud.pkg11;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 *
 * @author jmore
 */
public class PROGUD11 {

    /**
     * @param args the command line arguments
     */
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
                mostraInfoRuta(f);
            }
            catch (FileNotFoundException e){
                System.err.println(e);
            }
        } while (true);
    }

    private static void mostraInfoRuta(File ruta) throws FileNotFoundException{
        
        if (ruta.exists()){
            if (ruta.isFile()){
                System.out.println("[A]" + ruta.getName());
            }
            if (ruta.isDirectory()){
                File directori[] = ruta.listFiles();
                if (directori.length > 1){
                    for( int f = 0 ; f < directori.length ; f++ ){
                        if (directori[f].isDirectory()){
                            System.out.println("[*]" +directori[f].getName());
                        }
                    }
                    for( int f = 0 ; f < directori.length ; f++ ){
                        if (directori[f].isFile()){
                            System.out.println("[A]" +directori[f].getName());
                        }
                    }
                }
            }
        }else{
            throw new FileNotFoundException ("L'arxiu no existeix");
        }
    }
    
}
