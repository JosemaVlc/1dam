package DATA;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;

import DOMAIN.*;
import UTIL.HibernateUtil;

/**
 * ============================================================================
 * Data layer. Program to manage CRUD operations to the DB. Table location
 * @author Josema Moreno. Based and modified from Sergio Badal and Abelardo
 * ============================================================================
 */

public class LocationDAO {
	
	/**
	 * ----------------------------------------
	 * GLOBAL CONSTANTS AND VARIABLES
	 * ----------------------------------------
	 */	
	//Table name constant
	static final String DBTABLENAME = "Location";
	
	/*
	 * ------------------
	 * INSERT
	 * ------------------
	 */
	/* Method to CREATE a Location in the database */
	public Location addLocation(String stCity, String stCountry, int iPopulation) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); // open hibernate session factory
		Transaction txDB = null; //database transaction
		Location objLocation = new Location(stCity, stCountry, iPopulation); // create object with city, country and population
		
		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			hibSession.persist(objLocation); // Inserts the object into the database.
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item added.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
		return objLocation;
	}
	
	/*
	 * ------------------
	 * INSERT
	 * ------------------
	 */
	/* Method to CREATE a Location in the database */
	public Location addLocation(Location objLocation) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction
		
		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			hibSession.persist(objLocation); // Inserts the object into the database.
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item added.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
		return objLocation;
	}

	/*
	 * ------------------
	 * SELECT
	 * ------------------
	 */
	/* Method to READ all the Locations */
	public void listLocations() {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory

		try {
			List<Location> lstLocations = hibSession.createQuery("FROM " + DBTABLENAME, Location.class).list(); // Executes a query to the database to retrieve all records from the 'location' table.
			if (lstLocations.isEmpty()) {
				System.out.println("******** No items found");
			}else {
				System.out.println("\n***** Start listing ...\n");
			}
			// Show all locations on the screen.
			for (Iterator<Location> itLocation = lstLocations.iterator(); itLocation.hasNext();) {
				Location objLocation = (Location) itLocation.next();
				System.out.print(DBTABLENAME + " City: " + objLocation.getStCity() + " | ");
				System.out.print(DBTABLENAME + " Country: " + objLocation.getStCountry() + " | ");
				System.out.print(DBTABLENAME + " Population: " + objLocation.getiPopulation() + "\n");
			}
		} finally {
			hibSession.close(); //close hibernate session
		}
	}

	/*
	 * ------------------
	 * SELECT
	 * ------------------
	 */
	/* Method to READ all the Locations and RETURN an object list */	
	public List<Location> fillListLocations() {
        Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
        List<Location> lLocationsFromQuery = null; //Generates the list and initializes it to null.
        try {
			lLocationsFromQuery = hibSession.createQuery("FROM " + DBTABLENAME, Location.class).list(); // Executes a query to the database to retrieve all records from the 'location' table.
        }finally {
            hibSession.close();
        }

        return lLocationsFromQuery;
    }
	
	/*
	 * ------------------
	 * DELETE
	 * ------------------
	 */
	/* Method to DELETE a Location from the records */
	public void deleteLocation(String stCity) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			Location objLocation;
			if ((objLocation = (Location) hibSession.get(Location.class, stCity)) != null)
				hibSession.remove(objLocation);
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item deleted.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
	}

	/* Method to DELETE all records */
	public void deleteAllItems() {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			List<Location> lstLocations = hibSession.createQuery("FROM " + DBTABLENAME, Location.class).list();
			if (!lstLocations.isEmpty())
				for (Iterator<Location> itLocation = lstLocations.iterator(); itLocation.hasNext();) {
					Location objLocation = (Location) itLocation.next();
					hibSession.remove(objLocation);
				}
			txDB.commit(); //ends transaction
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
	}
}