
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * 
 * Es definiran les constants dels pesos que s’utilitzaran en el procés de creació dels diferents tipus d’essers:
 * 
 * @param pesAmeba pes base de la ameba
 * @param pesBacteri pes base del bacteri
 * @param pesAlga pes base del alga
 * @param pesNutrients pes dels nutrients
 */
public interface Alimentacio {
    static final int pesAmeba = 20;
    static final int pesBacteri = 10;
    static final int pesAlga = 3;
    static final int pesNutrients = 5;
    
    /**
     * on cada tipus d’esser especificarà com porta a terme l’alimentació (a qui es menja i com)..
     * @param essers llista completa de essers
     * @throws Exception 
     */
    public void menjar(ArrayList essers)throws Exception;
}
