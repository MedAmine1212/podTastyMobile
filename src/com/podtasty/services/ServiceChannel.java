/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.l10n.ParseException;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Playlist;
import com.podtasty.entities.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author khail
 */
public class ServiceChannel {
     public Channel channel;
    public ArrayList<Channel> channels;
    
    private static ServiceChannel instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
    
     private ServiceChannel() {
        req = new ConnectionRequest();
    }

    public static ServiceChannel getInstance() {
        if (instance == null) {
            instance = new ServiceChannel();
        }
        return instance;
    }
    
    public Channel parseChannel(Map<String,Object> obj) throws IOException, ParseException{
        Channel channel = new Channel();
        float id = Float.parseFloat(obj.get("id").toString());
        channel.setId((int)id);
        channel.setChannel_Name(obj.get("ChannelName").toString());
        channel.setChannel_Description(obj.get("ChannelDescription").toString());
        float userId = Float.parseFloat(((Map<String,Object>)obj.get("UserId")).get("id").toString());
        ArrayList<User> users = ServiceUser.getInstance().getUserById((int)userId);
        channel.setUser(users.get(0));
        return channel;
    }
    
}
