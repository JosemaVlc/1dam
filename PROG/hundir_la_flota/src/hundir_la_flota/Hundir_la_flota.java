/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hundir_la_flota;
import java.util.Scanner;
/**
 *
 * @author jmore
 */
public class Hundir_la_flota {
    public static int demana_dades_entre_max_i_min(int a){
        Scanner entrada = new Scanner(System.in);
        boolean verif = false;
        while(verif==false){
            if(a<1 || a>3){
            System.out.print("""
                             Valor no valid, posa valor correcte.
                                
                                 Nivells de dificultat:
                                 1.Facil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).
                                 2.Mitja: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).
                                 3.Dificil: 1 llanxa y 1 vaixell (10 trets).
                                 Quin nivell tries?: """);
            a = entrada.nextInt();
            }else{
                verif = true;
            }   
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("""
                         ===== BENVINGUTS A AFONAR LA FLOTA =====
                         
                         Nivells de dificultat:
                         1.Facil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).
                         2.Mitja: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).
                         3.Dificil: 1 llanxa y 1 vaixell (10 trets).
                         Quin nivell tries?: """);
        int opc=entrada.nextInt();
        int lvl = demana_dades_entre_max_i_min(opc);
        System.out.print(lvl);
        
    }
    
}
