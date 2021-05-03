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
import com.podtasty.entities.PodcastComment;
import com.podtasty.utils.Statics;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ServicePodcastComment {

    public ArrayList<PodcastComment> comments;
    
    private static ServicePodcastComment instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePodcastComment() {
         req = new ConnectionRequest();
    }

    public static ServicePodcastComment getInstance() {
        if (instance == null) {
            instance = new ServicePodcastComment();
        }
        return instance;
    }

    public boolean addComment(PodcastComment com) {
        String url = Statics.BASE_URL + "/addComment";
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("comText", com.getCommentText());
        req.addArgument("podId", com.getPodcastIdId().getId().toString());
        req.addArgument("userId", com.getUserIdId().getId().toString());
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
    
    
     public boolean updateComment(int id, String comText) {
        String url = Statics.BASE_URL + "/UpdateComment";
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("comText", comText);
        req.addArgument("commentId", id+"");
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
     
     
        public boolean deleteComment(int id) {
        String url = Statics.BASE_URL + "/deleteComment/"+id;
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
   

    public ArrayList<PodcastComment> parseComments(String jsonText, Podcast pod) throws ParseException{
        try {
            comments=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> commentsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)commentsListJson.get("root");
            
            
            for(Map<String,Object> obj : list){
                PodcastComment com = new PodcastComment();
                float id = Float.parseFloat(obj.get("id").toString());
                com.setId((int)id);
                Date comDate = new SimpleDateFormat("yyyy-MM-dd").parse(obj.get("CommentDate").toString());
                com.setCommentDate(comDate);
                com.setCommentText(obj.get("CommentText").toString());
                com.setPodcastIdId(pod);
                ServiceUser srUser = ServiceUser.getInstance(); 
               User user  = srUser.parseUser((Map<String,Object>)obj.get("UserId"));
                com.setUserIdId(user);
                comments.add(com);
            }
            
            
        } catch (IOException ex) {
            
        }
        return comments;
    }
    
    public ArrayList<PodcastComment> getCommentsByPodcastId(Podcast pod){
        String url = Statics.BASE_URL+"/getCommentsByPodcastId/"+pod.getId();
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
                    pod.setPodcastCommentCollection(null);
                    comments = parseComments(new String(req.getResponseData()), pod);
                } catch (ParseException ex) {
                    System.out.println("getCom ex: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return comments;
    }
}
