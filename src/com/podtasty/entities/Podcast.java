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
public class Podcast {

    private Integer id;
    private String podcastName;
    private int currentlyLive;
    private int isBlocked;
    private int commentsAllowed;
    private String podcastDescription;
    private String podcastImage;
    private Integer podcastViews;
    private Integer currentlyWatching;
    private Date podcastDate;
    private String podcastSource;
    private Collection<User> userCollection;
    private Collection<Tag> tagCollection;
    private Collection<PodcastComment> podcastCommentCollection;
    private Collection<PodcastReview> podcastReviewCollection;
    private Playlist playlistIdId;
    private Collection<Reclamation> reclamationCollection;

    public Podcast() {
    }

    public Podcast(Integer id) {
        this.id = id;
    }

    public Podcast(Integer id, String podcastName, int currentlyLive, int isBlocked, int commentsAllowed, Date podcastDate) {
        this.id = id;
        this.podcastName = podcastName;
        this.currentlyLive = currentlyLive;
        this.isBlocked = isBlocked;
        this.commentsAllowed = commentsAllowed;
        this.podcastDate = podcastDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public int getCurrentlyLive() {
        return currentlyLive;
    }

    public void setCurrentlyLive(int currentlyLive) {
        this.currentlyLive = currentlyLive;
    }

    public int getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(int isBlocked) {
        this.isBlocked = isBlocked;
    }

    public int getCommentsAllowed() {
        return commentsAllowed;
    }

    public void setCommentsAllowed(int commentsAllowed) {
        this.commentsAllowed = commentsAllowed;
    }

    public String getPodcastDescription() {
        return podcastDescription;
    }

    public void setPodcastDescription(String podcastDescription) {
        this.podcastDescription = podcastDescription;
    }

    public String getPodcastImage() {
        return podcastImage;
    }

    public void setPodcastImage(String podcastImage) {
        this.podcastImage = podcastImage;
    }

    public Integer getPodcastViews() {
        return podcastViews;
    }

    public void setPodcastViews(Integer podcastViews) {
        this.podcastViews = podcastViews;
    }

    public Integer getCurrentlyWatching() {
        return currentlyWatching;
    }

    public void setCurrentlyWatching(Integer currentlyWatching) {
        this.currentlyWatching = currentlyWatching;
    }

    public Date getPodcastDate() {
        return podcastDate;
    }

    public void setPodcastDate(Date podcastDate) {
        this.podcastDate = podcastDate;
    }

    public String getPodcastSource() {
        return podcastSource;
    }

    public void setPodcastSource(String podcastSource) {
        this.podcastSource = podcastSource;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<Tag> getTagCollection() {
        return tagCollection;
    }

    public void setTagCollection(Collection<Tag> tagCollection) {
        this.tagCollection = tagCollection;
    }

    public Collection<PodcastComment> getPodcastCommentCollection() {
        return podcastCommentCollection;
    }

    public void setPodcastCommentCollection(Collection<PodcastComment> podcastCommentCollection) {
        this.podcastCommentCollection = podcastCommentCollection;
    }

    public Collection<PodcastReview> getPodcastReviewCollection() {
        return podcastReviewCollection;
    }

    public void setPodcastReviewCollection(Collection<PodcastReview> podcastReviewCollection) {
        this.podcastReviewCollection = podcastReviewCollection;
    }

    public Playlist getPlaylistIdId() {
        return playlistIdId;
    }

    public void setPlaylistIdId(Playlist playlistIdId) {
        this.playlistIdId = playlistIdId;
    }

    public Collection<Reclamation> getReclamationCollection() {
        return reclamationCollection;
    }

    public void setReclamationCollection(Collection<Reclamation> reclamationCollection) {
        this.reclamationCollection = reclamationCollection;
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
        if (!(object instanceof Podcast)) {
            return false;
        }
        Podcast other = (Podcast) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Podcast_1[ id=" + id + " ]";
    }
    
}
