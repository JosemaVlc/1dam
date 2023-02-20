/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MASCOTES;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class main {
    public static void main(String[] args) {
        String opc = "a";
        
        //se genera el arraylist de mascotas
        ArrayList<Mascotas> inventario = new ArrayList();
        
        //se genera un objeto y se manda el arraylist
        Inventari referencia = new Inventari(inventario);
        
        //introduzco varios objetos de Mascotas para no empezar con la tabla vacia
        Perro ref01 = new Perro("Otto", 10, "sano", "04/06/2008", "perro de aguas español", false);
        Gato ref02 = new Gato("Thor", 3, "sano", "10/02/2020", "perro de aguas español", false);
        Gato ref03 = new Gato("Naranjin", 3, "sano", "18/09/2020", "siames", true);
        Perro ref04 = new Perro("Charlie", 10, "enfermo", "19/02/2013", "galgo", true);
        Loro ref05 = new Loro("Popeye", 20, "sano", "23/10/2013", "largo", "Guatemala", true);
        Loro ref06 = new Loro("Olivia", 20, "enfermo", "23/10/2013", "largo", "Guatemala", false);
        Canario ref07 = new Canario("Shinchan", 20, "sano", "23/10/2013", "largo", "Amarillo", true);
        Canario ref08 = new Canario("Himagari", 3, "sano", "23/10/2020", "largo", "Blanco", false);
        
        //se introducen los objetos a la arraylist
        inventario.add(ref01);
        inventario.add(ref02);
        inventario.add(ref03);
        inventario.add(ref04);
        inventario.add(ref05);
        inventario.add(ref06);
        inventario.add(ref07);
        inventario.add(ref08);
        
        do{  
            System.out.println("""
                               ******* OPCIONES *************************************
                               *                                                    *
                               * 1 - Muestra la lista de animales(Nombre y tipo).   *
                               * 2 - Muestra todos los datos de un animal concreto. *
                               * 3 - Muestra todos los datos de todos los animales. *
                               * 4 - Muestra todos los datos de un tipo de animal.  * 
                               * 5 - Insertar Animales al inventario.               *
                               * 6 - Eliminar Animales del invertario.              *
                               * 7 - Vaciar inventario.                             *
                               *                                                    *
                               * 0 - Salir                                          *
                               *                                                    *
                               *                                                    *
                               ******************************************************
                               """);
            System.out.print("Introduce opcion \n-> ");

            opc = opc();
            
            switch (opc){
                case "0":
                    System.out.println("Adios");
                    break;
                case "1":
                    referencia.verTipoyNombre();
                    break;
                case "2":
                    referencia.verAnimalConcreto();
                    break;
                case "3":
                    referencia.verAnimales();
                    break;
                case "4":
                    menuVerMascota(referencia);
                    break;
                case "5":
                    menuAddMascota(referencia);
                    break;
                case "6":
                    referencia.eliminarAnimal();
                    break;
                case "7":
                    referencia.vaciarInventario();
                    break;
                default:
                    System.out.println("Selecciona una opcion valida");
                    break;       
            }
        }while(!"0".equals(opc));
    }
    
    public static String opc(){
        Scanner entrada = new Scanner(System.in);
        String opc = entrada.nextLine();
        return opc;
    }
    
    
    public static void menuAddMascota(Inventari referencia){
        System.out.println("""
                        ******* OPCIONES *************************************
                        *                                                    *
                        * **********Tipo de Mascota*****************************                                                    *
                        * *                                                    *
                        * * 1 - Introducir nuevo perro.                        *
                        * * 2 - Introducir nuevo gato.                         *
                        * * 3 - Introducir nuevo loro.                         * 
                        * * 4 - Introducir nuevo canario.                      *
                        * *                                                    *
                        * * 0 - Volver al menu anterior.                       *
                        * *                                                    *
                        * ******************************************************
                        *                                                    *
                        ******************************************************
                        """);
        System.out.println("Introduce opcion \n->");
        
        String opc = opc();
        
        switch(opc){
            case "0":
                break;
            case "1":
                referencia.addPerro();
                break;
            case "2":
                referencia.addGato();
                break;
            case "3":
                referencia.addLoro();
                break;
            case "4":
                referencia.addCanario();
                break;
            default:
                System.out.println("Selecciona una opcion valida");
                break;
        }
    }
    
    
    public static void menuVerMascota(Inventari referencia){
        System.out.println("""
                            ******* OPCIONES *************************************
                            *                                                    *
                            * **********Tipo de Mascota*****************************
                            * *                                                    *
                            * * 1 - Ver perros.                                    *
                            * * 2 - Ver gatos.                                     *
                            * * 3 - Ver loros.                                     * 
                            * * 4 - Ver canarios.                                  *
                            * *                                                    *
                            * * 0 - Volver al menu anterior.                       *
                            * *                                                    *
                            * ******************************************************
                            *                                                    *
                            ******************************************************
                            """);
        System.out.print("Introduce opcion \n-> ");
        
        String opc=opc();
            
        switch(opc){
            case "0":
                break;
            case "1":
                referencia.verPerros();
                break;
            case "2":
                referencia.verGatos();
                break;
            case "3":
                referencia.verLoros();
                break;
            case "4":
                referencia.verCanarios();
                break;
            default:
                System.out.println("Selecciona una opcion valida");
                break;
        }
    }

}
