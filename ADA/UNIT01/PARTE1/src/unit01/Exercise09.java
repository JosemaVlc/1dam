package unit01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise09 {
	public static void main(String[] args) {
	
		try {
	
			String[] content = {"patata", "queso", "chirimolla", "lenguado"};
					
			FileWriter fiRutaW = new FileWriter("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/"+"write.txt");
			BufferedWriter brFileW = new BufferedWriter(fiRutaW);
			
			for (String palabra : content){
				System.out.println(palabra);
				brFileW.write(palabra);	
				brFileW.newLine();
			}
			
			brFileW.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
