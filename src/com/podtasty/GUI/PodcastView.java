/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.LoadAudio;
import com.podtasty.services.ServiceFavorites;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Objects;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class PodcastView extends com.codename1.ui.Form {
SimpleDateFormat simpleDateFormat;
    Podcast pod;
    private boolean isFav;
    public PodcastView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PodcastView(com.codename1.ui.util.Resources resourceObjectInstance) {
        simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
        initGuiBuilderComponents(resourceObjectInstance);
    }
 
    public void setPodcastImg(Image img) {
        gui_podcastImage.setIcon(img);
    }
    public void setOwnerImage(Image img) {
        gui_ownerImage.setImage(img);
    }
    public void addDelButt(Favorites fav) {
        Button delButt = new Button("Remove favorite");
        delButt.addActionListener((e) -> {
            if(ServiceFavorites.getInstance().addRmvFav(pod.getId(), UserHolder.getInstance().getUser().getId())){
                fav.removeComp(this);
            }
        });
        gui_detailsContainer.add(delButt);
    }
    private void destroyAudio() {
                try {
                    LoadAudio.getInstance().stopAudio();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                LoadAudio.destroyInstance();
    }
    private void openPodcast() {
        if (PodcastComments.getCurrentPodcast() != null) {
            if (!Objects.equals(PodcastComments.getCurrentPodcast().getId(), pod.getId())) {
                destroyAudio();
            }
        } else {
                destroyAudio();
            
        }
         PodcastComments podCom;
        try {
            PodcastComments.setCurrentPodcast(pod);
            podCom = new PodcastComments();
            podCom.show();
            podCom.setUpView(isFav);
        } catch (IOException | URISyntaxException ex) {
            System.out.println(ex.getMessage()); 
        }
    }
    public void setUpView(Podcast pod, boolean isFav) {
        this.isFav = isFav;
        this.pod = pod;
        try {
            InputStream in = Display.getInstance().getResourceAsStream(null, "/defPod.png");           
            Image loadImg = Image.createImage(in);
            gui_podcastImage.setIcon(loadImg);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         try {
            InputStream in = Display.getInstance().getResourceAsStream(null, "/roundedAvatar.png");           
            Image  loadImg = Image.createImage(in);
            gui_ownerImage.setImage(loadImg);
        }catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
         Channel channel = pod.getPlaylistIdId().getChannelIdId();
         gui_owner.setText(channel.getChannel_Name());
         gui_podName.setText(pod.getPodcastName());
         gui_podName.addPointerPressedListener((e) ->{
            
             openPodcast();
         });
         gui_owner.addPointerPressedListener((e) ->{
             // 7el Chaine
         });
         gui_views.setText(pod.getPodcastViews()+" views");
        String date = simpleDateFormat.format(pod.getPodcastDate());  
         gui_date.setText(date);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Button gui_podcastImage = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.components.ImageViewer gui_ownerImage = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Container gui_detailsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Label gui_owner = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_spaceLabel  = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_podName = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Label gui_views = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_slash = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_date = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_podcastImage.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_podcastImage) {
                onpodcastImageActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("PodcastView");
        setName("PodcastView");
        gui_Box_Layout_Y.setPreferredSizeStr("53.767994mm 68.79763mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_podcastImage.setPreferredSizeStr("80.22862mm 35.3514mm");
                gui_podcastImage.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastImage.setInlineAllStyles("margin:inherit 2.0mm inherit inherit;");
        gui_podcastImage.setName("podcastImage");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setInlineAllStyles("padding:2.0mm inherit inherit inherit;");
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Box_Layout_Y.addComponent(gui_podcastImage);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
        gui_ownerImage.setPreferredSizeStr("13.547841mm 13.759526mm");
                gui_ownerImage.setInlineStylesTheme(resourceObjectInstance);
        gui_ownerImage.setName("ownerImage");
                gui_detailsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_detailsContainer.setName("detailsContainer");
        gui_Box_Layout_X.addComponent(gui_ownerImage);
        gui_Box_Layout_X.addComponent(gui_detailsContainer);
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setInlineAllStyles("padding:2.0mm inherit inherit inherit;");
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_detailsContainer.addComponent(gui_Box_Layout_Y_1);
                gui_owner.setInlineStylesTheme(resourceObjectInstance);
        gui_owner.setName("owner");
        gui_spaceLabel .setText("- ");
                gui_spaceLabel .setInlineStylesTheme(resourceObjectInstance);
        gui_spaceLabel .setName("spaceLabel ");
                gui_podName.setInlineStylesTheme(resourceObjectInstance);
        gui_podName.setName("podName");
        gui_Box_Layout_Y_1.addComponent(gui_owner);
        gui_Box_Layout_Y_1.addComponent(gui_spaceLabel );
        gui_Box_Layout_Y_1.addComponent(gui_podName);
        gui_detailsContainer.addComponent(gui_Box_Layout_X_1);
                gui_views.setInlineStylesTheme(resourceObjectInstance);
        gui_views.setName("views");
        gui_slash.setText("-");
                gui_slash.setInlineStylesTheme(resourceObjectInstance);
        gui_slash.setName("slash");
        gui_date.setText("  ");
                gui_date.setInlineStylesTheme(resourceObjectInstance);
        gui_date.setName("date");
        gui_Box_Layout_X_1.addComponent(gui_views);
        gui_Box_Layout_X_1.addComponent(gui_slash);
        gui_Box_Layout_X_1.addComponent(gui_date);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0px 0px 1.0mm 0px").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onpodcastImageActionEvent(com.codename1.ui.events.ActionEvent ev) {
        openPodcast();
    }

}
