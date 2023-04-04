
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jmore
 */
public class Ameba extends Esser {
    private static int totalAmebes;
    
    private String estat;
    private String detall;
    private Aliment aliment;
    private boolean reproduccio;

    public Ameba() {
        super("AMEBA", pesAmeba);
        this.aliment = Aliment.Tot;
        this.reproduccio = true;
        totalAmebes++;   
    }
    
    public static int dirPoblacio(){
        return totalAmebes;
    }
    
    @Override
    public String mostrarEstat(){
     return "@ "+ this.dirNom() + " => PES: :"+ this.dirPes();   
    }
    
    @Override
    public String mostrarDetall(){
        return "@ " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    };
    
    @Override
    public void reduirPoblacio(){
        --totalAmebes;
        super.reduirPoblacio();
    }
    
    @Override
    public void menjar(ArrayList essers){
        boolean verif = false;
        do {
            int aleatori = Esser.generaAleatori(0,essers.size());
            Esser esserAleatori = (Esser)essers.get(aleatori);
            if (!esserAleatori.dirNom().equals(this.dirNom())){
                this.canviaPes(esserAleatori.dirPes());
                System.out.println("ALIMENTACIÓ **** " + this.dirNom() + ": m'he menjat a " + esserAleatori.dirNom() + ". Ara pese " + esserAleatori.dirPes());
                esserAleatori.reduirPoblacio();
                essers.remove(aleatori);
                verif = true;
            }
        }while(verif=false);       
    }
    
    @Override
    public void reproduir(ArrayList essers) throws Exception{
        if (this.dirPes() >= pesAmeba * pesReproduccio){
            essers.add(new Ameba());
            canviaPes(-pesAmeba);  
            Esser esserHijo = (Esser) essers.get(essers.size()-1);
            System.out.println("REPRODUCCIÓ **** " + this.dirNom() + " m'he reproduït i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
        } else{
            throw new Exception("REPRODUCCIÓ **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
        }
    }
}
