/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.tests;

import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.interfaces.IserviceClient;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;

/**
 *
 * @author Asus
 */
public class tests {

    public static void main(String[] args) {
    /////////////////////////////////////////////////////CLIENT/////////////////////////////////////////////////////////////////////////////////
        ClientService cs = new ClientService();
        Client c,c2;
        c = new Client("wajdy", "12807857", "29/08/1995", "bouslama", "wajdy.bouslama@esprit.tn", "123456", 55054543, "sousse", "client", "");
        c2 = new Client("ghassen", "12807857", "29/08/1995", "jemai", "ghassen.jemai@esprit.tn", "123456", 55054543, "australia", "client", "");
        c2.setId_user(3);
        //cs.add(c);
        //cs.add(c2);
        //cs.update(c);
        //cs.remove(12);
        //System.out.println(cs.findById(28));
    ////////////////////////////////////////////////////HOTEL///////////////////////////////////////////////////////////////////////////////////  
        
        HotelService hotelService = new HotelService();
        Hotel h1 = new Hotel(1, "fathi", "wshthr", "99999", 6666, "france", "hotel147", "C://", 4, 15, 18);

       // hotelService.add(h1);
        //hotelService.update(h1);
        //hotelService.remove(1);
    ////////////////////////////////////////////////////VOYAGEPERSONALISE///////////////////////////////////////////////////////////////////////
        
        VoyagePersonaliseService vps = new VoyagePersonaliseService() ;
        VoyagePersonalise vp = new VoyagePersonalise(1, "re7la", "ville_departfff", "Ville_arriveff", "date_departf", "fdate_arrive", 7, c2, h1);
        // vps.add(vp);
        // vps.update(vp);
        // vps.remove(1);
        //System.out.println(vps.getAll());
    ////////////////////////////////////////////////////Guide///////////////////////////////////////////////////////////////////////
        GuideService guideservice = new GuideService();
        Guide g = new Guide("Ghassen", "1526", "1554826", 0, 0, "Jemai", "19561@orjf", "rfjf", 15482639, "tunis", "Guide", "fojnron");
        guideservice.remove(2);
    
    }

}
