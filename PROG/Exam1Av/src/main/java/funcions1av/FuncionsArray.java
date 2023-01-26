/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcions1av;

import java.util.Arrays;

/**
 *
 * @author jose manuel moreno
 */
public class FuncionsArray {
    
    public static void mostrarMatriu(int[][] matriu){
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(matriu[i]));
        }
    }
    public static void ordenarFiles(int[][]matriu){       
        for (int i = 0; i < 4; i++) {
            Arrays.sort(matriu[i]);
        }
    }
    public static void traspostaMatriu(int[][]matriu){
        int i, j;
        int trasposta[][]=new int[matriu[0].length][matriu.length];
        
        for(i = 0; i < matriu[0].length; i++) {
            for(j = 0; j <  matriu.length; j++) {
                trasposta[i][j] = matriu[j][i];
            }
        }
    }
}
