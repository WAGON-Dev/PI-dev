/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.tests;

import edu.esprit.pidev.models.*;
import edu.esprit.pidev.sevices.*;


import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.models.Client;
import edu.esprit.pidev.models.Evenement;
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.models.VoyageOrganise;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.EvenementService;
import edu.esprit.pidev.sevices.GuideService;
import edu.esprit.pidev.sevices.HotelService;
import edu.esprit.pidev.sevices.VolService;
import edu.esprit.pidev.sevices.VoyagePersonaliseService;
import edu.esprit.pidev.sevices.VoyageOrganiseService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Asus
 */
public class tests {

    public static void main(String[] args) throws ParseException {
        /////////////////////////////////////////////////////CLIENT/////////////////////////////////////////////////////////////////////////////////
        ClientService cs = new ClientService();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

        Date d1 = sdf.parse("2017/12/29");
        Date d2 = sdf2.parse("2017/12/31");
        Client c, c2;
        c = new Client("wajdy", "12807857", d1, "bouslama", "wajdy.bouslama@esprit.tn", "123456", 55054543, "sousse", "client", "C:/Users/Asus/Desktop/ESPRIT/4 infoB 1/Semestre 1/PI-Dev/Projet/PI-dev/PI-dev/src/edu/esprit/pidev/utils/person.png");
        c2 = new Client("ghassen", "12807857", d1, "jemai", "ghassen.jemai@esprit.tn", "123456", 55054543, "australia", "client", "");
        //c2.setId_user(3);
//       cs.add(c);
//        cs.add(c2);
//        cs.update(c);
        //cs.remove(12);
        System.out.println(cs.findById(38));
        ////////////////////////////////////////////////////HOTEL///////////////////////////////////////////////////////////////////////////////////  

        HotelService hotelService = new HotelService();
        Hotel h1 = new Hotel(15, "mohamed", "wshthr", "00000", 6666, "france", "hotel147", "C://", 4, 15, 18);

        //       hotelService.add(h1);
        //hotelService.update(h1);
        //hotelService.remove(1);
        //////////////////////////////////////////////////////////EVENEMENT//////////////////////////////////////////////////////////////////////////
        EvenementService evenementService = new EvenementService();
        Evenement e1 = new Evenement(2, "match", d1, "paris");
        Evenement e2 = new Evenement(3, "concert", d1, "madrid");
        //evenementService.add(e1);
        //evenementService.add(e2);
        //System.out.println("evenement e1");
        ////////////////////////////////////////////////////VOYAGEPERSONALISE///////////////////////////////////////////////////////////////////////

        VoyagePersonaliseService vps = new VoyagePersonaliseService();
        //VoyagePersonalise vp = new VoyagePersonalise(18, "bbbbbb", "ville_departfff", "Ville_arriveff", "17/02/2002", "20/09/1994", 7, h1, c2, e1);
        //vps.add3(vp);
        //vps.update(vp);
        //vps.remove(12);
        //System.out.println(vps.getAll());
        ////////////////////////////////////////////////////Guide///////////////////////////////////////////////////////////////////////
        GuideService guideservice = new GuideService();
        Guide g = new Guide("Ghassen", "1526", d1, 0, 0, "Jemai", "19561@orjf", "rfjf", 15482639, "tunis", "Guide", "fojnron");

        /////////////////////////////////////////////////Vol/////////////////////////////////////////
        VolService volservise = new VolService();
        Vol v4 = new Vol( d1, d1, 900d, "paris_tunis", 3, "Paris", "Tunis", "TunisAir");
        Vol v5 = new Vol( d1, d1, 1900d, "tunis_paris", 3, "Tunis", "Paris", "AirFrance");
        Vol v6 = new Vol( d1, d1, 9600d, "nfidha_barcelone", 3, "nfidha", "barcelone", "NouvelAir");
        //volservise.add(v4);
        //volservise.add(v5);
        //volservise.add(v6);

//        Vol v4 = new Vol(d1, d1, 900d, "paris_tunis", 3, "Paris", "Tunis", "TunisAir");
//        Vol v5 = new Vol(d1, d1, 1900d, "tunis_paris", 3, "Tunis", "Paris", "AirFrance");
//        Vol v6 = new Vol(d1, d1, 9600d, "nfidha_barcelone", 3, "nfidha", "barcelone", "NouvelAir");
        //volservise.add(v4);
        //volservise.add(v5);
        //volservise.add(v6);
        //////////////////////////////////////////////VoyageOrganisé/////////////////////////
        VoyageOrganiseService vo = new VoyageOrganiseService();
//        CarRentalService crr = new CarRentalService();
//        CarRental carl = new CarRental(0, 14, 117, "Agence Locator_Sousse", "Google@gmail.com", "hiyohi", 12549365, "Sousse", "Agence de Location", "C:/");
//        CarService cser = new CarService();
//        System.out.println(cser.FindByRate(50, 40));
    }

}
