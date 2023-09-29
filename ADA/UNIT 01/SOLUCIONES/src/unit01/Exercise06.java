package unit01;


import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Exercise06 {

	public static void main(String[] args) {
		try {
			FileReader fiRuta = new FileReader("E:/ASIGNATURAS/ADA/UNIT 01/SOLUCIONES/txts/read.txt");
			BufferedReader brFile = new BufferedReader(fiRuta);
			String stLine="";
			while((stLine=brFile.readLine())!=null){
				System.out.print(stLine+" ");				
			}
			brFile.close();		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
