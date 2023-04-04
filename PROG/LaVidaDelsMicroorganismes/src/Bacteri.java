
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
public class Bacteri extends Esser {
    private static int totalBacteris;
    
    private Aliment aliment;
    private boolean reproduccio;
    
    public Bacteri() {
        super("BACTERI",pesBacteri);
        this.aliment = Aliment.Alga;
        this.reproduccio = true;
        totalBacteris++; 
    }
    
    public Bacteri(int pes) {
        super("BACTERI", pes);
        this.aliment = Aliment.Alga;
        this.reproduccio = true;
        totalBacteris++; 
    }
    
    @Override
    public String mostrarEstat(){
        return "/ " + this.dirNom() + " => PES: " + this.dirPes();
    }
    
    @Override
    public String mostrarDetall(){
        return "/ " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    }
    
    public static int dirPoblacio(){
        return totalBacteris;
    }
    
    @Override
    public void reduirPoblacio(){
        --totalBacteris;
        super.reduirPoblacio();
    }

    @Override
    public void menjar(ArrayList essers) throws Exception{
        
        if (Alga.dirPoblacio() < 1){
            throw new Exception ("No hi ha algues per menjar");
        }else{
            int aleatori = Esser.generaAleatori(0,Alga.dirPoblacio());
            
            Iterator<Esser> iterador = essers.iterator();
            while (iterador.hasNext()){
                Esser esserInspect = iterador.next();
                if(esserInspect.getClass().getSimpleName().equals("Alga") && aleatori > 0){
                    aleatori--;
                }
                else if (esserInspect.getClass().getSimpleName().equals("Alga") && aleatori == 0){
                    this.canviaPes(esserInspect.dirPes());
                    System.out.println("ALIMENTACIÓ **** " + this.dirNom() + ": m'he menjat a " + esserInspect.dirNom() + ". Ara pese " + esserInspect.dirPes());
                    esserInspect.reduirPoblacio();
                    essers.remove(esserInspect);
                    break;
                }
            }
        }
    }    
    
    @Override    
    public void reproduir(ArrayList essers) throws Exception{
        if (this.dirPes() >= pesReproduccio * (pesBacteri * 2)){
            essers.add(new Bacteri(this.dirPes()/2));
            canviaPes(-this.dirPes()/2);  
            Esser esserHijo = (Esser) essers.get(essers.size()-1);
            System.out.println("REPRODUCCIÓ **** " + this.dirNom() + " m'he reproduït i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
        } else{
            throw new Exception("REPRODUCCIÓ **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
        }        
    }
}
