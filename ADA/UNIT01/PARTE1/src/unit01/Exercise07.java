package unit01;


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Exercise07 {

	public static void main(String[] args) {
		try {
			String[] content = new String[10];
			int contador = 0;
			
			FileReader fiRuta = new FileReader("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/Read.txt");
			BufferedReader brFile = new BufferedReader(fiRuta);
			String stLine="";
			while((stLine=brFile.readLine())!=null){
				content[contador] = stLine;
				contador++;				
			}			
			brFile.close();
			
			
			while(contador != 0){
				contador--;
				System.out.println(content[contador]);	
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}