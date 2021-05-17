/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;
import com.codename1.components.ImageViewer;
import com.codename1.ext.codescan.ScanResult;
import com.codename1.ext.codescan.CodeScanner;
import com.codename1.gif.GifImage;
import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.callSerially;
import static com.codename1.ui.CN.getResourceAsStream;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.PodcastReview;
import com.podtasty.entities.User;
import com.podtasty.entities.UserInfo;
import com.podtasty.services.LoadAudio;
import com.podtasty.services.LoadImage;
import com.podtasty.services.ServicePodcast;
import com.podtasty.services.ServicePodcastComment;
import com.podtasty.services.ServicePodcastReview;
import com.podtasty.services.ServiceUser;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class PodcastComments extends com.codename1.ui.Form {
    
    private static Podcast currentPod;
    private static User currentUser;
    private Command scanQr;
    private Command report;
    private Command rate;
    private Command podDetails;
    private Command addFav;
    private Command rmvFav;
    private float rating;
    private Container qsContainer;
    private Container qsOneContainer;
    private Container qsTwoContainer;
    private Container qsThreeContainer;
    private Container qsFourContainer;
    private int currentQs;
    Container ratingContainer;
    LoadAudio audioLoader;
    Dialog ratingDialog;
    Container reactions;
    private PodcastReview currentRev;
    
    public PodcastComments() throws IOException, URISyntaxException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    
        Style style = this.getAllStyles();
        scanQr = Command.create("Scan QRCode", FontImage.createMaterial(FontImage.MATERIAL_BLUR_LINEAR, style) , (e) -> scanQrCode());
        podDetails = Command.create("Podcast details", FontImage.createMaterial(FontImage.MATERIAL_INFO_OUTLINE, style) , (e) -> showDetailsDialog());
        report = Command.create("Report", FontImage.createMaterial(FontImage.MATERIAL_FLAG,style), (e) -> reportPodcst());
        rate = Command.create("Rate", FontImage.createMaterial(FontImage.MATERIAL_STAR,style), (e) -> retePodcast());
        addFav = Command.create("Add to favorite", FontImage.createMaterial(FontImage.MATERIAL_FAVORITE_BORDER,style), (e) -> addRmvFav(addFav, rmvFav));
        rmvFav = Command.create("Remove favorite", FontImage.createMaterial(FontImage.MATERIAL_FAVORITE,style), (e) -> addRmvFav(rmvFav, addFav));
        this.getToolbar().addCommandToOverflowMenu(podDetails);
        this.getToolbar().addCommandToOverflowMenu(scanQr);
        if (currentUser != null) {
            this.getToolbar().addCommandToOverflowMenu(report);
            this.getToolbar().addCommandToOverflowMenu(rate);
            if (ServicePodcastComment.getInstance().checkFav(currentPod.getId(),currentUser.getId())) {
                
          this.getToolbar().addCommandToOverflowMenu(rmvFav);
            } else {
                
            this.getToolbar().addCommandToOverflowMenu(addFav);
            }
        }
           
    }
    
    public PodcastComments(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException{
        ArrayList<User> u= ServiceUser.getInstance().getUserById(5);
        currentUser = u.get(0);
        initGuiBuilderComponents(resourceObjectInstance);   
              this.getContentPane().addPullToRefresh(() -> {
                System.out.println("refreshing..");
                    try {
                    audioLoader.stopAudio();
                    
            FontImage.setMaterialIcon(gui_playStopButton, FontImage.MATERIAL_PLAY_CIRCLE_FILLED);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                LoadAudio.destroyInstance();
                currentPod = ServicePodcast.getInstance().getPodcastById(currentPod.getId());
                ArrayList<User> us= ServiceUser.getInstance().getUserById(5);
                currentUser = us.get(0);
                setUpView();
            });

    }
    
    public void setUpView(){
        
        audioLoader = LoadAudio.getInstance();
        audioLoader.setAudioUrl(currentPod.getPodcastSource());
        audioLoader.start();
        
         gui_commentsContainer.setPreferredSizeStr("AUTO");
         gui_playerAndLoading.setPreferredSizeStr("AUTO");
        gui_Box_Layout_Y.setPreferredSizeStr("AUTO");
        
       gui_podcastDescription.setText(currentPod.getPodcastDescription());
        gui_podcastViews.setText(currentPod.getPodcastViews()+" Views");
        gui_podcastName.setText(currentPod.getPodcastName());
        gui_playStopButton.setEnabled(false);
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
                 
               
               Image loadImg = GifImage.decode(getResourceAsStream("/loadingComment.gif"), 1177720);
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
                if (currentPod.getCommentsAllowed() == 1) {
                gui_addComButton.setEnabled(false);
                        gui_addComButton.setVisible(true);
                } else {
                gui_addCommentText.setText("Comments currently disabled");
                gui_addCommentText.setEditable(false);
                gui_addComButton.setVisible(false);
                }
                gui_commentsContainer.refreshTheme();
                gui_playerAndLoading.refreshTheme();
                
            });
        
        }).start();
        gui_playStopButton.setEnabled(true);
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
                
        new Thread(() -> {
            callSerially(() -> {
                LoadImage loader = new LoadImage(comment, comView);
                loader.start();
                loader = null;
            });
       
        }).start();
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




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y  = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_Y_1  = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_toolsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Container gui_playerAndLoading = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_podcastImage  = new com.codename1.components.ImageViewer();
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
        setScrollableX(false);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("PodcastComments");
        setName("PodcastComments");
        gui_Box_Layout_Y .setPreferredSizeStr("100.127014mm 160.24556mm");
        gui_Box_Layout_Y .setScrollableY(false);
                gui_Box_Layout_Y .setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y .setInlineAllStyles("bgColor:ffffff;");
        gui_Box_Layout_Y .setName("Box_Layout_Y ");
        addComponent(gui_Box_Layout_Y );
                gui_Box_Layout_Y_1 .setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1 .setInlineAllStyles("bgColor:ffffff;");
        gui_Box_Layout_Y_1 .setName("Box_Layout_Y_1 ");
        gui_commentsContainer.setPreferredSizeStr("inherit 125.7409mm");
                gui_commentsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_commentsContainer.setName("commentsContainer");
        gui_Box_Layout_Y .addComponent(gui_Box_Layout_Y_1 );
                gui_toolsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_toolsContainer.setName("toolsContainer");
        gui_playerAndLoading.setPreferredSizeStr("83.61558mm 191.15157mm");
                gui_playerAndLoading.setInlineStylesTheme(resourceObjectInstance);
        gui_playerAndLoading.setInlineAllStyles("bgColor:ffffff;");
        gui_playerAndLoading.setName("playerAndLoading");
        gui_Box_Layout_Y_1 .addComponent(gui_toolsContainer);
        gui_Box_Layout_Y_1 .addComponent(gui_playerAndLoading);
                gui_podcastImage .setInlineStylesTheme(resourceObjectInstance);
        gui_podcastImage .setName("podcastImage ");
        gui_playStopButton.setText("   ");
                gui_playStopButton.setInlineStylesTheme(resourceObjectInstance);
        gui_playStopButton.setInlineAllStyles("font:60px; alignment:center;");
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
        gui_playerAndLoading.addComponent(gui_podcastImage );
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
        gui_Box_Layout_Y .addComponent(gui_commentsContainer);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y .getParent().getLayout()).setInsets(gui_Box_Layout_Y , "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Box_Layout_Y , "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y , "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    public static Podcast getCurrentPodcast() {
        return currentPod;
    }

    public static void setCurrentPodcast(Podcast pod) {
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
        this.gui_addComButton.setEnabled(false);
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
            
            Dialog.show("Comment blocked", "Comments are currently disabled for this podcast", "Okay", null);
        } else if(com.getId() == -2) {
            Dialog.show("Comment blocked", "Please watch your langage !", "Okay", null);
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
    public void scanQrCode() {
      
        
      if (CodeScanner.isSupported()) {
         
        try {
          CodeScanner.getInstance().scanQRCode(new ScanResult() {

        @Override
        public void scanCompleted(String contents, String formatName, byte[] rawBytes) {
            ServicePodcast sr = ServicePodcast.getInstance();
            float id = Float.parseFloat(contents);
            Podcast pod = sr.getPodcastById((int)id);
            showNewPod(pod);
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
            Dialog d = new Dialog();
            TextArea label = new TextArea("Qr code scanner not supported on this device. Enter podcast ID",3,20);
            label.setEditable(false);
            label.setEnabled(false);
            TextArea popupBody = new TextArea("", 3, 20);
            popupBody.setUIID("podId");
            d.setLayout(new BorderLayout());
            Button loadButton = new Button();
            loadButton.setText("Load");
            Button cancelButton = new Button();
            cancelButton.setText("Cancel");
            Container buttons = new Container();
            Container pn = new Container();
            buttons.add(loadButton);
            buttons.add(cancelButton);
            pn.add(label);
            pn.add(popupBody);
            pn.add(buttons);
            d.setLayout(new BorderLayout());
            d.add(BorderLayout.CENTER, pn);
            cancelButton.addActionListener(e -> {
            d.dispose();
        
        });
               loadButton.addActionListener(e -> {
           try{
            
            int id =Integer.parseInt(popupBody.getText());
            ServicePodcast sr = ServicePodcast.getInstance();
            Podcast pod = sr.getPodcastById(id);
            showNewPod(pod);
            d.dispose();
            } catch (Exception ex) {
                Dialog.show("Error", "Invalid id", "Try again",null);
            }
        });
        d.show();
      }
    }
 
    public void showNewPod(Podcast pod) {
           
            if (pod != null) {
                if (pod.getIsBlocked() == 1) {
                Dialog.show("Notice", "This podcast is currently blocked and can't be loaded.", "Ok", null);
                } else {
                try {
                    audioLoader.stopAudio();
                    
            FontImage.setMaterialIcon(gui_playStopButton, FontImage.MATERIAL_PLAY_CIRCLE_FILLED);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                LoadAudio.destroyInstance();
                currentPod = pod;
                setUpView();
                
                }
            } else{
                Dialog.show("Error", "There was an error loading this podcast.", "Ok", null);
            }
   
    }
    
    
    public void reportPodcst() {
        
    }
    public Button getImage(String imgName, int rate) {
        
        try {
            Button bt = new Button();
            InputStream in = Display.getInstance().getResourceAsStream(null, "/"+imgName);
            Image im = Image.createImage(in);
            im = im.scaled(110, 110);
            bt.setIcon(im);
            bt.addActionListener((ev) -> {
                rating+= rate;
                nextRatingText();
            });
            return bt;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public void nextRatingText() {
      switch (currentQs) {
            case 1:
                currentQs++;
                qsContainer.removeComponent(qsOneContainer);
                qsContainer.add(qsTwoContainer);
                ratingDialog.refreshTheme(true);
                break;
            case 2:
                currentQs++;
                qsContainer.removeComponent(qsTwoContainer);
                qsContainer.add(qsThreeContainer);
                ratingDialog.refreshTheme(true);
                break;
            case 3:
                currentQs++;
                qsContainer.removeComponent(qsThreeContainer);
                qsContainer.add(qsFourContainer);
                ratingDialog.refreshTheme(true);
                break;
            default:
                reactions.setVisible(false);
                qsContainer.removeComponent(qsFourContainer);
                ratingDialog.dispose();
                showSendingReview();
                break;
        }
    }
    
    private void showSendingReview() {
        if (sendRate()) {
            ratingDialog = new Dialog("Review added successfully !");
            int h = Display.getInstance().getDisplayHeight();
            ImageViewer img = new ImageViewer();
            try {
                InputStream in = Display.getInstance().getResourceAsStream(null, "/realDonut.png");
                img.setImage(Image.createImage(in));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Container cont = FlowLayout.encloseCenter(img);
            ratingDialog.setDisposeWhenPointerOutOfBounds(true);
            ratingDialog.setLayout(new BorderLayout());
            ratingDialog.add(BorderLayout.CENTER, cont);
            ratingDialog.show(h /7 * 5, 0, 0, 0);
        }else {
            Dialog.show("Error", "Couldn't add review", "Clsoe", null);
       }
    }
      private boolean sendRate(){
       rating /=4;
       String strDouble = rating+"";
       
       if (strDouble.contains(".")) {
        strDouble = strDouble.substring(0, strDouble.indexOf(".")+1);
       }
       rating = Float.parseFloat(strDouble);
       PodcastReview review = new PodcastReview();
       review.setPodcastIdId(currentPod);
       review.setUserIdId(currentUser);
       review.setRating(rating);
       System.out.println(review.getRating());
       currentRev = ServicePodcastReview.getInstance().addReview(review);
       if (currentRev != null) {
            currentPod.getPodcastReviewCollection().add(currentRev);
            return true;
       } else {
            return false;
       } 
    }
    
    public void retePodcast(){
        if (currentRev == null) {
        for(PodcastReview rev: currentPod.getPodcastReviewCollection()) {
            if (Objects.equals(rev.getUserIdId().getId(), currentUser.getId())) {
                currentRev = rev;
                break;
            }
        }
        if (currentRev != null) {
            openDelRateDia();
        } else {
            openRateDia();
        }
        } else {
            openDelRateDia();
        }
        
    }
    
    private void openDelRateDia() {
        
        ratingDialog = new Dialog("Podcast rating"); 
        Button delReview = new Button("Delete review");
        delReview.addActionListener((e) -> {
        if (ServicePodcastReview.getInstance().delReview(currentRev.getId())) {
            currentPod.getPodcastReviewCollection().remove(currentRev);
            currentRev = null;
            ratingDialog.dispose();
            Dialog.show("Notice", "Review deleted successfully ! ", "Okay", null);
        }
        });
        Container desc = FlowLayout.encloseCenter(new Label("Your rating to this podcast is"));
        Container ratingCont = FlowLayout.encloseCenter(new Label(currentRev.getRating()+" /10"));
        Container buttonCont = FlowLayout.encloseCenter(delReview);
        
        ratingContainer = new Container();
        ratingContainer.setLayout(new BoxLayout(2));
        ratingContainer.add(desc);
        ratingContainer.add(ratingCont);
        ratingContainer.add(buttonCont);
        ratingDialog.setLayout(new BorderLayout());
        ratingDialog.add(BorderLayout.CENTER, ratingContainer);
      
        int h = Display.getInstance().getDisplayHeight();
        
        ratingDialog.setDisposeWhenPointerOutOfBounds(true);
        ratingDialog.show(h /8 * 6, 0, 0, 0);
  
    }
    private void openRateDia() {
        
        currentQs = 1;
        rating = 0;
        reactions = new Container();
        reactions.setLayout(new BoxLayout(1));
        reactions.setPreferredSizeStr("AUTO");
        //setimages;
        reactions.add(getImage("love.png", 10));
        reactions.add(getImage("like.png", 8));
        reactions.add(getImage("meh.png", 6));
        reactions.add(getImage("dislike.png", 4));
        reactions.add(getImage("hate.png", 2));
        reactions.add(getImage("loath.png", 0));
        //done
        ratingDialog = new Dialog("Rate this Podcast");
        ratingContainer = new Container();
        ratingContainer.setLayout(new BoxLayout(2));
        qsOneContainer = FlowLayout.encloseCenter(new Label("Are you generally happy with this podcast ?"));
        qsTwoContainer = FlowLayout.encloseCenter(new Label("Is the topic interesting ?"));
        qsThreeContainer = FlowLayout.encloseCenter(new Label("What do you think about the host ?"));
        qsFourContainer = FlowLayout.encloseCenter(new Label("Voice quality ?"));
        Container flow = FlowLayout.encloseCenter(new Label(" "));
        Container flowReact = FlowLayout.encloseCenter(reactions);
        qsContainer = FlowLayout.encloseCenter(qsOneContainer);
        ratingContainer.add(qsContainer);
        ratingContainer.add(flow);
        ratingContainer.add(flowReact);
        ratingDialog.setLayout(new BorderLayout());
        ratingDialog.add(BorderLayout.CENTER, ratingContainer);
        int h = Display.getInstance().getDisplayHeight();
        
        ratingDialog.setDisposeWhenPointerOutOfBounds(true);
        ratingDialog.show(h /7 * 5, 0, 0, 0);
    }
    
    public void addRmvFav(Command com1, Command com2){
        
        if (ServicePodcastComment.getInstance().addRmvFav(currentPod.getId(), currentUser.getId())) {
        
        this.getToolbar().removeOverflowCommand(com1);
        this.getToolbar().addCommandToOverflowMenu(com2);
        this.getToolbar().refreshTheme();
        this.getToolbar().repaint();
        
        } else {
            Dialog.show("Error", "Error acquired, try again", "Okay", null);
        }
        
    }
    
      private void showDetailsDialog() {
           Dialog dia = new Dialog();
            int h = Display.getInstance().getDisplayHeight();
            ImageViewer img = new ImageViewer();
            try {
               Image loadImg = GifImage.decode(getResourceAsStream("/spinner.gif"), 1177720);
                img.setImage(loadImg);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            Container cont = FlowLayout.encloseCenter(img);
            dia.setDisposeWhenPointerOutOfBounds(true);
            dia.setLayout(new BorderLayout());
            dia.add(BorderLayout.CENTER, cont);
             new Thread(() -> {
                callSerially(() -> {
                    Label ratingLbl;
                    UserInfo owner = currentPod.getPlaylistIdId().getChannelIdId().getUser().getUserInfoIdId();
                    Label ownerName = new Label(owner.getUserFirstName()+" "+owner.getUserLastName());
                    ImageViewer ownerImage = new ImageViewer();
                      if (owner.getUserImage() != null && owner.getUserImage() != "") {
                        try {
                        URL url = new URL(Statics.BASE_URL+"/Files/podcastFiles/"+owner.getUserImage());
                          URL.URLConnection httpcon = url.openConnection();
                         InputStream stream = new BufferedInputStream(httpcon.getInputStream());
                         Image im = Image.createImage(stream);
                         im = im.scaled(250, 250);
                        ownerImage.setImage(im);
                        } catch(IOException | URISyntaxException ex) {
                            System.out.println("Owner Image Exception: "+ex.getMessage());
                            ownerImage.setImage(getAvatar());
                        }
                      } else {
                            ownerImage.setImage(getAvatar());
                      }
                    if (currentPod.getPodcastReviewCollection().size()>0) {
                        float rating = 0;
                        for(PodcastReview rev: currentPod.getPodcastReviewCollection()) {
                            rating+=rev.getRating();
                        }
                        rating/=currentPod.getPodcastReviewCollection().size();

                        String strRating = rating+"";

                        if (strRating.contains(".")) {
                         strRating = strRating.substring(0, strRating.indexOf(".")+1);
                        }
                        rating = Float.parseFloat(strRating);
                        ratingLbl = new Label("Podcast rating: "+rating+" /10");
                    }else {
                        
                        ratingLbl = new Label("No rating on this podcast yet.");
                    }
                    Label podcastName = new Label("Podcast name: "+currentPod.getPodcastName());
                    Label podcastDesc = new Label("Podcast description: "+currentPod.getPodcastDescription());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
                    
                    String date =simpleDateFormat.format(currentPod.getPodcastDate());
                    Label podcastDate = new Label("creation date: "+date);
                    
                    Container bigCont = new Container();
                    bigCont.setLayout(new BoxLayout(2));
                    Container userCont = new Container();
                    userCont.setLayout(new BoxLayout(1));
                    
                    userCont.add(ownerImage);
                    userCont.add(ownerName);
                    
                    
                    bigCont.add(new Label(" "));
                    bigCont.add(ratingLbl);
                    bigCont.add(new Label(" "));
                    bigCont.add(podcastName);
                    bigCont.add(podcastDesc);
                    bigCont.add(podcastDate);
                    bigCont.add(new Label(" "));
                    bigCont.add(new Label("Owner:"));
                    bigCont.add(userCont);
                    
                    dia.removeAll();
                    dia.add(BorderLayout.CENTER, bigCont);
                    dia.refreshTheme();
            
            
                    });
             }).start();
             
            dia.show(h /8 * 4, 0, 0, 0);
    }
    private Image getAvatar() {
         try {
        InputStream in = Display.getInstance().getResourceAsStream(null, "/roundedAvatar.png");
        Image  loadImg = Image.createImage(in);
        return loadImg.scaled(250, 250);
    } catch (IOException ex) {
    System.out.println("Avatat Image Exception !! : "+ex.getMessage());
    }
         return null;
    }
}