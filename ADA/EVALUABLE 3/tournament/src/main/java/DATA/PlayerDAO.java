package DATA;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

import DOMAIN.Player;
import UTIL.HibernateUtil;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.CriteriaBuilder;

/**
 * ============================================================================
 * Data layer. Program to manage CRUD operations to the DB. Table location
 * @author Josema Moreno. Based and modified from Sergio Badal and Abelardo Martínez
 * ============================================================================
 */

public class PlayerDAO {
	
	/**
	 * ----------------------------------------
	 * GLOBAL CONSTANTS AND VARIABLES
	 * ----------------------------------------
	 */	
	//Table name constant
	static final String DBTABLENAME = "Player";
	
	/*
	 * ------------------
	 * INSERT
	 * ------------------
	 */
	/* Method to CREATE a Player in the database */
	public Player addPlayer(int iPlayerID, String stFullname, String stCountry, int iELO) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction
		Player objPlayer = new Player(iPlayerID, stFullname, stCountry, iELO);
		
		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			hibSession.persist(objPlayer);
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item added.\n");
		} catch (HibernateException hbe) {
			if (txDB != null)
				txDB.rollback(); //something went wrong, so rollback
			hbe.printStackTrace();
		} finally {
			hibSession.close(); //close hibernate session
		}
		return objPlayer;
	}
	
	/* Method to CREATE a Player in the database */
	public void addPlayer(Player objPlayer) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction
		
		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			hibSession.persist(objPlayer);
			txDB.commit(); //ends transaction
			System.out.println(DBTABLENAME + " ***** Item added.\n");
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
	 * SELECT
	 * ------------------
	 */
	/* Method to READ all the Players */
	public void listPlayers() {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory

		try {
			List<Player> lstPlayers = hibSession.createQuery("FROM " + DBTABLENAME, Player.class).list();
			if (lstPlayers.isEmpty())
				System.out.println("******** No items found");
			else
				System.out.println("\n***** Start listing ...\n");
			for (Iterator<Player> itPlayer = lstPlayers.iterator(); itPlayer.hasNext();) {
				Player objPlayer = (Player) itPlayer.next();
				System.out.print(DBTABLENAME + " Player ID: " + objPlayer.getiPlayerID() + " | ");
				System.out.print(DBTABLENAME + " Full Name: " + objPlayer.getStFullname() + " | ");
				System.out.print(DBTABLENAME + " Country: " + objPlayer.getStCountry() + " | ");
				System.out.print(DBTABLENAME + " ELO: " + objPlayer.getiELO() + "\n");
			}
		} finally {
			hibSession.close(); //close hibernate session
		}
	}
	
	/* Method to READ all the Players and RETURN an object list */	
	public List<Player> fillListPlayers() {
        Session hibSession = HibernateUtil.SFACTORY.openSession();
        List<Player> lPlayersFromQuery = null;
        
        try {
			lPlayersFromQuery = hibSession.createQuery("FROM " + DBTABLENAME, Player.class).list();
        }finally {
            hibSession.close();
        }

        return lPlayersFromQuery;
    }
	
	/* Method to read and show player that start with the number passed as a parameter */
	public void findPlayerChessWithHQLCriteria(int number){
		String stNumber = String.valueOf(number);
		String stPattern = stNumber+"%";
		
		Session hibSession = HibernateUtil.SFACTORY.openSession();
		System.out.print("\n***** Listing Player Chess usin HQL criteria...\n");
		
		try {
			// 1. Create a CriteriaBuilder instance by calling the session.getCriteriaBuilder() method.
			CriteriaBuilder crbCritBuilder = hibSession.getCriteriaBuilder();
			// 2. Create a query object by creating an instance of the CriteriaQuery interface.
			CriteriaQuery<Player> crqHQL = crbCritBuilder.createQuery(Player.class);
			// 3. Set the query Root by calling the from() method on the CriteriaQuery object to define a range variable in FROM clause.
			Root<Player> rootPlayer = crqHQL.from(Player.class);
			// 4. Specify what the type of the query result will be by calling the select() method of the CriteriaQuery object.
			crqHQL.select(rootPlayer).where(crbCritBuilder.like(rootPlayer.get("iPlayerID").as(String.class), stPattern));
			crqHQL.orderBy(crbCritBuilder.asc(rootPlayer.get("iPlayerID")));
			// 5. Prepare the query for execution by creating a org.hibernate.query.Query instance by calling the Session.createQuery() method, specifying the type of the query result.
			Query<Player> qryHQL = hibSession.createQuery(crqHQL);
			// 6. Execute the query by calling the getResultList() or getSingleResult() method on the org.hibernate.query.Query object.
			List<Player> lstPlayers = qryHQL.getResultList();
			if (lstPlayers.isEmpty())
				System.out.println("******** No items found");
			for (Iterator<Player> itPlayer = lstPlayers.iterator(); itPlayer.hasNext();) {
				Player objPlayer = (Player) itPlayer.next();
				System.out.print("Player ID: " + objPlayer.getiPlayerID() + " | ");
				System.out.print("Player Name: " + objPlayer.getStFullname() + " | ");
				System.out.print("Country: " + objPlayer.getStCountry() + " | ");
				System.out.println("ELO: " + objPlayer.getiELO());
			}
		} finally {
			hibSession.close(); //close hibernate session
		}
	}
	
	/*
	 * ------------------
	 * DELETE
	 * ------------------
	 */
	/* Method to DELETE a Player from the records */
	public void deletePlayer(int iPlayerID) {
		
		Session hibSession = HibernateUtil.SFACTORY.openSession(); //open hibernate session factory
		Transaction txDB = null; //database transaction

		try {
			txDB = hibSession.beginTransaction(); //starts transaction
			Player objPlayer;
			if ((objPlayer = (Player) hibSession.get(Player.class, iPlayerID)) != null)
				//delete method is deprecated, but still working in the latest version
				//https://stackoverflow.com/questions/71211904/alternative-to-using-deprecated-save-method-in-hibernate
				hibSession.remove(objPlayer);
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
			List<Player> lstPlayers = hibSession.createQuery("FROM " + DBTABLENAME, Player.class).list();
			if (!lstPlayers.isEmpty())
				for (Iterator<Player> itPlayer = lstPlayers.iterator(); itPlayer.hasNext();) {
					Player objPlayer = (Player) itPlayer.next();
					//delete method is deprecated, but still working in the latest version
					//https://stackoverflow.com/questions/71211904/alternative-to-using-deprecated-save-method-in-hibernate
					hibSession.remove(objPlayer);
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