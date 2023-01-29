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
        Punt coordenadas4 = Punt.creaPuntoAleatorio();
        Punt coordenadas5 = Punt.creaPuntoAleatorio();
        Punt coordenadas6 = Punt.creaPuntoAleatorio();
        System.out.println("Coordenades4");
        coordenadas4.imprimeix();
        System.out.println("Coordenades5");
        coordenadas5.imprimeix();
        System.out.println("Coordenades6");
        coordenadas6.imprimeix();
        
        System.out.println("Les coordenades 1 son: x="+coordenadas1.getX()+" y="+coordenadas1.getY());
        System.out.println("Les coordenades 2 son: x="+coordenadas2.getX()+" y="+coordenadas2.getY());
        System.out.println("Les coordenades 3 son: x="+coordenadas3.getX()+" y="+coordenadas3.getY());
        
        coordenadas2.setX(coordenadas2.getX()*3);
                
        System.out.println("Coordenades2");
        coordenadas2.imprimeix();
        
        coordenadas3.setXY(4, 9);
        System.out.println("Coordenades3");
        coordenadas3.imprimeix();
        
        coordenadas1.desplaza(3, 4);
        System.out.println("Coordenades1");
        coordenadas1.imprimeix();
        
        int distancia = coordenadas2.distancia(coordenadas3);
        System.out.println("La distancia entre las coordenadas introducidas, son: "+distancia);
    }


    
}
