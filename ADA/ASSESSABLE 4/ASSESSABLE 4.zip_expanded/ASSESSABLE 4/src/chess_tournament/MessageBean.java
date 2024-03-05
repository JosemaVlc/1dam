package chess_tournament;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessageBean implements Serializable, PropertyChangeListener {

	/*
	 * ------------------------------------------
	 * ATTRIBUTES
	 * ------------------------------------------
	 */
	private static final long serialVersionUID = 1L;
	private PlayerBean objPlayerBean;

    /*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	
	/*
	 * Empty constructor
	 */
    public MessageBean() {

    }
    
    /*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */
    public void setObjPlayerBean(PlayerBean objPlayerBean) {
        this.objPlayerBean = objPlayerBean;
    }

    /*
   	 * -------------------------
   	 * LISTENERS. EVENTS RAISED
   	 * -------------------------
   	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("changeMatchDate")) {
			if ((LocalDateTime)evt.getOldValue() == null 
					&& (LocalDateTime)evt.getNewValue() != null) {
				String message = "--------------------------\n";
				message += "HI, MESSAGEBEAN SPEAKING!\n";
				message += "********\n";
				message += "Game match set as PENDING and registered to player '" + objPlayerBean.getStFullname() + "'\n";
				message += "at tournament '" + objPlayerBean.getObjTournament().getStName() + "' on date " + objPlayerBean.getLdtNextMatchDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " and time " + objPlayerBean.getLdtNextMatchDate().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
				message += "********";
				System.out.println(message);
				DBBean.insertMessage(objPlayerBean, message);
			} else if ((LocalDateTime)evt.getOldValue() != null 
					&& (LocalDateTime)evt.getNewValue() == null
					&& !objPlayerBean.getStGameResult().equals("PENDING")){
				String message = "--------------------------\n";
				message += "HI, MESSAGEBEAN SPEAKING!\n";
				message += "********\n";
				message += "Chess game completed set as "+objPlayerBean.getStGameResult()+"\n";
				message += "********";
				System.out.println(message);
				DBBean.insertMessage(objPlayerBean, message);
			}
		}
		if (evt.getPropertyName().equals("changeDeferralDate")) {
			if ((LocalDateTime)evt.getOldValue() == null 
					&& (LocalDateTime)evt.getNewValue() != null
					&& objPlayerBean.getStGameResult().equals("PENDING")) {
				String message = "--------------------------\n";
				message += "HI, MESSAGEBEAN SPEAKING!\n";
				message += "********\n";
				message += "Deferral set as REQUESTED and registered to player '" + objPlayerBean.getStFullname() + "\n";
				message += "at tournament '" + objPlayerBean.getObjTournament().getStName() + "' on date " + objPlayerBean.getLdtNextDeferralDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " and time " + objPlayerBean.getLdtNextDeferralDate().format(DateTimeFormatter.ofPattern("HH:mm")) + "\n";
				message += "********";
				System.out.println(message);
				DBBean.insertMessage(objPlayerBean, message);
			} else {
				String message = "--------------------------\n";
				message += "HI, MESSAGEBEAN SPEAKING!\n";
				message += "********\n";
				message += "Deferral request set as REJECTED\n";
				message += "********";
				System.out.println(message);
				DBBean.insertMessage(objPlayerBean, message);				
			}
		}
	}      
}
