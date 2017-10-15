/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.tests;

import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.interfaces.IserviceClient;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.sevices.HotelService;

/**
 *
 * @author Asus
 */
public class tests {

    public static void main(String[] args) {
        ClientService cs = new ClientService();
        Client c;
        c = new Client("wajdy", "12807857", "29/08/1995", "bouslama", "wajdy.bouslama@esprit.tn", "123456", 55054543, "sousse", "client", "");
        //cs.add(c);
        //cs.update(c);
        //cs.remove(12);
        
        System.out.println(c.getId_user());
        HotelService hotelService = new HotelService();
        Hotel h1 = new Hotel(1, "fathi", "wshthr", "99999", 6666, "france", "hotel147", "C://", 4, 15, 18);

        //hotelService.add(h1);
        //hotelService.update(h1);
        //hotelService.remove(1);
    }

}
