/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejerciciob06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pi = null;
        int posicion = 0;
        
        // se introduce el numero a buscar como string
        System.out.println("Introduce el numero a buscar en el numero Pi:");
        String numero = sc.nextLine();
        
        try {
            File fpi = new File("./src/prog/ud/pkg11/DOCS/pi-million.txt");
            Scanner lectura = new Scanner(fpi);
            pi = lectura.nextLine().substring(2);
            
            boolean encontrado = false;
            
            for (int i=0 ; i <= pi.length() - numero.length(); i++){
                String trozo = pi.substring(i,(numero.length() + i));
                if (trozo.equals(numero)){
                    encontrado = true;
                    posicion = i;
                    break;
                }
            }
            
            if (encontrado == true){
                System.out.println("Se ha encontrado tu numero en el primer millon de decimales de pi, mas concretamente en la posicion: "+posicion);
            }else{
                System.out.println("No se ha encontrado tu numero en el primer millon de decimales de pi");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

