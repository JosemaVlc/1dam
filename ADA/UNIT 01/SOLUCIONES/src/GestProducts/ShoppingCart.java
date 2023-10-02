package GestProducts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCart {
	
	private static String stPath = "src/GestProducts/";
	private static String stName = "ShoppingCart.txt";
	private static ArrayList<Products> arShoppingCart = new ArrayList<Products>();
	
	public static void addProducts(Scanner sc) throws IOException, InputMismatchException {
		sc.nextLine();
		
		String stName= "-1";
		
		while (true) {
			System.out.print("Product name: ");
			stName = sc.nextLine();
			if (stName.equals("0")) {
				System.out.println("Ha terminado de introducir productos");
				saveProducts();
				break;
			}
			
			System.out.print("Product price: ");
			double dbPrice = sc.nextDouble();
			
			System.out.print("Product units: ");
			int iUnits = sc.nextInt();
			
			arShoppingCart.add(new Products(stName, dbPrice, iUnits));
			sc.nextLine();
			
		}			
	}
	
    private static void saveProducts() throws IOException {
        
		String text = "";
        File file = new File(stPath+stName);

        for (Products product : arShoppingCart) {
            text += product.toString() + "\n";
        }

        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(text);
        
        bw.close();

    }
    
    public static void readProducts() throws IOException{
    	
    	FileReader file = new FileReader (stPath+stName);
    	
    	BufferedReader reader = new BufferedReader(file);
    	
    	String line = "";
    	while((line=reader.readLine())!=null){
			System.out.println(line);	
		}			
		reader.close();
    	
    }
    
    public static void deleteProducts() throws IOException{
    	File file = new File (stPath+stName);
    	
    	if (file.exists()) {
    		file.delete();
    		System.out.println("The list has been emptied successfully.");
		} else {
			System.out.println("The list could not be deleted, maybe it was already empty.");
		}	
    }
}
