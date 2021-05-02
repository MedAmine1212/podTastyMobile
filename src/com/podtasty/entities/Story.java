
package com.podtasty.entities;

import java.util.Collection;

public class Story {

    private Integer id;
    private String storyImage;
    private Collection<UserInfo> userInfoCollection;
    private UserInfo ownerId;

    public Story() {
    }

    public Story(Integer id) {
        this.id = id;
    }

    public Story(Integer id, String storyImage) {
        this.id = id;
        this.storyImage = storyImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
    }

    public UserInfo getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UserInfo ownerId) {
        this.ownerId = ownerId;
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
        if (!(object instanceof Story)) {
            return false;
        }
        Story other = (Story) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Story[ id=" + id + " ]";
    }
    
}
