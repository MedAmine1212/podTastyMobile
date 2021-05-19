/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.URL;
import com.codename1.ui.Command;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.ServiceUser;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class MyProfile extends com.codename1.ui.Form {
    private static boolean isCom;
    public MyProfile() throws URISyntaxException, IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    public static void setIsCom(boolean com) {
        isCom = com;
    }
    public MyProfile(com.codename1.ui.util.Resources resourceObjectInstance) throws URISyntaxException, IOException {
        initGuiBuilderComponents(resourceObjectInstance);
        
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToHome()));
        UserHolder holder = UserHolder.getInstance();
        this.setpic();
        this.gui_FirstNameLabel.setText("First Name : " + holder.getUser().getUserInfoIdId().getUserFirstName());
        this.gui_LastName.setText("Last Name : " + holder.getUser().getUserInfoIdId().getUserLastName());
        if (holder.getUser().getUserInfoIdId().getUserBio() != null) {
            this.gui_BioLabel.setText("Bio : " + holder.getUser().getUserInfoIdId().getUserBio());
        } else {
            this.gui_BioLabel.setText("Bio :  You have no bio");
        }

        if (holder.getUser().getUserInfoIdId().getUserBirthDate() != null) {
            String date = holder.getUser().getUserInfoIdId().getUserBirthDate();
            this.gui_birthdateLabel.setText("BirthDate : " + date);
        }
        this.gui_Gender.setText("Gender : " + holder.getUser().getUserInfoIdId().getUserGender());
//gui_ImageContainer.setMaterialIcon(img);
        ServiceUser su = new ServiceUser();
        int nbFollower = su.getfollowers(holder.getUser());
        this.gui_FollowerNb.setText(String.valueOf(nbFollower));
        int nbFollowing = su.getfollowing(holder.getUser());
        this.gui_FollowingNb.setText(String.valueOf(nbFollowing));

    }
    
private void backToHome() {
    this.deinitialize();
    if (!isCom) {
    HomeView.destroyFavViews();
    PodTasty.getHomeView().show();
        
    } else {
        HomeView.getPodView().show();
    }
}

public void refreshThis() {
    
    this.deinitialize();
    MyProfile profile;
        try {
            profile = new MyProfile();
            profile.show();
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex.getMessage());
        }
}
public void setpic(){
        try {
            UserHolder holder = UserHolder.getInstance();
            URL url = new URL("http://127.0.0.1:8000/Files/podcastFiles/" + holder.getUser().getUserInfoIdId().getUserImage());
            URL.URLConnection httpcon = url.openConnection();
            InputStream stream = new BufferedInputStream(httpcon.getInputStream());
            
            Image img = Image.createImage(stream).fill(350, 350);
            
            int w = 350;
            int h = 350;
            
            Image maskImage = Image.createImage(w, h);
            Graphics g = maskImage.getGraphics();
            g.setAntiAliased(true);
            g.setColor(0x000000);
            g.fillRect(0, 0, w, h);
            g.setColor(0xffffff);
            g.fillArc(0, 0, w, h, 0, 360);
            Object mask = maskImage.createMask();
            Image maskedImage = img.applyMask(mask);
            this.gui_ImageContainer.setIcon(maskedImage);
            this.gui_ImageContainer.getStyle().setAlignment(CENTER, focusScrolling);
        } catch (URISyntaxException ex) {
        System.out.print(ex);    
        } catch (IOException ex) {
System.out.print(ex);        }
     
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_FirstNameLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LastName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_BioLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Settings = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_birthdateLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Gender = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Picture = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_FollowerNb = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_FollowingNb = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Settings.addActionListener(callback);
        gui_Picture.addActionListener(callback);
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

            if(sourceComponent == gui_Settings) {
                onSettingsActionEvent(ev);
            }
            if(sourceComponent == gui_Picture) {
                onPictureActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("MyProfile");
        setName("MyProfile");
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_ImageContainer.setPreferredSizeStr("40.74074mm inherit");
        gui_ImageContainer.setText("  ");
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setName("ImageContainer");
        gui_FirstNameLabel.setText("Label");
                gui_FirstNameLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_FirstNameLabel.setName("FirstNameLabel");
        gui_LastName.setText("Label");
                gui_LastName.setInlineStylesTheme(resourceObjectInstance);
        gui_LastName.setName("LastName");
        gui_BioLabel.setText("Label");
                gui_BioLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_BioLabel.setName("BioLabel");
        gui_Settings.setPreferredSizeStr("inherit inherit");
        gui_Settings.setText("Settings");
                gui_Settings.setInlineStylesTheme(resourceObjectInstance);
        gui_Settings.setName("Settings");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Settings,"\ue8b8".charAt(0));
        gui_birthdateLabel.setText("Label");
                gui_birthdateLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_birthdateLabel.setName("birthdateLabel");
        gui_Gender.setText("Label");
                gui_Gender.setInlineStylesTheme(resourceObjectInstance);
        gui_Gender.setName("Gender");
        gui_Picture.setText("Profile Picture");
                gui_Picture.setInlineStylesTheme(resourceObjectInstance);
        gui_Picture.setName("Picture");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Picture,"\ue439".charAt(0));
        gui_Label_1.setText("Followers");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Label_2.setText("Following");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_FollowerNb.setText("Label");
                gui_FollowerNb.setInlineStylesTheme(resourceObjectInstance);
        gui_FollowerNb.setName("FollowerNb");
        gui_FollowingNb.setText("dsfq");
                gui_FollowingNb.setInlineStylesTheme(resourceObjectInstance);
        gui_FollowingNb.setName("FollowingNb");
        addComponent(gui_Label);
        addComponent(gui_ImageContainer);
        addComponent(gui_FirstNameLabel);
        addComponent(gui_LastName);
        addComponent(gui_BioLabel);
        addComponent(gui_Settings);
        addComponent(gui_birthdateLabel);
        addComponent(gui_Gender);
        addComponent(gui_Picture);
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_FollowerNb);
        addComponent(gui_FollowingNb);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ImageContainer.getParent().getLayout()).setInsets(gui_ImageContainer, "0.0mm auto auto auto").setReferenceComponents(gui_ImageContainer, "0 -1 -1 -1").setReferencePositions(gui_ImageContainer, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FirstNameLabel.getParent().getLayout()).setInsets(gui_FirstNameLabel, "0.0mm auto auto auto").setReferenceComponents(gui_FirstNameLabel, "1 -1 -1 -1").setReferencePositions(gui_FirstNameLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LastName.getParent().getLayout()).setInsets(gui_LastName, "0.0mm auto auto auto").setReferenceComponents(gui_LastName, "2 -1 -1 -1").setReferencePositions(gui_LastName, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BioLabel.getParent().getLayout()).setInsets(gui_BioLabel, "0.0mm auto auto auto").setReferenceComponents(gui_BioLabel, "3 -1 -1 -1").setReferencePositions(gui_BioLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Settings.getParent().getLayout()).setInsets(gui_Settings, "0.0mm auto auto auto").setReferenceComponents(gui_Settings, "8 -1 -1 -1").setReferencePositions(gui_Settings, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_birthdateLabel.getParent().getLayout()).setInsets(gui_birthdateLabel, "0.0mm auto auto auto").setReferenceComponents(gui_birthdateLabel, "4 -1 -1 -1").setReferencePositions(gui_birthdateLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Gender.getParent().getLayout()).setInsets(gui_Gender, "0.0mm 45.67039% auto 89.41799mm").setReferenceComponents(gui_Gender, "6 -1 -1 -1").setReferencePositions(gui_Gender, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Picture.getParent().getLayout()).setInsets(gui_Picture, "0.0mm auto auto auto").setReferenceComponents(gui_Picture, "7 -1 -1 -1").setReferencePositions(gui_Picture, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "8.465609mm auto auto auto").setReferenceComponents(gui_Label_1, "5 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm auto auto auto").setReferenceComponents(gui_Label_2, "11 -1 -1 -1").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FollowerNb.getParent().getLayout()).setInsets(gui_FollowerNb, "6.878307mm auto auto auto").setReferenceComponents(gui_FollowerNb, "5 -1 -1 -1").setReferencePositions(gui_FollowerNb, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FollowingNb.getParent().getLayout()).setInsets(gui_FollowingNb, "6.878307mm auto auto auto").setReferenceComponents(gui_FollowingNb, "10 -1 -1 -1").setReferencePositions(gui_FollowingNb, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onPictureActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Display.getInstance().openGallery(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (ev != null && ev.getSource() != null) {
                    String filePath = (String) ev.getSource();
                    int fileNameIndex = filePath.lastIndexOf("/") + 1;
                    String fileName = filePath.substring(fileNameIndex);

                    Image img = null;
                    ServiceUser su = new ServiceUser();
                    UserHolder holder = UserHolder.getInstance();

                    try {
                       img  = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));  
                        
                        su.updateProfilPic(holder.getUser(),filePath,fileName);
                            int id = holder.getUser().getId();
                            holder.setUser(su.getUserById(id).get(0));
                            refreshThis();
                            
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Do something, add to List
                }
            }

        }, Display.GALLERY_IMAGE);
        
    }

    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void onSettingsActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new ProfileSettings().show();
    }

}
