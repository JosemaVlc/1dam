/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curs.uf07matematiques;

/**
* Funcions geomètriques
*/
public class UF07Geometria {
    /**
    * FUNCIÓ: Calcula el volum d'un cilindre.
    * @param r radi del cilindre
    * @param h altura del cilindre
    * @return volum del cilindre
    */
    public static double volumCilindre(double r, double h) {
        return Math.PI * r * r * h;
    }

    /**
    * FUNCIÓ: Calcula la longitud d'una circunferència a partir del radi.
    * @param r radi de la circunferència
    * @return longitud de la circunferència
    */
    public static double longitudCircunferencia(double r) {
        return 2 * Math.PI * r;
    }
}
