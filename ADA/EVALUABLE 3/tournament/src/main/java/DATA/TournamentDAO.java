package DATA;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

import DOMAIN.Tournament;
import DOMAIN.Location;
import DOMAIN.Player;
import UTIL.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * ============================================================================
 * Data layer. Program to manage CRUD operations to the DB. Table Tournament
 * @author Josema Moreno. Based and modified from Sergio Badal and Abelardo
 * ============================================================================
 */

public class TournamentDAO {
	
	/**
	 * ----------------------------------------
	 * GLOBAL CONSTANTS AND VARIABLES
	 * ----------------------------------------
	 */	
	//Table name constant
	static final String DBTABLENAME = "Tournament";
	
	/*
	 * ------------------
	 * INSERT
	 * ------------------
	 */
	/* Method to CREATE a Tournament in the database */
	public Tournament addTournament(Tournament objTournament) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction
		
		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			hibSession.persist(objTournament);
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item added.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
		return objTournament;
	}


	/*
	 * ------------------
	 * SELECT
	 * ------------------
	 */
	/* Method to READ all the Tournaments */
	public void listTournaments() {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory

		try {
			List<Tournament> lstTournaments = hibSession.createQuery("FROM " + DBTABLENAME, Tournament.class).list();
			if (lstTournaments.isEmpty())
				System.out.println("******** No items found");
			else
				System.out.println("\n***** Start listing ...\n");
			for (Iterator<Tournament> itTournament = lstTournaments.iterator(); itTournament.hasNext();) {
				Tournament objTournament = (Tournament) itTournament.next();
				System.out.print(DBTABLENAME + " Code: " + objTournament.getStCode() + " | ");
				System.out.print(DBTABLENAME + " Category: " + objTournament.getStCategory() + " | ");
				System.out.print(DBTABLENAME + " Start date: " + objTournament.getTmStartDate() + " | ");
				System.out.print(DBTABLENAME + " End date: " + objTournament.getTmEndDate() + " | ");
				System.out.print(DBTABLENAME + " Players: " + "\n");
				
	            // Print players associated with the tournament.
	            Set<Player> players = objTournament.getSetObjPlayers();
	            for (Player player : players) {
	                System.out.println("Player ID: " + player.getiPlayerID() + " | Full Name: " + player.getStFullname());
	            }
			}
		} finally {
			hibSession.close(); //close hibernate session
		}
	}
	
	/* Method to READ all the Tournaments and RETURN an object list */	
	public List<Tournament> fillListTournaments() {
        Session hibSession = HibernateUtil.SFACTORY.openSession();
        List<Tournament> lTournamentsFromQuery = null;
        try {
			lTournamentsFromQuery = hibSession.createQuery("FROM " + DBTABLENAME, Tournament.class).list();
        }finally {
            hibSession.close();
        }
        return lTournamentsFromQuery;
    }
	
	/* Method to read and show tournaments that start with the character passed as a parameter */	
	public void findTournamentWithHQLCriteria(char chCharacter){
		String stLetter = chCharacter + "%";
		
		Session hibSession = HibernateUtil.SFACTORY.openSession();
		System.out.print("\n***** Listing Tournaments usin HQL criteria...\n");
		
		try {
			// 1. Create a CriteriaBuilder instance by calling the Session.getCriteriaBuilder() method.
			CriteriaBuilder crbCritBuilder = hibSession.getCriteriaBuilder();
			// 2. Create a query object by creating an instance of the CriteriaQuery interface.
			CriteriaQuery<Tournament> crqHQL = crbCritBuilder.createQuery(Tournament.class);
			// 3. Set the query Root by calling the from() method on the CriteriaQuery object to define a range variable in FROM clause.
			Root<Tournament> rootTournament = crqHQL.from(Tournament.class);
			// 4. Specify what the type of the query result will be by calling the select() method of the CriteriaQuery object.
			crqHQL.select(rootTournament).where(crbCritBuilder.like(rootTournament.get("stCode"), stLetter));
			crqHQL.orderBy(crbCritBuilder.asc(rootTournament.get("stCode")));
			// 5. Prepare the query for execution by creating a org.hibernate.query.Query instance by calling the Session.createQuery() method, specifying the type of the query result.
			Query<Tournament> qryHQL = hibSession.createQuery(crqHQL);
			// 6. Execute the query by calling the getResultList() or getSingleResult() method on the org.hibernate.query.Query object.
			List<Tournament> lstTournaments = qryHQL.getResultList();
			
			if (lstTournaments.isEmpty())
				System.out.println("******** No items found");
			for (Iterator<Tournament> itTournament = lstTournaments.iterator(); itTournament.hasNext();) {
				Tournament objTournament = (Tournament) itTournament.next();
				System.out.print("Code: " + objTournament.getStCode() + " | ");
				System.out.print("Category: " + objTournament.getStCategory() + " | ");
				System.out.print("Start Date: " + objTournament.getTmStartDate() + " | ");
				System.out.println("End Date: " + objTournament.getTmEndDate());
				System.out.print(DBTABLENAME + " Players: " + "\n");
				
	            // Print players associated with the tournament.
	            Set<Player> players = objTournament.getSetObjPlayers();
	            for (Player player : players) {
	                System.out.println("Player ID: " + player.getiPlayerID() + " | Full Name: " + player.getStFullname());
	            }
			}
		} finally {
			hibSession.close(); //close hibernate session
		}
	}

	/*
	 * ------------------
	 * UPDATE
	 * ------------------
	 */
	/* Method to UPDATE a Tournament */
	public void updateTournament(Tournament tournament, Location objLocation) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			Tournament objTournament = (Tournament) hibSession.get(Tournament.class, tournament.getStCode());
			objTournament.setObjLocation(objLocation);
			hibSession.merge(objTournament);
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Tournament updated.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
	}

	/* Method to UPDATE Tournaments */
	public void updateTournament(Set<Tournament> lTournaments, Location objLocation) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			for (Tournament tournament: lTournaments) {
				Tournament objTournament = (Tournament) hibSession.get(Tournament.class, tournament.getStCode());
				objTournament.setObjLocation(objLocation);
				hibSession.merge(objTournament);
			}
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Tournament updated.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
	}

	/*
	 * ------------------
	 * DELETE
	 * ------------------
	 */
	/* Method to DELETE a Tournament from the records */
	public void deleteTournament(String stCode) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			Tournament objTournament;
			if ((objTournament = (Tournament) hibSession.get(Tournament.class, stCode)) != null)
				hibSession.remove(objTournament);
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
			//old createQuery method is deprecated, but still working in the latest version
			List<Tournament> lstTournaments = hibSession.createQuery("FROM " + DBTABLENAME, Tournament.class).list();
			if (!lstTournaments.isEmpty())
				for (Iterator<Tournament> itTournament = lstTournaments.iterator(); itTournament.hasNext();) {
					Tournament objTournament = (Tournament) itTournament.next();
					hibSession.remove(objTournament);
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