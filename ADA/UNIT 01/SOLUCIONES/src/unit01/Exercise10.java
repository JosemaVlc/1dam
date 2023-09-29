package unit01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise10 {	
	public static void main(String[] args) {
		try {
			FileReader fiRutaR = new FileReader("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/"+"write.txt");
			BufferedReader brFileR = new BufferedReader(fiRutaR);
			
			int nLetras = 0;
			String palabraMasLarga="";
						
			String stLine="";
			while((stLine=brFileR.readLine())!=null){
				if (nLetras < stLine.length()) {
					palabraMasLarga = stLine;
					nLetras = stLine.length();
				}			
			}			
			brFileR.close();
			
			System.out.println(palabraMasLarga);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}

}
