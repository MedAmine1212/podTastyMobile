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
public class Notification {

    private Integer id;
    private Date notificationDate;
    private String notificationTitle;
    private String notificationDescription;
    private boolean isViewed;
    private User userIdId;

    public Notification() {
    }

    public Notification(Integer id) {
        this.id = id;
    }

    public Notification(Integer id, Date notificationDate, String notificationTitle, String notificationDescription, boolean isViewed) {
        this.id = id;
        this.notificationDate = notificationDate;
        this.notificationTitle = notificationTitle;
        this.notificationDescription = notificationDescription;
        this.isViewed = isViewed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }

    public boolean getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(boolean isViewed) {
        this.isViewed = isViewed;
    }

    public User getUserIdId() {
        return userIdId;
    }

    public void setUserIdId(User userIdId) {
        this.userIdId = userIdId;
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
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Notification[ id=" + id + " ]";
    }
    
}
