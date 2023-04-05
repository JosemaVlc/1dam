import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
/**
 * Projecte que construeix un ecosistema d’essers vius o microorganismes que interactuaran entre ells per a alimentar-se i per a reproduir-se. 
 * Tots els microorganismes pertanyen a un grup comú d’essers que estableix un conjunt d’elements comuns, que poden vindre definits o deixar en mans dels 
 * diferents grups d’esses la sua definició. Així doncs, el nostre ecosistema de microorganismes o Essers estarà format per Amebes, Bacteris i Algues. 
 * A més existiran uns nutrients dels que s’alimentarà la base de la cadena per anar fer engreixant al nostre ecosistema. Tota la gestió d’aquest ecosistema 
 * es farà des de un programa principal amb el que l’usuari interactuarà per consultar o provocar canvis en aquest.
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
        
        procesaMenu(essers);
        
        mostraLlistaEssers(essers);
        
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
    
    private static void procesaMenu(ArrayList essers){
        int opc;
        do{
            System.out.print("OPCIONS==> 1.-Una Interaccio, 2.-Deu Interaccions, 3.-Llistat, 4-Detall 0.-Eixir: ");
            opc = llegirNumero(0,4);
            try{
                switch (opc){
                    case 0:
                        break;
                    case 1:
                        produeixInteraccio(essers);
                        break;
                    case 2:
                        for (int i = 0; i < 10; i++){                           
                            produeixInteraccio(essers);
                        }
                        break;
                    case 3:
                        mostraLlistaEssers(essers);
                        break;
                    case 4:
                        mostrarEsser(essers);
                        break;
                    default:
                        throw new Exception ("No es una opcio valida");
                }
                if (Esser.dirPoblacio()==1){
                    System.out.println("Solamente queda un esser");
                    break;
                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }while(opc != 0);
    }

    private static void mostraLlistaEssers(ArrayList essers) {
        Iterator <Esser> it = essers.iterator();
        while(it.hasNext()){
            Esser esserInspeccionat = it.next();
            System.out.println(esserInspeccionat.mostrarEstat());
        }
        System.out.println("POBLACIO: TOTAL ESSERS=>" + Esser.dirPoblacio() + ", AMEBES=>" + Ameba.dirPoblacio() + ", BACTERIES=>" + Bacteri.dirPoblacio() + ", ALGUES=>" + Alga.dirPoblacio());        
    }

    private static void mostrarEsser(ArrayList essers) throws Exception {
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        System.out.println("Introdueix el nom d'un esser");
        String nom = sc.nextLine();
        Iterator <Esser> it = essers.iterator();
        while(it.hasNext()){
            Esser esserInspeccionat = it.next();
            if (esserInspeccionat.dirNom().equals(nom.toUpperCase())){
                System.out.println(esserInspeccionat.mostrarDetall());
                break;
            }
            contador++;
            if (contador >= essers.size()){
                throw new Exception ("ERROR: el microorganisme " + nom.toUpperCase() + " no apareix en la llista.");
            }
        }
    }

    private static void produeixInteraccio(ArrayList essers) throws Exception {
        int indexAleatori = Esser.generaAleatori(0, essers.size()); 
        int accio = Esser.generaAleatori(0, 2);
        Esser esserAleatori = (Esser) essers.get(indexAleatori);
        try{
            if (accio == 0){
                esserAleatori.reproduir(essers);
            }else{
                esserAleatori.menjar(essers);
            }   
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}   
