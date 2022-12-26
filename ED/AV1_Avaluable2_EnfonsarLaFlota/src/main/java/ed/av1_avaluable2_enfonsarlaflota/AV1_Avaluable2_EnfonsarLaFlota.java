/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ed.av1_avaluable2_enfonsarlaflota;
import java.util.Scanner;
/**
 *
 * @author Jose Manuel Moreno
 */
public class AV1_Avaluable2_EnfonsarLaFlota {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int files=10, columnes=10, min=1, max=3, llanxes=0, vaixells=0, cuirassats=0, portaavions=0, max_intents=0;
        String text;
        System.out.println("""
                           ===== BENVINGUTS A AFONAR LA FLOTA =====
                           
                           Nivells de dificultat:
                           1. Fàcil: 5 llanxes, 3 vaixells, 1 cuirassat i 1 portaavions (50 trets).
                           2. Mitjà: 2 llanxes, 1 vaixell, 1 cuirassat i 1 portaavions (30 trets).
                           3. Difícil: 1 llanxa y 1 vaixell (10 trets).
                           Quin nivell tries?
                           ->""");
        text = entrada.nextLine();
        switch(demana_dades_entre_max_i_min(text, min, max)){
            case 1:
                llanxes=5;
                vaixells=3;
                cuirassats=1;
                portaavions=1;
                max_intents=50;
                break;
            case 2:
                llanxes=2;
                vaixells=1;
                cuirassats=1;
                portaavions=1;
                max_intents=30;
                break;
            case 3:
                llanxes=1;
                vaixells=1;
                cuirassats=0;
                portaavions=0;
                max_intents=10;
                break;       
        }
        jugar_partida(files, columnes, llanxes, vaixells, cuirassats, portaavions, max_intents);
    }
    public static void jugar_partida(int files, int columnes, int llanxes, int vaixells, int cuirassats, int portaavions, int max_intents){
        char tauler[][]=new char[0][0];
        System.out.println("""
                           ===== BENVINGUTS A AFONAR LA FLOTA =====
                           
                           Preparat perque escomençem!""");
        crear_tauler(files, columnes);
        inserir_barcos(tauler, llanxes, vaixells, cuirassats, portaavions);   
    }
    // FUNCIÓ: Crear tauler buit amb "-" en totes les posicions
    public static char[][] crear_tauler(int files, int columnes) {
        char tauler[][]=new char[files][columnes];
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                tauler[i][j]='-';
            }
        }
        return tauler;
    }
    // PROCEDIMENT: Mostra per pantalla el tauler
    public static void mostra_tauler(char[][] tauler, boolean veureTot) {
    } 
    // PROCEDIMENT: Inserir els barcos en posicions aleatòries 
    public static void inserir_barcos (char[][] tauler, int llanxes, int vaixells, int cuirassats, int portaavions) {
        int coordenada[]={0,0}, mida;
        for (int i = 0; i < portaavions; i++){
            mida=5;
            coordenada_aleatoria(tauler, mida);
            for(int j = 1; j < mida; j++){
                tauler[coordenada[0]][coordenada[1]]='P';                
            }
        }
        for (int i = 0; i < cuirassats; i++){
            mida=4;
            coordenada_aleatoria(tauler, mida);
            for(int j = 1; j < mida; j++){
                tauler[coordenada[0]][coordenada[1]]='C';                
            }
        }
        for (int i = 0; i < vaixells; i++){
            mida=3;
            coordenada_aleatoria(tauler, mida);
            for(int j = 1; j < mida; j++){
                tauler[coordenada[0]][coordenada[1]]='B';                
            }
        }
        for (int i = 0; i < llanxes; i++){
            mida=1;
            coordenada_aleatoria(tauler, mida);
            tauler[coordenada[0]][coordenada[1]]='L';
        }
        
    }
    // FUNCIÓ: Demana coordenades de tret
    public static int[] demana_coordenades_tret(char[][] tauler) {
    }
    // PROCEDIMENT: Processem el tret amb les coordenades indicades 
    public static void processa_tret(char[][] tauler, int f, int c) {
    }
    // FUNCIÓ: Rep el tauler i dimensions de l'objecte i ens retorna una posició aleatòria 
    public static int[] coordenada_aleatoria(char[][] tauler, int mida) {
        int fila = 0, columna = 0, min = 0,max = 0;
        max=10-mida;
        fila = (int)(Math.random()*(max+1));
        columna = (int)(Math.random()*(9+1));
        
        return coordenada;
    }
    // FUNCIÓ: Comprovar si quede barcos en el tauler 
    public static boolean queden_barcos(char[][] tauler) {
    }
    // FUNCIÓ: Demana el valor indicat del menú a l'usuari i valida que siga correcte.
    public static int demana_dades_entre_max_i_min (String text, int min, int max) {
        Scanner entrada = new Scanner(System.in);
        int i=0, opc=0;
        while(i<1){
            opc = Integer.parseInt(text);
            if (opc>=min && opc<=max){
                break;
            }else{
                System.out.println("Escribe opción valida");
                text = entrada.nextLine();
            }    
        }
        return opc;
    }


}
