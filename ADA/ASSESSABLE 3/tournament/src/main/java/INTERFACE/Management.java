package INTERFACE;

import DATA.*;
import DOMAIN.*;
import UTIL.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Management {
	// "Initialization of DAO objects."
	private static PlayerDAO objPlayerDAO = new PlayerDAO();
	private static TournamentDAO objTournamentDAO = new TournamentDAO();
	private static LocationDAO objLocationDAO = new LocationDAO();
	
	/* 
	 * Method responsible for gathering the information, validating it, inserting it into a 
	 * list of Player objects, and passing it to the addPlayer method of the objPlayerDAO object. 
	 */
	public static void createPlayers() {
		int iPlayerID = -1;
		
		// List of Players currently in the database.
		List<Player> listPlayers = objPlayerDAO.fillListPlayers();
		// ArrayList to fill with the players to be introduced.
		ArrayList<Player> alNewPlayers = new ArrayList<>();		
		
		do {
			// control variable 
			boolean bCorrectID = true;
			
			// Takes data and verifies that it is not duplicated.
			do {
				int verif = 0;
				iPlayerID = IOTools.AskInt("Insert Player ID or zero to back to the menu", 0);
				if (iPlayerID > 0){
					for (Player player:listPlayers) {
						if (player.getiPlayerID()==iPlayerID) {
							System.out.println("Player ID exists, insert correct ID");
							verif += 1;
						}
					}					
				}
				if (verif > 0){
					bCorrectID = false;
				}else {
					bCorrectID = true;
				}
			}while(bCorrectID==false);
			
			if (iPlayerID!=0) {
				String stFullname = IOTools.AskStringWhitSpaces("Insert Player Fullname").toUpperCase();
				String stCountry = IOTools.AskStringWhitSpaces("Insert Player Country").toUpperCase();
				int iELO = IOTools.AskInt("Insert Player ELO", 0);
				
				// Stored in an ArrayList of Player objects.
				Player player = new Player(iPlayerID, stFullname, stCountry, iELO);
				alNewPlayers.add(player);
			}
		}while(iPlayerID!=0); // While it is different from zero, it will continue requesting data.
		
		
		if (!alNewPlayers.isEmpty()) {			
			// Introduced to the database		
			for (Player player:alNewPlayers) {
				objPlayerDAO.addPlayer(player);
			}
			
			// List players
			objPlayerDAO.listPlayers();
		}
	}
	
	/*
	 * Method responsible for gathering tournament information, verifying it, 
	 * inserting it into a list of Tournament objects, and passing it to the 
	 * addTournament method of the objTournamentDAO object.
	 */
	public static void createTournaments() {
		String stCode = "";
		
		// List of tournaments currently in the database.
		List<Tournament> listTournaments = objTournamentDAO.fillListTournaments();
	 	// ArrayList to fill with the tournaments to be introduced.
		ArrayList<Tournament> alNewTournaments = new ArrayList<>();	
		
		do {
			String stCategory = "";
			
			// Control variable
			boolean bCorrectID = true;
			
			//Takes data and verifies that it is not duplicated.
			do {
				int verif = 0;
				stCode = IOTools.AskString("Insert Tournament Code").toUpperCase();
				if (!stCode.equals("0")){
					for (Tournament tournament:listTournaments) {
						if (tournament.getStCode().equals(stCode)) {
							System.out.println("Tournament code exists, insert correct code");
							verif += 1;
						}
					}					
				}
				if (verif > 0){
					bCorrectID = false;
				}else {
					bCorrectID = true;
				}
			}while(bCorrectID==false);
			
			if (!stCode.equals("0")) {
				int iCategorySelect = IOTools.ShowMenu("Select Category","AMATEUR", "PROFESSIONAL", "MASTER", "SENIOR");
				switch (iCategorySelect){
				case 0:
					stCategory = "AMATEUR";
					break;
				case 1:
					stCategory = "PROFESSIONAL";
					break;
				case 2:
					stCategory = "MASTER";
					break;
				case 3:
					stCategory = "SENIOR";
					break;
				}				
				LocalDate tmStartDate = IOTools.AskDate("Insert Start Date with this format 'dd/MM/yyyy'");
				LocalDate tmEndDate = IOTools.AskDate("Insert End Date with this format 'dd/MM/yyyy'");
				
				// Stored in an ArrayList of Player objects.
				Tournament tournament = new Tournament(stCode, stCategory, tmStartDate, tmEndDate);
				
				// HashSet to store the players associated with each of the tournaments.
				HashSet<Player> hsetPlayers = new HashSet<Player>();
				// List of tournaments currently in the database.
				List<Player> listPlayers = objPlayerDAO.fillListPlayers();
				
				// Control variable
				int iPlayerID = -1;
				
				// Takes the Player objects selected by the user and verifies their existence.
				do {
					int verif = 0;
					iPlayerID = IOTools.AskInt("Enter Player ID to be associated with the tournament or zero to continue", 0);
					for (Player player:listPlayers) {
						if (player.getiPlayerID()==iPlayerID) {
							hsetPlayers.add(player);						
							verif += 1;
						}					
					}
					if (verif != 1) {
						System.out.println("Player Non-existent");
					} else {
						System.out.println("Player Added");
					}
				}while (iPlayerID!=0);
				
				// Introduced associated players to the tournament object
				if (!hsetPlayers.isEmpty()) {
					tournament.setSetObjPlayers(hsetPlayers);
				}
				// add tournament to ArrayList
				alNewTournaments.add(tournament);
			}
		}while(!stCode.equals("0"));
		
		if (!alNewTournaments.isEmpty()) {			
			// Introduced to the database
			for (Tournament tournament:alNewTournaments) {
				objTournamentDAO.addTournament(tournament);
			}			
			// List tournaments
			objTournamentDAO.listTournaments();
		}
	}
	
	/* 
	 * Method responsible for gathering location information, verifying it, 
	 * inserting it into a list of Location objects, and passing it to the 
	 * addLocation method of the objLocationDAO object.
	 */
	public static void createLocations() {
		
		String stCity = "";
		
		// List of locations currently in the database.
		List<Location> listLocations = objLocationDAO.fillListLocations();
		// ArrayList to fill with the locations to be introduced.
		ArrayList<Location> alNewLocations = new ArrayList<>();	
		
		// List of tournaments currently in the database.
		List<Tournament> listTournaments = objTournamentDAO.fillListTournaments();
		
		do {
			// Control variable
			boolean bCorrectID = true;
			
			//Takes data and verifies that it is not duplicated.
			do {
				// Control counter
				int verif = 0;
				stCity = IOTools.AskStringWhitSpaces("Insert City or zero to back to the menu").toUpperCase();
				if (!stCity.equals("0")){
					for (Location location:listLocations) {
						if (location.getStCity().equals(stCity)) {
							System.out.println("City exists, insert correct City");
							verif += 1;
						}
					}					
				}
				if (verif > 0){
					bCorrectID = false;
				}else {
					bCorrectID = true;
				}
			}while(bCorrectID==false);
			
			if (!stCity.equals("0")) {
				String stCountry = IOTools.AskStringWhitSpaces("Insert Country").toUpperCase();
				int iPopulation = IOTools.AskInt("Insert Population", 1);
				
				String stCode = "";
				
				// Stored in an ArrayList of location object.
				Location location = new Location(stCity, stCountry, iPopulation);
				
				// Takes the Tournament objects selected by the user and verifies their existence.
				if (!listTournaments.isEmpty()) {
					do {
						boolean exist = false;
						stCode = IOTools.AskString("Insert Tournament Code for asocied to city or zero to continue").toUpperCase();
						if (!stCode.equals("0")){
							for (Tournament tournament:listTournaments) {
								if (tournament.getStCode().equals(stCode)) {
									// Introduced associated tournaments to the location object
									location.addTournament(tournament);
									exist = true;
								}
							}					
							if (!exist){
								System.out.println("Tournament code not exists, insert correct code");
							}
						}
					}while (!stCode.equals("0"));
				} else {
					System.out.println("Dont exist tournaments");
				}
				
				// add tournament to ArrayList
				alNewLocations.add(location);
			}
		}while(!stCity.equals("0"));
		
		if (!alNewLocations.isEmpty()) {			
			// Introduced to the database		
			for (Location location:alNewLocations) {
				objLocationDAO.addLocation(location);
				objTournamentDAO.updateTournament(location.getSetObjTournaments(), location);
			}			
			// List tournaments
			objLocationDAO.listLocations();
		}		
	}
	
	/*
	 * Method responsible for gathering information about the players to be 
	 * deleted, verifying their existence, and then passing the array of 
	 * players to be deleted to the deletePlayers method of the objPlayerDAO.
	 */
	public static void deletePlayers() {
		// List of players currently in the database.
		List<Player> listPlayers = objPlayerDAO.fillListPlayers();
		// ArrayList to fill with the players to be introduced.
		ArrayList<Player> alDeletePlayers = new ArrayList<>();
		
		int iPlayerID = -1;
		if (!listPlayers.isEmpty()) {
			//Takes the information of the player that the user wants to delete and verifies its existence
			do {
				boolean exist = false;
				iPlayerID = IOTools.AskInt("Insert Player ID to delete player or zero to back to the menu",0);
				if (iPlayerID != 0){
					for (Player player:listPlayers) {
						if (player.getiPlayerID()==iPlayerID) {
							// add player to ArrayList
							alDeletePlayers.add(player);
							exist = true;
						}
					}					
					if (!exist){
						System.out.println("Player ID not exists, insert correct ID");
					}
				}			
						
			}while (iPlayerID!=0);
			
			if (!alDeletePlayers.isEmpty()) {			
				// Deletes the selected players from the database.		
				for (Player player:alDeletePlayers) {
					objPlayerDAO.deletePlayer(player.getiPlayerID());
				}
			}
		} else {
			System.out.println("Dont exist players");
		}
	} 
	
	/*
	 * Method responsible for gathering information about the tournaments to be 
	 * deleted, verifying their existence, and then passing the array of 
	 * tournaments to be deleted to the deleteTournaments method of the objTournamentDAO.
	 */
	public static void deleteTournaments() {
		// List of tournaments currently in the database.
		List<Tournament> listTournaments = objTournamentDAO.fillListTournaments();
		// ArrayList to fill with the players to be introduced.
		ArrayList<Tournament> alDeleteTournaments = new ArrayList<>();
		
		String stCode = "";
		if (!listTournaments.isEmpty()) {
			//Takes the information of the tournament that the user wants to delete and verifies its existence
			do {
				boolean exist = false;
				stCode = IOTools.AskString("Insert Tournament Code to delete tournament or zero to back to the menu").toUpperCase();
				if (!stCode.equals("0")){
					for (Tournament tournament:listTournaments) {
						if (tournament.getStCode().equals(stCode)) {
							// add tournament to ArrayList
							alDeleteTournaments.add(tournament);
							exist = true;
						}
					}					
					if (!exist){
						System.out.println("Tournament not exists, insert correct Code");
					}
				}
			}while (!stCode.equals("0"));
			
			if (!alDeleteTournaments.isEmpty()) {			
				// Deletes the selected players from the database.			
				for (Tournament tournament:alDeleteTournaments) {
					objTournamentDAO.deleteTournament(tournament.getStCode());
				}
			}
		} else {
			System.out.println("Dont exist tournaments");
		}			
	} 
	
	/*
	 * Method responsible for gathering information about the locations to be 
	 * deleted, verifying their existence, and then passing the array of 
	 * locations to be deleted to the deleteLocations method of the objLocationDAO.
	 */
	public static void deleteLocations() {
		// List of location currently in the database.
		List<Location> listLocations = objLocationDAO.fillListLocations();
		// ArrayList to fill with the locations to be introduced.
		ArrayList<Location> alDeleteLocations = new ArrayList<>();
		
		String stCity = "";
		if (!listLocations.isEmpty()) {
			//Takes the information of the location that the user wants to delete and verifies its existence
			do {
				boolean exist = false;
				stCity = IOTools.AskStringWhitSpaces("Insert City to delete location or zero to back to the menu").toUpperCase();
				if (!stCity.equals("0")){
					for (Location location:listLocations) {
						if (location.getStCity().equals(stCity)) {
							// add location to ArrayList
							alDeleteLocations.add(location);
							exist = true;
						}
					}					
					if (!exist){
						System.out.println("Location not exists, insert correct City");
					}
				}
			}while (!stCity.equals("0"));
			
			if (!alDeleteLocations.isEmpty()) {			
				// Deletes the selected players from the database.			
				for (Location location:alDeleteLocations) {
					objLocationDAO.deleteLocation(location.getStCity());
				}
			}
		} else {
			System.out.println("Dont exist locations");
		}			
	} 
	
	/*
	 * A method that allows selecting a number from 0 to 9 as the starting number 
	 * for the IDs of the players to be searched
	 */
	public static void findPlayer() {
		int iNumber = -1;		
		do {
			iNumber = IOTools.AskInt("Intro a number(0-9) or zero to back to the menu", 0, 9);
			objPlayerDAO.findPlayerChessWithHQLCriteria(iNumber);
		}while(iNumber!=0);
	}
	
	/*
	 * A method that allows selecting a letter from A to Z as the starting character 
	 * for the names of the tournaments to be searched
	 */
	public static void findTournament() {
		char cLetter;		
		do {
			cLetter = IOTools.AskChar("Intro a letter(A-Z) or zero to back to the menu","[A-Z0]");
			objTournamentDAO.findTournamentWithHQLCriteria(cLetter);
		}while(cLetter!='0');
	}
}
