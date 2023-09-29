package unit01;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class GestProducts {
	/*Scanner option.*/
	public static int scOpc(){
		
		int n = -1;
		
		System.out.print(":/> ");
		
		Scanner sc = new Scanner(System.in);
		if (sc.hasNextInt()) {
			n = sc.nextInt();
		}
		
		return n;
	}
	
	public static void addProducts(String stPath, String stName) {
		
	}
	
	public static void listAll(String stPath, String stName) {
		
	}
	
	//Borrado del archivo
	public static void removeAll(String stPath, String stName) {
		//Se genera el objeto del archivo
		File fiArchivo = new File(stPath+stName);
		
		//Se revisa si existe y si es así se borra y sino, muestra un mensaje de la negativa.
		if (fiArchivo.exists()) {
			fiArchivo.delete();
			System.out.println("The list has been emptied successfully.");
		} else {
			System.out.println("The list could not be deleted, maybe it was already empty.");
		}	
	}

	public static void main(String[] args) {
		String stPath = "src/unit01/gestproducts/";
		String stName = "productslist.txt";
				
		int opc = -1;
		
		do {
			System.out.println("""
					***********************
					Choose an options
					***********************
					1. Add Products
					2. List all Products
					3. Remove all products
					0. Exit
					***********************
					""");
			opc = scOpc();
			
			switch (opc) {
			case 0:
				System.out.println("Bye");
			case 1:
				addProducts(stPath, stName);
				break;
			case 2:
				listAll(stPath, stName);
				break;
			case 3:
				removeAll(stPath, stName);
				break;
			default:
				System.out.println("Option not selectable");
				break;
			}
			
		}while (opc != 0);
		

	}

}
