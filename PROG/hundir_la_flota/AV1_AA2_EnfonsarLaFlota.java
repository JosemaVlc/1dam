/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

import java.util.Scanner;

/**
 * Versió simplificada del joc "Afonar la flota" on només hi haurà un jugador humà(usuari) i l'objetiu es
 * afonar tots els barcos de l'ordinador en un nombre determinat d'intents. L'ordinador tindrà un tauler 
 * barcos i l'usuari dispararà per a intentar afonar-los.
 * @version 28/12/22
 * @author Jose Manuel Moreno Bolivar
 * @author <br><a href="mailTo:j.moreno.bolivar@gmail.com">j.moreno.bolivar@gmail.com</a>
 */
public class AV1_AA2_EnfonsarLaFlota {
    
    /**
     * FUNCIÓ: Menú del joc on el jugador diu la dificultat que vol
     * @param args 
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int files=10, columnes=10, min=1, max=3, llanxes=0, vaixells=0, cuirassats=0, portaavions=0, max_intents=0;
        String text;
        System.out.print("""
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
    
    /**
     * FUNCIÓ: Escomença, desarrolla i finalitza la partida.
     * @param files nombre de files del tauler
     * @param columnes nombre de columnes del tauler
     * @param llanxes nombre de llanxes a enfonsar
     * @param vaixells nombre de vaixells a a enfonsar
     * @param cuirassats nombre de cuirassts a enfonsar
     * @param portaavions nombre de portaavions a enfonsar
     * @param max_intents maxim de intents per enfonsar tots els barcos
     */
    public static void jugar_partida(int files, int columnes, int llanxes, int vaixells, int cuirassats, int portaavions, int max_intents){
        boolean veureTot=false;
        char tauler[][]=new char[files][columnes];
        System.out.println("""
                           ===== BENVINGUTS A AFONAR LA FLOTA =====
                           
                           Preparat perque escomençem!""");
        tauler = crear_tauler(files, columnes);
        inserir_barcos(tauler, llanxes, vaixells, cuirassats, portaavions, files, columnes);
        int i=0;
        while(i < max_intents && queden_barcos(tauler) == true){
            int f = 0, c = 0, tret[]={0,0};
            mostra_tauler(tauler,veureTot);
            System.out.println("Tret numero: "+i+"/"+max_intents);
            tret = demanar_coordenades_tret(tauler, files, columnes);
            f = tret[0];
            c = tret[1];
            processa_tret(tauler, f, c);
            i+=1;
        }
        veureTot=true;
        mostra_tauler(tauler,veureTot);
        if (queden_barcos(tauler)==false){
            System.out.println("===== HAS GUANYAT =====");
        }else{
            System.out.println("===== HAS PERDUT =====");
        }
        System.out.println("Torna quan vulgues");
    }
    
    /**
     * FUNCIÓ: Crear un tauler buit
     * @param files nombre de files del tauler
     * @param columnes nombre de columnes del tauler
     * @return retorna el tauler (files x columnes) amb "-" en totes les posicions
     */
    public static char[][] crear_tauler(int files, int columnes) {
        char tauler[][]=new char[files][columnes];
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                tauler[i][j]='-';
            }
        }
        return tauler;
    }
    
    /**
     * PROCEDIMENT: Mostra per pantalla el tauler
     * @param tauler tauler de la partida
     * @param veureTot parametre per visualitzar el tauler del jugador o el complet.
     */
    public static void mostra_tauler(char[][] tauler, boolean veureTot) {
        int letra = 65;
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        if (veureTot == false){
            for (int i = 0; i < tauler.length; i++) {
                System.out.print((char)letra);
                for (int j = 0; j < tauler[i].length; j++) {
                    switch (tauler[i][j]) {
                        case 'A':
                            System.out.print(" A");
                            break;
                        case 'X':
                            System.out.print(" X");
                            break;
                        case '-', 'L', 'B', 'C', 'P':
                            System.out.print(" -");
                            break;
                        default:
                            System.out.println(" ");
                            break;
                    }
                }
                letra+=1;
                System.out.println("");
            }
        }else{
            for (int i = 0; i < tauler.length; i++) {
                System.out.print((char)letra);
                for (int j = 0; j < tauler[i].length; j++) {
                    System.out.print(" "+tauler[i][j]);                   
                }
                letra+=1;
                System.out.println("");
            }
        }
    } 
    
    /**
     * PROCEDIMENT: Inserir els barcos en posicions aleatòries
     * @param tauler tauler buit
     * @param llanxes nombre de llanxes a inserir al tauler
     * @param vaixells nombre de vaixells a inserir al tauler
     * @param cuirassats nombre de cuirassats a inserir al tauler
     * @param portaavions nombre de portaavions a inserir al tauler
     * @param files files del tauler
     * @param columnes columnes del tauler
     */
    public static void inserir_barcos (char[][] tauler, int llanxes, int vaixells, int cuirassats, int portaavions, int files, int columnes) {
        int coordenada[]={0,0}, mida;
        for (int i = 0; i < portaavions; i++){
            mida=5;
            coordenada = coordenada_aleatoria(tauler, mida, files, columnes);             
            if (coordenada[0] == -1 && coordenada[1] == -1){
                System.out.println("ERROR: No s\'ha pogut inserir el portaavions");
            }else{
                for(int j = 0; j < mida; j++){
                    tauler[coordenada[0]][coordenada[1]]='P';
                    coordenada[1]+=1;
                }
            }
        }
        for (int i = 0; i < cuirassats; i++){
            mida=4;
            coordenada = coordenada_aleatoria(tauler, mida, files, columnes);
            if (coordenada[0] == -1 && coordenada[1] == -1){
                System.out.println("ERROR: No s\'ha pogut inserir el cuirasat");
            }else{
                for(int j = 0; j < mida; j++){
                    tauler[coordenada[0]][coordenada[1]]='C';
                    coordenada[1]+=1;
                }
            }
        }
        for (int i = 0; i < vaixells; i++){
            mida=3;
            coordenada = coordenada_aleatoria(tauler, mida, files, columnes);
            if (coordenada[0] == -1 && coordenada[1] == -1){
                System.out.println("ERROR: No s\'ha pogut inserir el vaisell");
            }else{
                for(int j = 0; j < mida; j++){
                    tauler[coordenada[0]][coordenada[1]]='B';
                    coordenada[1]+=1;
                }
            }
        }
        for (int i = 0; i < llanxes; i++){
            mida=1;
            coordenada = coordenada_aleatoria(tauler, mida, files, columnes);
            if (coordenada[0] == -1 && coordenada[1] == -1){
                System.out.println("ERROR: No s\'ha pogut inserir la llanxa");
            }else{
                tauler[coordenada[0]][coordenada[1]]='L';
            }          
        }  
    }
    
    /**
     * FUNCIÓ: Demana coordenades de tret
     * @param tauler tauler en barcos a enfonsar
     * @param files files del tauler
     * @param columnes columnes del tauler
     * @return retorna les coordenades verificades del tret donat per el jugador
     */
    public static int[] demanar_coordenades_tret(char[][] tauler, int files, int columnes) {
        Scanner entrada = new Scanner(System.in);
        int tret[]={0,0}, min=0, max=0;
        String c, f;
        min = 65;
        max = 65+(files-1);
        System.out.print("Indica la fila del seguent tret(A-J)\n-> ");
        f = entrada.nextLine();
        tret[0] = demana_dades_entre_max_i_min(f, min, max)-65;
        min = 0;
        max = columnes-1;
        System.out.print("Indica la columna del seguent tret (0-9)\n-> ");
        c = entrada.nextLine();
        tret[1] = demana_dades_entre_max_i_min(c, min, max);
        return tret;
    }
    
    /**
     * PROCEDIMENT: Processem el tret amb les coordenades indicades
     * @param tauler tauler a procesar el tret
     * @param f fila de la coordenada verificada a procesar
     * @param c columna de la coordenada verificada a procesar
     */
    public static void processa_tret(char[][] tauler, int f, int c) {
        switch (tauler[f][c]) {
            case '-':
                System.out.println("Aigua!");
                tauler[f][c]='A';
                break;
            case 'L':
            case 'B':
            case 'C':
            case 'P':
                System.out.println("Tocat!");
                tauler[f][c]='X';
                break;
            default:
                System.out.println("Error! ja hi havies fet un tret açí");
                break;
        }
    }
    
    /**
     * FUNCIÓ: genera un coordenades de forma aleatoria i revisa que estiguen buides
     * @param tauler tauler a comprobar que siga "-" les posicions aleatores 
     * @param mida dimensions del barco
     * @param columnes columnes de tauler
     * @param files files del tauler
     * @return retorna una posició aleatoria on colocar els barcos
     */
    public static int[] coordenada_aleatoria(char[][] tauler, int mida, int columnes, int files) {
        int coordenada[]={-1,-1};
        for (int i = 0; i<100; i++){
            int coordFila, coordColumna, max, verif;
            verif = 0;
            max = columnes-mida;
            coordFila = (int)(Math.random()*(files));
            coordColumna = (int)(Math.random()*(max+1));
            for (int j = 0; j<mida; j++){
                if (tauler[coordFila][coordColumna+j]=='-'){
                    verif += 1;
                }
            }
            if (verif == mida){
                coordenada[0] = coordFila;
                coordenada[1] = coordColumna;
                break;
            }
        }
        return coordenada;
    }
    
    /**
     * FUNCIÓ: Comprovar si quede barcos en el tauler
     * @param tauler tauler a comprovar
     * @return retorna si al tauler queden barcos o no
     */
    public static boolean queden_barcos(char[][] tauler) {
        boolean verif = false;
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[i].length; j++) {
                if (tauler[i][j] == 'P' || tauler[i][j] == 'C' || tauler[i][j] == 'B' || tauler[i][j] == 'L'){
                    verif=true;
                }
            }
        }
        return verif;
    }
    
    /**
     * FUNCIÓ: Verifica que el valor indicat al menú y el valor indicat al tret donat per el jugador siguen correctes.
     * @param text linea de text introduit per el jugador a verificar
     * @param min valor minim correcte
     * @param max valor maxim correcte
     * @return retorna el valor correcte a procesar
     */
    public static int demana_dades_entre_max_i_min (String text, int min, int max) {
        Scanner entrada = new Scanner(System.in);
        boolean opc_verif=false;
        int opc=0;
        do{
            int textLargo= text.length();
            if (textLargo==1){
                //Try se utiliza para probar si funciona algo y sinó hace el catch para solucionarlo.
                try{
                    opc = Integer.parseInt(text);
                }catch(NumberFormatException e){
                    String text_mayus = text.toUpperCase();
                    char text_char = text_mayus.charAt(0);
                    opc = text_char;
                }
                if (opc>=min && opc<=max){
                    opc_verif=true;
                }else{
                    System.out.println("Escriu una opcio valida");
                    text = entrada.nextLine();
                }    
            }else{
                System.out.println("Escriu una opcio valida");
                text = entrada.nextLine();
            }    
        }while (opc_verif==false);
        return opc;
    }
}