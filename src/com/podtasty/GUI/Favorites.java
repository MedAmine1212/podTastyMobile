/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.gif.GifImage;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.callSerially;
import static com.codename1.ui.CN.getResourceAsStream;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
import com.podtasty.entities.Podcast;
import com.podtasty.services.LoadImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class Favorites extends com.codename1.ui.Form {
    ArrayList<Podcast> podcasts;
    
    public Favorites() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Favorites(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToHome()));
        Image loading;
        try {
            loading = GifImage.decode(getResourceAsStream("/spinner.gif"), 1177720);
            gui_loadingImg.setImage(loading);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
private void backToHome() {
   
    this.deinitialize();
    HomeView.destroyFavViews();
    PodTasty.getHomeView().show();
}
 public void setPodcasts(ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
        setUpView();
    }
 
    public void removeComp(PodcastView podView){
        gui_podcastContainer.removeComponent(podView);
          this.gui_podcastContainer.refreshTheme();
          gui_bigContainer.refreshTheme();
          this.refreshTheme();
          if(gui_podcastContainer.getChildrenAsList(true).size() == 0) {
              showEmpty();
          }
          
    }
    private void showEmpty() {
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(FlowLayout.encloseCenter(new Label("No podcasts to show")));
    }
 private void addPodToView(Podcast pod) {
        Style style = this.getAllStyles();
        PodcastView podView = new PodcastView();
        podView.setUpView(pod, true);
        podView.getToolbar().hideToolbar();
        if (pod.getPodcastImage() != null) {
        new Thread(() -> {
            callSerially(() -> {
                LoadImage loader = new LoadImage(pod.getPodcastImage(), podView, false);
                loader.start();
                loader = null;
            });
       
        }).start();
        }
          if (pod.getPlaylistIdId().getChannelIdId().getUser().getUserInfoIdId().getUserImage() != null) {
        new Thread(() -> {
            callSerially(() -> {
                LoadImage loader = new LoadImage(pod.getPlaylistIdId().getChannelIdId().getUser().getUserInfoIdId().getUserImage(), podView, true);
                loader.start();
                loader = null;
            });
       
        }).start();
        }
          podView.addDelButt(this);
         this.gui_podcastContainer.addComponent(TOP, podView);
          this.gui_podcastContainer.refreshTheme();
          gui_bigContainer.refreshTheme();
          this.refreshTheme();
    }
    private void setUpView(){
        int i =0;
            gui_podcastContainer.removeAll();
            this.gui_loadingImg.setVisible(true);
            this.gui_podcastContainer.refreshTheme();
            gui_bigContainer.refreshTheme();
            this.refreshTheme();
             if (this.podcasts != null) {
                if (this.podcasts.size() > 0) {
                    for(Podcast pod: podcasts) {
                            i++;
                            addPodToView(pod);
                    }
                } else {
                    showEmpty();
                 i++;
                }
            } else {
                 showEmpty();
                 i++;
             }
             if (i == 0) {
                showEmpty();
             }

            this.gui_loadingImg.setVisible(false);
            this.gui_podcastContainer.refreshTheme();
            gui_bigContainer.refreshTheme();
            this.refreshTheme();
        }
////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_bigContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_podcastContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_loadingImg = new com.codename1.components.ImageViewer();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Favorites");
        setName("Favorites");
                gui_bigContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_bigContainer.setName("bigContainer");
        addComponent(gui_bigContainer);
        gui_Label.setText("Favorites");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:80px;");
        gui_Label.setName("Label");
        gui_podcastContainer.setScrollableY(true);
                gui_podcastContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastContainer.setName("podcastContainer");
                gui_loadingImg.setInlineStylesTheme(resourceObjectInstance);
        gui_loadingImg.setName("loadingImg");
        gui_bigContainer.addComponent(gui_Label);
        gui_bigContainer.addComponent(gui_podcastContainer);
        gui_bigContainer.addComponent(gui_loadingImg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_bigContainer.getParent().getLayout()).setInsets(gui_bigContainer, "5.0mm 1.0mm 5.0mm 5.0mm").setReferenceComponents(gui_bigContainer, "-1 -1 -1 -1").setReferencePositions(gui_bigContainer, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
