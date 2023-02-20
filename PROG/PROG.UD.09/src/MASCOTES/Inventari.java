/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author jmore
 */
public class Inventari {
    ArrayList inventario;

    public Inventari(ArrayList<Mascotas> inventario){
        this.inventario = inventario;    
    }

    public void addPerro() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del perro");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la edad del perro");
        int edad = entrada.nextInt();
        System.out.println("Introduce el estado del perro (sano/enfermo)");
        String estado = entrada.nextLine();
        System.out.println("Introduce la fecha de nacimiento del perro (XX/XX/XXXX)");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Introduce raza");
        String raza = entrada.nextLine();
        System.out.println("Introduce si tiene pulgas (true/false)");
        Boolean pulgas = entrada.nextBoolean();
        
        Perro canido = new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgas);
        inventario.add(canido);      
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void addGato(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del gato");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la edad del gato");
        int edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce el estado del gato (sano/enfermo)");
        String estado = entrada.nextLine();
        System.out.println("Introduce la fecha de nacimiento del gato (XX/XX/XXXX)");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Introduce color");
        String color = entrada.nextLine();
        System.out.println("Introduce si tiene el pelo largo (true/false)");
        Boolean peloLargo = entrada.nextBoolean();
        entrada.nextLine();
        
        Gato felino = new Gato(nombre, edad, estado, fechaNacimiento, color, peloLargo);
        inventario.add(felino);
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void addLoro(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del loro");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la edad del loro");
        int edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce el estado del loro (sano/enfermo)");
        String estado = entrada.nextLine();
        System.out.println("Introduce la fecha de nacimiento del loro (XX/XX/XXXX)");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Introduce pico (largo/corto)");
        String pico = entrada.nextLine();
        System.out.println("Introduce el origen");
        String origen = entrada.nextLine();
        System.out.println("Introduce si habla (true/false)");
        Boolean habla = entrada.nextBoolean();
        entrada.nextLine();
        
        Loro lorito = new Loro(nombre, edad, estado, fechaNacimiento, pico, origen, habla);
        inventario.add(lorito);        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void addCanario(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Introduce el nombre del canario");
        String nombre = entrada.nextLine();
        System.out.println("Introduce la edad del canario");
        int edad = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce el estado del canario (sano/enfermo)");
        String estado = entrada.nextLine();
        System.out.println("Introduce la fecha de nacimiento del canario (XX/XX/XXXX)");
        String fechaNacimiento = entrada.nextLine();
        System.out.println("Introduce pico (largo/corto)");
        String pico = entrada.nextLine();
        System.out.println("Introduce el color");
        String origen = entrada.nextLine();
        System.out.println("Introduce si canta (true/false)");
        Boolean habla = entrada.nextBoolean();
        entrada.nextLine();
        
        Canario canarito = new Canario(nombre, edad, estado, fechaNacimiento, pico, origen, habla);
        inventario.add(canarito);        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void verAnimales(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        while(iter.hasNext()){
            Mascotas animal = (Mascotas)iter.next();  
            animal.muestra();
        }        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();   
    }
    public void verPerros(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        for(int i =0;iter.hasNext();i++){
            Mascotas animal = (Mascotas)iter.next();
            if (inventario.get(i).getClass().getSimpleName().equals("Perro")){
                animal.muestra();
            }
        }        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();   
    }
    
    public void verGatos(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        for(int i =0;iter.hasNext();i++){
            Mascotas animal = (Mascotas)iter.next();
            if (inventario.get(i).getClass().getSimpleName().equals("Gato")){
                animal.muestra();
            }
        }        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();   
    }
    
    public void verLoros(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        for(int i =0;iter.hasNext();i++){
            Mascotas animal = (Mascotas)iter.next();
            if (inventario.get(i).getClass().getSimpleName().equals("Loro")){
                animal.muestra();
            }
        }        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();   
    }
    
    public void verCanarios(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        for(int i =0;iter.hasNext();i++){
            Mascotas animal = (Mascotas)iter.next();
            if (inventario.get(i).getClass().getSimpleName().equals("Canario")){
                animal.muestra();
            }
        }        
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();   
    }
    
    public void verTipoyNombre(){
        Scanner entrada = new Scanner(System.in);
        Iterator iter = this.inventario.iterator();
        while(iter.hasNext()){
            Mascotas animal = (Mascotas)iter.next();  
            System.out.println("Nombre: "+ animal.nombre + " Tipo: " + animal.getClass().getSimpleName());
        }
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void verAnimalConcreto(){
        System.out.println("Introduzca el nombre del perro que quiera ver los datos");
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        Iterator iter = this.inventario.iterator();
        while(iter.hasNext()){
            Mascotas animal = (Mascotas)iter.next();
            if (animal.nombre.equals(nombre)){
                animal.muestra();
            }
        }
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void eliminarAnimal(){
        System.out.println("Introduzca el nombre del animal que quiera eliminar");
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        Iterator iter = this.inventario.iterator();
        for(int i =0;iter.hasNext();i++){
            Mascotas animal = (Mascotas)iter.next();
            if (animal.nombre.equals(nombre)){
                this.inventario.remove(i);
                break;
            }
        } 
        System.out.println("<---PULSA INTRO PARA CONTINUAR--->");
        entrada.nextLine();
    }
    
    public void vaciarInventario(){
        this.inventario.clear();
    } 
}
