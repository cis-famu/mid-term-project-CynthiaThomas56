/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.midtermcarservice.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cynthia thomas
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

public class officeLocation {
    private String officeId;
    private String officeCity;
    private String officeState;
    private String officeZip;
    private String officePhone;
    private ArrayList<String> officeStreet;

    
    public officeLocation(){}
    
    
    /*Constructor*/
    public officeLocation(String officeId, String officeCity, String officeState, String officeZip, String officePhone, ArrayList<String> officeStreet) {
        this.officeId = officeId;
        this.officeCity = officeCity;
        this.officeState = officeState;
        this.officeZip = officeZip;
        this.officePhone = officePhone;
        this.officeStreet = officeStreet;
    }
   
/*set*/

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }

    public void setOfficeState(String officeState) {
        this.officeState = officeState;
    }

    public void setOfficeZip(String officeZip) {
        this.officeZip = officeZip;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public void setOfficeStreet(ArrayList<String> officeStreet) {
        this.officeStreet = officeStreet;
    }
  
  /*get*/  

    public String getOfficeId() {
        return officeId;
    }

    public String getOfficeCity() {
        return officeCity;
    }

    public String getOfficeState() {
        return officeState;
    }

    public String getOfficeZip() {
        return officeZip;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public ArrayList<String> getOfficeStreet() {
        return officeStreet;
    }
    
}