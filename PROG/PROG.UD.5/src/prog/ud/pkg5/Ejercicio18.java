/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
/**
 *
 * @author jmore
 */
public class Ejercicio18 {
    public static void main(String[] args) {
        double suma=0;
        for(int i=5;i>0;i--){
            double potencia=Math.pow(i, 2);
            suma+=potencia;
        }
    System.out.println("La suma de cuadrados de los primeros\n5 numeros naturales dan como resultado "+suma);
    }
}
