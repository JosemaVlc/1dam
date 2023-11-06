import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;

public class GestChessPlayers {

	/* METODE Main for a manage CHESS PLAYERS in a Chess Tournament by printing and using a specific menu.
	 * After each option, the user see the same menu until option zero is pressed.
	 * */
	public static void main(String[] args) throws SAXException {
		
		File fiPlayersCSV = new File("./ChessPlayers.csv");
		File fiPlayersXML = new File("./ChessPlayers.xml");
		File fiPlayersXSL = new File ("./ChessPlayers.xsl");
		File fiPlayersHTML = new File("./ChessPlayers.html");
		File fiCandidatesXML = new File("./Candidates.xml");
		File fiCandidatesXSL = new File("./Candidates.xsl");
		File fiCandidatesHTML = new File("./Candidates.html");
		// initialized variables
		Scanner scScanner = new Scanner(System.in);		
		int iOption = -1;
		
		// loop for the menu until option zero is pressed.
		do {
			System.out.println(
					"""
					*****
					MENU
					*****
					========================================================================
					 0. Exit
					 1. Get chess players and scores (to CSV & XML)
					 2. List all chess players
					 3. Generate HTML with all chess players via XSL
					 4. [optional] Modify the rating of a chess player's game
					 5. [optional] Generate HTML with chess master candidates via XSL
					========================================================================
					 Select an option:"""
					);
			
			// I use the try-catch to catch all possible failures at this point
			try {				
				iOption = scScanner.nextInt();
								
				switch (iOption) {
				case 0:
					// Close Application
					System.out.println("Application closed");
					break;
				case 1:
					// Get chess players and scores (to CSV & XML)
					TournamentPlayers.addPlayers(scScanner, fiPlayersCSV, fiPlayersXML);					
					break;
				case 2:					
					// List all chess players
					TournamentPlayers.readPlayersFromXML(fiPlayersXML);
					break;
				case 3:
					// Generate HTML with all chess players via XSL
					TournamentPlayers.convertXMLToHTMLWithXSL(fiPlayersXML, fiPlayersXSL, fiPlayersHTML);
					break;
				case 4:
					// Modify the rating of a chess player's game
					TournamentPlayers.modifyRating(scScanner, fiPlayersXML, fiPlayersCSV);
					break;
				case 5:
					// Generate HTML with chess master candidates via XSL
					TournamentPlayers.chessMasterCandidates(fiPlayersCSV, fiCandidatesXML, fiCandidatesXSL, fiCandidatesHTML);
					break;
				default:
					System.out.println("Option not selectable");
					break;
			}
			// I catch all possible failures at this point
			}catch (InputMismatchException e){
				System.err.println(e + " Error: Spected a Integer value");
				scScanner.nextLine();
			} catch (IOException e) {
				System.err.println(e + " Error: Could not read/write");
			} catch (DOMException e) {
				System.err.println(e + " Error: DOM tree operation");
			} catch (ParserConfigurationException e) {
				System.err.println(e + " Error: XML Parse Configuration");
			} catch (TransformerFactoryConfigurationError e) {
				System.err.println(e + " Error: XML Transformer Factory Configuration");
			} catch (TransformerException e) {
				System.err.println(e + " Error: Could not transformer to XML");
			} catch (Exception e) {
				System.err.println(e + " Error: unspecified error");
			} 
		}while (iOption != 0);	
		
		// Close the Scanner
		scScanner.close();
	}
}