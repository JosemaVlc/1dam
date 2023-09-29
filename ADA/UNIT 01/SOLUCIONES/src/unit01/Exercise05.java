package unit01;

import java.io.File;

public class Exercise05 {

	public static void main(String[] args) {
		// Genero un objeto tipo archivo
		File fiRuta = new File("E:/ASIGNATURAS/ADA/UNIT 01/CASTELLANO/CONTENIDOS/01.Part1. Intro, Java review and basic file access es.pdf");
		
		// Si la ruta es un archivo y existe, mira la ultima modificacion, lo formatea y muestra por pantalla.
		if (fiRuta.exists() && fiRuta.isFile()) {
			System.out.println(fiRuta.getName()+" - "+fiRuta.length()+" bytes, "+(float)fiRuta.length()/1024+" Kb, "+(float)fiRuta.length()/1024/1024+" Mb");
		}
	}
}
