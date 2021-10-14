/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cynthia thomas
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

/*Create carRental confirmation class*/
public class carRental {
    private int confirmationNum;
    private int customerId;
    private String customerName;
    private Date submitted;
    private String pickupLocation;
    private double totalCost;
    
    
 //constructor //
	public carRental(){
	}

//constructor to give the variable a value to pass through //
    public carRental(int confirmationNum, int customerId, String customerName, Date submitted, String pickupLocation, double totalCost) {
        this.confirmationNum = confirmationNum;
        this.customerId = customerId;
        this.customerName = customerName;
        this.submitted = submitted;
        this.pickupLocation = pickupLocation;
        this.totalCost = totalCost;
    }
/*set*/
    public void setConfirmationNum(int confirmationNum) {
        this.confirmationNum = confirmationNum;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setSubmitted(Date submitted) {
        this.submitted = submitted;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
/*get*/
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getConfirmationNum() {
        return confirmationNum;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Date getSubmitted() {
        return submitted;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
