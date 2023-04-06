
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Interface per anotar les constants dels pesos que s’utilitzaran en el procés de creació dels diferents tipus d’essers
 * 
 * @author jmore
 */
public interface Alimentacio {
    // CONSTANTS //
    
    /**
     * pes base de la ameba.
     */
    static final int pesAmeba = 20;
    
    /**
     * pes base del bacteri.
     */
    static final int pesBacteri = 10;
    
    /**
     * pes base del alga.
     */
    static final int pesAlga = 3;
    
    /**
     * pes base dels nutrients
     */
    static final int pesNutrients = 5;
    
    /**
     * on cada tipus d’esser especificarà com porta a terme l’alimentació (a qui es menja i com).
     * 
     * @param essers llista completa de essers
     * @throws Exception si hi ha un error al alimentarse
     */
    public void menjar(ArrayList essers)throws Exception;
}
