package ADA_Test;

import ADABeans.*;

public class Main {

	public static void main(String[] args) {
		//Get random player and random tournament
		PlayerBean objPlayerBean = DBBean.getRandomPlayer();
		Tournament objTournament = DBBean.getRandomTournament();
		objPlayerBean.setObjTournament(objTournament);
		
		//Create and bind listeners.
		MessageBean objMessageBean = new MessageBean(objPlayerBean);
		objPlayerBean.addPropertyChangeListener(objMessageBean);
		GameBean objGameBean = new GameBean(objPlayerBean);
		objPlayerBean.addPropertyChangeListener(objGameBean);
		DeferralBean objDeferralBean = new DeferralBean(objPlayerBean);
		objPlayerBean.addPropertyChangeListener(objDeferralBean);
		
		//Actions to generate reactions.
		objPlayerBean.setLdtNextMatchDate("2024-03-08T18:00");
		objPlayerBean.setLdtNextDeferralDate("2024-03-08T18:00");
		objPlayerBean.setStMatchResult("WON");
		objPlayerBean.setLdtNextMatchDate(null);
		objPlayerBean.setStDeferralResult("GRANTED");
		objPlayerBean.setLdtNextDeferralDate(null);
		//objPlayerBean.setLdtNextDeferralDate("2024-03-11T18:00");
	}
}
