package ADABeans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

/**
 * A bean representing deferral actions, implementing Serializable and PropertyChangeListener interfaces.
 */
public class DeferralBean implements Serializable, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private PlayerBean objPlayerBean;
	
	/**
     * Default constructor.
     */
	public DeferralBean() {}
	
	/**
     * Parameterized constructor.
     * @param objPlayerBean The player bean associated with this deferral bean.
     */
	public DeferralBean(PlayerBean objPlayerBean) {
		this.objPlayerBean = objPlayerBean;
	}
	
	/**
     * Getter for the player bean associated with this deferral bean.
     * @return The player bean.
     */
	public PlayerBean getObjPlayerBean() {
		return objPlayerBean;
	}

	/**
     * Setter for the player bean associated with this deferral bean.
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
		// Check if the property change event is related to a deferral date change
		if(evt.getPropertyName().equals("deferralDateChange")) {
			// Retrieve the current state of the match from the database
			String matchState = DBBean.getGameString("result", objPlayerBean);
			boolean bHasADeferral = DBBean.getBoolFromDatabase("has_deferral", "Player", objPlayerBean);
			// Check if the new value of the event is not null (indicating a deferral)
			if(!bHasADeferral && evt.getNewValue() != null && matchState.equals("PENDING")) {
				// Print a message indicating the deferral bean is speaking
				System.out.println("HI, DEFERRALBEAN SPEAKING!");
				// Insert the deferral into the database
				DBBean.insertDeferral(objPlayerBean);
				// Update the player's deferral status to true
				DBBean.updatePlayerDeferral(true, objPlayerBean);
			}else if (bHasADeferral && evt.getNewValue() == null) {
				// If the new value is null (indicating cancellation of deferral), update the deferral status to false
				System.out.println("HI, DEFERRALBEAN SPEAKING!");
				DBBean.UpdateTableResult(objPlayerBean.getStDeferralResult(), "Deferral", objPlayerBean);
				DBBean.updatePlayerDeferral(false, objPlayerBean);
			}else if(bHasADeferral && evt.getNewValue() != null) {
				String message = "HI, DEFERRALBEAN SPEAKING\n"
						+ "ERROR\n"
						+ "This Player has already a Deferral\n"
						+ "----------------------------------------";
				System.out.println(message);
			}
		}
	}
}
