/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.models;


import java.util.Objects;

/**
 *
 * @author omarfarouk
 */
public class Car {
    private String model ;// this is car model
    private String regNo;// this is car registration number
    private int duration;// the duration of the car rental
    private int rate;// depending on the car type 
    private String type;//three type of cars exist Small, meduim and large(VAN)
    private boolean status;// status of the car is it rented or not??
    private int CarRentalID;// car Rental's Id
    private int UserId;//the renter's Id

    
    
    public Car(){
    
    }

    public Car(String model, String regNo, int duration, int rate, String type, boolean status) {
        this.model = model;
        this.regNo = regNo;
        this.duration = duration;
        this.rate = rate;
        this.type = type;
        this.status = status;
       // this.CarRentalID = CarRentalID;
        //this.UserId = UserId;
    }

    public int getCarRentalID() {// this is forign key! For Car rental CRUD
        return CarRentalID;
    }

    public void setCarRentalID(int CarRentalID) {
        this.CarRentalID = CarRentalID;
    }

    public int getUserId() {// this is also a foreign key! For car table CRUD
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    @Override
    public String toString() {
        return "Car{" + "model=" + model + ", regNo=" + regNo + ", duration=" + duration + ", rate=" + rate + ", type=" + type + ", status=" + status + ", CarRentalID=" + CarRentalID + ", UserId=" + UserId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.model);
        hash = 43 * hash + Objects.hashCode(this.regNo);
        hash = 43 * hash + this.duration;
        hash = 43 * hash + this.rate;
        hash = 43 * hash + Objects.hashCode(this.type);
        hash = 43 * hash + (this.status ? 1 : 0);
        hash = 43 * hash + this.CarRentalID;
        hash = 43 * hash + this.UserId;
        return hash;
    }
    
        
   

    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}

