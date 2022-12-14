/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;
import java.util.Scanner;

/**
 *  Crea un programa que cree un array amb 100 números reals aleatoris entre 0.0 i 1.0,
 * utilitzant Math.random(), i després li demane a l'usuari un valor real R. Finalment, 
 * mostrarà quants valors del array són igual o superiors a R.
 *
 * @author jmore
 */
public class ejercicio08 {
    public static void main(String[] args){
        Scanner entrada = new Scanner (System.in);
        double num[];
        num=new double[100];
        for(int i=0;i<num.length;i++){
            num[i]=(Math.random()* 1.0);
        }
        
        System.out.print("Pon un numero real entre el 0,0 y 1,0: ");
        double min = entrada.nextDouble();
        
        for(int i=0;i<num.length;i++){
            if (num[i]>=min){
                System.out.println(num[i]);
            }
        }
    }
}
