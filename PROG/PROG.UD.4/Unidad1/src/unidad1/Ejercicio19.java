/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Ejercicio19 {
    public static void main(String[] args) {
        //Creación de entrada de escaner
        Scanner entrada = new Scanner(System.in);
        //Impresiones y entrada de datos
        System.out.print("Introduce el alto de la bandera en cm: ");
        int alto = entrada.nextInt();
        System.out.print("Ahora introduce el ancho: ");
        int ancho = entrada.nextInt();
        System.out.print("Quieres escudo bordado? (s/n): ");
        String bordado = entrada.next();
        //Calculos
        int area = alto*ancho; //Calculo del area
        //Precios
        double envio = 3.25; //Precio en centimos del envio
        double escudo = 2.50; //Precio en centimos del escudo
        double bandera=area*0.01; //precio encentimos de la bandera
        double total = 0;//inicializo la variable total
        //Salidas o impresiones en pantalla
        System.out.println("Gracias, Aqui tiene el desglose de su compra.\nBandera de "+area+"cm2: "+bandera+".-Euros");//imprime cabecera y precio de la bandera
        
        if("s".equals(bordado)){
          total = bandera+escudo+envio;//calculo del total con escudo
          System.out.println("Escudo: "+escudo+".-Euros");//impresion del precio del escudo
        } 
        if("n".equals(bordado)){
          total = bandera+envio;//calculo del total sin escudo
          System.out.println("Sin escudo: 0,00.-Euros");//impresion de la ausencia del escudo
        }
        System.out.println("Gastos de envio: "+envio+".-Euros\nTotal: "+total+".-Euros");//impresión de los gastos de envio y del total
        //fin
    }
}
