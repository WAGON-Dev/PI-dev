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
import edu.esprit.pidev.models.Guide;
import edu.esprit.pidev.models.Hotel;
import edu.esprit.pidev.models.Vol;
import edu.esprit.pidev.models.VoyagePersonalise;
import edu.esprit.pidev.sevices.AdminService;
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

    public static void main(String[] args) throws ParseException {
    /////////////////////////////////////////////////////CLIENT/////////////////////////////////////////////////////////////////////////////////
        AdminService cs = new AdminService();
        Admin c8,c9;
        c8 = new Admin("omar", "12807857", "29/08/1995", "bouslama", "wajdy.bouslama@esprit.tn", "123456", 55054543, "sousse", "admin", "");
        c9 = new Admin("ghassen", "12807857", "29/08/1995", "jemai", "ghassen.jemai@esprit.tn", "123456", 55054543, "australia", "admin", "");
        c9.setId_user(3);
        cs.add(c8);
        cs.add(c9);
        cs.update(c8);
            cs.remove(12);
        System.out.println(cs.findById(4));
    ////////////////////////////////////////////////////HOTEL///////////////////////////////////////////////////////////////////////////////////  
        
       /* HotelService hotelService = new HotelService();
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
    */
    
    
    
   ////////////////////////////////////////////////////VOL//////////////////////////////////////////////////////////////// 
     VolService volService=new VolService();
      Client c = new Client("wajdy", "12807857", "29/08/1995", "bouslama", "wajdy.bouslama@esprit.tn", "123456", 55054543, "sousse", "client", "");
        Client c2 = new Client("ghassen", "12807857", "29/08/1995", "jemai", "ghassen.jemai@esprit.tn", "123456", 55054543, "australia", "client", "");
       Client c3=new Client(1,"nouha","nouha.asfour","123456",50665665,"tunis","admin","*.png","asfour","06579428","1995");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d2 = sdf.parse("2057/09/25");
        Date d1 = sdf.parse("2018/09/25");
        Vol vol=new Vol(d1,d2,444.5,"deutch",3,"deutch","paris","african");
        //volService.addVolWithStatement(vol);
        
      
        Date d3 = sdf.parse("2057/09/24");
        Date d4 = sdf.parse("2068/09/22");
       
       Vol v = new Vol( d2,d1 , 444.65, "parisVol", 3, "paris", "tunis", "tunisaire");
        //volService.add(v);
      // volService.remove(3);
               Vol v1 = new Vol(16, d1,d2 , 444.65, "paris", 3, "paris", "americaa", "tunisaire");
           //volService.update(v1);
     
       List<Vol> vols=new ArrayList<>();
       vols=volService.getAll();
       for(int i=0; i<vols.size();i++)
        System.out.println(vols.get(i));
       
        System.out.println("next");
        
        System.out.println(volService.findById(4));
        
        System.out.println("next2");
        
        List<Vol> vols1=new ArrayList<>();
        vols1=volService.getByClient(c3);
         for(int i=0; i<vols1.size();i++)
        System.out.println(vols1.get(i));
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

}
