/*
 * Car reservation System
 * Class for car type that in inventory.
 */
package com.mycompany.midtermcarservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author cynthia thomas
 */

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

/*Create CarType class */
public class CarType {
    private @XmlAttribute String carId;
    private String description;
    private @XmlAttribute String vinNum;
    

    //constructor //
	public CarType(){
	}
    
    
   //constructor to give the variable a value to pass through //
    public CarType(String carId, String description, String vinNum) {
        this.carId = carId;
        this.description = description;
        this.vinNum = vinNum;
    }

    /*set*/ 

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVinNum(String vinNum) {
        this.vinNum = vinNum;
    }
    
    
    
    /*get*/ 

    public String getCarId() {
        return carId;
    }

    public String getDescription() {
        return description;
    }

    public String getVinNum() {
        return vinNum;
    }
}