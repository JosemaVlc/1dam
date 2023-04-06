
import java.util.ArrayList;
import java.util.Iterator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Subclasse de Esser per crear y manipular les bacteris
 * 
 * @author jmore
 */
public class Bacteri extends Esser {
    
    // ATRIBUTS DE CLASE //
    
    /**
     * Incrementa quan es cree un nou bacteri i es reduirà quan desaparega.
     */
    private static int totalBacteris;
    
    // ATRIBUTS D'INSTANCIA //
    
    /**
     * Indica quin és el tipus d’alimentació que té
     */
    private Aliment aliment;
    
    /**
     * Indica si pot reproduir-se
     */
    private boolean reproduccio;
    
    // CONSTRUCTORS //
    
    /**
     * Constructor de bacteri sense cap parametres de entrada.
     * Crea un a nou bacteri en el nom BACTERI y un pes base, que se alimenta de algues y es pot reproduir
     * Ademes sumará 1 a la poblacio total d'amebes.
     */
    public Bacteri() {
        super("BACTERI",pesBacteri);
        this.aliment = Aliment.Alga;
        this.reproduccio = true;
        totalBacteris++; 
    }
    
    /**
     * Constructor de bacteri sense cap parametres de entrada.
     * Crea un a nou bacteri en el nom BACTERI y un pes indicat al parametre, que se alimenta de algues y es pot reproduir
     * Ademes sumará 1 a la poblacio total d'amebes.
     * 
     * @param pes Incrementara en la quantitat que vinga indicada segons el tipus d’esser que s’hajacreat.
     */
    public Bacteri(int pes) {
        super("BACTERI", pes);
        this.aliment = Aliment.Alga;
        this.reproduccio = true;
        totalBacteris++; 
    }
    
    // METODES DE CLASSE //
    
    /**
     * Indicarà el total de individus d’aquesta classe
     * 
     * @return Retorna el nombre de individus de bacteris.
     */
    public static int dirPoblacio(){
        return totalBacteris;
    }
    
    // METODES HERETATS //
    
    /**
     * Mostrarà un missatge amb l'estat generic del bacteri
     * 
     * @return Retorna l'estat del bacteri
     */
    @Override
    public String mostrarEstat(){
        return "/ " + this.dirNom() + " => PES: " + this.dirPes();
    }
    
    /**
     * Mostrarà un missatge amb l'estat detallat de la ameba
     * 
     * @return Retorna el detall de l'ameba
     */
    @Override
    public String mostrarDetall(){
        return "/ " + this.dirNom() + " => PES " + this.dirPes() + " - ALIMENTACIÓ: " + this.aliment + " - REPRODUCCIÓ: " + this.reproduccio;
    }
    
    // METODES D'INTERFICIE // 
    
    /**
     * Tindrà com a finalitat que cada tipus d’esser quan siga menjat reduïsca el seu propi 
     * nombre total d’individus i el general.
     */   
    @Override
    public void reduirPoblacio(){
        --totalBacteris;
        super.reduirPoblacio();
    }

    /**
     * Els bacteris sols mengen algues.
     * Triara un alga aleatoriament de la llista
     * Incrementara el seu pes amb el pes de l'esser que s'ha menjat.
     * Informara de qui es la victima y qui s'ha menjat
     * Reduira el totals de poblacio que corresponga
     * Elimina de la llista a la victima
     * 
     * @param essers Llista total del essers actuals.
     * @throws Exception Error si no hi han algues per a menjar
     */
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
                    System.out.println("ALIMENTACIO **** " + this.dirNom() + ": m'he menjat a " + esserInspect.dirNom() + ". Ara pese " + esserInspect.dirPes());
                    esserInspect.reduirPoblacio();
                    essers.remove(esserInspect);
                    break;
                }
            }
        }
    }    
    
    /**
     * Els bacteris es divideixen en dos fills d’igual mida.
     * Si el seu pes és major o igual al pes de reproducció multiplicat pel doble del pes base de el bacteri es portarà a terme la reproducció.
     * Crearà un nou bacteri amb la meitat del seu pes.
     * Reduirà el seu pes amb el que s’ha quedat el nou bacteri.
     * Informara qui s'ha reproduit, qui ha nascut y el pes del primer.
     * 
     * @param essers Llista total del essers actuals.
     * @throws Exception Error quan l'esser no pot reproduirse 
     */
    @Override    
    public void reproduir(ArrayList essers) throws Exception{
        if (this.dirPes() >= pesReproduccio * (pesBacteri * 2)){
            essers.add(new Bacteri(this.dirPes()/2));
            canviaPes(-this.dirPes()/2);  
            Esser esserHijo = (Esser) essers.get(essers.size()-1);
            System.out.println("REPRODUCCIO **** " + this.dirNom() + " m'he reproduit i he creat a " + esserHijo.dirNom() + ". Ara pese " + this.dirPes());
        } else{
            throw new Exception("REPRODUCCIO **** " + this.dirNom() + " amb un pes de " + this.dirPes() + " no em puc reproduir");
        }        
    }
}
