/*
 Car Reservation System
 Used to connect to the Firebase database CarReservation
 */
package com.mycompany.midtermcarservice.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cynth
 */
public class DBConnection {

	//Database connection variable. It is shared with any class that inherits from this class
    protected static Firestore db;
    
	//constructor
	//throws file and IO exceptions from attempting to open the credential file
    public DBConnection() {
		
		//Your project id
        String projectId = "carreservation-328921";
		
		//Open the credential json file 
        FileInputStream serviceAccount;
        try{
            serviceAccount = new FileInputStream("E:\\Web Services\\carreservation-328921-firebase-adminsdk-3nkg7-8df1464d00.json");
        
		//set up database connection
            FirestoreOptions firestoreOptions =
            FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId(projectId)
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build();
			
		//connect to database
        db = firestoreOptions.getService();
        
    }catch (IOException ex){
        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
   
  }
    }
}
   

