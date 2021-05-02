
package com.podtasty.entities;

import java.util.Collection;

/**
 *
 * @author Douiri Amine
 */
public class User {

    private Integer id;
    private String userEmail;
    private String userPassword;
    private boolean isAdmin;
    private boolean desactiveAccount;
    private String githubId;
    private Collection<Channel> channelCollection;
    private Channel channelIdId;
    private UserInfo userInfoIdId;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, Channel channelIdId) {
        this.id = id;
        this.channelIdId = channelIdId;
    }

    public User(Integer id, String userEmail, boolean isAdmin, boolean desactiveAccount) {
        this.id = id;
        this.userEmail = userEmail;
        this.isAdmin = isAdmin;
        this.desactiveAccount = desactiveAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean getDesactiveAccount() {
        return desactiveAccount;
    }

    public void setDesactiveAccount(boolean desactiveAccount) {
        this.desactiveAccount = desactiveAccount;
    }

    public String getGithubId() {
        return githubId;
    }

    public void setGithubId(String githubId) {
        this.githubId = githubId;
    }

    public Collection<Channel> getChannelCollection() {
        return channelCollection;
    }

    public void setChannelCollection(Collection<Channel> channelCollection) {
        this.channelCollection = channelCollection;
    }

    public Channel getChannelIdId() {
        return channelIdId;
    }

    public void setChannelIdId(Channel channelIdId) {
        this.channelIdId = channelIdId;
    }

    public UserInfo getUserInfoIdId() {
        return userInfoIdId;
    }

    public void setUserInfoIdId(UserInfo userInfoIdId) {
        this.userInfoIdId = userInfoIdId;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", isAdmin=" + isAdmin + ", desactiveAccount=" + desactiveAccount + ", githubId=" + githubId + ", channelCollection=" + channelCollection + ", channelIdId=" + channelIdId + ", userInfoIdId=" + userInfoIdId + '}';
    }

    
    
}
