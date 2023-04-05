
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Interface per definir una constant multiplicadora per al pes de reproducció i una altra per al màxim d’essers de cada tipus que existirà.
 * 
 */
public interface Poblacio {
    // CONSTANTS //
    
    /**
     * constant multiplicadora per al pes de reproduccio
     */
    static final int pesReproduccio = 3;
    
    /**
     * numero maxim d'essers de cada tipus que existira inicialment
     */
    static final int numeroMaxim = 20;
    
    // METODES //
    
    /**
     * Tindrà com a finalitat que cada tipus d’esser quan siga menjat reduïsca el seu propi nombre total d’individus i el general.
     */
    public void reduirPoblacio();
    
    /**
     * S’utilitzarà per a que cada tipus d’organismes definisca el seu mètode dereproducció i puga incloure un nou esser del seu 
     * tipus en la llista de essers, per la qual cosa aquestaformarà part de les dades d’entrada al mètode.
     * 
     * @param essers llista de tots l'essers
     * @throws Exception si hi ha un error al reproduir
     */
    public void reproduir(ArrayList essers) throws Exception;
}
