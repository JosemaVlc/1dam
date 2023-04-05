
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
    
    // ATRIBUTS DE CLASSE //
    
    /**
     * Poblacio total de amebes que incrementarà quan es cree una nova i es reduirà quan desaparega.
     */
    private static int totalAmebes;
    
    // ATRIBUTS D'INSTANCIA //
    
    /**
     * Indicarà quin és el tipus d’alimentació que té
     */
    private Aliment aliment;
    
    /**
     * Indica si pot reproduirse o no
     */
    private boolean reproduccio;

    // CONSTRUCTOR //
    
    /**
     * Crea un a nova ameba en el nom AMEBA y un pes base, que se alimenta de tot y es pot reproduir
     * Ademes sumará 1 a la poblacio total d'amebes.
     */
    public Ameba() {
        super("AMEBA", pesAmeba);
        this.aliment = Aliment.Tot;
        this.reproduccio = true;
        totalAmebes++;   
    }
    
    // METODES DE CLASSE //
    
    /**
     * Indicarà el total de individus d’aquesta classe
     * 
     * @return Retorna el nombre de individus de Amebes.
     */
    public static int dirPoblacio(){
        return totalAmebes;
    }
    
    // METODES HERETATS //
    
    /**
     * Mostrarà un missatge amb l'estat generic de la ameba
     * 
     * @return Retorna l'estat de l'ameba
     */
    @Override
    public String mostrarEstat(){
     return "@ "+ this.dirNom() + " => PES: :"+ this.dirPes();   
    }
    
    /**
     * Mostrarà un missatge amb l'estat detallat de la ameba
     * 
     * @return Retorna el detall de l'ameba
     */
    @Override
    public String mostrarDetall(){
        return "@ " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    };
    
    /**
     * Tindrà com a finalitat que cada tipus d’esser quan siga menjat reduïsca el seu propi 
     * nombre total d’individus i el general.
     */
    @Override
    public void reduirPoblacio(){
        --totalAmebes;
        super.reduirPoblacio();
    }
    
    /**
     * Tria aleatoriament un esser qualsevol de la llista que no siga ella mateixa,
     * incrementa el seu pes amb el pes de l'esser que s'ha menjat,
     * informa de que es la victima i a qui s'ha menjat amb un text,
     * redueix els totals de poblacio que corresponga,
     * y elimina de la llista a la victima.
     * 
     * @param essers Llista total del essers actuals.
     */
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
    
    /**
     * Si el seu pes és major o igual al pes base de l’ameba multiplicat pel pes de reproducció es portarà a terme la reproducció.
     * Crearà una nova ameba.
     * Reduirà el seu pes amb el que s’ha quedat la nova ameba.
     * Informarà amb text el nom del pare y del fill y el pes del primer.
     * 
     * @param essers Llista total del essers actuals.
     * @throws Exception quan amb el seu pes no pot reproduir-se
     */
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
