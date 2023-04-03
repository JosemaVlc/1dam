
import java.util.ArrayList;
import java.util.InputMismatchException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class LaVidaDelsMicroorganismes {
    public static void main(String[] args) {
        ArrayList<Esser>essers = new ArrayList<Esser>();
        
        int nombreAmebes = 0;
        int nombreBacteris = 0;
        int nombreAlgues = 0;
        
        System.out.println("Introdueix el nombre d'amebes (entre 1 i " + Poblacio.numeroMaxim + ")");
        nombreAmebes = llegirNumero(1, Poblacio.numeroMaxim);
        System.out.println("Introdueix el minim de bacteris (entre 1 i " + Poblacio.numeroMaxim + ")");
        nombreBacteris = llegirNumero(1, Poblacio.numeroMaxim);
        System.out.println("Introdueix el minim d'algues (entre 1 i " + Poblacio.numeroMaxim + ")");
        nombreAlgues = llegirNumero(1, Poblacio.numeroMaxim);
        
        crearEssers(nombreAmebes, nombreBacteris, nombreAlgues, essers);
        
        procesaMenu();
        
        mostraLlistaEssers();
        
        System.out.println("Torna quant vulgues");
    }

    private static int llegirNumero(int min, int max) {
        Scanner sc = new Scanner(System.in);
        boolean verif = false;
        int nombre = 0;
        do{
            try{
                nombre = sc.nextInt();
                if (nombre >= min && nombre <= max){
                    verif = true;
                }else{
                    throw new Exception ("ERROR: Ha d'introduir un numero entre " + min + " i " + max + ".");
                }                     
            }
            catch (InputMismatchException e){
                System.err.println("ERROR: No s'ha introduit un valor numeric");
                sc.nextLine();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }while (verif != true);
        return nombre;
    }
    
    private static void crearEssers(int nombreAmebes, int nombreBacteris, int nombreAlgues, ArrayList essers){
        int nombreTotal = nombreAmebes + nombreBacteris + nombreAlgues;
        
        while(nombreTotal > 0){
            
            int nombreAleatori = Esser.generaAleatori(0, 3);
            
            try{
                switch (nombreAleatori){
                    case 0:
                        if (nombreAmebes > 0){
                            essers.add(new Ameba());
                            nombreAmebes--;
                            nombreTotal--;
                        }
                        break;
                    case 1:
                        if (nombreBacteris > 0){
                            essers.add(new Bacteri());
                            nombreBacteris--;
                            nombreTotal--;
                        }
                        break;
                    case 2:
                        if (nombreAlgues > 0){
                            essers.add(new Alga());
                            nombreAlgues--;
                            nombreTotal--;
                        }
                        break;
                    default:
                        throw new Exception ("No es pot insertar l'esser");
                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }
    }
    
    private static void procesaMenu(){
        int opc;
        do{
            System.out.print("OPCIONS==> 1.-Una Interacció, 2.-Deu Interaccions, 3.-Llistat, 4-Detall 0.-Eixir: ");
            opc = llegirNumero(0,4);
            
            try{
                switch (opc){
                    case 0:
                        break;
                    case 1:
                        produeixInteraccio();
                        break;
                    case 2:
                        produeixInteraccio();
                        break;
                    case 3:
                        mostraLlistaEssers();
                        break;
                    case 4:
                        mostrarEsser();
                        break;
                    default:
                        throw new Exception ("No es una opcio valida");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }while(opc != 0);
    }

    private static void mostraLlistaEssers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void produeixInteraccio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void mostrarEsser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}   
