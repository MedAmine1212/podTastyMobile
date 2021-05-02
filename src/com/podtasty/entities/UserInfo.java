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
 * @author Douiri Amine
 */
public class UserInfo {

    private Integer id;
    private String userLastName;
    private String userFirstName;
    private String userImage;
    private String userGender;
    private Date userBirthDate;
    private String userBio;
    private Collection<UserInfo> userInfoCollection;
    private Collection<UserInfo> userInfoCollection1;
    private User user;

    public UserInfo() {
    }

    public UserInfo(Integer id) {
        this.id = id;
    }

    public UserInfo(Integer id, String userLastName, String userFirstName, String userGender, Date userBirthDate) {
        this.id = id;
        this.userLastName = userLastName;
        this.userFirstName = userFirstName;
        this.userGender = userGender;
        this.userBirthDate = userBirthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserBio() {
        return userBio;
    }

    public void setUserBio(String userBio) {
        this.userBio = userBio;
    }

    public Collection<UserInfo> getUserInfoCollection() {
        return userInfoCollection;
    }

    public void setUserInfoCollection(Collection<UserInfo> userInfoCollection) {
        this.userInfoCollection = userInfoCollection;
    }

    public Collection<UserInfo> getUserInfoCollection1() {
        return userInfoCollection1;
    }

    public void setUserInfoCollection1(Collection<UserInfo> userInfoCollection1) {
        this.userInfoCollection1 = userInfoCollection1;
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
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserInfo[ id=" + id + " ]";
    }
    
}
