package unit01;

import java.io.File;

public class Exercise03 {

	public static void main(String[] args) {
		
		// Genero un objeto tipo archivo
		File fiDirectorio = new File("E:/ASIGNATURAS/ADA/UNIT 01/CASTELLANO/CONTENIDOS/01.Part1. Intro, Java review and basic file access es.pdf");
		// Obtengo el nombre
		String dirName = fiDirectorio.getName();
		
		// Si la ruta existe y es un directorio
		if (fiDirectorio.exists() && fiDirectorio.isDirectory()) {
			System.out.print("El directorio "+dirName+" existe");		
		}
		// Si la ruta existe y es un archivo
		else if (fiDirectorio.exists() && fiDirectorio.isFile()){
			System.out.print("Existe un archivo llamado "+dirName+", pero no un directorio");
		}
		// Si la ruta no
		else{
			System.out.print("No existe el directorio "+dirName);
		}
	}
}
