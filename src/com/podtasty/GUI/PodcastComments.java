/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.ui.Image;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.User;
import com.podtasty.services.ServicePodcastComment;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class PodcastComments extends com.codename1.ui.Form {

    private static Podcast currentPod;
    private static User currentUser;
    
    public PodcastComments() throws IOException, URISyntaxException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PodcastComments(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException, URISyntaxException {
        currentUser = new User();
        currentUser.setId(5);
        initGuiBuilderComponents(resourceObjectInstance);
        gui_addComButton.setEnabled(false);
        currentPod = new Podcast();
        currentPod.setId(10);
        currentPod.setPodcastName("Podcast 1");
        currentPod.setPodcastDescription("This is a description");
        currentPod.setPodcastViews(120);
        currentPod.setPodcastSource("6074b2a184d44.mp3");
        currentPod.setPodcastImage("2f0ec7ff2aa6ea0871bfb26e324683bd.jpeg");
       gui_podcastDescription.setText(currentPod.getPodcastDescription());
        gui_podcastViews.setText(currentPod.getPodcastViews()+" Views");
        gui_podcastName.setText(currentPod.getPodcastName());
        URL url = new URL("http://127.0.0.1:8000/Files/podcastFiles/"+currentPod.getPodcastImage());
          URL.URLConnection httpcon = url.openConnection();
         InputStream stream = new BufferedInputStream(httpcon.getInputStream());
         Image img = Image.createImage(stream);
        gui_podcastImage.setImage(img);
        showComments();

    }
    
    public void showComments() { 
        ServicePodcastComment sr = ServicePodcastComment.getInstance();
        ArrayList<PodcastComment> comList = sr.getCommentsByPodcastId(currentPod);
        Collections.reverse(comList);
        if(comList.size() > 0) {
            
        if(comList.size() > 1) {
            gui_commentsCount.setText(comList.size()+" Comments");   

        } else {
            
            gui_commentsCount.setText("1 Comment");
        }
        }else {
            gui_commentsCount.setText("No comments on this podcast");
        }
        
        for(PodcastComment comment : comList){
            try {
                CommentView comView = new CommentView();
                comView.setView(comment);
                comView.getToolbar().hideToolbar();
                gui_commentsContainer.add(comView);
            } catch (URISyntaxException ex) {
                System.out.println("Img error1: "+ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Img error2: "+ex.getMessage());
            }
        }
        
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_podcastImage = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Button gui_playStopButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_podcastName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_podcastViews = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_Y_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.SpanLabel gui_podcastDescription = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_commentsCount = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.TextField gui_addCommentText = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_addComButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_commentsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        gui_addCommentText.addDataChangedListener(new EventCallbackClass(gui_addCommentText));
        EventCallbackClass callback = new EventCallbackClass();
        gui_addComButton.addActionListener(callback);
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

            if(sourceComponent == gui_addComButton) {
                onaddComButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
            onaddCommentTextDataChangeEvent(cmp, type, index);
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("PodcastComments");
        setName("PodcastComments");
        gui_Box_Layout_Y.setPreferredSizeStr("100.127014mm 159.6105mm");
        gui_Box_Layout_Y.setScrollableY(true);
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_X.setScrollableY(false);
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_commentsContainer.setPreferredSizeStr("inherit 157.70534mm");
        gui_commentsContainer.setScrollableY(true);
                gui_commentsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_commentsContainer.setName("commentsContainer");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        gui_Box_Layout_X.addComponent(gui_Box_Layout_Y_1);
                gui_podcastImage.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastImage.setName("podcastImage");
        gui_playStopButton.setText("   ");
                gui_playStopButton.setInlineStylesTheme(resourceObjectInstance);
        gui_playStopButton.setInlineAllStyles("font:60px;");
        gui_playStopButton.setName("playStopButton");
        com.codename1.ui.FontImage.setMaterialIcon(gui_playStopButton,"\ue038".charAt(0));
        gui_podcastName.setText("Label");
                gui_podcastName.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastName.setInlineAllStyles("font:70px; alignment:left;");
        gui_podcastName.setName("podcastName");
        gui_podcastViews.setText("Label");
                gui_podcastViews.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastViews.setInlineAllStyles("font:40px;");
        gui_podcastViews.setName("podcastViews");
        gui_Box_Layout_Y_2.setScrollableY(true);
                gui_Box_Layout_Y_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_2.setName("Box_Layout_Y_2");
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_commentsCount.setText("Label");
                gui_commentsCount.setInlineStylesTheme(resourceObjectInstance);
        gui_commentsCount.setInlineAllStyles("font:70px;");
        gui_commentsCount.setName("commentsCount");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_Box_Layout_Y_1.addComponent(gui_podcastImage);
        gui_Box_Layout_Y_1.addComponent(gui_playStopButton);
        gui_Box_Layout_Y_1.addComponent(gui_podcastName);
        gui_Box_Layout_Y_1.addComponent(gui_podcastViews);
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_Y_2);
        gui_podcastDescription.setText("podcastDescription");
                gui_podcastDescription.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastDescription.setInlineAllStyles("font:50px;");
        gui_podcastDescription.setName("podcastDescription");
        gui_Box_Layout_Y_2.addComponent(gui_podcastDescription);
        gui_Box_Layout_Y_1.addComponent(gui_Label);
        gui_Box_Layout_Y_1.addComponent(gui_commentsCount);
        gui_Box_Layout_Y_1.addComponent(gui_Box_Layout_X_1);
                gui_addCommentText.setInlineStylesTheme(resourceObjectInstance);
        gui_addCommentText.setName("addCommentText");
        gui_addCommentText.setColumns(13);
        gui_addComButton.setEnabled(true);
        gui_addComButton.setText("Add ");
                gui_addComButton.setInlineStylesTheme(resourceObjectInstance);
        gui_addComButton.setName("addComButton");
        gui_Box_Layout_X_1.addComponent(gui_addCommentText);
        gui_Box_Layout_X_1.addComponent(gui_addComButton);
        gui_Box_Layout_Y.addComponent(gui_commentsContainer);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "5.0mm 5.0mm 5.0mm 5.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    public static Podcast getPod() {
        return currentPod;
    }

    public static void setPod(Podcast pod) {
        PodcastComments.currentPod = pod;
    }

    public void onaddCommentTextDataChangeEvent(com.codename1.ui.Component cmp, int type, int index) {
       if (gui_addCommentText.getText().length() >= 3) {
           gui_addComButton.setEnabled(true);
       } else {
           
           gui_addComButton.setEnabled(false);
       }
    }

    public void onaddComButtonActionEvent(com.codename1.ui.events.ActionEvent ev){
        
        gui_addComButton.setEnabled(false);
        ServicePodcastComment sr = ServicePodcastComment.getInstance();
        PodcastComment com = new PodcastComment();
        com.setCommentText(gui_addCommentText.getText());
        com.setPodcastIdId(currentPod);
        com.setUserIdId(currentUser);
        if(sr.addComment(com)){
            gui_addCommentText.setText("");
            showComments();
        }
    }

}
