/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import java.util.List;

/**
 *
 * @author omarfarouk
 */
public interface IServiceF <T,Z>{
    
    void post(T t);
    
    void delete(Z z);
    
    List<T> getAll();
}
