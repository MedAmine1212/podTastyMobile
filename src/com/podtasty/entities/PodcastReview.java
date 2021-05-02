/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.entities;


/**
 *
 * @author khail
 */
public class PodcastReview {

    private Integer id;
    private float rating;
    private User userIdId;
    private Podcast podcastIdId;

    public PodcastReview() {
    }

    public PodcastReview(Integer id) {
        this.id = id;
    }

    public PodcastReview(Integer id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public User getUserIdId() {
        return userIdId;
    }

    public void setUserIdId(User userIdId) {
        this.userIdId = userIdId;
    }

    public Podcast getPodcastIdId() {
        return podcastIdId;
    }

    public void setPodcastIdId(Podcast podcastIdId) {
        this.podcastIdId = podcastIdId;
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
        if (!(object instanceof PodcastReview)) {
            return false;
        }
        PodcastReview other = (PodcastReview) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PodcastReview[ id=" + id + " ]";
    }
    
}
