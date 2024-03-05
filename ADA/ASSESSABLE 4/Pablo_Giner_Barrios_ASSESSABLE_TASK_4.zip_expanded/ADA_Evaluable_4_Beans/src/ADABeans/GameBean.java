package ADABeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * A bean representing game actions, implementing Serializable and PropertyChangeListener interfaces.
 */
public class GameBean implements Serializable, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private PlayerBean objPlayerBean;
	
	/**
     * Default constructor.
     */
	public GameBean() {	}
	
	/**
	 * Parameterized constructor.
	 * @param objPlayerBean The player bean associated with this game bean.
	 */
	public GameBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}

	/**
     * Getter for the player bean associated with this game bean.
     * @return The player bean.
     */
	public PlayerBean getObjPlayerBean() {
		return objPlayerBean;
	}

	/**
     * Setter for the player bean associated with this game bean.
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
				// Print a message indicating the game bean is speaking
				System.out.println("HI, GAMEBEAN SPEAKING!");
				// Insert the game into the database
				DBBean.insertGame(objPlayerBean);
				// Update the player's match status to true
				DBBean.updatePlayerMatch(true, objPlayerBean);
			}else if(bHasAMatch && evt.getNewValue() == null) { // If the player has a match scheduled
				// Print a message indicating the game bean is speaking
				System.out.println("HI, GAMEBEAN SPEAKING!");
				// Update the game result in the database
				DBBean.UpdateTableResult(objPlayerBean.getStMatchResult(), "Game", objPlayerBean);
				// Update the player's match status to false
				DBBean.updatePlayerMatch(false, objPlayerBean);
			}else {
				String message = "HI, GAMEBEAN SPEAKING\n"
						+ "ERROR\n"
						+ "Game not inserted or updated\n"
						+ "----------------------------------------";
				System.out.println(message);
			}
		}
	}
}
