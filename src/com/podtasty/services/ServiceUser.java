/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.User;
import com.podtasty.entities.UserInfo;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        if(obj.get("UserEmail") != null) {
            String email = obj.get("UserEmail").toString();
            user.setUserEmail(email);
            boolean isAdmin = Boolean.parseBoolean(obj.get("isAdmin").toString());
            user.setIsAdmin(isAdmin);

            boolean DesactiveAccount = Boolean.parseBoolean(obj.get("DesactiveAccount").toString());
            user.setIsAdmin(DesactiveAccount);
        }
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
        if (obj.get("UserImage") != null) {
            userInfo.setUserImage(obj.get("UserImage").toString());
        }
        if (obj.get("UserGender") != null) {
        userInfo.setUserGender(obj.get("UserGender").toString());
        }
        if (obj.get("UserBio") != null) {
            userInfo.setUserBio(obj.get("UserBio").toString());
        }
        if (obj.get("UserBirthDate") != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = obj.get("UserBirthDate").toString().substring(0, 10);
            userInfo.setUserBirthDate(date1);
            
        }
        
        return userInfo;
    }
    
    public ArrayList<User> getUserById(int id) {
        String url = Statics.BASE_URL + "/mobile/getUserById/" + id;
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
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
        String url = Statics.BASE_URL + "/mobile/getUserByMail/" + mail;
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
        
        String url = Statics.BASE_URL + "/mobile/login";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
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
        String url = Statics.BASE_URL + "/mobile/getUserInfoById/" + id;
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
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
        String url = Statics.BASE_URL + "/mobile/CheckMail";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("mail", mail);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    if (req.getResponseCode() == 200) {
                        ok = true;
                    } else {
                        ok = false;
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
        String url = Statics.BASE_URL + "/mobile/addUser";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
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
    
    public boolean ContinueReg(User u) {
        String url = Statics.BASE_URL + "/mobile/continueReg";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("id", u.getId().toString());
        req.addArgument("gender", u.getUserInfoIdId().getUserGender());
        req.addArgument("birthdate", u.getUserInfoIdId().getUserBirthDate());
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
    int nb = 0;
    
    public int getfollowers(User u) {
        String url = Statics.BASE_URL + "/mobile/getFollowers";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("id", u.getId().toString());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String jsonText = new String(req.getResponseData());
                /* jsonText = "[" + jsonText + "]";
                JSONParser j = new JSONParser();
                /* Map<String, Object> userJSON = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                List<Map<String, Object>> list = (List<Map<String, Object>>) userJSON.get("root");
                for (Map<String, Object> obj : list) {
                nb=Integer.parseInt(obj.get("followers").toString());
                }
                 */
                nb = Integer.parseInt(jsonText);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        return nb;
    }
    
    public int getfollowing(User u) {
        String url = Statics.BASE_URL + "/mobile/getFollowing";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("id", u.getId().toString());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String jsonText = new String(req.getResponseData());
                
                nb = Integer.parseInt(jsonText);
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        return nb;
    }
    public boolean desactiveAccount(User u){
        String url = Statics.BASE_URL + "/mobile/desactiveAccount";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("id", u.getId().toString());
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
    public boolean updateProfile(int id,String fs,String ls,String bio){
        String url = Statics.BASE_URL + "/mobile/updateProfile";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("id",String.valueOf(id));
        req.addArgument("firstanme", fs);
        req.addArgument("lastname", ls);
        req.addArgument("bio", bio);
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
    public boolean updateProfilPic(User u, String path, String name) {
        String url = Statics.BASE_URL + "/mobile/updatePic";
        MultipartRequest request=new MultipartRequest();
        request.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        try {
            request.addArgument("id", u.getId().toString());
            request.addData("myFile", path, "image/png");
            request.setFilename("fileUpload", name);

        } catch (IOException ex) {
            System.out.print(ex);
        }
        request.setPriority(ConnectionRequest.PRIORITY_CRITICAL);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ok = req.getResponseCode() == 200;
                
            }
        });
        NetworkManager.getInstance().addToQueue(request);
        return ok;
    }
    
    public boolean follow (int idCurrent, int idOther){
        String url = Statics.BASE_URL + "/mobile/follow";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("idCurrent",String.valueOf(idCurrent));
        req.addArgument("idOther", String.valueOf(idOther));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    if (req.getResponseCode() == 200) {
                        ok = true;
                    } else {
                        ok = false;
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
    public boolean unfollow (int idCurrent, int idOther){
        String url = Statics.BASE_URL + "/mobile/unfollow";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("idCurrent",String.valueOf(idCurrent));
        req.addArgument("idOther", String.valueOf(idOther));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    if (req.getResponseCode() == 200) {
                        ok = true;
                    } else {
                        ok = false;
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
    
    public boolean checkFollowed(int idCurrent, int idOther){
        String url = Statics.BASE_URL + "/mobile/CheckFollowed";
        req.setUrl(url);
        try{
         req.setPost(false);
        }catch(Exception ex) {}
        req.addArgument("idCurrent",String.valueOf(idCurrent));
        req.addArgument("idOther", String.valueOf(idOther));
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    if (req.getResponseCode() == 200) {
                        ok = true;
                    } else {
                        ok = false;
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println("response: "+ok);
        return ok;
        
      
    }
    
}