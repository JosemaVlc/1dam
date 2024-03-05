package chess_tournament;

import java.beans.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class PlayerBean implements Serializable {
	
	/*
	 * ------------------------------------------
	 * ATTRIBUTES
	 * ------------------------------------------
	 */
	private static final long serialVersionUID = 1L;         
	private String stFullname;
	private TournamentBean objTournament;
	private int iPlayerID;
	private boolean bHasAMatch;
	private boolean bHasADeferral;
	private LocalDateTime ldtNextMatchDate;
	private LocalDateTime ldtNextDeferralDate;
	private String stGameResult;
	private String stDeferralResult;
	
	private PropertyChangeSupport propertySupport;
	
	/*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	
	/*
	 * Empty constructor
	 */
    public PlayerBean() {
    	bHasAMatch = false;
    	bHasADeferral = false;    			
        propertySupport = new PropertyChangeSupport(this);
    }
    
    /*
     * ------------------------------------------
     * GETTERS
     * ------------------------------------------
     */    
	public String getStFullname() {
		return stFullname;
	}
    
	public int getiPlayerID() {
		return iPlayerID;
	}

	public TournamentBean getObjTournament() {
		return objTournament;
	}

	public boolean getLsbHasAMatch() {
		return bHasAMatch;
	}

	public boolean getLsbHasADeferral() {
		return bHasADeferral;
	}

	public LocalDateTime getLdtNextMatchDate() {
		return ldtNextMatchDate;
	}

	public LocalDateTime getLdtNextDeferralDate() {
		return ldtNextDeferralDate;
	}
    
	public String getStGameResult() {
		return stGameResult;
	}
    
	public String getStDeferralResult() {
		return stDeferralResult;
	}
	
    /*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */
	public void setStFullname(String stFullname) {
		this.stFullname = stFullname;
	}

	public void setIPlayerID(int iPlayerID) {
		this.iPlayerID = iPlayerID;
	}

	public void setObjTournament(TournamentBean objTournament) {
		this.objTournament = objTournament;
	}

	public void setbHasAMatch(boolean bHasAMatch) {
		this.bHasAMatch = bHasAMatch;
	}

	public void setbHasADeferral(boolean bHasADeferral) {
		this.bHasADeferral = bHasADeferral;
	}

	public void setLdtNextMatchDate(LocalDateTime ldtNewNextMatchDate) {
		LocalDateTime ldtOldNextMatchDate = this.ldtNextMatchDate;
		this.ldtNextMatchDate = ldtNewNextMatchDate;
		propertySupport.firePropertyChange("changeMatchDate", ldtOldNextMatchDate, ldtNewNextMatchDate);
	}

	public void setLdtNextDeferralDate(LocalDateTime idtNewNextDeferralDate) {
		LocalDateTime ldtOldNextDeferralDate = this.ldtNextDeferralDate;
		ldtNextDeferralDate = idtNewNextDeferralDate;
		propertySupport.firePropertyChange("changeDeferralDate", ldtOldNextDeferralDate, idtNewNextDeferralDate);
	}

	public void setStGameResult(String stGameResult) {
		this.stGameResult = stGameResult;
	}

	public void setStDeferralResult(String stDeferralResult) {
		this.stDeferralResult = stDeferralResult;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	} 

    /*
	 * ---------------------------
	 * LISTENERS. PROPERTYCHANGE
	 * ---------------------------
	 */	
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
}
