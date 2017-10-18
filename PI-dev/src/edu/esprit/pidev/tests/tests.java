/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.tests;

import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.interfaces.IserviceClient;
import edu.esprit.pidev.models.Admin;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Evenement;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.AdminService;
import edu.esprit.pidev.sevices.EvenementService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VolService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Asus
 */
public class tests {

    public static void main(String[] args) {
        /////////////////////////////////////////////////////CLIENT/////////////////////////////////////////////////////////////////////////////////
        ClientService cs = new ClientService();
        Client c, c2;
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
        Hotel h1 = new Hotel(90, "mohamed", "wshthr", "00000", 6666, "france", "hotel147", "C://", 4, 15, 18);

        // hotelService.add(h1);
        //hotelService.update(h1);
        //hotelService.remove(1);
        //////////////////////////////////////////////////////////EVENEMENT//////////////////////////////////////////////////////////////////////////
        EvenementService evenementService = new EvenementService();
        Evenement e1 = new Evenement(2, "match", "18/09/1994", "paris");
        Evenement e2 = new Evenement(3, "concert", "19/09/1994", "madrid");
        //evenementService.add(e1);
        //evenementService.add(e2);
        //System.out.println("evenement e1");
        ////////////////////////////////////////////////////VOYAGEPERSONALISE///////////////////////////////////////////////////////////////////////

        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        VoyagePersonalise vp = new VoyagePersonalise(12, "bbbbbb", "ville_departfff", "Ville_arriveff", "17/02/1994", "20/09/1994", 7, h1, c2, e1, e1, e2);
        //vps.add(vp);
        //vps.update(vp);
        //vps.remove(12);
        //System.out.println(vps.getAll());
        ////////////////////////////////////////////////////Guide///////////////////////////////////////////////////////////////////////
        GuideService guideservice = new GuideService();
        Guide g = new Guide("Ghassen", "1526", "1554826", 0, 0, "Jemai", "19561@orjf", "rfjf", 15482639, "tunis", "Guide", "fojnron");
    }

}
