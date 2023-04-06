
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Subclasse de Esser per crear y manipular les algues 
 * 
 * @author jmore
 */
public class Alga extends Esser {
    
    // ATRIBUTS DE CLASE //
    
    /**
     * Poblacio total de algues que incrementarà quan es cree una nova i es reduirà quan desaparega.
     */
    private static int totalAlgues = 0;
    
    // ATRIBUTS D'INSTANCIA //
    
    /**
     * Indicarà quin és el tipus d’alimentació que té
     */
    private Aliment aliment;
    
    /**
     * Indica si pot reproduirse o no
     */
    private boolean reproduccio;
    
    // CONSTRUCTORS //
    
    /**
     * Crea un a nova alga en el nom ALGA y un pes base, que se alimenta de tot y es pot reproduir
     * Ademes sumará 1 a la poblacio total d'algues.
     */
    public Alga(){
        super("ALGA", pesAlga);
        aliment = aliment.Nutrient;
        reproduccio = true;
        totalAlgues++;
    }
    
    // METODES DE CLASSE //
    
    /**
     * Indicarà el total de individus d’aquesta classe
     * 
     * @return Retorna el nombre de individus de algues.
     */
    public static int dirPoblacio(){
        return totalAlgues;
    }
    
    // METODES HERETATS //
    
    /**
     * Mostrarà un missatge amb l'estat generic de l'alga
     * 
     * @return Retorna l'estat de l'alga
     */
    @Override
    public String mostrarEstat(){
        return "# " + this.dirNom() + " => PES: " + this.dirPes();
    }
    
    /**
     * Mostrarà un missatge amb l'estat detallat de la ameba
     * 
     * @return Retorna el detall de l'ameba
     */
    @Override
    public String mostrarDetall(){
        return "# " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    }
    
    // METODES DE INTERFACE //
    
    /**
     * Tindrà com a finalitat que cada tipus d’esser quan siga menjat reduïsca el seu propi 
     * nombre total d’individus i el general.
     */
    @Override
    public void reduirPoblacio(){
        --totalAlgues;
        super.reduirPoblacio();
    }
    
    /**
     * Les algues sols mengen nutrients. Bàsicament el que es fa és incorporar el pes d’un nutrient alpes de l’alga.
     * Incrementarà el seu pes amb el pes constant del nutrient que s’ha menjat.
     * Informarà de qui és la víctima i a qui s’ha menjat amb un text
     * Si el pes actual de l’alga es major que el doble del pes base de l’alga per la constant pes de reproducció es reproduirà.
     * 
     * @param essers Llista total del essers actuals.
     * @throws Exception Error si no pot reproduirse.
     */
    @Override
    public void menjar(ArrayList essers) throws Exception{
        this.canviaPes(pesNutrients);
        System.out.println("ALIMENTACIO **** " + this.dirNom() + ": m'he menjat a " + "un nutriente" +". Ara pese " + this.dirPes());
        if (this.dirPes() > (pesAlga * 2) * pesReproduccio){
            reproduir(essers);
        }
    }
    
    /**
     * Les algues es poden reproduir més d’una vegada en funció del pes que tinguen.
     * enerarà algues (farà totes les accions del procés de reproducció) mentre el seu pes 
     * siga major o igual al pes base de l’alga per la constant del pes de reproducció.
     * Crearà una nova alga.
     * Reduirà el seu pes amb pes base de la nova alga creada.
     * Informarà amb text el nom del pare y del fill y el pes del primer.
     * 
     * @param essers Llista total del essers actuals.
     * @throws Exception Error si no pot reproduirse encara.
     */
    @Override
    public void reproduir(ArrayList essers) throws Exception{
        if (this.dirPes() >= pesAlga * pesReproduccio){
            while(this.dirPes() >= pesAlga * pesReproduccio){
                essers.add(new Alga());
                Esser esserHijo = (Esser) essers.get(essers.size()-1);
                System.out.println("REPRODUCCIO **** " + this.dirNom() + " m'he reproduït i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
                this.canviaPes(-esserHijo.dirPes());
            }
        } else {
            throw new Exception ("REPRODUCCIO **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
        }
    } 
    
}
