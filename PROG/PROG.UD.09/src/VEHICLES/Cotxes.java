/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VEHICLES;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Cotxes extends Terrestres{
    private String model;
    
    public Cotxes(String model){
            Scanner entrada = new Scanner(System.in);
            String matricula = entrada.nextLine();
            if(matricula.matches("[0-9]{4}[a-zA-Z]{3}");
            super(matricula);
            this.model=model;
    }
}
