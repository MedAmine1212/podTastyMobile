/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.entities;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author khail
 */
public class Channel {

    private Integer id;
    private String channelName;
    private String channelDescription;
    private String channelCreationDate;
    private int channelStatus;
    private Collection<User> userCollection;
    private Collection<Playlist> playlistCollection;
    private User user;

    public Channel() {
    }

    public Channel(Integer id) {
        this.id = id;
    }

    public Channel(String channelName, String channelDescription) {
        this.channelName = channelName;
        this.channelDescription = channelDescription;
    }

    public Channel(Integer id, String channelName, String channelDescription, String channelCreationDate, int channelStatus, Collection<Playlist> playlistCollection) {
        this.id = id;
        this.channelName = channelName;
        this.channelDescription = channelDescription;
        this.channelCreationDate = channelCreationDate;
        this.channelStatus = channelStatus;
        this.playlistCollection = playlistCollection;
    }

    public Channel(Integer id, String channelName, String channelDescription, String channelCreationDate, int channelStatus) {
        this.id = id;
        this.channelName = channelName;
        this.channelDescription = channelDescription;
        this.channelCreationDate = channelCreationDate;
        this.channelStatus = channelStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChannel_Name() {
        return channelName;
    }

    public void setChannel_Name(String channelName) {
        this.channelName = channelName;
    }

    public String getChannel_Description() {
        return channelDescription;
    }

    public void setChannel_Description(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public String getChannel_CreationDate() {
        return channelCreationDate;
    }

    public void setChannel_CreationDate(String channelCreationDate) {
        this.channelCreationDate = channelCreationDate;
    }

    public int getChannel_Status() {
        return channelStatus;
    }

    public void setChannel_Status(int channelStatus) {
        this.channelStatus = channelStatus;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<Playlist> getPlaylistCollection() {
        return playlistCollection;
    }

    public void setPlaylistCollection(Collection<Playlist> playlistCollection) {
        this.playlistCollection = playlistCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Channel)) {
            return false;
        }
        Channel other = (Channel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Channel{" + "id=" + id + ", channelName=" + channelName + ", channelDescription=" + channelDescription + ", channelCreationDate=" + channelCreationDate + ", channelStatus=" + channelStatus + ", userCollection=" + userCollection + ", playlistCollection=" + playlistCollection + ", user=" + user + '}';
    }

}
