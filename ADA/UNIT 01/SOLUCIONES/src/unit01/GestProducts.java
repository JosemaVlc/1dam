package unit01;
import java.util.ArrayList;

public class GestProducts {
	public static int scNumeros() {
		int n = 0;
		
		return n;
	}
	
	public static ArrayList<String> productos() {
		ArrayList<String> product = new ArrayList<String>();
		
		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p = 0;
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
			
		}while (p == 0);
		System.out.println("Adios");

	}

}
