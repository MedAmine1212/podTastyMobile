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
import com.podtasty.entities.Tag;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khail
 */
public class ServiceTag {
     
    public Tag tag;
    public ArrayList<Tag> tags;
    
    private static ServiceTag instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServiceTag() {
          req = new ConnectionRequest();
    }

    public static ServiceTag getInstance() {
        if (instance == null) {
            instance = new ServiceTag();
        }
        return instance;
    }
    
    public ArrayList<Tag> parseTags(ArrayList<Map<String,Object>> object) throws IOException, ParseException{
        ArrayList<Tag> tagList = new ArrayList<>();
         for(Map<String,Object> obj: object) {
            float id = Float.parseFloat(obj.get("id").toString());
            tag = new Tag();
            tag.setId((int)id);
            tag.setName(obj.get("name").toString());
            tag.setTagStyle(obj.get("tagStyle").toString());
            tagList.add(tag);
         }
        return tagList;
    }
    
    private ArrayList<Tag> goToParseTags(String jsonText) {
        ArrayList<Tag> tagList = new ArrayList<>();
        JSONParser j = new JSONParser();
            Map<String,Object> tagsList;
        try {
            tagsList = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            ArrayList<Map<String,Object>> list = (ArrayList<Map<String,Object>>)tagsList.get("root");
            return parseTags(list);
        } catch (IOException | ParseException ex) {
            System.out.println(ex.getMessage());
        }
            
        return tagList;
    }
    public ArrayList<Tag> getTags() {
        tags = new ArrayList<>();
        String url = Statics.BASE_URL+ "/mobile/getTags";
        req.setUrl(url);
          try {
        req.setPost(false);
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tags = goToParseTags(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tags;
    }
    
}
