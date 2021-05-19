/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Playlist;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.User;
import com.podtasty.utils.Statics;
import java.io.IOException;

/**
 *
 * @author Lwiss
 */
public class ServicePlaylist {
    public boolean resultOK;
     private static ServicePlaylist instance=null;
     private ConnectionRequest req;
     
     
     
     public ServicePlaylist() {
         req = new ConnectionRequest();
    }
     
     public static ServicePlaylist getInstance() {
        if (instance == null) {
            instance = new ServicePlaylist();
        }
        return instance;
    }
     
     
     
     
     
     
    @SuppressWarnings("deprecation")
     public boolean addPlaylist(Playlist p,String path, String name) {
        
         Channel c = new Channel();
         c.setId(1);
         
        String url = Statics.BASE_URL + "/addPlaylist";
        MultipartRequest req=new MultipartRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("playlistName", p.getPlaylistName());
        req.addArgument("playlistDescription", p.getPlaylistDescription());
        req.addArgument("channelId", p.getChannelIdId().toString());
        try {
             req.addData("pic", path, "image/png");
        req.setFilename("fileUpload", name);
        } catch (IOException e) {
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
     
     
     
     public boolean updateProfilPic(User u, String path, String name) {
        String url = Statics.BASE_URL + "/updatePic";
        MultipartRequest request=new MultipartRequest();
        request.setUrl(url);
        request.setPost(true);
        try {
            request.addArgument("id", u.getId().toString());
            request.addData("myFile", path, "image/png");
            request.setFilename("fileUpload", name);

        } catch (IOException ex) {
            System.out.print(ex);
        }
        request.setPriority(ConnectionRequest.PRIORITY_CRITICAL);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                
            }
        });
        NetworkManager.getInstance().addToQueue(request);
        return resultOK;
    }
     
     
     
}
