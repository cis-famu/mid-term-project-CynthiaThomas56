/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cynthia Thomas
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

/*create class for customer*/
public class Customer {
    
    private int customerId;
    private String fName;
    private String lName;
    private String sAddress;
    private String sCity;
    private String sState;
    private String sZip;
    private String email;
    private String phone;
    
    
    public void setcustomerId(int customerId){this.customerId = customerId;}
    
   /*Constructor */
    public Customer(String fName, String lName, String sAddress, String sCity, String sState, String sZip, String email, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.sAddress = sAddress;
        this.sCity = sCity;
        this.sState = sState;
        this.sZip = sZip;
        this.email = email;
        this.phone = phone;
    }
   
  /*set*/
    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public void setsZip(String sZip) {
        this.sZip = sZip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    /*Get */
    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public String getsCity() {
        return sCity;
    }

    public String getsState() {
        return sState;
    }

    public String getsZip() {
        return sZip;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
  
}