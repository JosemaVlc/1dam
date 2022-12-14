/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg6;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicio04 {
    public static void main(String[] args){
        Scanner entrada =new Scanner(System.in);
        int sumaPos=0;
        int sumaNeg=0;
        int almacen[];
        almacen=new int[20];
        
        
        for(int i=0;i<almacen.length;i++){
            System.out.println(i+" - Inserta un numero: ");
            almacen[i]=entrada.nextInt();
        }
        
        
        for(int i=0;i<almacen.length;i++){
            if(almacen[i]<0){
                sumaNeg+=almacen[i];
            }else{
                sumaPos+=almacen[i];
            }
        }
        
        
        System.out.println("La suma de numeros positivos es: "+sumaPos+"\nLa suma de los numeros negativos es: "+sumaNeg);
    }
}
