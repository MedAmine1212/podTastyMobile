/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.podtasty.entities.UserHolder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class MyProfile extends com.codename1.ui.Form {

    public MyProfile() throws URISyntaxException, IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public MyProfile(com.codename1.ui.util.Resources resourceObjectInstance) throws URISyntaxException, IOException {
        initGuiBuilderComponents(resourceObjectInstance);
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
        this.gui_FirstNameLabel.setText("First Name : " + holder.getUser().getUserInfoIdId().getUserFirstName());
        this.gui_LastName.setText("Last Name : " + holder.getUser().getUserInfoIdId().getUserLastName());
        this.gui_BioLabel.setText("Bio : " + holder.getUser().getUserInfoIdId().getUserBio());
//gui_ImageContainer.setMaterialIcon(img);

    }

//////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_FirstNameLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_LastName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_BioLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
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
        gui_Button.setText("Settings");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Button,"\ue8b8".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_ImageContainer);
        addComponent(gui_FirstNameLabel);
        addComponent(gui_LastName);
        addComponent(gui_BioLabel);
        addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ImageContainer.getParent().getLayout()).setInsets(gui_ImageContainer, "0.0mm auto auto auto").setReferenceComponents(gui_ImageContainer, "0 -1 -1 -1").setReferencePositions(gui_ImageContainer, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FirstNameLabel.getParent().getLayout()).setInsets(gui_FirstNameLabel, "0.0mm auto auto auto").setReferenceComponents(gui_FirstNameLabel, "1 -1 -1 -1").setReferencePositions(gui_FirstNameLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LastName.getParent().getLayout()).setInsets(gui_LastName, "0.0mm auto auto auto").setReferenceComponents(gui_LastName, "2 -1 -1 -1").setReferencePositions(gui_LastName, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BioLabel.getParent().getLayout()).setInsets(gui_BioLabel, "0.0mm auto auto auto").setReferenceComponents(gui_BioLabel, "3 -1 -1 -1").setReferencePositions(gui_BioLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "0.0mm auto auto auto").setReferenceComponents(gui_Button, "4 -1 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
