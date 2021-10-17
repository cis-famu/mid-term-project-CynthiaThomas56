/*
 * Car Reservation System
 * Used to retrieve the cost of the rental based on car to be rented.
 */
package com.mycompany.midtermcarservice.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cynthia Thomas
 */
/*Creates reservation class*/
public class Reservation extends CarType{
   private double totalCost;
 
public Reservation(){
}
   
   
public Reservation(double totalCost, String carId, String vinNum, String Description) {
        super(carId, vinNum, Description);
        this.totalCost = totalCost;
    }

    public Reservation(int customerId, Date submitted, Customer fName, Customer lName, ArrayList<officeLocation> officeNum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}