package ADABeans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A bean representing a player, implementing Serializable.
 */
public class PlayerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int intPlayerID;
	private String stFullname;
	private Tournament objTournament;
	private boolean bHasAMatch;
	private boolean bHasADeferral;
	private LocalDateTime ldtNextMatchDate;
	private LocalDateTime ldtNextDeferralDate;
	private String stMatchResult;
	private String stDeferralResult;
	
	// Property support for firing property change events
	private PropertyChangeSupport propertySupport;
	
	/**
     * Default constructor.
     */
	public PlayerBean() {
		propertySupport = new PropertyChangeSupport(this);
		this.bHasAMatch = false;
		this.bHasADeferral = false;
		this.ldtNextMatchDate = null;
		this.ldtNextDeferralDate = null;
		this.stMatchResult = null;
		this.stDeferralResult = null;
	}

	/**
     * Constructor with player ID and full name.
     * @param intPlayerID The player's ID.
     * @param stFullname The player's full name.
     */
	public PlayerBean(int intPlayerID, String stFullname) {
		this.propertySupport = new PropertyChangeSupport(this);
		this.intPlayerID = intPlayerID;
		this.stFullname = stFullname;
		this.objTournament = null;
		this.bHasAMatch = false;
		this.bHasADeferral = false;
		this.ldtNextMatchDate = null;
		this.ldtNextDeferralDate = null;
		this.stMatchResult = null;
		this.stDeferralResult = null;
	}
	
	// Getters and setters

	public int getIntPlayerID() {
		return intPlayerID;
	}

	public void setIntPlayerID(int intPlayerID) {
		this.intPlayerID = intPlayerID;
	}
	
	public String getStFullname() {
		return stFullname;
	}

	public void setStFullname(String stFullname) {
		this.stFullname = stFullname;
	}

	public Tournament getObjTournament() {
		return objTournament;
	}

	public void setObjTournament(Tournament objTournament) {
		this.objTournament = objTournament;
	}
	
	public boolean isbHasAMatch() {
		return bHasAMatch;
	}

	public void setbHasAMatch(boolean bHasAMatch) {
		this.bHasAMatch = bHasAMatch;
	}
	
	public boolean isbHasADeferral() {
		return bHasADeferral;
	}

	public void setbHasADeferral(boolean bHasADeferral) {
		this.bHasADeferral = bHasADeferral;
	}

	public String getStMatchResult() {
		return stMatchResult;
	}

	public void setStMatchResult(String stMatchResult) {
		if(stMatchResult.equals("PENDING") || stMatchResult.equals("WON") || stMatchResult.equals("LOST") || stMatchResult.equals("DRAWS")) {
			this.stMatchResult = stMatchResult;
		}else {
			System.out.println("Invalid match result value.");
		}
	}

	public String getStDeferralResult() {
		return stDeferralResult;
	}

	public void setStDeferralResult(String stDeferralResult) {
		if(stDeferralResult.equals("REQUESTED") || stDeferralResult.equals("GRANTED") || stDeferralResult.equals("REJECTED")) {
			this.stDeferralResult = stDeferralResult;
		}else {
			System.out.println("Invalid Deferral result value.");
		}
	}
	
	// Property change support methods

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}
	
	// Getter and setter for the next match date
	
	public LocalDateTime getLdtNextMatchDate() {
		return ldtNextMatchDate;
	}
	
	public void setLdtNextMatchDate(String stDate) {
		LocalDateTime ldtDate = dateFormatter(stDate);
		LocalDateTime ldtOldMatchDate = this.ldtNextMatchDate;
		this.ldtNextMatchDate = ldtDate;
		// Fire a property change event for match date change
		propertySupport.firePropertyChange("matchDateChange", ldtOldMatchDate, ldtNextMatchDate);
	}
	
	// Getter and setter for the next deferral date

	public LocalDateTime getLdtNextDeferralDate() {
		return ldtNextDeferralDate;
	}

	public void setLdtNextDeferralDate(String stNextDeferralDate) {
		LocalDateTime ldtNextDeferralDate = dateFormatter(stNextDeferralDate);
		LocalDateTime ldtOldDeferralDate = this.ldtNextDeferralDate;
		this.ldtNextDeferralDate = ldtNextDeferralDate;
		// Fire a property change event for deferral date change
		propertySupport.firePropertyChange("deferralDateChange", ldtOldDeferralDate, ldtNextDeferralDate);
	}
	
	/**
	 * // Private method to parse date string into LocalDateTime
	 * @param stDate String representing the Date
	 * @return Formatted Date or null.
	 */
	private LocalDateTime dateFormatter(String stDate) {
		if(stDate != null) {
			LocalDateTime ldtMatchDate = LocalDateTime.parse(stDate, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			return ldtMatchDate;
		}else {
			return null;
		}
	}
}
