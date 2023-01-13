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
public class ejercicio07 {
    public static void main(String[] args){
        double ample=0, alt=0, perimetre, area;
        Scanner entrada=new Scanner(System.in);
        System.out.print("Introduix el ample del rectangul: ");
        if(entrada.hasNextDouble()){
            ample = entrada.nextDouble();
        }
        System.out.print("Introduix el alt del rectangul: ");
        if(entrada.hasNextDouble()){
            alt = entrada.nextDouble();
        }
        entrada.close();
        perimetre = perimetreRectangul(ample, alt);
        area = areaRectangul(ample, alt);
        System.out.println("El perimetre de un rectangle de "+ample+" de ample y "+alt+" de altura,\nte un perimetre de "+perimetre+"\nte un area de "+area);
    }
    public static double perimetreRectangul(double ample, double alt){
        double perimetre = ample + ample + alt + alt;
        return perimetre;
    }
    public static double areaRectangul(double ample, double alt){
        double area = ample * alt;
        return area;
    }
}
