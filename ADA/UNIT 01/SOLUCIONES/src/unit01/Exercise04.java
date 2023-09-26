package unit01;

import java.io.File;
import java.util.Date;

public class Exercise04 {

	public static void main(String[] args) {
		// Genero un objeto tipo archivo
		File fiRuta = new File("E:/ASIGNATURAS/ADA/UNIT 01/CASTELLANO/CONTENIDOS/01.Part1. Intro, Java review and basic file access es.pdf");
		
		// Si la ruta es un archivo y existe, mira la ultima modificacion, lo formatea y muestra por pantalla.
		if (fiRuta.exists() && fiRuta.isFile()) {
			long ultimaModificacion = fiRuta.lastModified();
			Date fechaUltimaModificacion = new Date(ultimaModificacion);
			System.out.println(fiRuta.getName()+" - "+fechaUltimaModificacion);
		}
	}
}
