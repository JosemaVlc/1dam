/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;
/**
 *
 * @author jmore
 */
public class EjercicioPunt {
    
    public static void main(String[] args) {
        Punt coordenadas1 = new Punt(5,0);
        Punt coordenadas2 = new Punt(10,10);
        Punt coordenadas3 = new Punt(-3,7);
        
        System.out.println("Les coordenades 1 son: x="+coordenadas1.x+" y="+coordenadas1.y);
        System.out.println("Les coordenades 1 son: x="+coordenadas2.x+" y="+coordenadas2.y);
        System.out.println("Les coordenades 1 son: x="+coordenadas3.x+" y="+coordenadas3.y);
        
        coordenadas2.x = coordenadas1.x * 3;
        System.out.println("Les coordenades 1 son: x="+coordenadas2.x+" y="+coordenadas2.y);
        
        
    }


    
}
