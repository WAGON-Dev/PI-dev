/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pidev.tests;

import edu.esprit.pidev.sevices.ClientService;
import edu.esprit.pidev.interfaces.IserviceClient;
import edu.esprit.pidev.models.Client;

/**
 *
 * @author Asus
 */
public class tests {

    public static void main(String[] args) {
        ClientService cs = new ClientService();
        Client c;
        c = new Client("wajdy", "12807857", "29/08/1995", "bouslama", "wajdy.bouslama@esprit.tn", "12345678", 55054543, "sousse", "client", "");
        cs.add(c);
    }

}
