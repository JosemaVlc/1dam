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
public class noevaluable {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num;
        do{
            System.out.print("Dame un numero: ");
            num=entrada.nextInt();
        }while(num<1);
        System.out.print("Si n = "+num+" la succesion es:\n"+num+", ");
        
        while(num!=1){
            if (num%2==0){
                num=num/2;
            }else{
                num=num*3+1;
            }
            if (num!=1){
                System.out.print(num+", ");
            }else{
                System.out.print(num+".");
            }
        }
        
    }
}
