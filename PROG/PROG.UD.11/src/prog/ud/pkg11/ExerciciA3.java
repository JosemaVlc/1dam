/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.ud.pkg11;

import java.io.File;

/**
 * Exercici A3 - Canviant de nom directoris i fitxersImplementa un programa que faça el següent:
 *  ● Canviar el nom de la carpeta ‘Documents’ a ‘DOCS’, el de la carpeta ‘Fotografias’ a ‘FOTOS’ 
 *    i el de la carpeta ‘Libros’ a ‘LECTURAS’
 *  ● Canviar el nom de tots els arxius de les carpetes FOTOS i LECTURES llevant-li l'extensió. 
 * Per exemple, ‘astronauta.jpg’ passarà a dir-se ‘astronauta’.
 * 
 * @author jmore
 */
public class ExerciciA3 {
    public static void main(String[] args) {
        File docOrigen = new File("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/Documentos");
        File docDesti = new File("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/DOCS");
        File fotOrigen = new File("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/DOCS/Fotografias");
        File fotDesti = new File("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/DOCS/FOTOS");
        File lecOrigen = new File ("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/DOCS/Libros");
        File lecDesti = new File ("E:/ASIGNATURAS/PROG/PROG.UD.11/src/prog/ud/pkg11/DOCS/LECTURAS");

        boolean res = docOrigen.renameTo(docDesti);
        System.out.println("S'ha pogut cambiar de nom? " + res);
        res = fotOrigen.renameTo(fotDesti);
        System.out.println("S'ha pogut cambiar de nom? " + res);
        res = lecOrigen.renameTo(lecDesti);
        System.out.println("S'ha pogut cambiar de nom? " + res);

        File directoriFot[] = fotDesti.listFiles();
        for (File i : directoriFot) {
            String[] nom = i.getName().split("\\.");
            File senseExtensio = new File (i.getParent()+"/"+nom[0]);
            res = i.renameTo(senseExtensio);
            System.out.println("S'ha pogut cambiar de nom? " + res);
        }
        
        
        
        File directoriLec[] = lecDesti.listFiles();
        for (File i : directoriLec) {
            String[] nom = i.getName().split("\\.");
            File senseExtensio = new File (i.getParent()+"/"+nom[0]);
            res = i.renameTo(senseExtensio);
            System.out.println("S'ha pogut cambiar de nom? " + res);
        }
    }

    
}
