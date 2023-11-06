import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class Carta {	
	
	private static String stPath = "src/GestPizzas/";
	private static String stName = "carta.xml";
	private static ArrayList<Pizzas> arCarta = new ArrayList<Pizzas>();
	
	public static void addPizza(Scanner sc) throws IOException, InputMismatchException, DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {
		sc.nextLine();
		
		String stName= "-1";
		
		while (true) {
			System.out.print("Product name: ");
			stName = sc.nextLine();
			if (stName.equals("0")) {
				System.out.println("Ha terminado de introducir pizzas en la carta");
				savePizzas();
				break;
				}
			
			System.out.print("Pizza price: ");
			double dbPrice = sc.nextDouble();
			
			System.out.print("Pizza ID: ");
			int iId = sc.nextInt();
			
			arCarta.add(new Pizzas(stName, dbPrice, iId));
			sc.nextLine();			
		}			
	}
	
    private static void savePizzas() throws IOException, DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		TratamientoXML.CreateXML(arCarta, stPath, stName);
    }
    
    public static void readPizzas() throws IOException, ParserConfigurationException, SAXException{
    	TratamientoXML.PizzasReaderSax(stName);
    }
    
    public static void deletePizzas() throws IOException{
    	File file = new File (stName);
    	
    	if (file.exists()) {
    		file.delete();
    		System.out.println("The list has been emptied successfully.");
		} else {
			System.out.println("The list could not be deleted, maybe it was already empty.");
		}	
    }

}
