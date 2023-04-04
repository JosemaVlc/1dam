
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public class Alga extends Esser {
    private static int totalAlgues = 0;
    
    private Aliment aliment;
    private boolean reproduccio;
    
    public Alga(){
        super("ALGA", pesAlga);
        aliment = aliment.Nutrient;
        reproduccio = true;
        totalAlgues++;
    }
    
    public static int dirPoblacio(){
        return totalAlgues;
    }
    
    @Override
    public void reduirPoblacio(){
        --totalAlgues;
        super.reduirPoblacio();
    }
    
    @Override
    public String mostrarEstat(){
        return "# " + this.dirNom() + " => PES: " + this.dirPes();
    }
    
    @Override
    public String mostrarDetall(){
        return "# " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    }
    
    @Override
    public void menjar(ArrayList essers){
        this.canviaPes(pesNutrients);
        System.out.println("ALIMENTACIÓ **** " + this.dirNom() + ": m'he menjat a " + "un nutriente" +". Ara pese " + this.dirPes());
        if (this.dirPes() > (pesAlga * 2) * pesReproduccio){
            reproduir(essers);
        }
    }
    
    // cuanto se resta del Alga cuando se reproduce y de cuanto es el alga que se genera //
    @Override
    public void reproduir(ArrayList essers){
        try{
            while(this.dirPes() >= pesAlga * pesReproduccio){
                if (this.dirPes() >= pesAlga * pesReproduccio){
                    essers.add(new Alga());
                    Esser esserHijo = (Esser) essers.get(essers.size()-1);
                    System.out.println("REPRODUCCIÓ **** " + this.dirNom() + " m'he reproduït i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
                    this.canviaPes(-esserHijo.dirPes());
                } else {
                    throw new Exception ("REPRODUCCIÓ **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
                }
            }
        }
        catch(Exception e){
            System.err.println(e);
        }
    } 
    
}
