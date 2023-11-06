package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class TournamentPlayers {
	
	// Create players and add to ArrayList
	public static void getChessPlayersAndScores(Scanner scScanner) throws IOException, SQLException {

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
						writePlayersToDB_usingJDBC(arPlayersChess);
						System.out.println("All CHESS PLAYERS will be saved both in a CSV and XML file");	
					} else {
						System.out.println("Chess players is empty");
					}
					break;
				} else {
					// verify that the ID is unique in the array and set boolean to true if not is unique.
					for (PlayersChess objPlayer : arPlayersChess) {
						String stIdPlayer = objPlayer.getStId();
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
	private static void writePlayersToDB_usingJDBC( ArrayList<PlayersChess> arInfoPlayers) throws SQLException{
		
		PlayersChess objPlayer;
		boolean bDropTableFirst = true;

		/*
		 * 1st STEP: Connect to database
		 */
		Connection cnDB = SQLiteOperations.ConnectToDB();
		Statement staSQLquery = cnDB.createStatement();
		SQLiteOperations.CreateTableIfNotExists(staSQLquery, bDropTableFirst);
		
		Iterator<PlayersChess> itPlayer = arInfoPlayers.iterator();
		/*
		 * 2nd STEP: For every item, add a row
		 */
		while (itPlayer.hasNext()) {
			objPlayer = (PlayersChess)(itPlayer.next());
			staSQLquery.executeUpdate(
					"INSERT INTO " + SQLiteOperations.getDBTableName() + " VALUES (" + objPlayer.toString() +")");
			System.out.println("Inserted row in given database, table " + SQLiteOperations.getDBTableName() + objPlayer.toString());
		};
	}
	
	// Read all players from DB and print in console
	public static void listAllChessPlayersFromSQLite() {
		
		SQLiteOperations.PrintTable();
	}
	
	public static void dumpDataFromSQLiteToMongoDB() {
		
	}


	/*
	 * Static method: Creates a DB collection with all the items of the ArrayList
	 */
	private static void writePlayersToDB_usingMongoDB( ArrayList<PlayersChess> arInfoPlayers){
		
		PlayersChess objPlayer;
		boolean bDropTableFirst = true;
		String stId;
		String stName;
		String stCountry;
		float[] arScore;
			
		/*
		 * 1st STEP: Connect to database
		 */
		MongoClient cnDB = MongoOperations.connectToBD();
		try {
			MongoDatabase mDBFactory = cnDB.getDatabase("ChessPlayers");
			MongoOperations.CreateCollectionIfNotExists(mDBFactory);
			/*
			 * 2nd STEP: For every item, add a row
			 */
			Document docProduct;
			Iterator<PlayersChess> itPlayer = arInfoPlayers.iterator();
			while (itPlayer.hasNext()) {
				/*
				 * { "productName" : "1", "productPrice" : "19.99", "productUnits" : "1" }
				 */
				objPlayer = (PlayersChess) (itPlayer.next());
				stId = objPlayer.getStId();
				stName = objPlayer.getStName();
				stCountry = objPlayer.getStCountry();
				arScore = objPlayer.getArScore();
				
				docProduct = new Document("_id", stId)
						.append(DBDOCUMENTNAME + "price", dPrice)
						.append(DBDOCUMENTNAME + "units", iUnits);
				System.out.println("Element about to be inserted into the collection: " 
						+ DBDOCUMENTNAME + " Name (" + stName + ") " 
						+ DBDOCUMENTNAME + " Price (" + dPrice + ")" 
						+ DBDOCUMENTNAME + " Units (" + iUnits + ")");
				mDBFactory.getCollection(DBCOLLECTIONNAME).insertOne(docProduct);
			}
		} catch (Exception exe) {
			System.out.println("Something was wrong while populating the collection!");
			exe.printStackTrace(System.out);
		}
		CloseDB(cnDB); //close the connection to the DB

	public static void listAllChessPlayersFromMongoDB() {
		
	}
}