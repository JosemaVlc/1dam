/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;

/**
 *
 * @author jmore
 */
public class Ejercicio11 {
    public static void main(String[] args) {
        int pares=0;
        int impares=0;
        int i;
        for (i=100;i<=200;i++){
            if (i%2==0){
                pares+=i;
            }else{
                impares+=i;
            }
        }
        System.out.println("La suma de pares da como resultado "+pares+" mientras que la suma de impares da "+impares);
    }
}
