package DOMAIN;

import jakarta.persistence.*;

/**
 * =====================================================================
 * Object Player
 * @author Josema Moreno
 * =====================================================================
 */

@Entity
@Table(name = "Player")
public class Player {

	/*
	 * ------------------------------------------
	 * ATTRIBUTES
	 * ------------------------------------------
	 */
	/* 
	 * Be careful about the name of the variables. The getters and setters must follow the same criteria to allow Hibernate
	 * to find the appropriate methods
	 * https://stackoverflow.com/questions/921239/hibernate-propertynotfoundexception-could-not-find-a-getter-for
	 */
	@Id
	@Column(name = "playerID")
	private int iPlayerID;
	
	@Column(name = "fullname")
	private String stFullname;
	
	@Column(name = "country")
	private String stCountry;
	
	@Column(name = "ELO")
	private int iELO;
	
	/*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	/*
	 * Empty constructor
	 */
	public Player() {

	}

	/*
	 * Constructor with all fields
	 */
	public Player(int iPlayerID, String stFullname, String stCountry, int iELO) {
		this.iPlayerID = iPlayerID;
		this.stFullname = stFullname;
		this.stCountry = stCountry;
		this.iELO = iELO;
	}
	
	/*
	 * ------------------------------------------
	 * GETTERS
	 * ------------------------------------------
	 */	
	public int getiPlayerID() {
		return iPlayerID;
	}
	
	public String getStFullname() {
		return stFullname;
	}
	
	public String getStCountry() {
		return stCountry;
	}
	
	public int getiELO() {
		return iELO;
	}
	
	/*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */
	public void setiPlayerID(int iPlayerID) {
		this.iPlayerID = iPlayerID;
	}

	public void setStFullname(String stFullname) {
		this.stFullname = stFullname;
	}

	public void setStCountry(String stCountry) {
		this.stCountry = stCountry;
	}

	public void setiELO(int iELO) {
		this.iELO = iELO;
	}
}
