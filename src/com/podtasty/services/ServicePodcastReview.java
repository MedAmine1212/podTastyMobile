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
import com.podtasty.entities.PodcastReview;
import com.podtasty.utils.Statics;
import java.util.ArrayList;

/**
 *
 * @author khail
 */
public class ServicePodcastReview {
    
     public PodcastReview review;
    public ArrayList<PodcastReview> reviews;
    
    private static ServicePodcastReview instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePodcastReview() {
        req = new ConnectionRequest();
    }

    public static ServicePodcastReview getInstance() {
        if (instance == null) {
            instance = new ServicePodcastReview();
        }
        return instance;
    }
    
    public boolean addReview(PodcastReview rev) {
        String url = Statics.BASE_URL + "/mobile/addReview";
        req.setUrl(url);
        try{ 
        req.setPost(true);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        req.addArgument("rating", rev.getRating()+"");
        req.addArgument("podId", rev.getPodcastIdId().getId().toString());
        req.addArgument("userId", rev.getUserIdId().getId().toString());
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
    
    
}
