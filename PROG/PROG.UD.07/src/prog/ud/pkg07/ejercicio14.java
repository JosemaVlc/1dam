/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class ejercicio14 {
    public static void main (String[] args){
        char lletra='a';
        int llinies=0;
        Scanner entrada = new Scanner (System.in);
        System.out.print("Introduix una lletra: ");
        if (entrada.hasNextLine()){
            lletra = entrada.nextLine().charAt(0);
        }
        System.out.print("Introuix un nombre de files: ");
        if (entrada.hasNextInt()){
            llinies = entrada.nextInt();
        }
        printTriangle(lletra, llinies);
        
    }
    public static void printTriangle(char lletra, int llinies){
        for(int i=0;i<llinies;i++){
            //imprime espacios
            int cont=0;
            for(int it=0;it<llinies-i;it++){
                cont++;
                System.out.print(" ");
            }
            //imprime lletras
            for(int it=0;it<(llinies-cont)*2-1;it++){
                System.out.print(lletra);
            }
            System.out.println();
        }
    }
}
