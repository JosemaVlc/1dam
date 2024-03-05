package ADABeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

/**
 * A bean representing message actions, implementing Serializable and PropertyChangeListener interfaces.
 */
public class MessageBean implements Serializable, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private PlayerBean objPlayerBean;
	
	/**
     * Default constructor.
     */
	public MessageBean() {
		
	}
	
	/**
     * Parameterized constructor.
     * @param objPlayerBean The player bean associated with this message bean.
     */
	public MessageBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}
	
	/**
     * Getter for the player bean associated with this message bean.
     * @return The player bean.
     */
	public PlayerBean getObjPlayerBean() {
		return objPlayerBean;
	}

	/**
     * Setter for the player bean associated with this message bean.
     * @param objPlayerBean The player bean to set.
     */
	public void setObjPlayerBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}

	/**
     * Method called when a property change event occurs.
     * @param evt The property change event.
     */
	public void propertyChange(PropertyChangeEvent evt) {
		// Check if the property change event is related to a match date change
		if(evt.getPropertyName().equals("matchDateChange")) {
			// Retrieve whether the player has a match scheduled from the database
			boolean bHasAMatch = DBBean.getBoolFromDatabase("has_match", "Player", objPlayerBean);
			// If the player does not have a match scheduled
			if(!bHasAMatch && evt.getNewValue() != null){
				// Format the date and time of the next match
				String formattedDate = objPlayerBean.getLdtNextMatchDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String formattedTime = objPlayerBean.getLdtNextMatchDate().format(DateTimeFormatter.ofPattern("HH:mm"));
				// Construct the message for pending match
				String message = "HI, "
						+ "MESSAGEBEAN SPEAKING!\n"
						+ "\t\t\t*******\n"
						+ "Game match set as PENDING and registered to player '" + objPlayerBean.getStFullname()
						+ "'\nat tournament '" + objPlayerBean.getObjTournament().getStName() + "' on date "
						+ formattedDate + " and time " + formattedTime
						+ "\n\t\t\t*******";
				// Insert the message into the database
				DBBean.insertMessage(objPlayerBean, message);				
			}else if(bHasAMatch && evt.getNewValue() == null) { // If the player has a match scheduled
				// Construct the message for completed match
				String message = "HI, MESSAGEBEAN SPEAKING!\n"
						+ "\t\t\t*******\n"
						+ "Chess game completed set as " + objPlayerBean.getStMatchResult()
						+ "\n\t\t\t*******";
				// Insert the message into the database
				DBBean.insertMessage(objPlayerBean, message);
			}else {
				String message = "HI, MESSAGEBEAN SPEAKING\n"
						+ "\t\t\t*******\n"
						+ "ERROR\n"
						+ "----------------------------------------";
				DBBean.insertMessage(objPlayerBean, message);
			}
		}
		// Check if the property change event is related to a deferral date change
		if(evt.getPropertyName().equals("deferralDateChange")) {
			// Retrieve the current state of the match from the database
			String matchState = DBBean.getGameString("result", objPlayerBean);
			boolean bHasADeferral = DBBean.getBoolFromDatabase("has_deferral", "Player", objPlayerBean);
			// If the new value of the event is not null (indicating a deferral)
			if(!bHasADeferral && evt.getNewValue() != null && matchState.equals("PENDING")) {
				// Format the date and time of the next deferral
				String formattedDate = objPlayerBean.getLdtNextDeferralDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
				String formattedTime = objPlayerBean.getLdtNextDeferralDate().format(DateTimeFormatter.ofPattern("HH:mm"));
				// Construct the message for requested deferral
				String message = "\nHI, "
						+ "MESSAGEBEAN SPEAKING!\n"
						+ "\t\t\t*******\n"
						+ "Deferral set as REQUESTED and registered to player '" + objPlayerBean.getStFullname()
						+ "'\nat tournament '" + objPlayerBean.getObjTournament().getStName() + "' on date "
						+ formattedDate + " and time " + formattedTime
						+ "\n\t\t\t*******";
				// Insert the message into the database
				DBBean.insertMessage(objPlayerBean, message);
			}else if(bHasADeferral && evt.getNewValue() == null) {// If the new value is null (indicating completion of deferral)
                // Construct the message for completed deferral
				String message = "HI, MESSAGEBEAN SPEAKING!\n"
						+ "\t\t\t*******\n"
						+ "Deferral request set as " + objPlayerBean.getStDeferralResult() + "."
						+ "\n\t\t\t*******";
				// Insert the message into the database
				DBBean.insertMessage(objPlayerBean, message);
			}else if(bHasADeferral && evt.getNewValue() != null) {
				String message = "HI, MESSAGEBEAN SPEAKING\n"
						+ "ERROR\n"
						+ "This Player has already a Deferral\n"
						+ "----------------------------------------";
				System.out.println(message);
			}
		}
	}
}
