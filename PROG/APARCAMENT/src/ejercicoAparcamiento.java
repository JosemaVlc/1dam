
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import  java.util.Scanner;
/**
 *
 * @author jmore
 */
public class ejercicoAparcamiento {
    public static void main(String[] args) {
        //inicializacion de las variables
        char opc='a';
        int num;
        String matricula;
        Aparcamiento plaza[] = new Aparcamiento[20];
        
        //Se generan todas las plazas de aparcamiento
        for (int i = 0; i < plaza.length; i++) {
            plaza[i]= new Aparcamiento(i+1);
        }
        
        //generamos el menu y el switch de las opciones
        do{
            Scanner entrada = new Scanner(System.in);
            System.out.print("""
                             ========= MENU APARCAMENT ========
                             1.- Entra de vehicle
                             2.- Eixida de vehicle
                             3.- Estat d'una plaza
                             4.- Estat d'un aparcament
                             0.- Finalitzar
                             Introdueix una opcio:""");
            opc = entrada.nextLine().charAt(0);
            switch (opc){
                //salida de la aplicacion
                case '0':
                    System.out.println("Sortint de la aplicacio... \nTinga un bon dia");
                    break;
                //entrada de coche
                case '1':
                    if(Aparcamiento.getPlazasOcupada()<20){
                        System.out.print("Introdueix la matricula: ");
                        matricula = entrada.nextLine();
                        for (int i = 0; i < plaza.length; i++) {
                            if(plaza[i].getEstadoPlaza()=="LLIURE"){
                                plaza[i].setEntrada(matricula);
                                i=plaza.length;
                            }
                        }
                    }else{
                        System.out.println("Totes les places estan ocupades, torne un altre cop");
                    }
                    break;
                //salida de coches
                case '2':
                    System.out.print("Introdueix el numero de plaza: ");
                    num = entrada.nextInt();
                    if(num<=plaza.length && num>0){
                        plaza[num-1].setSalida();
                    }else{
                        System.err.println("no existeix esa plaza");
                    }
                    break;
                //ver el estado de la plaza
                case '3':
                    System.out.print("De quina plaza vol veure el estat?\n->");
                    num = entrada.nextInt();
                    if(num<=plaza.length && num>0){
                        System.out.println(plaza[num-1]);
                    }else{
                        System.err.println("no existeix esa plaza");
                    }
                    break;
                //ver el estado de todas las plazas
                case '4':
                    for (int i = 0; i < plaza.length; i++) {
                        System.out.println(plaza[i]);
                    }
                    break;
                //respuesta de opcion novalida
                default:
                    System.err.println("Opcio incorrecta o no seleccionable");
            }
        }while(opc != '0');
    }
}