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
        
        entrada.nextLine();
        
        if (persona1.getEdad() >= 18){
            System.out.printf("\n%s %s amb DNI %s es major d'edat \n", persona1.getNom(), persona1.getCognoms(), persona1.getDNI());
        }else{
            System.out.printf("\n%s %s amb DNI %s no es major d'edat\n", persona1.getNom(), persona1.getCognoms(), persona1.getDNI());
        }
        
        if (persona2.getEdad() >= 18){
            System.out.printf("%s %s amb DNI %s es major d'edat \n", persona2.getNom(), persona2.getCognoms(), persona2.getDNI());
        }else{
            System.out.printf("%s %s amb DNI %s no es major d'edat \n", persona2.getNom(), persona2.getCognoms(), persona2.getDNI());
        }
        
        System.out.print("Inserir DNI de la primera persona: ");
        dni = entrada.nextLine();
        System.out.print("Inserir Nom de la primera persona: ");
        nom = entrada.nextLine();
        System.out.print("Inserir Cognom de la primera persona: ");
        cognoms = entrada.nextLine();
        System.out.print("Inserir Edat de la primera persona: ");
        edad = entrada.nextInt();
        persona1.setNom(nom);
        persona1.setCognoms(cognoms);
        persona1.setDNI(dni);
        persona1.setEdad(edad);    
        
        entrada.nextLine();
        
        System.out.print("\nInserir DNI de la segona persona: ");
        dni = entrada.nextLine();
        System.out.print("Inserir Nom de la segona persona: ");
        nom = entrada.nextLine();
        System.out.print("Inserir Cognoms de la segona persona: ");
        cognoms = entrada.nextLine();
        System.out.print("Inserir Edat de la segona persona: ");
        edad = entrada.nextInt();
        persona2.setNom(nom);
        persona2.setCognoms(cognoms);
        persona2.setDNI(dni);
        persona2.setEdad(edad);   
        
        entrada.nextLine();
        
        System.out.println("Datos de la persona 1");
        persona1.imprimeix();
        if (persona1.esJubilat() == true) {
            System.out.println("Aquesta persona es jubilada");
        }
        if (persona1.esMajorEdat() == false){
            System.out.println("Es menor de edat");
        }else{
            System.out.println("Es major de edat");
        }
        
        System.out.println("Datos de la persona 2");
        persona2.imprimeix();
        if (persona2.esJubilat() == true) {
            System.out.println("Aquesta persona es jubilada");
        }
        if (persona2.esMajorEdat() == false){
            System.out.println("Es menor de edat");
        }else{
            System.out.println("Es major de edat");
        } 
        
        System.out.println("La diferencia entre els dos es de "+persona1.diferenciaEdat(persona2)+" anys de edat");
    }
}
