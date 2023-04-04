
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public interface Poblacio {
    static final int pesReproduccio = 3;
    static final int numeroMaxim = 20;
    
    public void reduirPoblacio();
    
    public void reproduir(ArrayList essers) throws Exception;
}
