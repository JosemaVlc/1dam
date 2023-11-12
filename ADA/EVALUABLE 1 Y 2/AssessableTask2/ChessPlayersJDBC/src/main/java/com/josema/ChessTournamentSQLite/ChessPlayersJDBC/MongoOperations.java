package com.josema.ChessTournamentSQLite.ChessPlayersJDBC;

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
	
	public static void setURLMongoDB(String URLMongoDB) {
		MongoOperations.URLMongoDB = URLMongoDB;
	}
	
	public static void setMongoDBName(String MongoDBName) {
		MongoOperations.MongoDBName = MongoDBName;
	}
	
	public static void setMongoDBCollectionName(String MongoDBCollectionName) {
		MongoOperations.MongoDBCollectionName = MongoDBCollectionName;
	}
	
	public static String getMongoDBName() {
		return MongoOperations.MongoDBName;
	}
	
	public static String getMongoDBCollectionName() {
		return MongoOperations.MongoDBCollectionName;
	}

	/*
	 * method to try to connect to the database
	 */
	public static MongoClient connectToBD(){        
        try {
        	MongoClient cnDB = MongoClients.create(URLMongoDB);
    		System.out.println("Connection to database has been established.");
    		return cnDB;
        } catch (Exception exe) {
    		System.out.println("Something was wrong while trying to connect to the database!");
    		exe.printStackTrace(System.out);
    	}
    	return null;
    }
	
	/*
	 * Static method: Just try to disconnect to the database
	 */
	public static void CloseDB(MongoClient cnDB) {
		
		try {
			cnDB.close(); //close the connection to the DB
		} catch (Exception exe) {
			System.out.println("Something was wrong while closing the database!");
			exe.printStackTrace(System.out);
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
	public static void CreateCollectionIfNotExists(MongoDatabase MongoDBName, boolean bDropTableFirst) {
		
		try {
			if (!(CollectionExists(MongoDBCollectionName,MongoDBName))) {
				System.out.println("Collection does not exist");
				MongoDBName.createCollection(MongoDBCollectionName);
				System.out.println("Created collection " + MongoDBCollectionName + " in given database...");
			}else {
				if (bDropTableFirst) {
					DropCollectionIfExists();
				}
			}
		} catch (Exception exe) {
			System.out.println("Something was wrong when creating the collection!");
			exe.printStackTrace(System.out);
		}
	}	
	
	/*
	 * Method to drop collection if exists
	 */
	public static void DropCollectionIfExists () {
		/*
		 * 1st STEP: Connect to database
		 */
		MongoClient cnDB = connectToBD();
		try {
			MongoDatabase mDBFactory = cnDB.getDatabase(getMongoDBName());
			/*
			 * 2nd STEP: Check if the collection exists.
			 */
			if (!(CollectionExists(MongoDBCollectionName, mDBFactory))) {
				System.out.println("Collection does not exist");
			}
			else {
				MongoCollection<Document> mcolPlayer = mDBFactory.getCollection(MongoDBCollectionName);
				mcolPlayer.drop();
				System.out.println("Collection has been dropped");
			}			
		} catch (Exception exe){
			System.out.println("Something was wrong while dropping the collection " + MongoDBCollectionName);
		}
		CloseDB(cnDB);
	}
	
}