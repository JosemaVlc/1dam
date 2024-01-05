package INTERFACE;

import UTIL.IOTools;

public class Main {

	public static void main(String[] args) {	
		int iOption = -1;		
		
		// loop for the menu until option zero is pressed.
		do {
			System.out.println("""					
					*****
					MENU
					*****
					========================================================================
					0. Exit
					1. Insert & List chess players
					2. Insert & List tournaments
					3. Insert & List locations
					4. Delete chess players
					5. Delete tournaments
					6. Delete locations
					7. [optional] Find a chess player
					8. [optional] Find a tournament
					========================================================================""");
			
			// I use the try-catch to catch all possible failures at this point
			try {				
				iOption = IOTools.AskInt("Select an option", 0, 8);
								
				switch (iOption) {
				case 0:
					// Close Application
					System.out.println("Application closed");
					break;
				case 1:
					// Insert & List chess players		
					Management.createPlayers();
					break;
				case 2:					
					// Insert & List tournaments
					Management.createTournaments();
					break;
				case 3:
					// Insert & List locations
					Management.createLocations();
					break;
				case 4:
					// Delete chess players
					Management.deletePlayers();
					break;
				case 5:
					Management.deleteTournaments();
					// Delete tournaments
					break;
				case 6:
					// Delete locations
					Management.deleteLocations();
					break;
				case 7:
					// Find a chess player
					Management.findPlayer();
					break;
				case 8:
					// Find a tournament
					Management.findTournament();
					break;
				default:
					System.out.println("Option not selectable");
					break;
			}
			// I catch all possible failures at this point			
			} catch (Exception e) {
				System.err.println(e + " Error: unspecified error");
			} 
		}while (iOption != 0);	
	}
}
