
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */


public interface Alimentacio {
    static final int pesAmeba = 20;
    static final int pesBacteri = 10;
    static final int pesAlga = 3;
    static final int pesNutrients = 5;
    
    public void menjar(ArrayList essers)throws Exception;
}
