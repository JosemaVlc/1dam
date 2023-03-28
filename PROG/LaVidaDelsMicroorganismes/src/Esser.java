
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
abstract class Esser {
    private static int totalEssers = 0;
    private static int consecutiu = 1;
    
    private int pes;
    private final String nom;
             

    public Esser(String nom, int pes) {
        consecutiu++;
        this.nom = nom+consecutiu;
        this.pes = pes;
        totalEssers++;
    }
    
    public String dirNom(){
        return this.nom;
    }
    
    public int dirPes(){
        return this.pes;
    }
    
    public void canviaPes(int pes){
        this.pes += pes;
    }
    
    public static int generaAleatori(int inicial, int quantitat){
        Random aleatori = new Random();
        int valorAleatori =aleatori.nextInt(quantitat) + inicial;
        return valorAleatori;
    }
    
    public static int dirPoblacio() {
        return totalEssers;
    }
    
    public abstract String mostrarEstat();

    public abstract String mostrarDetall();
}
