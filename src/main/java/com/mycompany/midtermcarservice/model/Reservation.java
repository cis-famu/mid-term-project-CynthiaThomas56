/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.model;

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

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}