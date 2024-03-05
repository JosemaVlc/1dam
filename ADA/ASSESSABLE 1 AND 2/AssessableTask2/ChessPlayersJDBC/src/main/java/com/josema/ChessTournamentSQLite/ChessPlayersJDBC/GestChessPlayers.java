package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;
import java.util.InputMismatchException;
import java.util.Scanner;


public class GestChessPlayers {

	/* METODE Main for a manage CHESS PLAYERS in a Chess Tournament by printing and using a specific menu.
	 * After each option, the user see the same menu until option zero is pressed.
	 * */
	public static void main(String[] args) {
		
		// initialized variables
		Scanner scScanner = new Scanner(System.in);		
		int iOption = -1;
		
		// Set SQLOperations
		SQLiteOperations.setURLSQLite("jdbc:sqlite:./ChessPlayers.db");
		SQLiteOperations.setSQLiteTableName("Players");
		String stSQLData = "ID VARCHAR (255) NOT NULL, " 
				+ "NAME VARCHAR (255), " 
				+ "COUNTRY VARCHAR (255), "
				+ "SCORE1 REAL, "
				+ "SCORE2 REAL, "
				+ "SCORE3 REAL, "
				+ "PRIMARY KEY (ID)";
		SQLiteOperations.setStSQLData(stSQLData);
		String stSQLDataItems = "ID, NAME, COUNTRY, SCORE1, SCORE2, SCORE3";
		SQLiteOperations.setStSQLDataItems(stSQLDataItems);
		
		// Set MongoOperations
		MongoOperations.setURLMongoDB("mongodb://localhost:27017");
		MongoOperations.setMongoDBName("ChessPlayers");
		MongoOperations.setMongoDBCollectionName("players");
		
		// loop for the menu until option zero is pressed.
		do {
			System.out.println(
					"""
					*****
					MENU
					*****
					========================================================================
					 0. Exit
					 1. Get chess players and scores (to SQLite)
					 2. List all chess players (from SQLite)
					 3. Delete all chess players (from SQLite)
					 4. [optional] Dump data from SQLite to MongoDB
					 5. [optional] List all chess players (from MongoDB)
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
					TournamentPlayers.getChessPlayersAndScores(scScanner);					
					break;
				case 2:					
					// List all chess players
					SQLiteOperations.PrintTable();
					break;
				case 3:
					// Delete data from SQLite3
					SQLiteOperations.DeleteDataFromDB();
					break;
				case 4:
					// Modify the rating of a chess player's game
					TournamentPlayers.dumpDataFromSQLiteToMongoDB();
					break;
				case 5:
					// Generate HTML with chess master candidates via XSL
					TournamentPlayers.listAllChessPlayersFromMongoDB();
					break;
				default:
					System.out.println("Option not selectable");
					break;
			}
			// I catch all possible failures at this point
			}catch (InputMismatchException e){
				System.err.println(e + " Error: Spected a Integer value");
				scScanner.nextLine();
			}catch (Exception e) {
				System.err.println(e + " Error: unspecified error");
			} 
		}while (iOption != 0);	
		
		// Close the Scanner
		scScanner.close();
	}
}