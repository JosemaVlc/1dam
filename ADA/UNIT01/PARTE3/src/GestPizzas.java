import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class GestPizzas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opc = -1;
		do {
			System.out.println("""
					*****
					MENU
					*****
					=========================================
					  0. Exit
					  1. Add pizzas
					  2. List all pizzas
					  3. Remove all pizzas
					  4. Generate HTML report using XSL
					=========================================
						Select an option:	""");
			try {
				if (sc.hasNextInt()) {
					opc = sc.nextInt();
				}
				
				switch (opc) {
				case 0:
					System.out.println("Bye");
					break;
				case 1:
					Carta.addPizza(sc);
					break;
				case 2:		
					Carta.readPizzas();
					break;
				case 3:
					Carta.deletePizzas();
					break;
				default:
					System.out.println("Option not selectable");
					break;
				}
			} catch (IOException e){
				System.out.println("Error to file");
			} catch (InputMismatchException e) {
				System.out.println("Error input type");
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}while (opc != 0);
		
		sc.close();

	}

}
