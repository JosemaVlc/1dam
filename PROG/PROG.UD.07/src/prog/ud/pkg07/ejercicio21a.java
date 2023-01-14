/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;

import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class ejercicio21a {
    public static void main(String[] args) {
        int opc = menu();
        double radi = demanaRadi();
        switch (opc) {
            case 1:
                System.out.printf("La circunferencia es: %.2f %n",circumferencia(radi));
                break;
            case 2:
                System.out.printf("El area es: %.2f %n",area(radi));
                break;
            case 3:
                System.out.printf("El volum es: %.2f %n",volum(radi));
                break;
        }
    }
    public static int menu(){
        int opc = 0;            
        boolean verif=false;
        Scanner entrada = new Scanner (System.in);
        do{
            System.out.print("Selecciona entre les seguents opcions: \n1 - Circunferencia \n2 - Area \n3 - Volum \nEscriu opcio: ");
            if (entrada.hasNextInt()){
                opc = entrada.nextInt();
            }
            if (opc == 1 || opc == 2 || opc == 3){
                verif=true;
            }
        }while(verif==false);
        return opc;
    }
    public static double demanaRadi(){
        int radi=0;
        boolean verif=false;
        Scanner entrada = new Scanner (System.in);
        do{
            System.out.print("Escriu radi: ");
            if (entrada.hasNextInt()){
                radi = entrada.nextInt();
                verif = true;
            }
        }while(verif==false);
        return radi;
    }
    public static double circumferencia(double radi){
        double circumferencia = 2 * Math.PI * radi;
        return circumferencia;
    }
    public static double area(double radi){
        double area = Math.PI * Math.pow(radi, 2);
        return area;
    }
    public static double volum(double radi){
        double volum = (4/3) * Math.PI * Math.pow(radi, 3);
        return volum;
    }
}
