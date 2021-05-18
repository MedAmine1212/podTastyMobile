/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.ui.Image;
import com.podtasty.GUI.CommentView;
import com.podtasty.GUI.PodcastView;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ConcurrentModificationException;

/**
 *
 * @author khail
 */
public class LoadImage extends Thread{
    String imgUrl;
    CommentView comView;
    PodcastView podView;
    boolean isUser;
    public LoadImage(String url, CommentView view) {
        this.imgUrl = url;
        this.comView = view;
    }
    
    
    public LoadImage(String url, PodcastView view, boolean isUser) {
        this.imgUrl = url;
        this.podView = view;
        this.isUser = isUser;
    }
    
     @Override
    public void run() {
             try {
                URL url = new URL(Statics.BASE_URL+"/Files/podcastFiles/"+imgUrl);
                URL.URLConnection httpcon = url.openConnection();
                InputStream stream = new BufferedInputStream(httpcon.getInputStream());
                Image userImg = Image.createImage(stream);
                if (podView != null) {
                    if (isUser) {
                    podView.setOwnerImage(userImg);
                    } else {
                    podView.setPodcastImg(userImg);
                    }
                    podView.refreshTheme();
                    podView.repaint();
                } else {
                    comView.setUserImg(userImg);
                    comView.refreshTheme();
                    comView.repaint();
                }
             } catch (NullPointerException | IOException | URISyntaxException | ConcurrentModificationException ex) {
                System.out.println(ex.getMessage());
             }
            }
    
}
