/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;

import java.util.Random;

/**
 *
 * @author jmore
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Random r = new Random();
        int num1 = r.nextInt(6)+1;
        int num2 = r.nextInt(6)+1;
        int suma=num1+num2;
        int resta=num1-num2;
        int multi=num1*num2;
        int divi=num1/num2;
        System.out.println("Los calculos con los numeros "+num1+" y "+num2+"\nSuma = "+suma+"\nResta = "+resta+"\nMultiplicacion = "+multi+"\nDivision = "+divi);
    }
}
