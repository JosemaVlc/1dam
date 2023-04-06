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
        /**
         * Declara e inicialtza la llista on es magatzemaran l'objectes de tipus Esser
         */
        ArrayList<Esser>essers = new ArrayList<Esser>();
        
        /**
         * Variables on es magatzemaran del nombre de cada tipus de essers que l'usuari introdueix 
         */
        int nombreAmebes = 0;
        int nombreBacteris = 0;
        int nombreAlgues = 0;
        
        /**
         * Es demana a l'usuari el nombre d'essers que vol tindre de cada tipus, entre 1 i constant de maxim d'essers.
         */
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
    
    // METODES //
    
    /**
     * Per a llegir i validar cadascun dels valors que introdueix el usuari
     * tant si el nombre no esta en rango com si no es un enter donara un error.
     * 
     * @param min Valor minim que pot introduir l'usuari
     * @param max Valor maxim que pot introduir l'usuari
     * @return Valor llegit i validat
     */
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
    
    /**
     * A partir de la llista buida d’essers i dels valors indicats per l’usuari 
     * crearà de forma aleatòria els essers de cada tipus que corresponga.
     * Els esser s’introduiran en la llista de forma aleatòria fent us de la funció generaAleatori() 
     * utilitzant 3 valors per a triar en cada moment quin tipus d’esser s’insereix.
     * 
     * @param nombreAmebes nombre de amebes que se introduiran a la llista
     * @param nombreBacteris nombre de bacteris que se introduiran a la llista
     * @param nombreAlgues nombre de algues que se introduiran a la llista
     * @param essers Llista total del essers, actualment vuida.
     */
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
    
    /**
     * Mostra el menu i gestiona la interaccio amb l'usuari.
     * Valida la informacio introduida utilizant la funcio llegirNumero(..)
     * 
     * @param essers Llista total del essers
     */
    private static void procesaMenu(ArrayList essers){
        int opc;
        do{
            System.out.print("OPCIONS==> 1.-Una Interaccio, 2.-Deu Interaccions, 3.-Llistat, 4-Detall 0.-Eixir: ");
            opc = llegirNumero(0,4);
            try{
                switch (opc){
                    // Opcio 0: finalitza el bucle i anira al final del programa per mostrar la llista d'essers i donar un missatge d'acomiadament.
                    case 0:
                        break;
                    // Opcio 1: crida al metode produeixInteraccio(..) per provocar una interaccio entre essers de la llista.
                    case 1:
                        produeixInteraccio(essers);
                        break;
                    // Opcio 2: crida al metode produeixInteraccio(..) 10 vegades per provacar 10 interaccions entre essers de la llista. Si queda asoles un esser sort del bucle for
                    case 2:
                        for (int i = 0; i < 10; i++){
                            if (Esser.dirPoblacio() != 1){
                                produeixInteraccio(essers);
                            }
                        }
                        break;
                    // Opcio 3: crida al metode mostraLlistaEssers(..) per mostrar la llista de tots l'essers actuals.
                    case 3:
                        mostraLlistaEssers(essers);
                        break;
                    // Opcio 4: crida al metode mostrarEsser(..) per mostrar el detall d'un esser que trie l'usuari.
                    case 4:
                        mostrarEsser(essers);
                        break;
                    // Si la opcio no es ninguna de les anterior dona error.
                    default:
                        throw new Exception ("No es una opcio valida");
                }
                // Si asoles queda un esser ho diu en text y sort del bucle.
                if (Esser.dirPoblacio() == 1){
                    System.out.println("Solamente queda un esser");
                    break;
                }
            }
            catch (Exception e){
                System.err.println(e);
            }
        }while(opc != 0);
    }
    
    /**
     * Recorreix la llista d'essers mostrant informacio de l'estat de cadascun d'ells.
     * Finalment, donara un missatge resum del estat actual del conjunt de microorganismes que tenim a la llista
     * 
     * @param essers Llista total del essers
     */
    private static void mostraLlistaEssers(ArrayList essers) {
        Iterator <Esser> it = essers.iterator();
        while(it.hasNext()){
            Esser esserInspeccionat = it.next();
            System.out.println(esserInspeccionat.mostrarEstat());
        }
        System.out.println("POBLACIO: TOTAL ESSERS=>" + Esser.dirPoblacio() + ", AMEBES=>" + Ameba.dirPoblacio() + ", BACTERIES=>" + Bacteri.dirPoblacio() + ", ALGUES=>" + Alga.dirPoblacio());        
    }

    /**
     * L'usuari introduira un nom per teclat i es buscara en la llista per a proporcionar la informacio detallada d'aquest microorganisme.
     * 
     * @param essers Llista total del essers.
     * @throws Exception Error si no existeix eixe nom en la llista.
     */
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

    /**
     * Es tria un esser de la llista a l'atzar en la funcio genera Aleatori(..).
     * Es tria a l'atzar si aquest esser es menjara o es reproduira.
     * 
     * @param essers Llista total del essers.
     * @throws Exception Error si l'esser no pot fer l'accio prevista. 
     */
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
