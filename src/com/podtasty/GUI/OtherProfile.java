/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.podtasty.entities.User;
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
public class OtherProfile extends com.codename1.ui.Form {
    int id;
    public OtherProfile(int id) {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        this.id=id;

    }
    
    public OtherProfile(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        ServiceUser su = new ServiceUser();
        User u = su.getUserById(id).get(0);
        this.gui_Firstanme.setText(u.getUserInfoIdId().getUserFirstName());
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
        } catch (URISyntaxException ex) {
        System.out.print(ex);    
        } catch (IOException ex) {
System.out.print(ex);        }
           this.gui_NbFollowers.setText(String.valueOf(su.getfollowers(u)));
           this.gui_followNb.setText(String.valueOf(su.getfollowing(u)));
           UserHolder holder = UserHolder.getInstance();

           if(su.checkFollowed(holder.getUser().getId(), id)){
               this.gui_Followbtn.setText("Unfollow");
           }
        
    }

//////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Firstanme = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Lastname = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Bio = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Followbtn = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_NbFollowers = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_followNb = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Followbtn.addActionListener(callback);
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

            if(sourceComponent == gui_Followbtn) {
                onFollowbtnActionEvent(ev);
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
        setTitle("OtherProfile");
        setName("OtherProfile");
        gui_Label.setText("  ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_ImageContainer.setText("   ");
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setName("ImageContainer");
        gui_Firstanme.setText("Label");
                gui_Firstanme.setInlineStylesTheme(resourceObjectInstance);
        gui_Firstanme.setName("Firstanme");
        gui_Lastname.setText("Label");
                gui_Lastname.setInlineStylesTheme(resourceObjectInstance);
        gui_Lastname.setName("Lastname");
        gui_Bio.setPreferredSizeStr("inherit inherit");
        gui_Bio.setText("Label");
                gui_Bio.setInlineStylesTheme(resourceObjectInstance);
        gui_Bio.setName("Bio");
        gui_Followbtn.setText("Follow");
                gui_Followbtn.setInlineStylesTheme(resourceObjectInstance);
        gui_Followbtn.setName("Followbtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Followbtn,"\ue7fe".charAt(0));
        gui_Label_1.setText("Followers");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_NbFollowers.setText("Label");
                gui_NbFollowers.setInlineStylesTheme(resourceObjectInstance);
        gui_NbFollowers.setName("NbFollowers");
        gui_Label_2.setText("Following");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_followNb.setText("Label");
                gui_followNb.setInlineStylesTheme(resourceObjectInstance);
        gui_followNb.setName("followNb");
        gui_Box_Layout_Y.setPreferredSizeStr("89.15344mm 55.291004mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Label);
        addComponent(gui_ImageContainer);
        addComponent(gui_Firstanme);
        addComponent(gui_Lastname);
        addComponent(gui_Bio);
        addComponent(gui_Followbtn);
        addComponent(gui_Label_1);
        addComponent(gui_NbFollowers);
        addComponent(gui_Label_2);
        addComponent(gui_followNb);
        addComponent(gui_Box_Layout_Y);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ImageContainer.getParent().getLayout()).setInsets(gui_ImageContainer, "6.878307mm auto auto auto").setReferenceComponents(gui_ImageContainer, "-1 -1 -1 -1").setReferencePositions(gui_ImageContainer, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Firstanme.getParent().getLayout()).setInsets(gui_Firstanme, "10.569106% auto auto 47.206703%").setReferenceComponents(gui_Firstanme, "-1 -1 -1 -1").setReferencePositions(gui_Firstanme, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Lastname.getParent().getLayout()).setInsets(gui_Lastname, "15.853659% auto auto 47.206703%").setReferenceComponents(gui_Lastname, "-1 -1 -1 -1").setReferencePositions(gui_Lastname, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Bio.getParent().getLayout()).setInsets(gui_Bio, "21.138212% auto auto 47.206703%").setReferenceComponents(gui_Bio, "-1 -1 -1 -1").setReferencePositions(gui_Bio, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Followbtn.getParent().getLayout()).setInsets(gui_Followbtn, "26.422764% auto auto 44.97207%").setReferenceComponents(gui_Followbtn, "-1 -1 -1 -1").setReferencePositions(gui_Followbtn, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "32.92683% auto auto auto").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_NbFollowers.getParent().getLayout()).setInsets(gui_NbFollowers, "38.211384% auto auto 47.206703%").setReferenceComponents(gui_NbFollowers, "-1 -1 -1 -1").setReferencePositions(gui_NbFollowers, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "56.613758mm auto auto 86.772484mm").setReferenceComponents(gui_Label_2, "-1 -1 -1 -1").setReferencePositions(gui_Label_2, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_followNb.getParent().getLayout()).setInsets(gui_followNb, "63.492065mm auto auto 89.41799mm").setReferenceComponents(gui_followNb, "-1 -1 -1 -1").setReferencePositions(gui_followNb, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "-2.6455026mm 61.45252% 45.027626% -61px").setReferenceComponents(gui_Box_Layout_Y, "4 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onFollowbtnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        UserHolder holder = UserHolder.getInstance();
        ServiceUser su = new ServiceUser();
        if(su.checkFollowed(holder.getUser().getId(), id)){
               su.unfollow(holder.getUser().getId(), id);
        this.gui_Followbtn.setText("follow");
              
           }else{
        su.follow(holder.getUser().getId(), id);
        this.gui_Followbtn.setText("Unfollow");

    }
        
    }

}
