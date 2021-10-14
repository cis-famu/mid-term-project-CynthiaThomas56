/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.endpoint;

import com.mycompany.midtermcarservice.model.CarType;
import com.mycompany.midtermcarservice.model.Customer;
import com.mycompany.midtermcarservice.model.Reservation;
import com.mycompany.midtermcarservice.model.carRental;
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
 * @author cynth
 */

@WebService
public class CarReservation {
    
    private final CRService service = new CRService();
    
    /**
     *
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @WebMethod(operationName= "allCRS")
    @WebResult(name= "CRService")
    public List<carRental> getAllCarReservation() throws InterruptedException, ExecutionException{
        return service.all();
    } 
    
    
   
    @WebResult(name="CRService")
    public Reservation getCarReservationByreservationId(@WebParam(name = "CarReservationreservationId")int reservationId) throws InterruptedException, ExecutionException{
        return service.findByreservationId(reservationId);
   }
    
    /**
     *
     * @param customerId
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @WebResult(name="CRService")
    public Customer getCarReservationBycustomerId(@WebParam(name = "CarReservationcustomerId")int customerId) throws InterruptedException, ExecutionException{
        return service.findBycustomerId(customerId);
   }
    
    @WebResult(name="CRService")
    public ArrayList<Reservation> getBySubmittedDate(@WebParam(name = "submitted") Date submitted) throws InterruptedException, ExecutionException{
        return service.findBySubmittedDate(submitted);    
 }
 
   
    @WebResult(name="objectreservationId") 
 public String createCarReservation
   (@WebParam(name = "customerId") int customerId,
    @WebParam(name = "confirmationNum") carRental confirmationNum,       
    @WebParam(name = "fName") Customer fName,
    @WebParam(name = "lName") Customer lName,
    @WebParam(name = "pickupLocation") carRental pickupLocation,
    @WebParam(name = "Phone") Customer Phone,
    @WebParam(name = "rent") ArrayList<CarType> rent)
         throws ParseException, InterruptedException,ExecutionException{
     return service.createCarReservation(customerId, confirmationNum, fName, lName, pickupLocation, Phone, rent);
    }          
}
    

