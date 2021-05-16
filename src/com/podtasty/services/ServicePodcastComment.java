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
import com.codename1.ui.events.ActionEvent;
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
    public PodcastComment comment;
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

public PodcastComment addComment(PodcastComment com) {
        String url = Statics.BASE_URL + "/mobile/addComment";
        req.setUrl(url);
        try{ 
        req.setPost(true);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        req.addArgument("comText", com.getCommentText());
        req.addArgument("podId", com.getPodcastIdId().getId().toString());
        req.addArgument("userId", com.getUserIdId().getId().toString());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try{
                    switch (new String(req.getResponseData())) {
                        case "403":
                            comment = new PodcastComment();
                            comment.setId(-1);
                            break;
                        case "401":
                            comment = new PodcastComment();
                            comment.setId(-2);
                            break;
                        default:
                            comments = parseComments("["+new String(req.getResponseData())+"]", com.getPodcastIdId());
                            comment = comments.iterator().next();
                            try {
                                String url = Statics.BASE_URL+"/callMercure/comments/"+comment.getId()+"/"+com.getPodcastIdId().getId();
                                ConnectionRequest mercReq = new ConnectionRequest();
                                mercReq.setUrl(url);
                                mercReq.setPost(false);
                                NetworkManager.getInstance().addToQueueAndWait(mercReq);
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                            }
                            comment = comments.iterator().next();
                            req.removeResponseListener(this);
                            break;                        
                    }
                    
                } catch(ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return comment;
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
    
    
    public boolean checkFav(int podId, int userId) {
        String url = Statics.BASE_URL + "/mobile/checkIfFav/"+podId+"/"+userId;
    req.setUrl(url);
      try {
            req.setPost(false);
        } catch(IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
      req.addResponseListener(new ActionListener<NetworkEvent>() {
          @Override
          public void actionPerformed(NetworkEvent evt) {
              resultOK = new String(req.getResponseData()).equals("1");
              req.removeResponseListener(this);     
          }
      });
       NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
     public boolean updateComment(int id, String comText) {
        String url = Statics.BASE_URL + "/mobile/UpdateComment";
        req.setUrl(url);
        try{ 
            req.setPost(true);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        req.addArgument("comText", comText);
        req.addArgument("comId", id+"");
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
        String url = Statics.BASE_URL + "/mobile/deleteComment/"+id;
        req.setUrl(url);
        try {
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
        
            String url = Statics.BASE_URL+"/mobile/getCommentsByPodcastId/"+pod.getId();
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
            try {
                NetworkManager.getInstance().addErrorListener(new ActionListener() {
               @Override
              public void actionPerformed(ActionEvent evt) {
                  NetworkEvent n = (NetworkEvent) evt;              
                 Dialog.show("my Error", "Exception :"+ n.getMessage(),"OK", null);                  
              }});
                NetworkManager.getInstance().addToQueueAndWait(req);
               
            }catch(Exception ex) {
                Dialog.show("Error", "Exception: "+ex.getMessage(), "Ok", null);
            }
            return comments;
    }
}

