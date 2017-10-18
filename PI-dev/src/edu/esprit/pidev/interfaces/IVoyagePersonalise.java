/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.models.VoyagePersonalise;

/**
 *
 * @author Ahmed
 */
public interface IVoyagePersonalise extends Iservice<VoyagePersonalise, Integer,String>{
     public void add3(VoyagePersonalise vp) ;
     public void add2(VoyagePersonalise vp) ;
}
