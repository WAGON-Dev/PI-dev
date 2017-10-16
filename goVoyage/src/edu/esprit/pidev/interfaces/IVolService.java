/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;


import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Vol;
import java.util.List;

/**
 *
 * @author nouha
 */
public interface IVolService extends Iservice<Vol, Integer> {
    
     void addVolWithStatement(Vol e);

    List<Vol> getByClient(Client client);

}
