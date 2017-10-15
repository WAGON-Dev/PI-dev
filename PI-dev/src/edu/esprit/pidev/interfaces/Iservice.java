/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import java.util.List;

/**
 *
 * @author Ahmed
 */

    public interface Iservice <T,R,Z>{
    void add(T t);

    void update(T t);
    
    void update(T t, Z z);// this update is for car table takes 2 parameters Car c and RegNo(registration number)

    void remove(R r);
    
    void delete(Z z);// this is also for car table takes RegNo as a parameter     
     
    T findById(R r);

    T FindByReg(Z z);// find by specific RegNo
    
    List<T> getAll();
}
    

