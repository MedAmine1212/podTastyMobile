/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.ui.Command;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
import com.podtasty.entities.User;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class OtherProfile extends com.codename1.ui.Form {

    private static int id;
    private static boolean isPod;
    public OtherProfile() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public static void setUserId(int userId, boolean pod) {
        id = userId;
        isPod = pod;
    }
       private void backToHome() {
    if (!isPod) {
       PodTasty.getHomeView().show(); 
    }else {
        HomeView.getPodView().show();
    }
}
    public OtherProfile(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToHome()));
        ServiceUser su = new ServiceUser();
        User u = su.getUserById(id).get(0);
        this.gui_Firstname.setText(u.getUserInfoIdId().getUserFirstName());
        this.gui_Lastname.setText(u.getUserInfoIdId().getUserLastName());
        this.gui_Bio.setText(u.getUserInfoIdId().getUserBio());
                try {
            UserHolder holder = UserHolder.getInstance();
            
            URL url = new URL("http://127.0.0.1:8000/Files/podcastFiles/" + u.getUserInfoIdId().getUserImage());
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
        } catch (URISyntaxException | IOException ex) {
        System.out.print(ex);    
        }
           this.gui_NbFollowers.setText(String.valueOf(su.getfollowers(u)));
           this.gui_Followbtn.addActionListener((e) ->{
           followUnfollow();
           });
           this.gui_followNb.setText(String.valueOf(su.getfollowing(u)));
           UserHolder holder = UserHolder.getInstance();
           if (holder.getUser() != null) {
           if(su.checkFollowed(holder.getUser().getId(), id)){
               this.gui_Followbtn.setText("Unfollow");
           }
           } else {
               this.gui_Followbtn.remove();
           }
    }

//////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Firstname = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Lastname  = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Bio = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Followbtn = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_NbFollowers = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_followNb = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("OtherProfiile");
        setName("OtherProfiile");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setInlineAllStyles("alignment:center;");
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setInlineAllStyles("alignment:center;");
        gui_ImageContainer.setName("ImageContainer");
        gui_Firstname.setText("Label");
                gui_Firstname.setInlineStylesTheme(resourceObjectInstance);
        gui_Firstname.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_Firstname.setName("Firstname");
        gui_Lastname .setText("Label");
                gui_Lastname .setInlineStylesTheme(resourceObjectInstance);
        gui_Lastname .setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_Lastname .setName("Lastname ");
        gui_Bio.setText("Label");
                gui_Bio.setInlineStylesTheme(resourceObjectInstance);
        gui_Bio.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_Bio.setName("Bio");
        gui_Followbtn.setText("Follow");
                gui_Followbtn.setInlineStylesTheme(resourceObjectInstance);
        gui_Followbtn.setInlineAllStyles("margin:1.0mm inherit inherit inherit;");
        gui_Followbtn.setName("Followbtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Followbtn,"\ue7fe".charAt(0));
        gui_Label.setText("Followers");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_Label.setName("Label");
                gui_NbFollowers.setInlineStylesTheme(resourceObjectInstance);
        gui_NbFollowers.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_NbFollowers.setName("NbFollowers");
        gui_Label_1.setText("Following");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_Label_1.setName("Label_1");
                gui_followNb.setInlineStylesTheme(resourceObjectInstance);
        gui_followNb.setInlineAllStyles("alignment:center; margin:1.0mm inherit inherit inherit;");
        gui_followNb.setName("followNb");
        gui_Box_Layout_Y.addComponent(gui_ImageContainer);
        gui_Box_Layout_Y.addComponent(gui_Firstname);
        gui_Box_Layout_Y.addComponent(gui_Lastname );
        gui_Box_Layout_Y.addComponent(gui_Bio);
        gui_Box_Layout_Y.addComponent(gui_Followbtn);
        gui_Box_Layout_Y.addComponent(gui_Label);
        gui_Box_Layout_Y.addComponent(gui_NbFollowers);
        gui_Box_Layout_Y.addComponent(gui_Label_1);
        gui_Box_Layout_Y.addComponent(gui_followNb);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "5.0mm 5.0mm 5.0mm 5.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    private void followUnfollow() {
        UserHolder holder = UserHolder.getInstance();
        ServiceUser su = new ServiceUser();
        if(su.checkFollowed(holder.getUser().getId(), id)){
               su.unfollow(holder.getUser().getId(), id);
        this.gui_Followbtn.setText("follow");
           }else{
        su.follow(holder.getUser().getId(), id);
        this.gui_Followbtn.setText("Unfollow");
    }
        
               this.gui_Followbtn.refreshTheme();
               this.gui_Box_Layout_Y.refreshTheme();
               this.refreshTheme();
    }
}
