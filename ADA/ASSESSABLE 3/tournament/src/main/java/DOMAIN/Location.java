package DOMAIN;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

/**
 * =====================================================================
 * Object Location
 * @author Josema Moreno
 * =====================================================================
 */

@Entity
@Table(name = "Location")
public class Location {

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
	@Column(name = "city")
	private String stCity;
	
	@Column(name = "country")
	private String stCountry;
	
	@Column(name = "population")
	private int iPopulation;
		
    @OneToMany(mappedBy = "objLocation", cascade = CascadeType.REMOVE)
    private Set<Tournament> setObjTournaments = new HashSet<>();
	
	/*
	 * ------------------------------------------
	 * METHODS
	 * ------------------------------------------
	 */
	/*
	 * Empty constructor
	 */
	public Location() {

	}

	/*
	 * Constructor with all fields
	 */
	public Location(String stCity, String stCountry, int iPopulation) {
		this.stCity = stCity;
		this.stCountry = stCountry;
		this.iPopulation = iPopulation;
	}
	
	public void addTournament(Tournament objTournament) {
		setObjTournaments.add(objTournament);
		objTournament.setObjLocation(this); // Asegura la relación bidireccional
	}

	/*
	 * ------------------------------------------
	 * GETTERS
	 * ------------------------------------------
	 */		
	public String getStCity() {
		return stCity;
	}
	
	public String getStCountry() {
		return stCountry;
	}
	
	public int getiPopulation() {
		return iPopulation;
	}

	public Set<Tournament> getSetObjTournaments() {
		return setObjTournaments;
	}

	/*
	 * ------------------------------------------
	 * SETTERS
	 * ------------------------------------------
	 */		
	public void setStCity(String stCity) {
		this.stCity = stCity;
	}
	
	public void setStCountry(String stCountry) {
		this.stCountry = stCountry;
	}
	
	public void setiPopulation(int iPopulation) {
		this.iPopulation = iPopulation;
	}
	
	public void setSetObjTournaments(Set<Tournament> setObjTournaments) {
		this.setObjTournaments = setObjTournaments;
	}
}