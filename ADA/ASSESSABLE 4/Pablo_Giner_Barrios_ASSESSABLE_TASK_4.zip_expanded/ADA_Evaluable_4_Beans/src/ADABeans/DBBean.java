package ADABeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to connect with the database and manage CRUD operations.
 */
public class DBBean {
	
	// Database credentials
	private static final String DBNAME = "dbchessgames";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "admin";
	
	// Connection URL
	private static final String CONN_URL = "jdbc:mysql://localhost:3306/" + DBNAME
			+ "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	
	private Connection cnDB = null;
	
	// Constructor to establish the database connection
	public DBBean() {
		try {
			// Load MySQL JDBC driver and establish connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			cnDB = DriverManager.getConnection(CONN_URL, DBUSER, DBPASSWORD);
			//System.out.println("Connected to the database");
		}catch (ClassNotFoundException | SQLException sqle) {
			System.out.println("Got an exception connecting!!!");
			System.out.println(sqle.getMessage());
		}
	}
	
	/**
	 * Method to close the database connection
	 */
    private void closeDBConnection() {
        try {
            if (cnDB != null) {
            	cnDB.close();
            	//System.out.println("[OK!] Disconnected from the database");
            }
        } catch (Exception exe) {
        	System.out.println("Got an exception (closing database)! " + exe.getMessage());
        }
    }
    
    /**
     * Method to insert a message into the database
     * @param objPlayerBean Source
     * @param stDescription Content of the message
     */
    public static void insertMessage(PlayerBean objPlayerBean, String stDescription) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "INSERT INTO Message (playerID, description) VALUES (?,?)";
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setInt(1, objPlayerBean.getIntPlayerID());
    		pstaSQLInsert.setString(2, stDescription);
    		pstaSQLInsert.execute();
    		System.out.println(stDescription);
    		System.out.println("Inserted message.\n----------------------------------------");
    		objDBBean.closeDBConnection();
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception inserting a message! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to insert a game into the database
     * @param objPlayerBean Source
     */
    public static void insertGame(PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "INSERT INTO Game (code, playerID, matchdate) VALUES (?,?,?)";
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setString(1, objPlayerBean.getObjTournament().getStCode());
    		pstaSQLInsert.setInt(2, objPlayerBean.getIntPlayerID());
    		pstaSQLInsert.setObject(3, objPlayerBean.getLdtNextMatchDate());
    		pstaSQLInsert.execute();
    		objPlayerBean.setStMatchResult("PENDING");
    		System.out.println("Inserted Game.");
    		objDBBean.closeDBConnection();
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception inserting a game! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to insert a deferral into the database
     * @param objPlayerBean Source
     */
    public static void insertDeferral(PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "INSERT INTO Deferral (code, playerID, defdate) VALUES (?,?,?)";
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setString(1, objPlayerBean.getObjTournament().getStCode());
    		pstaSQLInsert.setInt(2, objPlayerBean.getIntPlayerID());
    		pstaSQLInsert.setObject(3, objPlayerBean.getLdtNextDeferralDate());
    		pstaSQLInsert.execute();
    		System.out.println("Inserted Deferral");
    		objDBBean.closeDBConnection();
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception inserting a deferral! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to update whether a player has a match appointment
     * @param value True of false
     * @param objPlayerBean Source
     */
    public static void updatePlayerMatch(boolean value, PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "UPDATE Player SET has_match = ? WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setBoolean(1, value);
    		pstaSQLUpdate.setInt(2, objPlayerBean.getIntPlayerID());
    		int rowsUpdates = pstaSQLUpdate.executeUpdate();
    		if(rowsUpdates > 0) {
    			if(value == true) {
    				System.out.println("Updated player. Has a match appointment.\n----------------------------------------");    				
    			}else {
    				System.out.println("Updated player. No longer has a match appointment.\n----------------------------------------");
    			}
    			objPlayerBean.setbHasAMatch(value);
    		} else {
    			System.out.println("There is any player with this ID.");
    		}
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception updating a player! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to update whether a player has requested a deferral.
     * @param value True or false
     * @param objPlayerBean Source
     */
    public static void updatePlayerDeferral(boolean value, PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "UPDATE Player SET has_deferral = ? WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setBoolean(1, value);
    		pstaSQLUpdate.setInt(2, objPlayerBean.getIntPlayerID());
    		int rowsUpdates = pstaSQLUpdate.executeUpdate();
    		if(rowsUpdates > 0) {
    			if(value) {
    				System.out.println("Updated player. Has a deferral requested.\n----------------------------------------");
    			}else {
    				System.out.println("Updated player. Has no longer a deferral request.\n----------------------------------------");
    			}
    			objPlayerBean.setbHasADeferral(value);
    		} else {
    			System.out.println("There is any player with this ID.");
    		}
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception updating a player! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to update the result of a game
     * @param value from PENDING to WIN, LOST or DRAWS
     * @param objPlayerBean Source
     */
    public static void UpdateTableResult(String value, String table, PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "UPDATE " + table + " SET result = ? WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setString(1, value);
    		pstaSQLUpdate.setInt(2, objPlayerBean.getIntPlayerID());
    		pstaSQLUpdate.executeUpdate();
    		System.out.println("Updated Game (" + value.toUpperCase() + ").");
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception updating a player! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to update the result of a deferral
     * @param value from REQUESTED to GRANTED, REJECTED
     * @param objPlayerBean Source
     */
    public static void UpdateDeferralResult(String value, PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "UPDATE Deferral SET result = ? WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setString(1, value);
    		pstaSQLUpdate.setInt(2, objPlayerBean.getIntPlayerID());
    		pstaSQLUpdate.executeUpdate();
    		System.out.println("Updated Deferral (" + value.toUpperCase() + ").");
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception updating a deferral! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to update a deferral
     * @param value New value for the field
     * @param field What you want to update
     * @param objPlayerBean Source
     */
    public static void updateDeferral(String value, String field, PlayerBean objPlayerBean) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "UPDATE Deferral SET " + field + " = ? WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setString(1, value);
    		pstaSQLUpdate.setInt(2, objPlayerBean.getIntPlayerID());
    		pstaSQLUpdate.executeUpdate();
    		System.out.println("Updated Deferral (" + value.toUpperCase() + ").");
    	}catch(SQLException sqle) {
    		System.out.println("Got an exception updating a player! " + sqle.getMessage());
    	}
    }
    
    /**
     * Method to get a player's boolean field value from the database
     * @param field Boolean attribute the user wants to know
     * @param objPlayerBean Source
     * @return Returns the value of the boolean field
     */
    public static boolean getBoolFromDatabase(String field, String table, PlayerBean objPlayerBean) {
    	boolean has = false;
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "SELECT " + field + " FROM " + table + " WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setInt(1, objPlayerBean.getIntPlayerID());
    		ResultSet rs = pstaSQLUpdate.executeQuery();
    		if(rs.next()) {
    			has = rs.getBoolean(field);
    		}
    		objDBBean.closeDBConnection();
    	}catch (SQLException sqle) {
    		System.out.println("ERROR");
    	}
    	
    	return has;
    }
    
    /**
     * Method to get a player's string field value from the database
     * @param field String attribute the user wants to know
     * @param objPlayerBean Source
     * @return Returns the value of the string field
     */
    public static String getGameString(String field, PlayerBean objPlayerBean) {
    	String has = "";
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "SELECT " + field + " FROM Game WHERE playerID = ?";
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setInt(1, objPlayerBean.getIntPlayerID());
    		ResultSet rs = pstaSQLUpdate.executeQuery();
    		if(rs.next()) {
    			has = rs.getString(field);
    		}
    		objDBBean.closeDBConnection();
    	}catch (SQLException sqle) {
    		System.out.println("ERROR");
    	}
    	
    	return has;
    }
    
    /**
     * Method to get a random player from the database
     * @return Returns a PlayerBean object with PlayerID and Fullname.
     */
    public static PlayerBean getRandomPlayer() {
    	System.out.println("Looking for a random player...");
    	PlayerBean randomPlayerBean = new PlayerBean();
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "SELECT playerID, fullname FROM Player ORDER BY RAND() LIMIT 1";
    		Statement staSQLSelect = objDBBean.cnDB.createStatement();
    		ResultSet rsPlayerBean = staSQLSelect.executeQuery(stSQLquery);
    		while (rsPlayerBean.next()) {
    			randomPlayerBean.setIntPlayerID(rsPlayerBean.getInt("playerID"));
    			randomPlayerBean.setStFullname(rsPlayerBean.getString("fullname"));
    		}
    		System.out.println("=> Player: '" + randomPlayerBean.getStFullname() + "' ...");
    		objDBBean.closeDBConnection();
    	}catch (SQLException sqle) {
    		System.out.println("Got an exception looing for random player");
    		System.out.println(sqle.getMessage());
    	}
    	return randomPlayerBean;
    }
    
    /**
     * Method to get a random tournament from the database
     * @return Returns a TTournament object with Code and Name
     */
    public static Tournament getRandomTournament() {
    	System.out.println("Looking for a random tournament...");
    	Tournament randomTournament = new Tournament();
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = "SELECT code, name FROM Tournament ORDER BY RAND() LIMIT 1";
    		Statement staSQLSelect = objDBBean.cnDB.createStatement();
    		ResultSet rsTournament = staSQLSelect.executeQuery(stSQLquery);
    		while(rsTournament.next()) {
    			randomTournament.setStCode(rsTournament.getString("code"));
    			randomTournament.setStName(rsTournament.getString("name"));
    		}
    		System.out.println("=> Tournament: '" + randomTournament.getStName() + "' ...\n----------------------------------------");
    		objDBBean.closeDBConnection();
    	}catch (SQLException sqle) {
    		System.out.println("Got an exception looing for random tournament");
    		System.out.println(sqle.getMessage());
    	}
    	return randomTournament;
    }
}
