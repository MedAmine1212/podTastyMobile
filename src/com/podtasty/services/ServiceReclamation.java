/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.ConnectionRequest;
import com.podtasty.entities.Reclamation;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class ServiceReclamation {
    
        public ArrayList<Reclamation> reclamations;

        private static ServiceReclamation instance=null;
        
        public boolean resultOK;

        private ConnectionRequest req;
    
     private ServiceReclamation() {
         req = new ConnectionRequest();
    }
        
        public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
        }

}
