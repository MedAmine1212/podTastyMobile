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
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.Reclamation;
import com.podtasty.entities.User;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
        
        public ArrayList<Reclamation> parseReclamation(String jsonText , Podcast pod) throws IOException, ParseException{
            try {
             Reclamation report = new Reclamation();
        reclamations = new ArrayList<>();
         JSONParser j = new JSONParser();
        Map<String,Object> podcastJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)podcastJSON.get("root");
            
              for(Map<String,Object> obj : list){
                float id = Float.parseFloat(obj.get("id").toString());
                report.setId((int)id);              
                report.setType(obj.get("type").toString());
                report.setDescription(obj.get("description").toString());
                float status = Float.parseFloat(obj.get("status").toString());
                ServiceUser srUser = ServiceUser.getInstance(); 
                float userId = Float.parseFloat(obj.get("userIdId").toString());
                report.setPodcastIdId(pod);
                ArrayList<User> users = srUser.getUserById((int)userId);
                reclamations.add(report);
                
               }
            }
              catch (IOException ex){
                      
                      }
        return reclamations;
    }

                
        //affichage
        public ArrayList<Reclamation>affichageReclamation(Podcast podcast){
            ArrayList<Reclamation> reclamations = new ArrayList<>();
            
            String url  = Statics.BASE_URL+ "/getReport";
            req.setUrl(url);
            req.addResponseListener((NetworkEvent evt) -> {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                try {
                    Map<String,Object>mapReclamation = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapReclamation.get("root");
                    
                    for (Map<String,Object> obj : listOfMaps){
                        Reclamation report = new Reclamation();
                        
                        float id = Float.parseFloat(obj.get("id").toString());
                        String type = obj.get("type").toString();
                        String description = obj.get("description").toString();
                        float status = Float.parseFloat(obj.get("status").toString());
                        float  userid = Float.parseFloat(obj.get("userIdId").toString());
                        float podcastid = Float.parseFloat(obj.get("podcastIdId").toString());
                        
                        report.setId((int)id);
                        report.setType(type);
                        report.setDescription(description);
                        report.setStatus((int)status);
                        ServiceUser srUser = ServiceUser.getInstance();
                        float userId = Float.parseFloat(obj.get("UserIdForMobile").toString());
                        ArrayList<User> users = srUser.getUserById((int)userId);
                        report.setPodcastIdId(podcast);
                        
                    }
                    
                }
                catch (Exception ex) {                             
                    ex.printStackTrace();
                }
            });
                    NetworkManager.getInstance().addToQueueAndWait(req); 
                    return reclamations;

    }
        
        
        
        //ajout 
        public boolean ajoutReclamation (Reclamation reclamation){
            
            String url = Statics.BASE_URL+ "/mobile/NewReport";
            req.setUrl(url);
            req.setPost(true);
            req.addArgument("type", reclamation.getType());
            req.addArgument("description", reclamation.getDescription());
            req.addArgument("status", ""+reclamation.getStatus());
            req.addArgument("podId", reclamation.getPodcastIdId().getId().toString());
            req.addArgument("userId", reclamation.getUserIdId().getId().toString());
            
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


        public ArrayList<Reclamation> getReportByPodcastId(Podcast pod){
        String url = Statics.BASE_URL+"/getReportsByPodcastId/"+pod.getId();
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    try {
                        reclamations = parseReclamation(new String(req.getResponseData()), pod);
                    } catch (ParseException ex) {
                        System.out.println("getRec ex: "+ex.getMessage());
                    }
                    } catch (IOException ex ) {
                      System.out.println("getRec ex: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;       
}



}
