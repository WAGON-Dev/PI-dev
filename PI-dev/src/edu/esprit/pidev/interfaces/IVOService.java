/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.models.VoyageOrganise;
import java.util.List;

/**
 *
 * @author zakiya
 */
public interface IVOService extends Iservice<VoyageOrganise,Integer,String>{
     int nouveauVoyageId() ;
   public List<VoyageOrganise> getAllByIdAgence(int id );

 
    
    
}
