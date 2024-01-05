package DOMAIN;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;

/**
 * =====================================================================
 * Object Tournament
 * @author Josema Moreno
 * =====================================================================
 */

@Entity
@Table(name = "Tournament")
public class Tournament {

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
	@Column(name = "code")
	private String stCode;
	
	@Column(name = "category")
	private String stCategory;
	
	@Column(name = "start_date")
	private LocalDate tmStartDate;
	
	@Column(name = "end_date")
	private LocalDate tmEndDate;		

    @ManyToOne
    @JoinColumn(name = "city")
    private Location objLocation;
	
	@ManyToMany(targetEntity = Player.class)
	@JoinTable(
			name = "Game", 
			joinColumns = { @JoinColumn(name = "code") }, 
			inverseJoinColumns = {@JoinColumn(name = "playerID")})
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Player> setObjPlayers = new HashSet<>();
	
	
	/*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	/*
	 * Empty constructor
	 */
	public Tournament() {

	}

	/*
	 * Constructor with all fields
	 */
	public Tournament(String stCode, String stCategory, LocalDate tmStartDate, LocalDate tmEndDate) {
		this.stCode = stCode;
		this.stCategory = stCategory;
		this.tmStartDate = tmStartDate;
		this.tmEndDate = tmEndDate;
	}
	
	/*
	 * ------------------------------------------
	 * GETTERS
	 * ------------------------------------------
	 */	
	public String getStCode() {
		return stCode;
	}

	public String getStCategory() {
		return stCategory;
	}

	public LocalDate getTmStartDate() {
		return tmStartDate;
	}

	public LocalDate getTmEndDate() {
		return tmEndDate;
	}

	public Location getObjLocation() {
		return objLocation;
	}
	
	public Set<Player> getSetObjPlayers() {
		return setObjPlayers;
	}
	
	/*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */	
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public void setStCategory(String stCategory) {
		this.stCategory = stCategory;
	}

	public void setTmStartDate(LocalDate tmStartDate) {
		this.tmStartDate = tmStartDate;
	}

	public void setTmEndDate(LocalDate tmEndDate) {
		this.tmEndDate = tmEndDate;
	}

	public void setObjLocation(Location objLocation) {
		this.objLocation = objLocation;
	}

	public void setSetObjPlayers(Set<Player> setObjPlayers) {
		this.setObjPlayers = setObjPlayers;
	}
	
	
}
