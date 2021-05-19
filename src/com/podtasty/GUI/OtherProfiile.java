package com.podtasty.GUI;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.util.Resources;


public class OtherProfiile extends Form  {
    public OtherProfiile(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
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
                gui_container.setInlineStylesTheme(resourceObjectInstance);
        gui_container.setInlineAllStyles("alignment:center;");
        gui_container.setName("container");
        addComponent(gui_container);
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setInlineAllStyles("alignment:center;");
        gui_ImageContainer.setName("ImageContainer");
        gui_Firstname.setText("Label");
                gui_Firstname.setInlineStylesTheme(resourceObjectInstance);
        gui_Firstname.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
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
        gui_container.addComponent(gui_ImageContainer);
        gui_container.addComponent(gui_Firstname);
        gui_container.addComponent(gui_Lastname );
        gui_container.addComponent(gui_Bio);
        gui_container.addComponent(gui_Followbtn);
        gui_container.addComponent(gui_Label);
        gui_container.addComponent(gui_NbFollowers);
        gui_container.addComponent(gui_Label_1);
        gui_container.addComponent(gui_followNb);
        ((com.codename1.ui.layouts.LayeredLayout)gui_container.getParent().getLayout()).setInsets(gui_container, "5.0mm 5.0mm 5.0mm 5.0mm").setReferenceComponents(gui_container, "-1 -1 -1 -1").setReferencePositions(gui_container, "0.0 0.0 0.0 0.0");
    }// </editor-fold>
//-- DON'T EDIT ABOVE THIS LINE!!!
}
