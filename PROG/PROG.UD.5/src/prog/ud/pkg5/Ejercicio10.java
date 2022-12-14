/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int notas=0;
        boolean sobresaliente=false;
        do{
            do{
                System.out.print("Escribe nota: ");
                notas = entrada.nextInt();
            }while (notas>=10&&notas<=-1);
            if (notas==10){
                sobresaliente=true;
            }
        }while (notas!=-1);
        if (sobresaliente==true){
            System.out.println("Entre las notas HAY algun sobresalientes");
        }else{
            System.out.println("Entre las notas NO HAY sobresalientes");
        }
    }
}
