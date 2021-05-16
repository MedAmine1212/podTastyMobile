/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.ui.Component;
import com.codename1.ui.Image;
import com.codename1.ui.Stroke;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.podtasty.GUI.CommentView;
import com.podtasty.entities.PodcastComment;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 *
 * @author khail
 */
public class LoadImage extends Thread{
    PodcastComment comm;
    CommentView view;
    public LoadImage(PodcastComment comm, CommentView view) {
        this.comm = comm;
        this.view = view;
    }
    
     @Override
    public void run() {
        
         if(comm.getUserIdId().getUserInfoIdId().getUserImage() != null) {
                    
             try {
                URL url = new URL(Statics.BASE_URL+"/Files/podcastFiles/"+comm.getUserIdId().getUserInfoIdId().getUserImage());
                URL.URLConnection httpcon = url.openConnection();
                InputStream stream = new BufferedInputStream(httpcon.getInputStream());
                
                Image userImg = Image.createImage(stream);
                view.setUserImg(userImg);
                
                
                view.refreshTheme();
                view.repaint();
             } catch (Exception ex) {
                System.out.println(ex.getMessage());
             }
            }
    }
    
}
