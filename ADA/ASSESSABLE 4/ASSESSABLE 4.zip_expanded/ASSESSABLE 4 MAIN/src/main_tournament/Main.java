package main_tournament;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import chess_tournament.*;

public class Main {

	public static void main(String[] args) {

    	/*
    	 * ---------------------
		 * Creating the objects
		 * ---------------------
		 */		
    	//Object source
		PlayerBean objRandomPlayer = DBBean.randomPlayer();
        //Object Auxiliary Class
		TournamentBean objTournamentBean = DBBean.randomTournament();
		//Object Listener
		MessageBean objMessageBean = new MessageBean();
		GameBean objGameBean = new GameBean();
		DeferralBean objDeferralBean = new DeferralBean();

        /*
         * ----------------------------------------------
         * Assign the object source to the auxiliary class
         * ----------------------------------------------
         */
		objRandomPlayer.setObjTournament(objTournamentBean);

        /*
         * ----------------------------------------------
         * Assign the object source to the listeners
         * Start the listeners objects
         * ----------------------------------------------
         */
		// Listener MessageBean
		objMessageBean.setObjPlayerBean(objRandomPlayer);
		objRandomPlayer.addPropertyChangeListener(objMessageBean);		
		// Listener GameBean
		objGameBean.setObjPlayerBean(objRandomPlayer);
		objRandomPlayer.addPropertyChangeListener(objGameBean);		
		// Listener DeferralBean
		objDeferralBean.setObjPlayerBean(objRandomPlayer);
		objRandomPlayer.addPropertyChangeListener(objDeferralBean); 

        /*
         * --------------
         * Firing events
         * --------------
         */
        objRandomPlayer.setLdtNextMatchDate(LocalDateTime.parse("2024-03-08T18:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));           
        objRandomPlayer.setLdtNextDeferralDate(LocalDateTime.parse("2024-03-11T12:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));        
        objRandomPlayer.setStGameResult("DRAWS");
        objRandomPlayer.setLdtNextMatchDate(null);        
        objRandomPlayer.setLdtNextDeferralDate(null);        
	} 
}