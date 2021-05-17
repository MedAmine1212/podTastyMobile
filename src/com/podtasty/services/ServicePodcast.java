/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Podcast;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khail
 */
public class ServicePodcast {
    
    
    public Podcast podcast;
    public ArrayList<Podcast> podcasts;
    
    private static ServicePodcast instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServicePodcast() {
          req = new ConnectionRequest() {
              @Override
            protected void handleErrorResponseCode(int code, String message) {
                if (code == 400) {
                    Dialog.show("Notice", code + ": " + message, "Ok",null);
                } else {
                    Dialog.show("Error", code + ": " + message, "Retry", "Cancel");
                }
    }
         };
          req.addExceptionListener(e -> {
                    Dialog.show("Error","Ex: "+e.getMessage(), "OK", null);
          });
    }

    public static ServicePodcast getInstance() {
        if (instance == null) {
            instance = new ServicePodcast();
        }
        return instance;
    }
    public Podcast parsePodcast(String jsonText) throws IOException, ParseException{
        Podcast pod = new Podcast();
         JSONParser j = new JSONParser();
        Map<String,Object> podcastJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)podcastJSON.get("root");
            
              for(Map<String,Object> obj : list){
                float id = Float.parseFloat(obj.get("id").toString());
                pod.setId((int)id);
                
                Date comDate = new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("PodcastDate").toString());
                pod.setPodcastDate(comDate);
                pod.setPodcastName(obj.get("PodcastName").toString());
                pod.setPodcastDescription(obj.get("PodcastDescription").toString());
                float allowed = Float.parseFloat(obj.get("commentsAllowed").toString());
                pod.setCommentsAllowed((int)allowed);
                float blocked = Float.parseFloat(obj.get("isBlocked").toString());
                pod.setIsBlocked((int)blocked);
                float live = Float.parseFloat(obj.get("currentlyLive").toString());
                pod.setCurrentlyLive((int)live);
                float views = Float.parseFloat(obj.get("PodcastViews").toString());
                pod.setPodcastViews((int)views);
                pod.setPodcastImage(obj.get("PodcastImage").toString());
                pod.setPlaylistIdId(ServicePlaylist.getInstance().parsePlaylist((Map<String,Object>)obj.get("PlaylistId")));
                pod.setPodcastReviewCollection(ServicePodcastReview.getInstance().parseReviews((ArrayList<Map<String,Object>>)obj.get("ReviewList")));
                pod.setPodcastSource(obj.get("PodcastSource").toString());
                return pod;
              }
            
        return pod;
    }
    
    public Podcast getPodcastById(int id) {
       String url = Statics.BASE_URL+"/mobile/getPodcastById/"+id;
        req.setUrl(url);
        try {
        req.setPost(false);
        } catch(IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    podcast = parsePodcast("["+new String(req.getResponseData())+"]");
                } catch (ParseException | IOException ex) {
                    System.out.println("getPod ex: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return podcast;
    }
    
}
