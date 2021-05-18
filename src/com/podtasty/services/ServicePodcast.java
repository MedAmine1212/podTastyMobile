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
    
    
    
//    public Podcast parsePodcast(String jsonText) throws IOException, ParseException{
//        Podcast pod = new Podcast();
//         JSONParser j = new JSONParser();
//        Map<String,Object> podcastJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//           
//            List<Map<String,Object>> list = (List<Map<String,Object>>)podcastJSON.get("root");
//            
//              for(Map<String,Object> obj : list){
//                float id = Float.parseFloat(obj.get("id").toString());
//                pod.setId((int)id);
//                
//                Date comDate = new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("PodcastDate").toString());
//                pod.setPodcastDate(comDate);
//                pod.setPodcastName(obj.get("PodcastName").toString());
//                pod.setPodcastDescription(obj.get("PodcastDescription").toString());
//                
//                
//                comments.add(com);
//            }
//            
//        return pod;
//    }
     public Podcast podcast;
    public ArrayList<Podcast> podcasts;
    
    //singelton
    private static ServicePodcast instance=null;
    
    public boolean resultOK;
    
    //initialisation connection request
    private ConnectionRequest req;
    
     private ServicePodcast() {
         req = new ConnectionRequest();
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
                pod.setPodcastSource(obj.get("PodcastSource").toString());
                
                //float playlistId = Float.parseFloat(obj.get("playlistIdId").toString());
                return pod;
              }
            
        return pod;
    }
    
   
   
    
    public Podcast getPodcastById(int id) {
        
        
        String url = Statics.BASE_URL+ "/getPodcastById/"+id;
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
                    podcast = parsePodcast(new String(req.getResponseData()));
                } catch (ParseException | IOException ex) {
                    System.out.println("getPod ex: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return podcast;
    }
    
    
    //ArrayList<Podcast> = parsePodcasts(new String(req.getgetResponseData()))
    
    public boolean AjoutPodcast (Podcast podcast){
//        String url = Statics.BASE_URL+"/mobile/AddPodcast?podcastName"+podcast.getPodcastName()+"podcastDescription"+podcast.getPodcastDescription()+"podcastImage"+podcast.getPodcastImage()+"podcastSource"+podcast.getPodcastSource();
//        
//        req.setUrl(url);
//        req.addResponseListener((e) -> {
//            String str = new String(req.getResponseData());
//            System.out.println("data == "+str);
//    });
//        NetworkManager.getInstance().addToQueueAndWait(req);

        String utl = Statics.BASE_URL + "/AddPodcast";
        req.setUrl(utl);
        req.setPost(true);
        req.addArgument("podcastName", podcast.getPodcastName());
        req.addArgument("podcastDescription", podcast.getPodcastDescription());
        //req.addArgument("podcastDate", podcast.getPodcastDate().toString());
        req.addArgument("podcastImage", podcast.getPodcastImage());
        req.addArgument("podcastSource", podcast.getPodcastSource());
     //   req.addArgument("playlistIdId", podcast.getPlaylistIdId().getId().toString());
        
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
    
    
    public ArrayList<Podcast>affichePodcast() {
        ArrayList<Podcast> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+ "/getPodcast";
        req.setUrl(url);
        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp;
            jsonp = new JSONParser() ;
            try {
                Map<String,Object>mapPodcast = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapPodcast.get("root");
                for (Map<String,Object> obj : listOfMaps) {
                    Podcast podcast1 = new Podcast();
                    float id = Float.parseFloat(obj.get("id").toString()) ;
                    String podcastName = obj.get("PodcastName").toString();
                    String description = obj.get("PodcastDescription").toString();
                    String podcastimage = obj.get("PodcastImage").toString();
                    String podcastsource = obj.get("PodcastSource").toString();
                    podcast1.setId((int)id);
                    podcast1.setPodcastName(podcastName);
                    podcast1.setPodcastDescription(description);
                    podcast1.setPodcastImage(podcastimage);
                    podcast1.setPodcastSource(podcastsource);
                    Date PodcastDate = new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("PodcastDate").toString());
                    podcast1.setPodcastDate(PodcastDate);
                    result.add(podcast1);
                }
            }catch (Exception ex) {                    
                ex.printStackTrace();
            }
        });

                NetworkManager.getInstance().addToQueueAndWait(req); 
                
                return result;

}
    
    
    public boolean deletePodcast(int id) {
        String url = Statics.BASE_URL + "/DeletePodcast/"+id;
        req.setUrl(url);
        req.setPost(false);
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

    





     




