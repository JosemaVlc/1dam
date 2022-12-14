/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg5;
import java.util.*;
/**
 *
 * @author jmore
 */
public class Ejercicio25 {
    public static void main (String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Introduce un numero entero positivo: ");
        long num=entrada.nextLong();
        long copiaNum=num; //Copia del numero para no perder el numero original
        int longitud=0;
        int contCapicua=0;
        int alreves=0;
        double cifraIzquierda=0;
        double cifraDerecha=0;
        //contea la longitud de la cifra dividiendo entre 10 mientra que el numero sea mayor a 0
        while (copiaNum>0){
            copiaNum=copiaNum/10;
            longitud++;
        }
        //restablecemos la copia del numero para poder calcular los numeros de la izquierda y la derecha
        copiaNum=num;
        //for para saber la cifra de la izquierda y la derecha
        for (int posicion=longitud;posicion>0;posicion--){
            
            //calculamos el numero mas a la izquierda
            double modulo = Math.pow(10, posicion-1); //Calcula la potencia para sacar la posicicion
            cifraIzquierda = copiaNum/modulo; //Saca la posicion correspondiente
            //Resta 10 hasta que el numero sea menor a 10 para cribar la unidad
            while (cifraIzquierda>10){
                cifraIzquierda=(int) cifraIzquierda-10; //result (int) para que %2 no sea dif a 0
            }
            
            //calculamos el numero mas a la derecha
            modulo = Math.pow(10, alreves); //Calcula la potencia para sacar la posición
            cifraDerecha= copiaNum/modulo; //Saca la posición correspondiente
            alreves++;//contador ascendente para sacar la potencia del siguiente bucle
            //Resta 10 hasta que el numero sea menor a 10 para cribar la unidad
            while (cifraDerecha>10){
                cifraDerecha=(int) cifraDerecha-10; //result (int) para que no tenga en cuenta los decimales
            }
            
            //Suma 1 al contador si es igual la cifra de la izquierda con la de la derecha
            if ((int)cifraIzquierda==(int)cifraDerecha){
                contCapicua++;
                }
            }
        
        //Si el contador de capicuas es igual al numero de digito es capicua
        if (contCapicua==longitud){
            System.out.println("El "+num+" es capicula");
        }else{
            System.out.println("El "+num+" no es capicula");
        }
    }
}
