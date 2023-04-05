
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * Superclasse a partir de la qual es definirà la resta. Adoptarà els esquemes que s’hagen definit en el projecte, tant per a l’alimentació com per a la reproducció.
 * 
 * @param totalEssers Incrementarà quan es cree algun nou microorganisme i es reduirà quan desaparega.
 * @param consecutio Anirà incrementant a cada nou microorganisme que es cree i que s’utilitzarà per aque forme part del text que s’assignarà al nom.
 * @param pes Podrà variar en qualsevol moment (al menjar o reproduir-se).
 * @param nom Text descriptor que no es podrà modificar una vegada assignat.
 * 
 */
abstract class Esser implements Alimentacio, Poblacio{
    // ATRIBUTS DE CLASSE //
    private static int totalEssers = 0;
    private static int consecutiu = 0;
    
    // ATRIBUTS D' INSTANCIA //
    private int pes;
    private final String nom;
    
    // CONSTRUCTORS //
    
    /**
     * Constructor de Esser
     * 
     * @param nom es formarà per la concatenació d’un text que vindrà des de les subclasses (segons el tipusd’esser que corresponga) més el consecutiu d’essers (per exemple AMEBA1)
     * @param pes s’haurà d’incrementar en la quantitat que vinga indicada segons el tipus d’esser que s’hajacreat.
     */
    public Esser(String nom, int pes) {
        consecutiu++;
        this.nom = nom+consecutiu;
        this.pes = pes;
        totalEssers++;
    }
    
    // METODES //
    
    /**
     * Getter del nom de l'esser.
     * 
     * @return Retorna el nom de l'esser.
     */
    public String dirNom(){
        return this.nom;
    }
    
    /**
     * Getter del pes de l'esser.
     * 
     * @return Retorna el pes de l'esser.
     */
    public int dirPes(){
        return this.pes;
    }
    
    /**
     * incrementarà (o decrementarà) el pes de l’objecte segons el valor que li arribe.
     * 
     * @param pes Pes a sumar o restar del pes actual de l'esser
     */
    public void canviaPes(int pes){
        this.pes += pes;
    }
    
    public final static int generaAleatori(int inicial, int quantitat){
        Random aleatori = new Random();
        int valorAleatori =aleatori.nextInt(quantitat) + inicial;
        return valorAleatori;
    }
    
    public static int dirPoblacio() {
        return totalEssers;
    }
     
    @Override
    public void reduirPoblacio(){
        --totalEssers;
    }
    
    public abstract String mostrarEstat();

    public abstract String mostrarDetall();
}
