import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class TournamentPlayers {
	
	// Create players and add to ArrayList
	public static void addPlayers(Scanner scScanner, File fiPlayersCSV, File fiPlayersXML) throws IOException, DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException{

		// initialized variables
		ArrayList<PlayersChess> arPlayersChess = new ArrayList<PlayersChess>();		
		String stId;
		String stName;
		String stCountry;
		boolean boInvalidId;
		
		scScanner.nextLine(); // Scanner cleaning
		
		// Request data from chess players in a loop until they enter 0 in the Id
		while (true) {
			/* The array is initialized inside the loop so that each PlayerChess object 
			 * has its own score and all objects are updated to the same score*/
			float[] arScore = new float[3];			
			
			// loop to verify that the id is unique, otherwise it will ask again
			do {		
				boInvalidId = false; // reset boolean to false
				System.out.print("Player ID: ");
				stId = scScanner.next();
				
				if (stId.equals("0")) {
					// If the entered id is 0 it will break the loop
					if (arPlayersChess.size()!=0) {
						savePlayersToCSV(arPlayersChess, fiPlayersCSV);
						savePlayersToXML(arPlayersChess, fiPlayersXML);
						System.out.println("All CHESS PLAYERS will be saved both in a CSV and XML file");	
					} else {
						System.out.println("Chess players is empty");
					}
					break;
				} else {
					// verify that the ID is unique in the array and set boolean to true if not is unique.
					for (PlayersChess objPlayer : arPlayersChess) {
						String stIdPlayer = objPlayer.getstId();
						if (stId.equals(stIdPlayer)) {
							boInvalidId = true;			
						}
					}
					if (boInvalidId == true) {
						System.err.println("That ID already exists, select another one.");							
					}
				}			
			}while (boInvalidId == true);
			
			// this is for break the while(true)
			if (stId.equals("0")) {
				break;
			}
			
			scScanner.nextLine(); // Scanner cleaning		
			
			System.out.print("Player Full Name: ");
			stName = scScanner.nextLine();

			System.out.print("Player Country: ");
			stCountry = scScanner.nextLine();
			
			//loop to enter the 3 scores
			for (int iGame = 0; iGame < 3 ; iGame++) { 
				
				// loop to verify that the user enters a correct value				
				while (true) {
					System.out.println(String.format("Game score %d: ", iGame+1));
					try {
						float fScore = scScanner.nextFloat();
						// check that it is one of the three scoring options
						if (fScore == 0 || fScore == 0.5 || fScore == 1) {
							arScore[iGame] = fScore;
							break;
						} else {
							System.err.println("Score not spected");
						}
					} catch (InputMismatchException e){
						System.err.println(e + " Error: Spected a Float value");
						scScanner.nextLine(); // Scanner cleaning
					}
				}
			}
			
			arPlayersChess.add(new PlayersChess(stId, stName, stCountry, arScore));
			
			System.out.println("The player has been stored.");
			
			scScanner.nextLine(); // Scanner cleaning		
		}			
	}
	
	// Save the information obtained from the array in a CSV document
	private static void savePlayersToCSV( ArrayList<PlayersChess> arInfoPlayers, File fiInfoPlayersChess) throws IOException {
		
		String stText = "playerID, Name, Country, Score1, Score2, Score3\n";
		
		// Iterates through the array and adds the information to the stText variable
		for (PlayersChess objPlayer : arInfoPlayers) {
			stText += objPlayer.toString() + "\n";
		}
		
		// Create the file and write the information
		FileWriter fwWriter = new FileWriter(fiInfoPlayersChess);
		BufferedWriter bwBuffer = new BufferedWriter(fwWriter);
		bwBuffer.write(stText);
		bwBuffer.close();
		fwWriter.close();
	}
	
	// Save the information obtained from the array in a CSV document
	private static void savePlayersToXML(ArrayList<PlayersChess> arInfoPlayers, File fiInfoPlayers)throws DOMException, ParserConfigurationException, TransformerFactoryConfigurationError, TransformerException {

		//Create DocumentBuilderFactory
		DocumentBuilderFactory dbfPlayers = DocumentBuilderFactory.newInstance();
		DocumentBuilder dbPlayers = dbfPlayers.newDocumentBuilder();
		
		/* Create a empty document
		 * Root Node --> Players
		 */		
		DOMImplementation domImplement = dbPlayers.getDOMImplementation();
		Document docPlayers = domImplement.createDocument(null, "Players", null);
		docPlayers.setXmlVersion("1.0");		
		
		// Loop for create and add all elements
		for (PlayersChess objPlayer : arInfoPlayers) {
			
			/* Create the player Node
			*  Append child to doc
			*/
			Element eNodePlayer = docPlayers.createElement("Player");			
			docPlayers.getDocumentElement().appendChild(eNodePlayer);
			
			/* Create the playeridnode
			 * Create a value for the ID element
			 * Associate the value with the element
			 * Link the child element with its parent
			 */
			Element eNodeId = docPlayers.createElement("playerid");
			Text txtNodeId = docPlayers.createTextNode(objPlayer.getstId());
			eNodeId.appendChild(txtNodeId);
			eNodePlayer.appendChild(eNodeId);	
			
			/* Create the playername
			 * Create a value for the name element
			 * Associate the value with the element
			 * Link the child element with its parent
			 */	
			Element eNodeName = docPlayers.createElement("playername");
			Text txtNodeName = docPlayers.createTextNode(objPlayer.getStName());
			eNodeName.appendChild(txtNodeName);
			eNodePlayer.appendChild(eNodeName);	
			
			/* Create the playercountry
			 * Create a value for the country element
			 * Associate the value with the element
			 * Link the child element with its parent
			 */		
			Element eNodeCountry = docPlayers.createElement("playercountry");
			Text txtNodeCountry = docPlayers.createTextNode(objPlayer.getStCountry());
			eNodeCountry.appendChild(txtNodeCountry);
			eNodePlayer.appendChild(eNodeCountry);	
			
			
			float[] arScore = objPlayer.getArScore();
			int iIterator = 1;
			float fTotalScore = 0;
			
			// Loop for read all scores and create scores 1,2 and 3, in addition scores 
			for (float score : arScore) {
				String name = "playerscore"+iIterator;
				
				/* Create the playerscore
				 * Create a value for the score element
				 * Associate the value with the element
				 * Link the child element with its parent
				 */
				Element eNodeScore = docPlayers.createElement(name);
				Text txtNodeScore = docPlayers.createTextNode(Float.toString(score));
				eNodeScore.appendChild(txtNodeScore);
				eNodePlayer.appendChild(eNodeScore);
				
				fTotalScore += score;
				
				iIterator++;
			}
			
			/* Create the playertotalscores
			 * Create a value for the playertotalscores element
			 * Associate the value with the element
			 * Link the child element with its parent
			 */	
			Element eNodeScoreTotal = docPlayers.createElement("playertotalscore");
			Text txtNodeScoreTotal = docPlayers.createTextNode(Float.toString(fTotalScore));
			eNodeScoreTotal.appendChild(txtNodeScoreTotal);
			eNodePlayer.appendChild(eNodeScoreTotal);		
			
			/* 
			 * Create source()
			 * Create result()
			 * Create transform()
			 * Apply the transformation 
			 */
			Source srcPlayers = new DOMSource(docPlayers);
			Result resultFile = new StreamResult(fiInfoPlayers);
			Transformer transfPizzas = TransformerFactory.newInstance().newTransformer();
			transfPizzas.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
			transfPizzas.setOutputProperty(OutputKeys.INDENT, "yes");
			transfPizzas.setOutputProperty(OutputKeys.METHOD, "xml");
			transfPizzas.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transfPizzas.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
			
			transfPizzas.transform(srcPlayers, resultFile);			
		}
	}		
	
	// Read all players from XML and print in console
	public static void readPlayersFromXML(File fiPlayersXML) throws ParserConfigurationException, IOException, SAXException {
		
		//We create the DocumentBuilder to be able to obtain the Document
		DocumentBuilderFactory dbfPlayers= DocumentBuilderFactory.newInstance();
		DocumentBuilder dbPlayers=dbfPlayers.newDocumentBuilder();
		//We read the Document from the file 
		Document docPlayers= dbPlayers.parse(fiPlayersXML);
		//We standardise the document to avoid reading errors
		docPlayers.getDocumentElement().normalize();
		
		//Display the name of the root element
		System.out.println("The root element is "+ docPlayers.getDocumentElement().getNodeName());
		//We create a list of all the nodes Players
		NodeList nlstPlayers= docPlayers.getElementsByTagName("Player");
		//We show the number of Players elements we have found
		System.out.println("The following have been found "+nlstPlayers.getLength()+" players");
		
		//We go through the list
		for(int ii=0; ii<nlstPlayers.getLength();ii++) {
			//We get the first node in the list
			Node nodePlayers= nlstPlayers.item(ii);
			//In case that node is an Element
			if(nodePlayers.getNodeType()==Node.ELEMENT_NODE) {
				//We create the employee element and read its information
				Element objPlayers = (Element)nodePlayers;
				
				System.out.println("****************");
				System.out.println("ID: " + objPlayers.getElementsByTagName("playerid").item(0).getTextContent() );
				System.out.println("Name: " + objPlayers.getElementsByTagName("playername").item(0).getTextContent() );
				System.out.println("Country: " + objPlayers.getElementsByTagName("playercountry").item(0).getTextContent() );
				System.out.println("Score 1: " + objPlayers.getElementsByTagName("playerscore1").item(0).getTextContent() );
				System.out.println("Score 2: " + objPlayers.getElementsByTagName("playerscore2").item(0).getTextContent() );
				System.out.println("Score 3: " + objPlayers.getElementsByTagName("playerscore3").item(0).getTextContent() );
				System.out.println("Total Score: " + objPlayers.getElementsByTagName("playertotalscore").item(0).getTextContent() );
			}
		}
		
		System.out.println("--- END LIST ---");
	}
	
	// Converts an XML document to HTML using an XSLT
	public static void convertXMLToHTMLWithXSL(File fiPlayersInfoXML, File fiPlayersInfoXSL, File fiPlayersInfoHTML) throws IOException, TransformerException {
		
		// Create XML and XSL sources
		Source xml = new StreamSource(fiPlayersInfoXML);
		Source xslt = new StreamSource(fiPlayersInfoXSL);
		
		// Create a StringWriter to store the transformed HTML content
		StringWriter sw = new StringWriter();
		
		// Create a FileWriter for the HTML output file
		FileWriter fw = new FileWriter(fiPlayersInfoHTML);
		
		// Create a Transformer and apply the XSLT transformation
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transform = tFactory.newTransformer(xslt);
		transform.transform(xml, new StreamResult(sw));
		
		// Write the transformed content to the HTML file
		fw.write(sw.toString());
		fw.close();
		
		System.out.println("HTML generated successfully");
	}
	
	//Modifies a player's score in an XML
	public static void modifyRating(Scanner scScanner, File fiPlayersInfoXML, File fiPlayersCSV) throws ParserConfigurationException, TransformerException, SAXException, IOException {

		// Create a DocumentBuilder to parse the XML file
        DocumentBuilderFactory docPlayers = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docPlayers.newDocumentBuilder();
        Document doc = docBuilder.parse(fiPlayersInfoXML);
        Element scoreElement = null;
        
        // Create variables
        String idToModify, gameToModify, scoreToModify;
        float totalScore=0;
        
        // Get the player you want to modify
        System.out.println("Enter the player id who you want modify the score");
        idToModify = scScanner.next();
        
        // Get the game you want to modify
        do {
            System.out.println("Enter the gameplay who you want modify the score");
        	gameToModify = scScanner.next();
        }while(!gameToModify.equals("1") && !gameToModify.equals("2") && !gameToModify.equals("3"));
        
        // Get the score you want to modify
        do {
            System.out.println("Enter the score who you want to insert");
        	scoreToModify = scScanner.next();
        }while(!scoreToModify.equals("1") && !scoreToModify.equals("0.5") && !scoreToModify.equals("0"));
        
        // Empty object, it will be the object to modify
        Element elementToModify = null;
        // List of players where the player will search
        NodeList nlPlayerList = doc.getElementsByTagName("Player");
        
        // Find the player's id to modify the score and return an element        
        for (int i = 0; i < nlPlayerList.getLength(); i++) {
            Element player = (Element) nlPlayerList.item(i);
            Element idElement = (Element) player.getElementsByTagName("playerid").item(0);
            String idValue = idElement.getTextContent();
            if (idToModify.equals(idValue)) {
                elementToModify = player;
                break;
            }
        }
        
        // If it's not null, continue to ask for the game and update its value        
        if (elementToModify != null) {
            for ( int i = 1; i<4;i++) {
            	if (!String.valueOf(i).equals(gameToModify)) {
            		// Sum the value to a totalScore variable
            		scoreElement = (Element) elementToModify.getElementsByTagName("playerscore"+i).item(0);
            		totalScore += Float.parseFloat(scoreElement.getTextContent());
	            }else {           
	            	// Modify the value	        	
		            scoreElement = (Element) elementToModify.getElementsByTagName("playerscore"+gameToModify).item(0);
		            scoreElement.setTextContent(String.valueOf(Float.parseFloat(scoreToModify)));
		            // Sum the value to a totalScore variable
		            totalScore += Float.parseFloat(scoreToModify);
	            }
            }            
            // Modify the total value based on the values of scores 1, 2, and 3
            scoreElement = (Element) elementToModify.getElementsByTagName("playertotalscore").item(0);
            scoreElement.setTextContent(String.valueOf(totalScore));           
	            
	            
        	// Transform and save the changes to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(fiPlayersInfoXML);
            transformer.transform(source, result);
	
            // This part is for read the CSV and update Score
	            
    		// Create an ArrayList to store update chess players
    		ArrayList<PlayersChess> arUpdatePlayersChess = new ArrayList<PlayersChess>();
	    		
    		// Read the player information from the CSV file
    		if(fiPlayersCSV.exists()) {
    			FileReader fr = new FileReader(fiPlayersCSV);
    			BufferedReader br = new BufferedReader(fr);
	    			
    			String line;
    			int iLoop = 0;
    			while((line=br.readLine()) != null) {    
    				/* Initializing an array inside a while loop to avoid sharing 
    				 * the same memory location and accidentally modifying other elements
    				 */
    	    		float[] arScore = new float[3];
    	    		
    				if (iLoop != 0) {
    					String[] stListValues = line.split(", ");
    					arScore[0]=Float.parseFloat(stListValues[3]);
    					arScore[1]=Float.parseFloat(stListValues[4]);
    					arScore[2]=Float.parseFloat(stListValues[5]);
    					if (stListValues[0].equals(idToModify)) {
    						arScore[Integer.parseInt(gameToModify)-1] = Float.parseFloat(scoreToModify);
    					}
						arUpdatePlayersChess.add(new PlayersChess(stListValues[0], stListValues[1], stListValues[2], arScore));
    				}
    				iLoop++;
    			}
    			br.close();
    			fr.close();
    			
	        } else {
	            System.out.println("Player no found.");
	        }
    		
    		// Update CSV with new score.
    		savePlayersToCSV( arUpdatePlayersChess,fiPlayersCSV);
	    }

        System.out.println("Score modificated successfully.");
	}
	
	
	//Generates a list of chess master candidates based on a CSV if candidate have 3 points, saves a XML, and converts to HTML using XSLT.
	public static void chessMasterCandidates(File fiPlayersCSV, File fiCandidatesXML, File fiCandidatesXSL, File fiCandidatesHTML) throws Exception {
		
		// Create an ArrayList to store candidate chess players
		ArrayList<PlayersChess> arCandidatePlayersChess = new ArrayList<PlayersChess>();
		
		
		// Read the player information from the CSV file
		if(fiPlayersCSV.exists()) {
			FileReader fr = new FileReader(fiPlayersCSV);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			int iLoop = 0;
			while((line=br.readLine()) != null) {    
				/* Initializing an array inside a while loop to avoid sharing 
				 * the same memory location and accidentally modifying other elements
				 */
				float[] arScore = new float[3];
				if (iLoop != 0) {
					String[] stListValues = line.split(", ");
					arScore[0]=Float.parseFloat(stListValues[3]);
					arScore[1]=Float.parseFloat(stListValues[4]);
					arScore[2]=Float.parseFloat(stListValues[5]);
					if (arScore[0]+arScore[1]+arScore[2]==3) {
						arCandidatePlayersChess.add(new PlayersChess(stListValues[0], stListValues[1], stListValues[2], arScore));
					}	
					
				}
				iLoop++;
			}
			br.close();
			fr.close();
			
			// Save the candidate players to an XML file
			savePlayersToXML(arCandidatePlayersChess, fiCandidatesXML);
			
			// Convert the XML to HTML using XSLT
			convertXMLToHTMLWithXSL(fiCandidatesXML, fiCandidatesXSL, fiCandidatesHTML);
						
		}else {
			throw new Exception("Player list is empty.");
		}		
	}
}