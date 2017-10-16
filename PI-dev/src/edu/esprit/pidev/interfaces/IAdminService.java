/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.models.Admin;
import edu.esprit.pidev.models.Vol;

/**
 *
 * @author nouha
 */
public interface IAdminService extends Iservice<Admin, Integer, Object>{
    
    void addAdminWithStatement(Admin e);
}
