package com.podtasty.app;

import static com.codename1.ui.CN.*;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.Toolbar;
import com.podtasty.GUI.HomeView;
import com.podtasty.GUI.PodcastComments;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.User;
import com.podtasty.services.LoadAudio;
import com.podtasty.services.ServicePodcast;
import com.podtasty.services.ServiceTag;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class PodTasty{
    private static HomeView homeview;
    private Form current;
    private Resources theme;
    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

       addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public static HomeView getHomeView() {
        return homeview;
    }
    public void start() {
        
        //set ccurrentUser
        ArrayList<User> u= ServiceUser.getInstance().getUserById(5);
        HomeView.setCurrentUser(u.get(0));
        //end
        
        homeview = new HomeView();
        try{
            homeview.show();
            new Thread(() -> {
                callSerially(() -> {
                    homeview.setPodcastsAndTags(ServiceTag.getInstance().getTags(),ServicePodcast.getInstance().getPodcasts());
                    });
             }).start();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
//        try {
//            Podcast pod = new Podcast();
//            pod.setId(1);
//            pod.setPodcastName("test Pod");
//            pod.setPodcastDescription("Description");
//            pod.setCommentsAllowed(1);
//            PodcastComments.setCurrentPodcast(pod);
//            PodcastComments podCom = new PodcastComments();
//            podCom.show();
//            podCom.setUpView(false);
//        } catch (IOException | URISyntaxException ex) {
//            System.out.println(ex.getMessage());
//        }
        
       
    }

    public void stop() {
        LoadAudio ld = LoadAudio.getInstance();
        try {
            ld.stopAudio();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        LoadAudio.destroyInstance();
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
