/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.entities;

import com.podtasty.services.ServiceUser;
import java.util.ArrayList;

/**
 *
 * @author Douiri Amine
 */
public final class UserHolder {
     private User user;
  private final static UserHolder INSTANCE = new UserHolder();
  
  private UserHolder() {}
  
  
  public void setUser(User u) {
    this.user = u;
  }
  
  public User getUser() {
    return this.user;
  }
   public static UserHolder  getInstance() {
    return INSTANCE;
  }
   
   public static void refreshCurrentUser() {
        ArrayList<User> u= ServiceUser.getInstance().getUserById(UserHolder.getInstance().getUser().getId());
        UserHolder.getInstance().setUser( u.get(0));
        }
   
}
