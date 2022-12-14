/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;
import java.util.Scanner;
/**
 *  Crea un programa per a realitzar càlculs relacionats amb l'altura 
 * (en metres) de persones. Demanarà un valor N i després emmagatzemarà 
 * en un array N altures introduïdes per teclat. Després mostrarà l'altura 
 * mitjana, màxima i mínima així com quantes persones mesuren per damunt i 
 * per davall de la mitjana.
 * 
 * 
 * @author jmore
 */
public class ejercicio10 {
    public static void main(String[] arg){
        Scanner entrada=new Scanner(System.in);
        float suma=0;
        float media=0;
        float max=0;
        float min=0;
        int bajos=0;
        int altos=0;
        System.out.print("Cuantas personas has medido hoy?: ");
        int N=entrada.nextInt();
        float alturas[];
        alturas=new float[N];
        
        for(int i = 0;i<alturas.length;i++){
            System.out.print("Introduce altura de cliente "+(i+1)+": ");
            alturas[i]=entrada.nextFloat();
        }
        
        for(int i = 0;i<alturas.length;i++){
            if (i==0){
                min=alturas[i];
            }
            if (alturas[i]<min){
                min=alturas[i];
            }
            if (alturas[i]>max){
                max=alturas[i];
            }
            suma+=alturas[i];
        }
        
        media=suma/N;
        
        for(int i=0; i<alturas.length; i++){
            if (alturas[i]<media){
                bajos++;
            }
            if (alturas[i]>media){
                altos++;
            }
        }
        System.out.println("La media de tus clientes es: "+media+"+\nEl cliente mas alto mide: "+max+"\nEl cliente mas bajo mide: "+min+"\nNumero de personas por encima de la media: "+altos+"\nNumero  de personas por debajo de la media: "+bajos);
    }
}