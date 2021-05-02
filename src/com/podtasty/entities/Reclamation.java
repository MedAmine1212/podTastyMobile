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
public class Reclamation {

    private Integer id;
    private String type;
    private String description;
    private int status;
    private User userIdId;
    private Podcast podcastIdId;

    public Reclamation() {
    }

    public Reclamation(Integer id) {
        this.id = id;
    }

    public Reclamation(Integer id, String type, String description, int status) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Reclamation)) {
            return false;
        }
        Reclamation other = (Reclamation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reclamation[ id=" + id + " ]";
    }
    
}
