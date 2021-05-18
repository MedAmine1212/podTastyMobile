/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Command;
import com.codename1.ui.FontImage;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
import com.podtasty.services.LoadAudio;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class Favorites extends com.codename1.ui.Form {

    public Favorites() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Favorites(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("Scan QRCode", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToHome()));

    }
    
private void backToHome() {
   
    this.deinitialize();
    PodTasty.getHomeView().show();
}

//////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Favorites");
        setName("Favorites");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_Label.setText("Favorites");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("font:80px;");
        gui_Label.setName("Label");
        gui_Box_Layout_Y.addComponent(gui_Label);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "5.0mm 1.0mm 5.0mm 5.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
