/*
 * Car Reservation System
 * Methods to pull a list of all reservation, reservation Id, Customer Id,
 * and date submitted
 */
package com.mycompany.midtermcarservice.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.mycompany.midtermcarservice.model.Customer;
import com.mycompany.midtermcarservice.model.Reservation;
import com.mycompany.midtermcarservice.model.officeLocation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
 
 
/*returns all reservations*/
 public List<Reservation> all()throws InterruptedException, ExecutionException{
      
      List<Reservation> resultList = new ArrayList<>();
      
      ApiFuture<QuerySnapshot> query = db.collection ("CarReservation").get();
      
      QuerySnapshot querySnapshot = query.get();
                    
      List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
      
      //loop over result set
      documents.forEach(document -> { 
          resultList.add(document.toObject(Reservation.class));
      });
  return resultList;
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
 
 
 public String createCarReservatin(int customerId, Customer fName, Customer lName, ArrayList<officeLocation> officeNum)
            throws ParseException, InterruptedException, ExecutionException {
        
        SimpleDateFormat formatter =  new SimpleDateFormat ("yyyy-MM-dd 00:00:00");
        String now = 
                formatter.format(new Date(System.currentTimeMillis()));
        Date submitted = formatter.parse(now);
        
        Random rand = new Random();
        int id = rand.nextInt(10000);
        
        Reservation newReservation = 
                new Reservation(customerId, submitted, fName, lName, officeNum);
        
        ApiFuture<DocumentReference> future =
                db.collection("CarReservation").add(newReservation);
        
        DocumentReference doc = future.get();
        
        return doc.getId();
    }  
 
 /*return all by confirm date*/
 public ArrayList<officeLocation> findBySubmittedDate(Date submitted) throws InterruptedException, ExecutionException{
    
	ArrayList<officeLocation> resultList = new ArrayList<>();
   
	CollectionReference  officeLocation = db.collection("CarReservation");
	Query query = officeLocation.whereEqualTo("submitted", submitted);
	
	ApiFuture<QuerySnapshot> querySnapshot = query.get();
  
	List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
	
        documents.forEach(document -> {
            resultList.add(document.toObject(officeLocation.class));
      });
   
   return resultList;
    } 

    public String createCarReservatin(String confirmationNum, Customer fName, Customer lName, ArrayList<officeLocation> officeNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}