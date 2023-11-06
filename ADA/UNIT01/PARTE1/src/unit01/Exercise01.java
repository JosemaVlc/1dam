package unit01;

import java.io.File;

public class Exercise01 {

	public static void main(String[] args) {
		// Genero un objeto tipo archivo
		File fiDirectorio = new File("E:/ASIGNATURAS/ADA/UNIT 01/CASTELLANO/CONTENIDOS");
		
		// Si la ruta es un directorio y existe, genera un array con la lista de archivos
		if (fiDirectorio.exists() && fiDirectorio.isDirectory()) {
			File[] lstArchivos = fiDirectorio.listFiles();
			
			// For-each para que imprima la lista de archivos
			for (File archivo : lstArchivos){
				System.out.print(archivo.getName()+"\n");
			}	
		}
	}
}
