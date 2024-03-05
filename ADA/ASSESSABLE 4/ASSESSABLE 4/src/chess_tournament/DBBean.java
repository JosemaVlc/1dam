package chess_tournament;

import java.sql.*;

public class DBBean {

	/*
	 * ------------------------------------------
	 * CONSTANTS AND VARIABLES
	 * ------------------------------------------
	 */
	
	/*
	 * Database name, user and password
	 */
	private static final String DBNAME = "dbchessgames";
	private static final String DBUSER = "root";
	private static final String DBPASSWORD = "admin";

	private static final String CONN_URL = "jdbc:mysql://localhost:3306/" + DBNAME
			+ "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private Connection cnDB = null;

    /*
	 * ------------------------------------------
	 * DB CONNECTION
	 * ------------------------------------------
	 */
	/*
	 * Empty constructor. Establish the connection to the DB
	 */	
	public DBBean() {
		try {
	        // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Setup the connection with the DB
	        cnDB = DriverManager.getConnection(CONN_URL,DBUSER,DBPASSWORD);
	        //System.out.println("Connected to the database.");
	    } catch (ClassNotFoundException | SQLException sqle) {
	        System.out.println("Got an exception (connecting)!");
	        System.out.println(sqle.getMessage());
	    } 
	}
	
	/*
	 * Close the connection to the DB
	 */
	private void closeDBConnection() {
		try {
			if (cnDB != null) {
				cnDB.close();
			}
		} catch (Exception exe) {
			System.out.println("Exception while closing" + exe.getMessage());
		}
	}

    /*
   	 * --------------------
   	 * CRUD OPERATIONS
   	 * --------------------
   	 */
	
    /*
     * Return a random player to the DB
     */    
	public static PlayerBean randomPlayer() {
    	System.out.println("Reading a random Player...");
    	PlayerBean randomPlayerBean = new PlayerBean();
    	
        try {
        	//create a new connection to the DB
            DBBean objDBBean = new DBBean();
            
        	String stSQLquery = " SELECT * FROM Player ORDER BY RAND() LIMIT 1 ";
            
            // create the MySQL insert prepared statement
            Statement staSQLSelect = objDBBean.cnDB.createStatement();
            // execute the statement;
            ResultSet rsPlayerBean = staSQLSelect.executeQuery(stSQLquery);

            while(rsPlayerBean.next()) {
            	randomPlayerBean.setStFullname(rsPlayerBean.getString("fullname"));
            	randomPlayerBean.setIPlayerID(rsPlayerBean.getInt("playerID"));
            	System.out.println("=> "+rsPlayerBean.getString("fullname"));
            }
            //close DB connection
            objDBBean.closeDBConnection();
        } catch (SQLException sqle) {
            System.out.println("Got an exception (selecting)!");
            System.out.println(sqle.getMessage());
        }
        return randomPlayerBean;
    }
	
    /*
     * Return a random tournament to the DB
     */    
	public static TournamentBean randomTournament() {
    	System.out.println("Reading a random tournament...");
    	TournamentBean randomTournamentBean = new TournamentBean();
    	
        try {
        	//create a new connection to the DB
            DBBean objDBBean = new DBBean();
            
        	String stSQLquery = " SELECT * FROM tournament ORDER BY RAND() LIMIT 1 ";
            
            // create the MySQL insert prepared statement
            Statement staSQLSelect = objDBBean.cnDB.createStatement();
            // execute the statement;
            ResultSet rsTournamentBean = staSQLSelect.executeQuery(stSQLquery);

            while(rsTournamentBean.next()) {
            	randomTournamentBean.setStCode(rsTournamentBean.getString("code"));
            	randomTournamentBean.setStName(rsTournamentBean.getString("name"));
            	System.out.println("=> "+rsTournamentBean.getString("name"));
            }
            //close DB connection
            objDBBean.closeDBConnection();
        } catch (SQLException sqle) {
            System.out.println("Got an exception (selecting)!");
            System.out.println(sqle.getMessage());
        }
        return randomTournamentBean;
    }
	
	/*
	 * Create message
	 */
	public static void insertMessage (PlayerBean objRandomPlayer, String message) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " INSERT INTO message (playerID, description)"
    							+ " VALUES (?, ?)";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setInt(1, objRandomPlayer.getiPlayerID());
    		pstaSQLInsert.setString(2, message);
    		// execute the preparedstatement
    		pstaSQLInsert.execute();
    		objDBBean.closeDBConnection();
    		System.out.println("Inserted message");
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (inserting loan)!");
    		System.out.println(sqle.getMessage());
    	}
    }
	
	/*
	 * Create a Game
	 */
	public static void insertGame (PlayerBean objRandomPlayer) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " INSERT INTO game (code, playerID, matchdate)"
    							+ " VALUES (?, ?, ?)";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setString(1, objRandomPlayer.getObjTournament().getStCode());
    		pstaSQLInsert.setInt(2, objRandomPlayer.getiPlayerID());
    		pstaSQLInsert.setObject(3, objRandomPlayer.getLdtNextMatchDate());
    		// execute the preparedstatement
    		pstaSQLInsert.execute();
    		objDBBean.closeDBConnection();
    		
    		System.out.println("Inserted Game");
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (inserting loan)!");
    		System.out.println(sqle.getMessage());
    	}
    }
	
	/*
	 * Create a Deferral
	 */
	public static void insertDeferral (PlayerBean objRandomPlayer) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " INSERT INTO deferral (code, playerID, defdate)"
    							+ " VALUES (?, ?, ?)";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLInsert = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLInsert.setString(1, objRandomPlayer.getObjTournament().getStCode());
    		pstaSQLInsert.setInt(2, objRandomPlayer.getiPlayerID());
    		pstaSQLInsert.setObject(3, objRandomPlayer.getLdtNextDeferralDate());
    		// execute the preparedstatement
    		pstaSQLInsert.execute();
    		objDBBean.closeDBConnection();
    		System.out.println("Inserted Deferral");
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (inserting loan)!");
    		System.out.println(sqle.getMessage());
    	}
    }

    /*
     * Change boolean bHasAMatch
     */
    public static void updateHasAMatch (PlayerBean objRandomPlayer, boolean bHasAMatch) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " UPDATE player SET has_match = ? "
    							+ " WHERE playerID = ? ";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setBoolean(1, bHasAMatch);
    		pstaSQLUpdate.setInt(2, objRandomPlayer.getiPlayerID());
    		// execute the preparedstatement
    		pstaSQLUpdate.execute();
    		objDBBean.closeDBConnection();    	
    		if (bHasAMatch == true) {
    			System.out.println("Updated player. Has a match appointment.");
    		}else {
    			System.out.println("Updated player. No longer has a match appointment.");
    		}
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (updating book availability)!");
    		System.out.println(sqle.getMessage());
    	}
    }

    /*
     * Change boolean bHasADeferral
     */
    public static void updateHasADeferral (PlayerBean objRandomPlayer, boolean bHasADeferral) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " UPDATE player SET has_deferral = ? "
    							+ " WHERE playerID = ? ";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setBoolean(1, bHasADeferral);
    		pstaSQLUpdate.setInt(2, objRandomPlayer.getiPlayerID());
    		// execute the preparedstatement
    		pstaSQLUpdate.execute();
    		objDBBean.closeDBConnection();    		
    		if (bHasADeferral == true) {
    			System.out.println("Updated player. Has a deferral requested.");
    		}else {
    			System.out.println("Updated player. No longer has a deferral request.");
    		}
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (updating book availability)!");
    		System.out.println(sqle.getMessage());
    	}
    }

    /*
     * Change Game Result
     */
    public static void updateGameResult (PlayerBean objRandomPlayer, String stGameResult) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " UPDATE game SET result = ? "
    							+ " WHERE playerID = ? ";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setString(1, stGameResult);
    		pstaSQLUpdate.setInt(2, objRandomPlayer.getiPlayerID());
    		// execute the preparedstatement
    		pstaSQLUpdate.execute();
    		objDBBean.closeDBConnection();    		
    		System.out.println("Updated Game ("+stGameResult+").");
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (updating book availability)!");
    		System.out.println(sqle.getMessage());
    	}
    }

    /*
     * Change Deferral Result
     */
    public static void updateDeferralResult (PlayerBean objRandomPlayer, String stDeferralResult) {
    	try {
    		DBBean objDBBean = new DBBean();
    		String stSQLquery = " UPDATE deferral SET result = ? "
    							+ " WHERE playerID = ? ";
    		// create the MySQL insert preparedstatement
    		PreparedStatement pstaSQLUpdate = objDBBean.cnDB.prepareStatement(stSQLquery);
    		pstaSQLUpdate.setString(1, stDeferralResult);
    		pstaSQLUpdate.setInt(2, objRandomPlayer.getiPlayerID());
    		// execute the preparedstatement
    		pstaSQLUpdate.execute();
    		objDBBean.closeDBConnection();    		
    		System.out.println("Updated Deferral ("+stDeferralResult+").");
    	} catch (SQLException sqle) {
    		System.out.println("Got an exception (updating book availability)!");
    		System.out.println(sqle.getMessage());
    	}
    }
	
}
