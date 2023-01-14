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
public class ejercicio09 {
    public static void main(String[] args){
        int a=0, b=0;
        Scanner entrada = new Scanner(System.in);
        for(int i=0; i<3; i++){
            System.out.println("Introduix enter");
            if(entrada.hasNextInt()){
                a = entrada.nextInt();
            }
            if(i==0){
                b = a;
            }else{
                b = maxim(a, b);
            }
        }
        System.out.println("El mayor dels enters introduits es: "+b);
    }
    public static int maxim(int a, int b){
        int maxim=Math.max(a, b);
        return maxim;
    }
}
