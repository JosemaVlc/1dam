package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoOperations {
	/**
	 * ----------------------------------
	 * SQLite CONFIG
	 * ----------------------------------
	 */
	private static String URLMongoDB;
	private static String MongoDBName;
	private static String MongoDBCollectionName;
	private static String stMongoData;
	private static String stMongoDataItems;
	
	public static void setURLMongoDB(String URLMongoDB) {
		MongoOperations.URLMongoDB = URLMongoDB;
	}
	
	public static void setMongoDBName(String MongoDBName) {
		MongoOperations.MongoDBName = MongoDBName;
	}
	
	public static void setSQLiteTableName(String SQLiteTableName) {
		MongoOperations.MongoDBCollectionName = SQLiteTableName;
	}
	
	public static void setStSQLData(String stSQLData){
		MongoOperations.stMongoData = stSQLData; 
	}
	
	public static void setStSQLDataItems(String stSQLDataItems){
		MongoOperations.stMongoDataItems = stSQLDataItems; 
	}
	
	public static String getMongoDBTableName() {
		return MongoOperations.MongoDBCollectionName;
	}

	/*
	 * Static method: Just try to connect to the database
	 */
	public static MongoClient connectToBD(){        
        try {
        	MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    		System.out.println("Connection to database has been established.");
    		return mongoClient;
        } catch (Exception e) {
    		System.out.println("Something was wrong while trying to connect to the database!");
    		e.printStackTrace(System.out);
    	}
    	return null;
    }
	
	/*
	 * Static method: Just try to disconnect to the database
	 */
	public static void CloseDB(MongoClient cnDB) {
		
		try {
			cnDB.close(); //close the connection to the DB
		} catch (Exception e) {
			System.out.println("Something was wrong while closing the database!");
			e.printStackTrace(System.out);
		}
	}
	
	
	/*
	 * Static method: Check if collection exists
	 * https://stackoverflow.com/questions/53810753/how-to-check-collection-mongo-db-in-java
	 */
	public static boolean CollectionExists(String stCollection, MongoDatabase mDBFactory) {
	
		MongoIterable<String> mitCollection = mDBFactory.listCollectionNames();
		for (String stIterCollection : mitCollection) {
			if (stIterCollection.equals(stCollection)) {
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Static method: Create collection if not exists
	 */
	public static void CreateCollectionIfNotExists(MongoDatabase mDBFactory) {

		try {
			if (!(CollectionExists(MongoDBCollectionName, mDBFactory))) {
				System.out.println("Collection does not exist");
				mDBFactory.createCollection(MongoDBCollectionName);
				System.out.println("Created collection " + MongoDBCollectionName + " in given database...");
			}
		} catch (Exception exe) {
			System.out.println("Something was wrong when creating the collection!");
			exe.printStackTrace(System.out);
		}
	}	
}