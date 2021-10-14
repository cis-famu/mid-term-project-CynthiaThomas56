/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.mycompany.midtermcarservice.model.CarType;
import com.mycompany.midtermcarservice.model.Customer;
import com.mycompany.midtermcarservice.model.Reservation;
import com.mycompany.midtermcarservice.model.carRental;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 *
 * @author cynthia thomas
 */
public class CRService extends DBConnection {
    private final ArrayList<Reservation> list = new ArrayList();
    
 public CRService() {
     
     super();
  }
 
 
/*All*/
  public List<carRental> all() throws InterruptedException, ExecutionException {
	List<carRental> results = new ArrayList<>();
  
	// asynchronously retrieve all users
	ApiFuture<QuerySnapshot> query = db.collection("CarReservation").get();
	
	// query.get() blocks (stops other processes from excuting) on response 
	// call to firebase
	QuerySnapshot querySnapshot = query.get();
	
	//getting the result set 
	List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
   
      //loop over result set and add them to list
      documents.forEach(document -> {
          results.add(document.toObject(carRental.class));
      });
	
	return results;
  }
  
  
  
/*return all car reservation by Id*/
public Reservation findByreservationId(int reservationId) throws InterruptedException, ExecutionException{
    
	//refernce to the collection(table)
	CollectionReference  Reservation = db.collection("CarReservation");
	//query where clause
	Query query = Reservation.whereEqualTo("reservationId", reservationId);
	
	
	ApiFuture<QuerySnapshot> querySnapshot = query.get();
  
	List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
	if(documents.size() == 1)
		return documents.get(0).toObject(Reservation.class);

     return null;
}  
 
/*return all by Id Customer Id*/
 public Customer findBycustomerId(int customerId) throws InterruptedException, ExecutionException{
    
	//refernce to the collection(table)
	CollectionReference  Customer = db.collection("CarReservation");
	//query where clause
	Query query = Customer.whereEqualTo("customerId", customerId);
	
	ApiFuture<QuerySnapshot> querySnapshot = query.get();
  
	List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
	if(documents.size() == 1)
	return documents.get(0).toObject(Customer.class);
  
  return null;
    }
 
 /*return all by confirm date*/
 public ArrayList<Reservation> findBySubmittedDate(Date submitted) throws InterruptedException, ExecutionException{
    
	ArrayList<Reservation> resultList = new ArrayList<>();
   
	CollectionReference  reservation = db.collection("CarReservation");
	Query query = reservation.whereEqualTo("submitted", submitted);
	
	ApiFuture<QuerySnapshot> querySnapshot = query.get();
  
	List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
	
        documents.forEach(document -> {
            resultList.add(document.toObject(Reservation.class));
      });
   
   return resultList;
    } 

    public String createCarReservation(int customerId, carRental confirmationNum, Customer fName, Customer lName, carRental pickupLocation, Customer Phone, ArrayList<CarType> rent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}