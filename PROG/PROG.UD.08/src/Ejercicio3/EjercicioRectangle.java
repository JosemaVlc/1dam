/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author jmore
 */
public class EjercicioRectangle {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(0,0,5,5);
        Rectangle rectangle2 = new Rectangle(7, 9, 2,3);

        if (rectangle1.getX1()<rectangle1.getX2() && rectangle1.getY1()<rectangle1.getY2()){
            System.out.printf("\nLes coordenades del rectagle 1 son: (%d, %d) (%d, %d)", rectangle1.getX1(), rectangle1.getY1(), rectangle1.getX2(), rectangle1.getY2());
            System.out.printf("\nLa suma dels costats del rectagle 1, dona: %d",((rectangle1.getX2()+1)-(rectangle1.getX1())+(rectangle1.getY2()+1)-(rectangle1.getY1()))*2);
            System.out.printf("\nEl area del rectagle 1, dona: %d\n",((rectangle1.getX2()+1)-(rectangle1.getX1()))*((rectangle1.getY2()+1)-(rectangle1.getY1())));
        }
        if (rectangle2.getX1()<rectangle2.getX2() && rectangle2.getY1()<rectangle2.getY2()){
            System.out.printf("\nLes coordenades del rectagle 2 son: (%d, %d) (%d, %d)", rectangle2.getX1(), rectangle2.getY1(), rectangle2.getX2(), rectangle2.getY2());
            System.out.printf("\nLa suma dels costats del rectagle 2, dona: %d",((rectangle2.getX2()+1)-(rectangle2.getX1())+(rectangle2.getY2()+1)-(rectangle2.getY1()))*2);
            System.out.printf("\nEl area del rectagle 2, dona: %d\n",((rectangle2.getX2()+1)-(rectangle2.getX1()))*((rectangle2.getY2()+1)-(rectangle2.getY1())));
        }
        
        rectangle1.setX1(4);
        rectangle1.setY1(4);
        rectangle1.setX2(0);
        rectangle1.setY2(0);

        rectangle2.setX1(1);
        rectangle2.setY1(3);
        rectangle2.setX2(8);
        rectangle2.setY2(7);        
        
        if (rectangle1.getX1()<rectangle1.getX2() && rectangle1.getY1()<rectangle1.getY2()){
            System.out.printf("\nLes coordenades del rectagle 1 son: (%d, %d) (%d, %d)", rectangle1.getX1(), rectangle1.getY1(), rectangle1.getX2(), rectangle1.getY2());
            System.out.printf("\nLa suma dels costats del rectagle 1, dona: %d",((rectangle1.getX2()+1)-(rectangle1.getX1())+(rectangle1.getY2()+1)-(rectangle1.getY1()))*2);
            System.out.printf("\nEl area del rectagle 1, dona: %d\n",((rectangle1.getX2()+1)-(rectangle1.getX1()))*((rectangle1.getY2()+1)-(rectangle1.getY1())));
        }
        if (rectangle2.getX1()<rectangle2.getX2() && rectangle2.getY1()<rectangle2.getY2()){
            System.out.printf("\nLes coordenades del rectagle 2 son: (%d, %d) (%d, %d)", rectangle2.getX1(), rectangle2.getY1(), rectangle2.getX2(), rectangle2.getY2());
            System.out.printf("\nLa suma dels costats del rectagle 2, dona: %d",((rectangle2.getX2()+1)-(rectangle2.getX1())+(rectangle2.getY2()+1)-(rectangle2.getY1()))*2);
            System.out.printf("\nEl area del rectagle 2, dona: %d\n",((rectangle2.getX2()+1)-(rectangle2.getX1()))*((rectangle2.getY2()+1)-(rectangle2.getY1())));
        }    
        
        System.out.println("Ejercicio D3");
        
        rectangle1.setX1Y1(4,4);
        rectangle1.setX2Y2(7,8);

        rectangle1.imprimeix();
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle1.getPerimetre());
        
        rectangle2.setAll(1,1,9,2);
        
        rectangle2.imprimeix();
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle2.getPerimetre());
        
        Rectangle aleatorio = Rectangle.rectangleAleatori();
        aleatorio.imprimeix();
    }
}
