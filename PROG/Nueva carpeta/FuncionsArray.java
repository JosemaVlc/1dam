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
            System.out.print("[ ");
            for (int j = 0; j < 4; j++) {
                if (j==3){
                    System.out.print(matriu[i][j]);
                }else{
                    System.out.print(matriu[i][j]+", ");
                }
            }
            System.out.println("]");
        }
    }
    public static int[][] ordenarFiles(int[][]matriu){
        int t[][]=new int[matriu[0].length][matriu.length];
        
        for (int i = 0; i < 4; i++) {
            Arrays.sort(matriu[i]);
        }
        for (int i = 0; i < 4; i++) {
            int contador=3;
            for (int j = 0; j < 4; j++) {
                t[i][j]= matriu[i][contador];
                contador--;
            }
        }
        return t;
    }
    public static int[][] traspostaMatriu(int[][]matriu){
        int i, j;
        int t[][]=new int[matriu[0].length][matriu.length];
        
        for(i = 0; i < matriu[0].length; i++) {
            for(j = 0; j <  matriu.length; j++) {
                t[i][j] = matriu[j][i];
            }
        }
    return t;
    }
}
