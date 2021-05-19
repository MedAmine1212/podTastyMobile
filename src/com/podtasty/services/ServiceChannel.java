/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.ConnectionRequest;

/**
 *
 * @author Lwiss
 */
public class ServiceChannel {
    
    public boolean resultOK;
     private static ServiceChannel instance=null;
     private ConnectionRequest req;
     
     
     
     private ServiceChannel() {
         req = new ConnectionRequest();
    }
     
     public static ServiceChannel getInstance() {
        if (instance == null) {
            instance = new ServiceChannel();
        }
        return instance;
    }
     
     
     
     
     
    
}
