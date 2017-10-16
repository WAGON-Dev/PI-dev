/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.interfaces.Iservice;
import edu.esprit.pidev.models.Car;
import edu.esprit.pidev.models.CarRental;

/**
 *
 * @author omarfarouk
 */
public interface ICarService extends Iservice<Car, Integer, String> {

    void update(Car t, String z);// this update is for car table takes 2 parameters Car c and RegNo(registration number);

    void delete(String z);// this is also for car table takes RegNo as a parameter

    Car FindByReg(String z);// find by specific RegNo
}
