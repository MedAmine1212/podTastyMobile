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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Channel;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.PodcastReview;
import com.podtasty.entities.User;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
    
    public PodcastReview addReview(PodcastReview rev) {
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
                
            float id = Float.parseFloat(new String(req.getResponseData()));
            rev.setId((int)id);
              req.removeResponseListener(this);     
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return rev;
    }
    
    public boolean delReview(int id) {
        String url = Statics.BASE_URL + "/mobile/delReview/"+id;
        req.setUrl(url);
        try{ 
        req.setPost(false);
        } catch(Exception ex) {
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
    
    
    public ArrayList<PodcastReview> parseReviews(ArrayList<Map<String,Object>> object) throws IOException, ParseException{
        reviews = new ArrayList<>();
        for(Map<String,Object> obj: object) {
             PodcastReview rev = new PodcastReview();
                float id = Float.parseFloat(obj.get("id").toString());
                rev.setId((int)id);
                rev.setRating(Float.parseFloat(obj.get("Rating").toString()));
                rev.setUserIdId(ServiceUser.getInstance().parseUser((Map<String,Object>)obj.get("UserId")));
                reviews.add(rev);
        }
        return reviews;
    }
}
