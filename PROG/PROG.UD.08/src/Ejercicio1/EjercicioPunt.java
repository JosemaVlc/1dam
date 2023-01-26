/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;
import Ejercicio1.Punt;
/**
 *
 * @author jmore
 */
public class EjercicioPunt {
    
    public static void main(String[] args) {
        Punt coordenadas1 = new Punt();
        Punt coordenadas2 = new Punt();
        Punt coordenadas3 = new Punt();
        
        coordenadas1.x = 5;
        coordenadas1.y = 0;
        
        coordenadas2.x = 10;
        coordenadas2.y = 10;
        
        coordenadas3.x = -3;
        coordenadas3.y = 7;
        
        System.out.println("Les coordenades 1 son: x="+coordenadas1.x+" y="+coordenadas1.y);
        System.out.println("Les coordenades 1 son: x="+coordenadas2.x+" y="+coordenadas2.y);
        System.out.println("Les coordenades 1 son: x="+coordenadas3.x+" y="+coordenadas3.y);
        
        coordenadas2.x = coordenadas1.x * 3;
        System.out.println("Les coordenades 1 son: x="+coordenadas2.x+" y="+coordenadas2.y);
        
        
    }


    
}
