/*
 * Car Reservation System
 * Methods to return a list of all reservation, reservation Id, Customer Id,
 * and date submitted
 */
package com.mycompany.midtermcarservice.endpoint;

import com.mycompany.midtermcarservice.model.Customer;
import com.mycompany.midtermcarservice.model.Reservation;
import com.mycompany.midtermcarservice.model.officeLocation;
import com.mycompany.midtermcarservice.service.CRService;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author cynthia Thomas
 */

@WebService
public class CarReservation {
    
    private final CRService service = new CRService();
    
    
    
    @WebMethod(operationName= "allPos")
    @WebResult(name= "CarReservation")
    public List<Reservation> getAllCarReservation() throws InterruptedException, ExecutionException{
        return service.all();
    }  
    
       
    @WebResult(name="CRService")
    public Reservation getCarReservationByreservationId(@WebParam(name = "CarReservationreservationId")int reservationId) throws InterruptedException, ExecutionException{
        return service.findByreservationId(reservationId);
   }
    
    
    @WebResult(name="CRService")
    public Customer getCarReservationBycustomerId(@WebParam(name = "CarReservationcustomerId")int customerId) throws InterruptedException, ExecutionException{
        return service.findBycustomerId(customerId);
   }
    
    @WebResult(name="CRService")
    public ArrayList<officeLocation> getBySubmittedDate(@WebParam(name = "submitted") Date submitted) throws InterruptedException, ExecutionException{
        return service.findBySubmittedDate(submitted);    
 }
 
   /**
     *
     * @param confirmationNum
     * @param fName
     * @param lName
     * @param officeNum
     * @return
     * @throws ParseException
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @WebResult(name="objectreservationId") 
 public String createCarReservation
   (@WebParam(name = "confirmationNum") String confirmationNum,       
    @WebParam(name = "fName") Customer fName,
    @WebParam(name = "lName") Customer lName,
    @WebParam(name = "officeNum") ArrayList<officeLocation> officeNum)
         throws ParseException, InterruptedException,ExecutionException{
     return service.createCarReservatin(confirmationNum, fName, lName, officeNum);
   }
 
}