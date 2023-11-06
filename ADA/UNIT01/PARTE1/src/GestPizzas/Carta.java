import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import GestPizzas.Pizzas;

public class Carta {	
	
	private static String stPath = "src/GestPizzas/";
	private static String stName = "carta.xml";
	private static ArrayList<Pizzas> arCarta = new ArrayList<Pizzas>();
	
	public static void addPizza(Scanner sc) throws IOException, InputMismatchException {
		sc.nextLine();
		
		String stName= "-1";
		
		while (true) {
			System.out.print("Product name: ");
			stName = sc.nextLine();
			if (stName.equals("0")) {
				System.out.println("Ha terminado de introducir pizzas en la carta");
				CreateXML();
				PizzasXML();
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
	
    private static void savePizzas() throws IOException {
        
		String text = "";
        File file = new File(stPath+stName);

        for (Carta Pizzas : arCarta) {
            text += Pizzas.toString() + "\n";
        }

        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(text);
        
        bw.close();

    }
    
    public static void readPizzas() throws IOException{
    	
    	FileReader file = new FileReader (stPath+stName);
    	
    	BufferedReader reader = new BufferedReader(file);
    	
    	String line = "";
    	while((line=reader.readLine())!=null){
			System.out.println(line);	
		}			
		reader.close();
    	
    }
    
    public static void deletePizzas() throws IOException{
    	File file = new File (stPath+stName);
    	
    	if (file.exists()) {
    		file.delete();
    		System.out.println("The list has been emptied successfully.");
		} else {
			System.out.println("The list could not be deleted, maybe it was already empty.");
		}	
    }
}