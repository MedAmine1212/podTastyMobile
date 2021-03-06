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
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.User;
import com.podtasty.entities.UserInfo;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khail
 */
public class ServiceUser {

    public ArrayList<User> users;
    public ArrayList<UserInfo> usersInfo;
    
    private static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
     public ArrayList<User> parseUsers(String jsonText) throws IOException{
          users = new ArrayList<>();
         JSONParser j = new JSONParser();
        Map<String,Object> userJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)userJSON.get("root");
              for(Map<String,Object> obj : list){
                
                  User user = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                user.setId((int)id);
                
                float userInfoId = Float.parseFloat(obj.get("UserInfoIdForMobile").toString());
                ArrayList<UserInfo> usInfo = getUserInfoById((int)userInfoId);
                
                UserInfo userInfo = usInfo.iterator().next();
                user.setUserInfoIdId(userInfo);
                users.add(user);
            }
            
        return users;
    }
     
     
       public ArrayList<UserInfo> parseUserInfo(String jsonText) throws IOException{

          usersInfo = new ArrayList<>();
          JSONParser j = new JSONParser();
        Map<String,Object> podcastJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
           
            List<Map<String,Object>> list = (List<Map<String,Object>>)podcastJSON.get("root");
              for(Map<String,Object> obj : list){
                UserInfo userInfo = new UserInfo();
                float id = Float.parseFloat(obj.get("id").toString());
                userInfo.setId((int)id);
                userInfo.setUserFirstName(obj.get("UserFirstName").toString());
                userInfo.setUserLastName(obj.get("UserLastName").toString());
                userInfo.setUserImage(obj.get("UserImage").toString());
                usersInfo.add(userInfo);
            }
        return usersInfo;
    }
    
     public ArrayList<User> getUserById(int id){
        String url = Statics.BASE_URL+"/getUserById/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    users = parseUsers(new String(req.getResponseData()));
                } catch (IOException ex) {
                    System.out.println("User ex: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
     
     
     
     public ArrayList<UserInfo> getUserInfoById(int id){
        String url = Statics.BASE_URL+"/getUserInfoById/"+id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    usersInfo = parseUserInfo(new String(req.getResponseData()));
                } catch (IOException ex) {
                    System.out.println("User info exception: "+ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return usersInfo;
    }
     
    
}
