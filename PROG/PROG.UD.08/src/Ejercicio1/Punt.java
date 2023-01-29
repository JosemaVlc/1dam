/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

/**
 *
 * @author jmore
 */
public class Punt {
    private int x, y;
    
    public Punt(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void imprimeix(){
        System.out.println("Les coordenades son: ("+this.x+", "+this.y+")");
    }
    
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void desplaza(int dx, int dy){
        this.x = this.x+dx;
        this.y = this.y+dy;
    }
    
    public int distancia(Punt p){
        int p1 = p.getX()-this.x;
        int p2 = p.getY()-this.y;
        p1 = (int) Math.pow(p1, 2);
        p2 = (int) Math.pow(p2, 2);
        int suma = p1+p2;
        int distancia = (int) Math.sqrt(suma);
        return distancia;
    }
    
    public static Punt creaPuntoAleatorio(){
        Punt p = new Punt((int)(Math.random()*10),(int)(Math.random()*10));
        return p;
    }
}
