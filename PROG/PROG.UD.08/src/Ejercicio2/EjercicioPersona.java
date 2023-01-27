/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class EjercicioPersona {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String dni, nom, cognoms;
        int edad;
        
        System.out.print("Inserir DNI de la primera persona: ");
        dni = entrada.nextLine();
        System.out.print("Inserir Nom de la primera persona: ");
        nom = entrada.nextLine();
        System.out.print("Inserir Cognom de la primera persona: ");
        cognoms = entrada.nextLine();
        System.out.print("Inserir Edat de la primera persona: ");
        edad = entrada.nextInt();
        Persona persona1 = new Persona(dni, nom, cognoms, edad);
        
        entrada.nextLine();
        
        System.out.print("\nInserir DNI de la segona persona: ");
        dni = entrada.nextLine();
        System.out.print("Inserir Nom de la segona persona: ");
        nom = entrada.nextLine();
        System.out.print("Inserir Cognoms de la segona persona: ");
        cognoms = entrada.nextLine();
        System.out.print("Inserir Edat de la segona persona: ");
        edad = entrada.nextInt();
        Persona persona2 = new Persona(dni, nom, cognoms, edad);
        
        if (persona1.edad >= 18){
            System.out.printf("\n%s %s amb DNI %s es major d'edat \n", persona1.nom, persona1.cognoms, persona1.dni);
        }else{
            System.out.printf("\n%s %s amb DNI %s no es major d'edat\n", persona1.nom, persona1.cognoms, persona1.dni);
        }
        
        if (persona2.edad >= 18){
            System.out.printf("%s %s amb DNI %s es major d'edat \n", persona2.nom, persona2.cognoms, persona2.dni);
        }else{
            System.out.printf("%s %s amb DNI %s no es major d'edat \n", persona2.nom, persona2.cognoms, persona2.dni);
        }
    }
}
