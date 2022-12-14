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
public class Ejercicio18 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nombre de operario: ");
        String nombre = entrada.next();
        System.out.print("Horas trabajadas esta semana: ");
        int horas = entrada.nextInt();
        System.out.print("Precio Hora, Tarifa Normal: ");
        int tarifa = entrada.nextInt();  
        double salario;
        if(horas>35){
            salario = 35*tarifa+(horas-35)*tarifa*1.5;
        }
        else{
            salario = horas*tarifa;
        }
        double impuesto = 0;
        if(salario>900){
            impuesto = (400*0.25)+(salario-900)*0.45;
        }
        else{
            if(salario>500){
                impuesto = (salario-500)*0.25;
            }
        }
        double neto = salario - impuesto;
        System.out.println("El salario NETO de "+nombre+" asciende a: "+neto+".-Euros Impuestos: "+impuesto+".-Euros");
    }
}
