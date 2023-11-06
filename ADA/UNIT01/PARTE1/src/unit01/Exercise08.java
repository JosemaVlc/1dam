package unit01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Exercise08 {	
	public static void main(String[] args) {
		try {
			FileReader fiRutaR = new FileReader("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/"+"read.txt");
			BufferedReader brFileR = new BufferedReader(fiRutaR);

			String[] content = new String[10];
			
			int contadorR = 0;
						
			String stLine="";
			while((stLine=brFileR.readLine())!=null){
				content[contadorR] = stLine;
				contadorR++;				
			}			
			brFileR.close();
			
			FileWriter fiRutaW = new FileWriter("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/"+"write.txt");
			BufferedWriter brFileW = new BufferedWriter(fiRutaW);
			
			int contadorW = 0;
			
			while(contadorR > contadorW){
				System.out.println(content[contadorW]);
				brFileW.write(content[contadorW]);	
				brFileW.newLine();
				contadorW++;
			}
			
			brFileW.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}