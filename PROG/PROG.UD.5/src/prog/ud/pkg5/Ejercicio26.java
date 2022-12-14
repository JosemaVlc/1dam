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
public class Ejercicio26 {
    public static void main(String[] args){
        //inicializamos e introducimos variables
        Scanner entrada = new Scanner (System.in);
        int primo=0;
        int cont=0;
        int max=0;
        int min=0;
        int suma=0;
        float mediana=0;
        do {
            //pedimos un numero
            System.out.print("Introduce un numero: ");
            int num=entrada.nextInt();
            int i=num;//divisor regresivo
            primo=0;//contador de divisiones sin resto
            //Calculamos si son primos.
            while(i!=0){
                if (num%i==0){
                    primo++;
                }
                i--;
            }
            //si no son primos hacemos los calculos
            if (primo!=2){
                //si es mayor sustituimos el maximo anterior por este.
                if (num>max){
                    max=num;
                }
                //si es menor o si el contador es cero sustituimos el minimo por este
                if ((num<min)||(cont==0)){
                    min=num;
                }
                //sumamos el acumulado con este
                suma=suma+num;
                //sumamos 1 al contador para saber cuantos numeros no primos han introducido
                cont++;
            }
        }while(primo!=2);//si es diferente a 2 volvemos al do
        System.out.println("has introducido "+cont+" numero que no primos");
        System.out.println("Maximo: "+max);
        System.out.println("Minimo: "+min);
        mediana=(float)suma/(float)cont;
        System.out.println("Mediana "+(float) mediana);
    }
}
