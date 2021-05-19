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
public class Playlist {

   private Integer id;
    private String playlistName;
    private String playlistDescription;
    private String playlistCreationDate;
    private String imageName;
    private Date updatedAt;
    private int channelIdId;
    private Collection<Podcast> podcastCollection;

    
    
    
    public Playlist(Integer id, String playlistName, String playlistDescription, String playlistCreationDate) {
        this.id = id;
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.playlistCreationDate = playlistCreationDate;
    }
    public Playlist() {
    }

    public Playlist(Integer id) {
        this.id = id;
    }
    
     public Playlist(String playlistName) {
         this.playlistName = playlistName;
    }

   

    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        this.playlistDescription = playlistDescription;
    }

    public String getPlaylistCreationDate() {
        return playlistCreationDate;
    }

    public void setPlaylistCreationDate(String playlistCreationDate) {
        this.playlistCreationDate = playlistCreationDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getChannelIdId() {
        return channelIdId;
    }

    public void setChannelIdId(int channelIdId) {
        this.channelIdId = channelIdId;
    }

    public Collection<Podcast> getPodcastCollection() {
        return podcastCollection;
    }

    public void setPodcastCollection(Collection<Podcast> podcastCollection) {
        this.podcastCollection = podcastCollection;
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
        if (!(object instanceof Playlist)) {
            return false;
        }
        Playlist other = (Playlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", playlistName=" + playlistName + ", playlistDescription=" + playlistDescription + ", playlistCreationDate=" + playlistCreationDate + ", imageName=" + imageName + ", updatedAt=" + updatedAt + ", channelIdId=" + channelIdId + ", podcastCollection=" + podcastCollection + '}';
    }

    
}
