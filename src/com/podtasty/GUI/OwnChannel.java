/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Label;

/**
 * GUI builder created Form
 *
 * @author Lwiss
 */
public class OwnChannel extends com.codename1.ui.Form {

    public OwnChannel() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public OwnChannel(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Label gui_ChannelName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ChannelDescription = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Playlists = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("OwnChannel");
        setName("OwnChannel");
        gui_Container.setPreferredSizeStr("214.6486mm 33.44623mm");
        gui_Container.setScrollableX(false);
        gui_Container.setScrollableY(false);
                gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setInlineAllStyles("alignment:center;");
        gui_Container.setName("Container");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_1.setPreferredSizeStr("214.6486mm 134.84335mm");
                gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setName("Container_1");
        addComponent(gui_Container);
        gui_ChannelName.setText("Channel Name");
                gui_ChannelName.setInlineStylesTheme(resourceObjectInstance);
        gui_ChannelName.setName("ChannelName");
        gui_ChannelDescription.setText("Channel Description");
                gui_ChannelDescription.setInlineStylesTheme(resourceObjectInstance);
        gui_ChannelDescription.setName("ChannelDescription");
        gui_Playlists.setText("Playlists");
                gui_Playlists.setInlineStylesTheme(resourceObjectInstance);
        gui_Playlists.setName("Playlists");
        gui_Container.addComponent(gui_ChannelName);
        gui_Container.addComponent(gui_ChannelDescription);
        gui_Container.addComponent(gui_Playlists);
        addComponent(gui_Container_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container.getParent().getLayout()).setInsets(gui_Container, "2.328535mm 0.0mm 78.848564% 0.0mm").setReferenceComponents(gui_Container, "-1 -1 -1 -1").setReferencePositions(gui_Container, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Container_1.getParent().getLayout()).setInsets(gui_Container_1, "0.0mm 0px 3px 0.0mm").setReferenceComponents(gui_Container_1, "0 -1 -1 -1").setReferencePositions(gui_Container_1, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    
    
    
    

    public void setGui_ChannelName(String s) {
        this.gui_ChannelName.setText(s);
    }

}
