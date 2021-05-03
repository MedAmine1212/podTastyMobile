/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.entities;

import java.util.Date;

/**
 *
 * @author khail
 */
public class PodcastComment {

    private Integer id;
    private String commentText;
    private Date commentDate;
    private User userIdId;
    private Podcast podcastIdId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public PodcastComment() {
    }

    public PodcastComment(Integer id) {
        this.id = id;
    }

    public PodcastComment(Integer id, String commentText, Date commentDate) {
        this.id = id;
        this.commentText = commentText;
        this.commentDate = commentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public User getUserIdId() {
        return userIdId;
    }

    public void setUserIdId(User userIdId) {
        this.userIdId = userIdId;
        try {
            this.userName = userIdId.getUserInfoIdId().getUserFirstName()+" "+userIdId.getUserInfoIdId().getUserLastName();
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        
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
        if (!(object instanceof PodcastComment)) {
            return false;
        }
        PodcastComment other = (PodcastComment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment: [ id=" + id + 
                ", CommentText: "+commentText+
                ", CommentDate: "+commentDate+
                ", PodcastName; "+podcastIdId.getPodcastName()+
                ", UserName: "+userIdId.getUserInfoIdId().getUserFirstName()+
                " "+userIdId.getUserInfoIdId().getUserLastName()+
                " ]";
    }
    
}
