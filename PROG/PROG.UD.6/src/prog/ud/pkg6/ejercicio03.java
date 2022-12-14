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
public class ejercicio03 {
    public static void main(String[] args){
        Scanner entrada =new Scanner(System.in);
        float max=0;
        float min=0;
        float almacen[];
        almacen=new float[10];
        
        
        for(int i=0;i<almacen.length;i++){
            System.out.println(i+" - Inserta un numero: ");
            almacen[i]=entrada.nextFloat();
        }
        
        
        for(int i=0;i<almacen.length;i++){
            if (i==0){
                max=almacen[i];
                min=almacen[i];
            }else{
                if (almacen[i]>max){
                    max=almacen[i];
                }
                if (almacen[i]<min){
                    min=almacen[i];
                }
            }
        }
        
        
        System.out.println("Dentro de nuestro array:\nEl valor maximo es "+max+"\nEl valor minimo es "+min);
    }
    
}
