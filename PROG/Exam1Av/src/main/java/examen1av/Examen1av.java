/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen1av;
import java.util.Scanner;
import funcions1av.FuncionsString;
import funcions1av.FuncionsArray;
/**
 *
 * @author jose manuel moreno
 */
public class Examen1av {
    public static void main(String[] args) {
        String frase="Aquesta es una frase de prova que anema utilitzar per a l'examen";
        int matriu[][] = {{ 8, 1, 6, 4}, { 7, 5, 3, 9}, { 4, 9, 2, 3}, {5, 7, 6, 8}};
        int opc=0;
        boolean exit=false;
        boolean verif=false;
        Scanner entrada = new Scanner(System.in);
        do{
            while(verif==false){            
                System.out.println("""
                                   === MENU ===
                                   1.- Contar aparicions d'un caracter en el string.
                                   2.- Ordenar les files de la matriu de menor a major.
                                   3.- Matriu trasposta.
                                   0.- Eixir.
                                   """);
                System.out.print("Introdueix opcio: ");
                if(entrada.hasNextInt()){
                    opc = entrada.nextInt();
                }
                if (opc > -1 && opc < 4){
                    verif=true;
                }   
            }
            switch(opc){
                case 0:
                    exit=true;
                    break;
                case 1:
                    FuncionsString.contarCaracter(frase);
                    break;
                case 2:
                    System.out.println("\nExemple Abans:\n");
                    FuncionsArray.mostrarMatriu(matriu);
                    System.out.println("\nExemple Despres:\n");
                    FuncionsArray.ordenarFiles(matriu);
                    FuncionsArray.mostrarMatriu(matriu);
                    break;
                case 3:
                    System.out.println("\nExemple Abans:\n");
                    FuncionsArray.mostrarMatriu(matriu);
                    System.out.println("\nExemple Despres:\n");
                    FuncionsArray.traspostaMatriu(matriu);
                    FuncionsArray.mostrarMatriu(matriu);
                    break;
            }
            verif=false; //sino se salta la verificacion de la siguiente vuelta y hace un bucle infinito.
        }while(exit==false);
    }
}
