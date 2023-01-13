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
public class ejercicio10 {
    public static void main (String[] args){
        int dia=0, mes=0, any=0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduix dia");
        if (entrada.hasNextInt()){
            dia = entrada.nextInt();
        }
        System.out.println("Introduix mes");
        if (entrada.hasNextInt()){
            mes = entrada.nextInt();
        }
        System.out.println("Introduix any");
        if (entrada.hasNextInt()){
            any = entrada.nextInt();
        }
        if (verifData(dia, mes, any)==true){
            System.out.println("La data es correcta");
        }else{
            System.out.println("La data es incorrecta");
        }
        
    }
    public static boolean verifData (int dia, int mes, int any){
        boolean verifData = false;
        if (dia > 0 && dia < 31){
            if (mes > 0 && mes < 13){
                if (any > 0 && any < 2024){
                    verifData = true;
                }
            }
        }
        return verifData;
    }
}
