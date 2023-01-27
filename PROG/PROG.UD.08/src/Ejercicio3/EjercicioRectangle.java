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

        if (rectangle1.x1!=0 || rectangle1.y1!=0 || rectangle1.x2!=0 || rectangle1.y2!=0){
            System.out.printf("\nLes coordenades del rectagle 1 son: (%d, %d) (%d, %d)", rectangle1.x1, rectangle1.y1, rectangle1.x2, rectangle1.y2);
            System.out.printf("\nLa suma dels costats del rectagle 1, dona: %d",((rectangle1.x2+1)-(rectangle1.x1)+(rectangle1.y2+1)-(rectangle1.y1))*2);
            System.out.printf("\nEl area del rectagle 1, dona: %d\n",((rectangle1.x2+1)-(rectangle1.x1))*((rectangle1.y2+1)-(rectangle1.y1)));
        }
        if (rectangle2.x1!=0 || rectangle2.y1!=0 || rectangle2.x2!=0 || rectangle2.y2!=0){
            System.out.printf("\nLes coordenades del rectagle 2 son: (%d, %d) (%d, %d)\n", rectangle2.x1, rectangle2.y1, rectangle2.x2, rectangle2.y2);
            System.out.printf("\nLa suma dels costats del rectagle 2, dona: %d \n",((rectangle2.x2+1)-(rectangle2.x1)+(rectangle2.y2+1)-(rectangle2.y1))*2);
            System.out.printf("\nEl area del rectagle 2, dona: %d\n",((rectangle2.x2+1)-(rectangle2.x1))*((rectangle2.y2+1)-(rectangle2.y1)));
        }
        
    }
}
