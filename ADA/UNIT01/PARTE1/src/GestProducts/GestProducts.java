package GestProducts;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestProducts {
	/*Menu*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);		
				
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
			try {
				if (sc.hasNextInt()) {
					opc = sc.nextInt();
				}
				
				switch (opc) {
				case 0:
					System.out.println("Bye");
					break;
				case 1:
					ShoppingCart.addProducts(sc);
					break;
				case 2:
					ShoppingCart.readProducts();
					break;
				case 3:
					ShoppingCart.deleteProducts();
					break;
				default:
					System.out.println("Option not selectable");
					break;
				}
			}
			catch (IOException e){
				System.out.println("Error to file");
			}	
			catch (InputMismatchException e) {
				System.out.println("Error input type");
			}
			
		}while (opc != 0);
		
		sc.close();
	}

}
