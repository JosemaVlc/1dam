/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Clase Aparcamiento
 * @author jmore
 */

public class Aparcamiento {
    private int numPlaza; 
    private static int plazasOcupadas=0;
    private String estadoPlaza;
    private String matricula;
    
    /**
     * Constructor del aparcamiento.
     * @param numPlaza Numero de plaza del aparcamiento
     */
    public Aparcamiento(int numPlaza){
        this.numPlaza = numPlaza;
        this.estadoPlaza = "LLIURE";
    }
    
    /**
     * Para saber el estado de una plaza en concreto
     * @return retorna el estado de la plaza (OCUPADA o LLIURE)
     */
    public String getEstadoPlaza(){
        return this.estadoPlaza;
    }
    
    /**
     * Para Saber el numero de plazas totales ocupadas en el aparcamiento
     * @return Retorna el numero de plazas ocupadas en el aparcamiento
     */
    public static int getPlazasOcupada(){
        return Aparcamiento.plazasOcupadas;
    }
    
    /**
     * Registra la entrada de vehiculos
     * @param matricula Matricula del vehiculo que accede al aparcamiento
     */
    public void setEntrada(String matricula){
        this.estadoPlaza="OCUPADA";
        this.matricula=matricula; 
        ++Aparcamiento.plazasOcupadas;
        System.out.println("Pot estacionar a la plaza: "+numPlaza);
    }
    
    /**
     * Registra la salida de vehiculos, vuelve el estado de la plaza a libre y borra la matricula
     */
    public void setSalida(){
        if (this.estadoPlaza == "LLIURE") {
            System.out.println("Se ha confos de plaza, la plaza "+this.numPlaza+" es troba "+this.estadoPlaza);
        }else{
            this.estadoPlaza="LLIURE";
            this.matricula="";
            --Aparcamiento.plazasOcupadas;
            System.out.println("Adeu, tinga un gran dia!!");
        }
    }
    
    /**
     * Para imprimir el estado de la plaza
     * @return retorna un SOUT con la informacion
     */
    public String toString(){
        if (this.estadoPlaza=="OCUPADA"){
            return "La plaza de aparcament "+this.numPlaza+" es troba "+this.estadoPlaza+" pel vehicle "+this.matricula;
        }else{
            return "La plaza de aparcament "+this.numPlaza+" es troba "+this.estadoPlaza;
        }
    }
    
    /**
     * Enumerador del estado de la plaza
     */
    public enum estadoPlaza{
    OCUPADA, LLIURE
    }
}

