/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.l10n.ParseException;
import com.podtasty.entities.Playlist;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author khail
 */
public class ServicePlaylist {
    
     public Playlist playlist;
    public ArrayList<Playlist> playlists;
    
    private static ServicePlaylist instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServicePlaylist() {
        req = new ConnectionRequest();
    }

    public static ServicePlaylist getInstance() {
        if (instance == null) {
            instance = new ServicePlaylist();
        }
        return instance;
    }
    
    
    public Playlist parsePlaylist(Map<String,Object> obj) throws IOException, ParseException{
        Playlist playlist = new Playlist();
        float id = Float.parseFloat(obj.get("id").toString());
        playlist.setId((int)id);
        try {
        playlist.setPlaylistDescription(obj.get("PlaylistDescription").toString());
        } catch (NullPointerException ex) {}
        playlist.setChannelIdId(ServiceChannel.getInstance().parseChannel((Map<String,Object>)obj.get("ChannelId")));
                
        return playlist;
    }
    
    
}
