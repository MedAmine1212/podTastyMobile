/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ext.codescan.CodeScanner;
import com.codename1.ext.codescan.ScanResult;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import static com.codename1.ui.CN.callSerially;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.User;
import com.podtasty.services.LoadAudio;
import com.podtasty.services.ServicePodcast;
import com.podtasty.services.ServicePodcastComment;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class PodcastComments extends com.codename1.ui.Form {

    private static Podcast currentPod;
    private static User currentUser;
    LoadAudio audioLoader;
    
    public PodcastComments() throws IOException, URISyntaxException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public PodcastComments(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException{
        currentUser = new User();
        currentUser.setId(5);
        currentPod = new Podcast();
        currentPod.setId(10);
        currentPod.setPodcastName("Podcast 1");
        currentPod.setPodcastDescription("This is a description");
        currentPod.setPodcastViews(120);
        currentPod.setPodcastSource("6074b2a184d44.mp3");
        currentPod.setPodcastImage("2f0ec7ff2aa6ea0871bfb26e324683bd.jpeg");
        initGuiBuilderComponents(resourceObjectInstance);       

    }
    
    public void setUpView(){
         gui_commentsContainer.setPreferredSizeStr("AUTO");
         gui_playerAndLoading.setPreferredSizeStr("AUTO");
        gui_Box_Layout_Y.setPreferredSizeStr("AUTO");
        gui_addComButton.setEnabled(false);
       gui_podcastDescription.setText(currentPod.getPodcastDescription());
        gui_podcastViews.setText(currentPod.getPodcastViews()+" Views");
        gui_podcastName.setText(currentPod.getPodcastName());
        new Thread(() -> {
            callSerially(() -> {
        audioLoader = LoadAudio.getInstance();
        audioLoader.setAudioUrl(currentPod.getPodcastSource());
        audioLoader.start();
         });
        
        }).start();
        try {
        URL url = new URL(Statics.BASE_URL+"/Files/podcastFiles/"+currentPod.getPodcastImage());
          URL.URLConnection httpcon = url.openConnection();
         InputStream stream = new BufferedInputStream(httpcon.getInputStream());
         Image img = Image.createImage(stream);
        gui_podcastImage.setImage(img);
        } catch(IOException | URISyntaxException ex) {
            System.out.println("Podcast Image Exception: "+ex.getMessage());
        }
         
             try {
                 
         InputStream in = Display.getInstance().getResourceAsStream(null, "/loadingComment.gif");
               Image  loadImg = Image.createImage(in);
                gui_loadingCom.setImage(loadImg);
                gui_loading2.setImage(loadImg);
                gui_loading3.setImage(loadImg);
                gui_loading4.setImage(loadImg);
             } catch (IOException ex) {
                 System.out.println(ex.getMessage());
             }
        gui_commentsCount.setVisible(false);
        gui_addCommentText.setVisible(false);
        gui_addComButton.setVisible(false);
        gui_playerAndLoading.refreshTheme();
        gui_playerAndLoading.revalidate();
        new Thread(() -> {
            callSerially(() -> {
                showComments(); 
                
                gui_loading2.remove();
                gui_loading3.remove();
                gui_loading4.remove();
                gui_loadingCom.remove();
                gui_commentsCount.setVisible(true);
                gui_addCommentText.setVisible(true);
                gui_addComButton.setVisible(true);
                gui_commentsContainer.refreshTheme();
                gui_playerAndLoading.refreshTheme();
                
            });
        
        }).start();

    }
    public void showComments() { 
        List<Component> list = gui_commentsContainer.getChildrenAsList(true);
        for(Component comp: list) {
            gui_commentsContainer.removeComponent(comp);
        }
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
         addComToContainer(comment, 1);
        }
        
    }
    
    public void addComToContainer(PodcastComment comment, int sender) {
          try {
                CommentView comView = new CommentView();
                comView.setView(comment, this);
                comView.getToolbar().hideToolbar();
                if(sender == 1){
                    
                gui_commentsContainer.addComponent(comView);
                } else {
                gui_commentsContainer.addComponent(TOP, comView);
                }
            } catch (URISyntaxException ex) {
                System.out.println("Img error1: "+ex.getMessage());
            } catch (IOException ex) {
                System.out.println("Img error2: "+ex.getMessage());
            }
    }
    
     public void removeCommentView(CommentView comView) {
        gui_commentsContainer.removeComponent(comView);
         String comNumb = gui_commentsCount.getText();
        comNumb = comNumb.substring(0, comNumb.indexOf(" "));
        int comNum = Integer.parseInt(comNumb);
        if (comNum == 1) {
           gui_commentsCount.setText("No comments on this podcast");
        } else if (comNum == 2) {
            gui_commentsCount.setText("1 Comment");
        } 
        
        else {
            
        gui_commentsCount.setText((--comNum)+" Comments");
        
        }
            
        gui_commentsContainer.refreshTheme();
    }
    
     public void updateCommentView() {
        gui_commentsContainer.refreshTheme();
    }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_Y_1  = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_toolsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_qrCodeScanButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_playerAndLoading = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_podcastImage = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Button gui_playStopButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_podcastName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_podcastViews = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_Y_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.SpanLabel gui_podcastDescription = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.components.ImageViewer gui_loading2 = new com.codename1.components.ImageViewer();
    protected com.codename1.components.ImageViewer gui_loading4 = new com.codename1.components.ImageViewer();
    protected com.codename1.components.ImageViewer gui_loading3 = new com.codename1.components.ImageViewer();
    protected com.codename1.components.ImageViewer gui_loadingCom  = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Label gui_commentsCount = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.TextField gui_addCommentText = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_addComButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_commentsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_qrCodeScanButton.addActionListener(callback);
        gui_playStopButton.addActionListener(callback);
        gui_addCommentText.addDataChangedListener(new EventCallbackClass(gui_addCommentText));
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

            if(sourceComponent == gui_qrCodeScanButton) {
                onqrCodeScanButtonActionEvent(ev);
            }
            if(sourceComponent == gui_playStopButton) {
                onplayStopButtonActionEvent(ev);
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
        gui_Box_Layout_Y.setPreferredSizeStr("100.127014mm 160.24556mm");
        gui_Box_Layout_Y.setScrollableY(false);
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setInlineAllStyles("bgColor:ffffff;");
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
                gui_Box_Layout_Y_1 .setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1 .setInlineAllStyles("bgColor:ffffff;");
        gui_Box_Layout_Y_1 .setName("Box_Layout_Y_1 ");
        gui_commentsContainer.setPreferredSizeStr("inherit 125.7409mm");
                gui_commentsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_commentsContainer.setName("commentsContainer");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_Y_1 );
                gui_toolsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_toolsContainer.setName("toolsContainer");
        gui_playerAndLoading.setPreferredSizeStr("83.61558mm 191.15157mm");
                gui_playerAndLoading.setInlineStylesTheme(resourceObjectInstance);
        gui_playerAndLoading.setInlineAllStyles("bgColor:ffffff;");
        gui_playerAndLoading.setName("playerAndLoading");
        gui_Box_Layout_Y_1 .addComponent(gui_toolsContainer);
                gui_qrCodeScanButton.setInlineStylesTheme(resourceObjectInstance);
        gui_qrCodeScanButton.setInlineAllStyles("font:40px;");
        gui_qrCodeScanButton.setName("qrCodeScanButton");
        com.codename1.ui.FontImage.setMaterialIcon(gui_qrCodeScanButton,"\ue3a3".charAt(0));
        gui_toolsContainer.addComponent(gui_qrCodeScanButton);
        gui_Box_Layout_Y_1 .addComponent(gui_playerAndLoading);
                gui_podcastImage.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastImage.setName("podcastImage");
        gui_playStopButton.setText("   ");
                gui_playStopButton.setInlineStylesTheme(resourceObjectInstance);
        gui_playStopButton.setInlineAllStyles("font:60px;");
        gui_playStopButton.setName("playStopButton");
        com.codename1.ui.FontImage.setMaterialIcon(gui_playStopButton,"\ue038".charAt(0));
        gui_playStopButton.setDisabledIcon(com.codename1.ui.FontImage.createMaterial("\ue000".charAt(0), gui_playStopButton.getDisabledStyle()));
        gui_podcastName.setText(" ");
                gui_podcastName.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastName.setInlineAllStyles("font:70px; alignment:left;");
        gui_podcastName.setName("podcastName");
        gui_podcastViews.setText(" ");
                gui_podcastViews.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastViews.setInlineAllStyles("font:40px;");
        gui_podcastViews.setName("podcastViews");
        gui_Box_Layout_Y_2.setScrollableY(true);
                gui_Box_Layout_Y_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_2.setName("Box_Layout_Y_2");
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_loading2.setPreferredSizeStr("72.607956mm 15.029636mm");
                gui_loading2.setInlineStylesTheme(resourceObjectInstance);
        gui_loading2.setName("loading2");
        gui_loading4.setPreferredSizeStr("72.607956mm 15.029636mm");
                gui_loading4.setInlineStylesTheme(resourceObjectInstance);
        gui_loading4.setName("loading4");
        gui_loading3.setPreferredSizeStr("72.607956mm 15.029636mm");
                gui_loading3.setInlineStylesTheme(resourceObjectInstance);
        gui_loading3.setName("loading3");
        gui_loadingCom .setPreferredSizeStr("72.607956mm 15.029636mm");
                gui_loadingCom .setInlineStylesTheme(resourceObjectInstance);
        gui_loadingCom .setName("loadingCom ");
        gui_commentsCount.setText("Label");
                gui_commentsCount.setInlineStylesTheme(resourceObjectInstance);
        gui_commentsCount.setInlineAllStyles("font:70px;");
        gui_commentsCount.setName("commentsCount");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_playerAndLoading.addComponent(gui_podcastImage);
        gui_playerAndLoading.addComponent(gui_playStopButton);
        gui_playerAndLoading.addComponent(gui_podcastName);
        gui_playerAndLoading.addComponent(gui_podcastViews);
        gui_playerAndLoading.addComponent(gui_Box_Layout_Y_2);
        gui_podcastDescription.setText("podcastDescription");
                gui_podcastDescription.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastDescription.setInlineAllStyles("font:50px;");
        gui_podcastDescription.setName("podcastDescription");
        gui_Box_Layout_Y_2.addComponent(gui_podcastDescription);
        gui_playerAndLoading.addComponent(gui_Label);
        gui_playerAndLoading.addComponent(gui_loading2);
        gui_playerAndLoading.addComponent(gui_loading4);
        gui_playerAndLoading.addComponent(gui_loading3);
        gui_playerAndLoading.addComponent(gui_loadingCom );
        gui_playerAndLoading.addComponent(gui_commentsCount);
        gui_playerAndLoading.addComponent(gui_Box_Layout_X_1);
                gui_addCommentText.setInlineStylesTheme(resourceObjectInstance);
        gui_addCommentText.setName("addCommentText");
        gui_addCommentText.setColumns(8);
        gui_addComButton.setText("Add ");
                gui_addComButton.setInlineStylesTheme(resourceObjectInstance);
        gui_addComButton.setName("addComButton");
        gui_Box_Layout_X_1.addComponent(gui_addCommentText);
        gui_Box_Layout_X_1.addComponent(gui_addComButton);
        gui_Box_Layout_Y.addComponent(gui_commentsContainer);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
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
        
        new Thread(() -> {
            callSerially(() -> {
                  
        ServicePodcastComment sr = ServicePodcastComment.getInstance();
        PodcastComment com = new PodcastComment();
        com.setCommentText(gui_addCommentText.getText());
        com.setPodcastIdId(currentPod);
        com.setUserIdId(currentUser);
        com = sr.addComment(com);
        gui_addCommentText.setText("");
        if(com.getId() == -1) {
            
            System.out.println("comments blocked");
        } else if(com.getId() == -2) {
            
            System.out.println("bad word");
            } else {
            
            String comNumb = gui_commentsCount.getText();
            if (comNumb.equals("No comments on this podcast")) {
                gui_commentsCount.setText("1 Comment");
            } else {
                comNumb = comNumb.substring(0, comNumb.indexOf(" "));
                int comNum = Integer.parseInt(comNumb);
                gui_commentsCount.setText((++comNum)+" Comments");
            }
            addComToContainer(com, 0); 
            gui_commentsContainer.refreshTheme();
            
        }
        
               });
        }).start();
    }

   public void onplayStopButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if(!audioLoader.isPlaying()){
            FontImage.setMaterialIcon(gui_playStopButton, FontImage.MATERIAL_PAUSE_CIRCLE_FILLED);
            audioLoader.startAudio();
        } else {
            
            FontImage.setMaterialIcon(gui_playStopButton, FontImage.MATERIAL_PLAY_CIRCLE_FILLED);
            audioLoader.pauseAudio();

        }
  }
 public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        PodcastComments.currentUser = currentUser;
 }  
    public void onqrCodeScanButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
      if (CodeScanner.isSupported()) {
         
        try {
          CodeScanner.getInstance().scanBarCode(new ScanResult() {

        @Override
        public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
            //barCode.setText("Bar: " + contents);
            ServicePodcast sr = ServicePodcast.getInstance();
            float id = Float.parseFloat(contents);
            Podcast pod = sr.getPodcastById((int)id);
            
            if (pod != null) {
                if (pod.getIsBlocked() == 1) {
                    
                Dialog.show("Notice", "This podcast is currently blocked and can't be loaded.", "Ok", null);
                } else {
                    
                currentPod = pod;
                setUpView();
                
                }
            } else{
                Dialog.show("Error", "There was an error loading this podcast.", "Ok", null);
            }
                
        }

        @Override
        public void scanCanceled() {
            System.out.println("cancelled");
        }

        @Override
        public void scanError(int errorCode, String message) {
            System.out.println("err " + message);
        }
    }); 
      } catch(Exception e) {
                Dialog.show("Error", "Qr code is not supported by this app", "Ok", null);

      }
         
      } else {
           Dialog.show("Error", "Qr code scanner is not supported by this device", "Ok", null);
      }
    }
 
}