/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public class Poblacio {
    private int pesReproduccio = 3;
    private int numeroMaxim = 20;
    
    public void reduirPoblacio(){
        poblacio = Esser.getTotalEssers();
        --poblacio
        Esser.setTotalEssers(poblacio);
    }
    
    public void reproduir(){
        poblacio = Esser.getTotalEssers();
        ++poblacio
        Esser.setTotalEssers(poblacio);
    }
}
