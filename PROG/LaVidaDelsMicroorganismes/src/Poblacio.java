
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Es definirà una constant multiplicadora per al pes de reproducció i una altra per al màxim d’essers de cada tipus que existirà.
 * 
 * @param pesReproduccio
 * @param numeroMaxim
 */
public interface Poblacio {
    static final int pesReproduccio = 3;
    static final int numeroMaxim = 20;
    
    /**
     * Tindrà com a finalitat que cada tipus d’esser quan siga menjat reduïsca el seupropi nombre total d’individus i el general.
     */
    public void reduirPoblacio();
    
    /**
     * S’utilitzarà per a que cada tipus d’organismes definisca el seu mètode dereproducció i puga incloure un nou esser del seu tipus en la llista de essers, per la qual cosa aquestaformarà part de les dades d’entrada al mètode.
     * 
     * @param essers llista de tots l'essers
     * @throws Exception 
     */
    public void reproduir(ArrayList essers) throws Exception;
}
