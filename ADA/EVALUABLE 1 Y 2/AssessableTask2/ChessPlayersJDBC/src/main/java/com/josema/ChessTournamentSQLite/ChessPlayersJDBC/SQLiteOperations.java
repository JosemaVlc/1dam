package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

class SQLiteOperations
{
	/**
	 * ----------------------------------
	 * SQLite CONFIG
	 * ----------------------------------
	 */	
	private static String URLSQLite;
	private static String SQLiteTableName;
	private static String stSQLData;
	private static String stSQLDataItems;
	
	public static void setURLSQLite(String URLSQLite) {
		SQLiteOperations.URLSQLite = URLSQLite;
	}
	
	public static void setSQLiteTableName(String SQLiteTableName) {
		SQLiteOperations.SQLiteTableName = SQLiteTableName;
	}
	
	public static void setStSQLData(String stSQLData){
		SQLiteOperations.stSQLData = stSQLData; 
	}
	
	public static void setStSQLDataItems(String stSQLDataItems){
		SQLiteOperations.stSQLDataItems = stSQLDataItems; 
	}
	
	public static String getStSQLDataItems(){
		return SQLiteOperations.stSQLDataItems; 
	}
	
	public static String getDBTableName() {
		return SQLiteOperations.SQLiteTableName;
	}
	
	/**
	 * -----------------------------------
	 * DATABASE OPERATIONS
	 * -----------------------------------
	 */
	/*
	 * Static method: Just try to connect to the database
	 */
	public static Connection ConnectToDB() {
	
		try {
			Connection cnDB = DriverManager.getConnection(URLSQLite);
			System.out.println("Connection to database has been established.");
			return cnDB;
		} catch (SQLException sqle) {
			System.out.println("Something was wrong while trying to connect to the database!");
			sqle.printStackTrace(System.out);
		}
		return null;
	}
	
	/*
	 * Static method: Just try to disconnect to the database
	 */
	public static void CloseDB(Connection cnDB) {
		
		try {
			cnDB.close(); //close the connection to the DB
		} catch (SQLException sqle) {
			System.out.println("Something was wrong while closing the database!");
			sqle.printStackTrace(System.out);
		}
	}
	
	/*
	 * Create table if not exists. Otherwise, drop table
	 */
	public static void CreateTableIfNotExists(Statement staSQLquery, boolean bDropFirst) {
		try {
			if (bDropFirst) {
				//drop table
				String stSQLDrop = "DROP TABLE IF EXISTS " + SQLiteTableName;
				staSQLquery.executeUpdate(stSQLDrop);
				System.out.println("Dropped table " + SQLiteTableName + " (IF EXISTS) in given database.");
			}
			//create table
			String stSQLCreate = "CREATE TABLE IF NOT EXISTS " + SQLiteTableName + " ("+ stSQLData + ")";
			staSQLquery.executeUpdate(stSQLCreate);
			if (bDropFirst)
				System.out.println("Created table " + SQLiteTableName + " (IF NOT EXISTS) in given database.");
		} catch (SQLException sqle) {
			System.out.println("Something was wrong when dropping and creating the table!");
			sqle.printStackTrace(System.out);
		}
	}
	/*
	 * Static Method: Print table with the info Players from SQLite Database
	 */
	public static void PrintTable() {
		/*
		 * 1st STEP: Connect to database
		 */
		Connection cnDB = ConnectToDB();
		try {
			Statement staSQLquery = cnDB.createStatement();
			/*
			 * 1st STEP: Check if the table exists. Otherwise, drop and create it again
			 */
			boolean bDropTableFirst = false;
			SQLiteOperations.CreateTableIfNotExists(staSQLquery, bDropTableFirst);
			/*
			 * 2nd STEP: For every item, print it
			 */
			//select all players
			String stSQLSelect = "SELECT " + stSQLDataItems + " FROM " + SQLiteTableName;
			System.out.println("Executing: " + stSQLSelect);
			//return all records to the result set
			ResultSet rsObject = staSQLquery.executeQuery(stSQLSelect);
			int iNumObject = 0;
			while (rsObject.next()) {
				iNumObject++;
				System.out.println(SQLiteTableName + " Id: " + rsObject.getString("ID"));
				System.out.println(SQLiteTableName + " Name: " + rsObject.getString("NAME"));
				System.out.println(SQLiteTableName + " Country: " + rsObject.getString("COUNTRY"));
				System.out.println(SQLiteTableName + " Score 1: " + rsObject.getFloat("SCORE1"));
				System.out.println(SQLiteTableName + " Score 2: " + rsObject.getFloat("SCORE2"));
				System.out.println(SQLiteTableName + " Score 3: " + rsObject.getFloat("SCORE3"));
			}
			if (iNumObject == 0)
				System.out.println("No items found on table " + SQLiteTableName);
			rsObject.close(); //close the ResultSet
		} catch (SQLException sqle) {
			System.out.println("Something was wrong while reading the table " + SQLiteTableName);
			sqle.printStackTrace(System.out);
		}
		CloseDB(cnDB); //close the connection to the DB
	}
	
	/*
	 * -----------------------------------
	 * DELETE DATA
	 * -----------------------------------
	 */
	/*
	 * Static method: Delete all items from given table 
	 * Since "DELETE IF EXISTS" is not available... we do "CREATE IF NOT EXISTS" and then "DELETE ..."
	 */
	public static void DeleteDataFromDB() {

		/*
		 * 1st STEP: Connect to database
		 */
		Connection cnDB = ConnectToDB();
		try {
			Statement staSQLquery = cnDB.createStatement();
			/*
			 * 2nd STEP: Check if the table exists. Otherwise, drop and create it again
			 */
			boolean bDropTableFirst = false;
			CreateTableIfNotExists(staSQLquery, bDropTableFirst);
			/*
			 * 3rd STEP: Do truncate
			 */
			String stSQLDelete = "DELETE FROM " + SQLiteTableName;
			System.out.println("Executing: " + stSQLDelete);

			/*			  
			 * Execute the SQL statement in this Prepared Statement object
			 */
			staSQLquery.executeUpdate(stSQLDelete); 
			staSQLquery.close(); //close the statement
			
		} catch (SQLException sqle) {
			System.out.println("Something was wrong while deleting the table " + SQLiteTableName);
			sqle.printStackTrace(System.out);
		}
		CloseDB(cnDB); //close the connection to the DB
	}
}
