
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

    @Override
    public void menjar(ArrayList essers){
        int cont = 0;
        boolean verif = false;
        
        Iterator<Esser> iterador = essers.iterator();
        while (iterador.hasNext()){
            Esser e = iterador.next();
            if(e.dirNom().matches("^ALGA")){
                cont++;
            }
        }
        try{
            if(cont > 0){
                do {
                    int aleatori = Esser.generaAleatori(0,essers.size());
                    Esser esserAleatori = (Esser)essers.get(aleatori);
                    if (esserAleatori.dirNom().matches("^ALGA")){
                        super.canviaPes(esserAleatori.dirPes());
                        System.out.println("ALIMENTACIÓ **** " + this.dirNom() + ": m'he menjat a " + esserAleatori.dirNom() + ". Ara pese " + esserAleatori.dirPes());
                        esserAleatori.reduirPoblacio();
                        essers.remove(aleatori);
                        verif = true;
                    }
                }while(verif=false);
            } else{
                throw new Exception ("No hi ha algues per menjar");
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
    }    
    
    @Override    
    public void reproduir(ArrayList essers){
        try {
            if (this.dirPes() >= pesReproduccio * (pesBacteri * 2)){
                essers.add(new Bacteri(this.dirPes()/2));
                canviaPes(-this.dirPes()/2);  
                Esser esserHijo = (Esser) essers.get(essers.size()-1);
                System.out.println("REPRODUCCIÓ **** " + this.dirNom() + " m'he reproduït i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
            } else{
                throw new Exception("REPRODUCCIÓ **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
            }
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}
