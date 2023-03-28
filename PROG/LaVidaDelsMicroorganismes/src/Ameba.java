/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public class Ameba extends Esser {
    private static int totalAmebes = 0;
    private String estat;
    private String detall;
    private String aliment = "Tot";
    private boolean reproduccio = true;

    public Ameba(String nom, int pes, String aliment, boolean reproduccio) {
        super(nom, pes);
        
        totalAmebes++;   
    }
    
    public static int dirPoblacio(){
        return totalAmebes;
    }
    
    
    @Override
    public String mostrarEstat(){
     return "@"+ this.dirNom() + " => PES: :"+ this.dirPes();   
    }
    @Override
    public String mostrarDetall(){
        return detall;
    };
}
