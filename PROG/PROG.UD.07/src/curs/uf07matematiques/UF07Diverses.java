/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curs.uf07matematiques;
/**
* Funcions matemàtiques de propòsit general
*/
public class UF07Diverses {

    /**
    * FUNCIÓ: Comprova si un número enter positiu és primer o no.
    * @param x un número enter positiu
    * @return <code>true</code> si el número és primer
    * @return <code>false</code> en cas contrari
    */
    public static boolean esPrimer(int x) {
        boolean nPrimer=true;

        for (int i = 2; i < x && nPrimer; i++) {
            if ((x % i) == 0) {
                nPrimer=false;
            }
        }
        return nPrimer;
    }
    /**
    * FUNCIÓ: Retorna el número de dígits que conté un número enter
    * @param x un número enter
    * @return la quantitat de dígits que conté el número
    */
    public static int digits(int x) {
        int n=0;

            if (x == 0) {
                n=1;
        } else {
            while (x > 0) {
                x = x / 10;
                n++;
            }
        }
        return n;
    }
}

