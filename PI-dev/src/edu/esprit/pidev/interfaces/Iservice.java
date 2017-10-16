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

    void remove(R r);     
     
    T findById(R r);
    
    List<T> getAll();
}
    

