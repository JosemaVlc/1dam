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
public class ejercicio19 {
    public static void main(String[] args){
        int x, y, z;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduix primer nombre: ");
        x = entrada.nextInt();
        System.out.println("Introduix segon nombre");
        y = entrada.nextInt();
        System.out.println("Introduix tercer nombre");
        z = entrada.nextInt();
        if (pitagorin(x, y, z)==true){
            System.out.println("Pitagorin estaria orgulloso");
        }else{
            System.out.println("Pitagorin no te ama");
        }
    }
    public static boolean pitagorin(int x, int y, int z){
        boolean valido = false;
        if ((x^2)+(y^2)==(z^2)){
            valido=true;
        }
        return valido;
    }
}
