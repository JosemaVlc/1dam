/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg07;
import curs.uf07matematiques.UF07Diverses;
import curs.uf07matematiques.UF07Geometria;
import java.util.Scanner;
/**
 *
 * Prova algunes funcions
 */
public class ejercicio22 {
    public static void main(String[] args) {
        int n;
        Scanner entrada = new Scanner (System.in);
        
        //Prova esPrimer()
        System.out.print("Introueix un nombre enter positiu: ");
        n = entrada.nextInt();
        
        if (curs.uf07matematiques.UF07Diverses.esPrimer(n)){
            System.out.println("El "+n+" es primer.");
        }else{
            System.out.println("El "+n+" no es primer.");
        }
        
        //Prova digits()
        System.out.print("Introueix un nombre enter positiu: ");
        n = entrada.nextInt();
        System.out.println(n+" te "+curs.uf07matematiques.UF07Diverses.digits(n)+" digits.");
        
        //Prova voulmCilindre()
        double r, h;
        System.out.println("Calcul del volum d'un cilindre");
        System.out.println("Introdueix el radi en metres: ");
        r = entrada.nextDouble();
        System.out.println("Introdueix l'altura en metres: ");
        h = entrada.nextDouble();
        System.out.println("El volum del cilindre es "+curs.uf07matematiques.UF07Geometria.volumCilindre(r, h)+"m3");
    }
}
