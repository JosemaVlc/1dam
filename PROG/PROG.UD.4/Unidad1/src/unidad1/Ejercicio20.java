/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad1;
import java.util.*;
/**
 *
 * @author jmore
 */
public class Ejercicio20 {
    public static void main(String[] args) {
        //llamo entrada al scanner
        Scanner entrada = new Scanner(System.in);
        //llamada a las variable
        String sabor;
        String tipo = null;
        double precioPastel = 0;
        String nata;
        double precioNata = 0;
        String nombre;
        double precioNombre = 0;
        double precioTotal = 0;
        //recopilación de datos
        do{
            System.out.print("Escoge sabor (manzana, fresa o chocolate): ");
            sabor = entrada.nextLine();
        }while (!"chocolate".equals(sabor)&&!"fresa".equals(sabor)&&!"manzana".equals(sabor));
        if ("manzana".equals(sabor)){
            precioPastel=18;
        }
        if ("fresa".equals(sabor)){
            precioPastel=16;
        }
        if ("chocolate".equals(sabor)){
            do{
                System.out.print("Que tipo de chocolate quereis? (negro o blanco): ");
                tipo=entrada.nextLine();
                if ("negro".equals(tipo)){
                    precioPastel=14;
                }
                if ("blanco".equals(tipo)){
                    precioPastel=15;
                }
            }while (!"negro".equals(tipo)&&!"blanco".equals(tipo));
        }
        do{
            System.out.print("Quiere nata? (si/no): ");
            nata=entrada.nextLine();
            if ("si".equals(nata)){
                precioNata=2.50;
            }
        }while (!"si".equals(nata)&&!"no".equals(nata));
        do{
            System.out.print("Quereis poner un nombre? (si/no): ");
            nombre=entrada.nextLine();
            if ("si".equals(nombre)){
                precioNombre=2.75;
            }
        }while (!"si".equals(nombre)&&!"no".equals(nombre));
        //Calculo del precio total
        precioTotal=precioPastel+precioNata+precioNombre;
        //Impresión de datos
        if ("chocolate".equals(sabor)){
            System.out.println("Paltel de "+sabor+" "+tipo+": "+precioPastel+".-Euros");
        } else {
            System.out.println("Paltel de "+sabor+": "+precioPastel+".-Euros");
        }
        if ("si".equals(nata)){
            System.out.println("Con nata: "+precioNata+".-Euros");
        }
        if ("si".equals(nombre)){
            System.out.println("Con nombre: "+precioNombre+".-Euros");
        }
        System.out.println("Total: "+precioTotal+".-Euros");
    }
}
