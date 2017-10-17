/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.interfaces;

import edu.esprit.pidev.models.Chambre;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Hotel;
import java.util.List;

/**
 *
 * @author Ghassen
 */
public interface IChambre extends Iservice<Chambre, Integer, String>{
    List<Chambre> getByHotel(Hotel h);
    List<Chambre> getByClient(Client c);
}
