/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author jmore
 */
public class Rectangle {
    int x1, x2, y1, y2;
    public Rectangle(int x1, int y1, int x2, int y2){
        if (x1<x2 && y1<y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }else{
            System.out.println("ERROR al instanciar rectangle");
        }
    }
    
}
