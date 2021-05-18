/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.User;
import com.podtasty.entities.UserHolder;
import com.podtasty.entities.UserInfo;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author khail
 */
public class ServiceUser {

    public ArrayList<User> users;
    public ArrayList<UserInfo> usersInfo;

    private static ServiceUser instance = null;
    public boolean resultOK;
    private ConnectionRequest req;
    boolean ok = false;

    public ServiceUser() {
        req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }

    // !important !!!! test 3la kol obj.("faza") null walé 9bal; sinin baaarcha errors
    public ArrayList<User> parseUsers(String jsonText) throws IOException {
        users = new ArrayList<>();
        jsonText = "[" + jsonText + "]";
        JSONParser j = new JSONParser();
        Map<String, Object> userJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
        List<Map<String, Object>> list = (List<Map<String, Object>>) userJSON.get("root");

        for (Map<String, Object> obj : list) {
            User user = parseUser(obj);
            users.add(user);
        }

        return users;
    }

    public User parseUser(Map<String, Object> obj) {
        User user = new User();
        float id = Float.parseFloat(obj.get("id").toString());
        user.setId((int) id);
        String email = obj.get("UserEmail").toString();
        user.setUserEmail(email);
        boolean isAdmin = Boolean.parseBoolean(obj.get("isAdmin").toString());
        user.setIsAdmin(isAdmin);

        boolean DesactiveAccount = Boolean.parseBoolean(obj.get("DesactiveAccount").toString());
        user.setIsAdmin(DesactiveAccount);
        UserInfo userInfo = parseUserInfo((Map<String, Object>) obj.get("UserInfoId"));
        user.setUserInfoIdId(userInfo);
        return user;
    }

    public ArrayList<UserInfo> parseUsersInfo(String jsonText) throws IOException {

        usersInfo = new ArrayList<>();
        JSONParser j = new JSONParser();
        Map<String, Object> podcastJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

        List<Map<String, Object>> list = (List<Map<String, Object>>) podcastJSON.get("root");
        for (Map<String, Object> obj : list) {
            UserInfo userInfo = parseUserInfo(obj);
            usersInfo.add(userInfo);
        }
        return usersInfo;
    }

    public UserInfo parseUserInfo(Map<String, Object> obj) {
        UserInfo userInfo = new UserInfo();
        float id = Float.parseFloat(obj.get("id").toString());
        userInfo.setId((int) id);
        userInfo.setUserFirstName(obj.get("UserFirstName").toString());
        userInfo.setUserLastName(obj.get("UserLastName").toString());
        userInfo.setUserImage(obj.get("UserImage").toString());
        userInfo.setUserGender(obj.get("UserGender").toString());
        if (obj.get("UserBio") != null) {
            userInfo.setUserBio(obj.get("UserBio").toString());
        }
        //   Collection<UserInfo>//; 

        //               userInfo.setFollowers(Arrays.asList(obj.get("Followers")));
        return userInfo;
    }

    public ArrayList<User> getUserById(int id) {
        String url = Statics.BASE_URL + "/getUserById/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    users = parseUsers(new String(req.getResponseData()));
                } catch (IOException ex) {
                    System.out.println("User ex: " + ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public ArrayList<User> getUserByMail(String mail) {
        String url = Statics.BASE_URL + "/getUserByMail/" + mail;
        req.setUrl(url);
//        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    users = parseUsers(new String(req.getResponseData()));
                } catch (IOException ex) {
                    System.out.println("User ex: " + ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }

    public boolean Validate(String mail, String pass) {

        String url = Statics.BASE_URL + "/login";
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("mail", mail);
        req.addArgument("password", pass);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    ok = req.getResponseCode() == 200;

//                    users = getUserByMail(mail);
                    //                  UserHolder holder = UserHolder.getInstance();
                    //holder.setUser(users.get(0));
                    System.out.print(ok);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());

                }

                req.removeResponseListener(this);
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return ok;
    }

    public ArrayList<UserInfo> getUserInfoById(int id) {
        String url = Statics.BASE_URL + "/getUserInfoById/" + id;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    usersInfo = parseUsersInfo(new String(req.getResponseData()));
                } catch (IOException ex) {
                    System.out.println("User info exception: " + ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return usersInfo;
    }

    public boolean checkMailExist(String mail) {
        String url = Statics.BASE_URL + "/CheckMail";
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("mail", mail);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    if(req.getResponseCode() == 200){
                    ok = true;    
                    }else{
                        ok=false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ok;

    }

    public boolean RegisterUser(User u, UserInfo info) {
        String url = Statics.BASE_URL + "/addUser";
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("email", u.getUserEmail());
        req.addArgument("password", u.getUserPassword());
        req.addArgument("firstname", info.getUserFirstName());
        req.addArgument("lastname", info.getUserLastName());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    ok = req.getResponseCode() == 200;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return ok;
    }

}
