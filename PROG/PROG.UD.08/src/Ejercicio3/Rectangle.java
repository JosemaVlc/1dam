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
    private int x1, x2, y1, y2;
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
    
    public void imprimeix(){
        System.out.println("La primera coordenada es ("+this.x1+", "+this.y1+") y la segona es ("+this.x2+", "+this.y2+")");
    }
    
    public void setX1Y1(int x1, int y1){
        this.x1 = x1;
        this.y1 = y1;
    }
    
    public void setX2Y2(int x2, int y2){
        if(this.x1 < x2 && this.y1 < y2){
            this.x2 = x2;
            this.y2 = y2;
        }else{
            System.out.println("\nERROR al introduir coordenada, es quedara el anterior valor");   
        }
    }
    
    public void setAll(int x1, int y1, int x2, int y2){
        if (x1 < x2 && y1 < y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }else{
            System.out.println("\nERROR al introduir coordenada, es quedara el anterior valor");    
        }
    }
    
    public void setX1(int x1){
        this.x1 = x1;
    }
        
    public void setY1(int y1){
        this.y1 = y1;
    }
    
    public void setX2(int x2){
        if(x2 > this.x1){
            this.x2 = x2;
        }else{
            System.out.println("\nERROR al introduir coordenada, es quedara el anterior valor");
        }
    }
    
    public void setY2(int y2){
        if(y2 > this.y1){
            this.y2 = y2;
        }else{
            System.out.println("\nERROR al introduir coordenada, es quedara el anterior valor");
        }
    }
    
    public int getX1(){
        return x1;
    }
    
    public int getY1(){
        return y1;
    }
    
    public int getX2(){
        return x2;
    }
    
    public int getY2(){
        return y2;
    }  
    
    public int getPerimetre(){
        int perimetre = ((this.x2+1)-this.x1+(this.y2+1)-this.y1)*2;
        return perimetre;
    }
    
    public int getArea(){
        int area=((this.x2+1)-this.x1)*((this.y2+1)-this.y1);
        return area;
    }
}
