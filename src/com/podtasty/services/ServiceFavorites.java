/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Podcast;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author khail
 */
public class ServiceFavorites {
     public ArrayList<Podcast> favorites;
    
    private static ServiceFavorites instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServiceFavorites() {
        req = new ConnectionRequest();
    }

    public static ServiceFavorites getInstance() {
        if (instance == null) {
            instance = new ServiceFavorites();
        }
        return instance;
    }
    
        public boolean addRmvFav(int podId, int userId) {
    String url = Statics.BASE_URL + "/mobile/addRmvFav/"+podId+"/"+userId;
    req.setUrl(url);
      try {
            req.setPost(false);
        } catch(IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
      req.addResponseListener(new ActionListener<NetworkEvent>() {
          @Override
          public void actionPerformed(NetworkEvent evt) {
              resultOK = req.getResponseCode() == 200;
              req.removeResponseListener(this);     
          }
      });
       NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
        
         public ArrayList<Podcast> getUserFavorites(int id) {
        favorites = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/mobile/getUserFavorites/"+id;
        req.setUrl(url);
        try {
        req.setPost(false);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            
                @Override
                public void actionPerformed(NetworkEvent evt) {
            try {
                favorites = ServicePodcast.getInstance().parsePodcasts(new String(req.getResponseData()));
            } catch (IOException | ParseException ex) {
                System.out.println(ex.getMessage());
            }
            
            req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return favorites;
        
    }
    
}
