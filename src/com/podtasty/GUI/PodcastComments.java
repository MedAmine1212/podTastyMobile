/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.podtasty.entities.Podcast;
import com.podtasty.entities.PodcastComment;
import com.podtasty.services.ServicePodcastComment;
import java.util.ArrayList;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class PodcastComments extends com.codename1.ui.Form {

    public PodcastComments() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
        ServicePodcastComment sr = ServicePodcastComment.getInstance();
        Podcast pod = new Podcast();
        pod.setId(10);
        ArrayList<PodcastComment> comList = sr.getCommentsByPodcastId(pod);
        System.out.println(comList);
    }
    
    public PodcastComments(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.components.ImageViewer gui_Image_Viewer = new com.codename1.components.ImageViewer();
    protected com.codename1.ui.Container gui_Grid_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(4, 1));
    protected com.codename1.ui.Label gui_podcastName = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_podcastViews = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_podcastDesc = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Grid_Layout_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.GridLayout(1, 3));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_playStopButton = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Box_Layout_X_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_Flow_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.TextField gui_searchInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Border_Layout = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.components.ScaleImageButton gui_ScaleImageButton = new com.codename1.components.ScaleImageButton();
    protected com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_editComButt = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_deleteComButt = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_addComInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setInlineAllStyles("bgImage:duke-no-logos.png;");
        setTitle("PodcastComments");
        setName("PodcastComments");
        gui_Box_Layout_Y.setPreferredSizeStr("102.24386mm 151.35478mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_Box_Layout_X.setPreferredSizeStr("98.43353mm 29.212532mm");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Label_2.setPreferredSizeStr("63.71719mm 16.723116mm");
        gui_Label_2.setText(" ");
        gui_Label_2.setUIID("Label");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setName("Label_2");
        gui_Box_Layout_X_1.setPreferredSizeStr("103.0906mm 22.861982mm");
                gui_Box_Layout_X_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X_1.setName("Box_Layout_X_1");
        gui_addComInput.setText("");
                gui_addComInput.setInlineStylesTheme(resourceObjectInstance);
        gui_addComInput.setName("addComInput");
        gui_Box_Layout_Y_1.setPreferredSizeStr("100.973755mm 136.9602mm");
        gui_Box_Layout_Y_1.setScrollableY(true);
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
                gui_Image_Viewer.setInlineStylesTheme(resourceObjectInstance);
        gui_Image_Viewer.setName("Image_Viewer");
        gui_Grid_Layout.setPreferredSizeStr("48.052498mm 25.613886mm");
                gui_Grid_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout.setName("Grid_Layout");
        gui_Box_Layout_X.addComponent(gui_Image_Viewer);
        gui_Box_Layout_X.addComponent(gui_Grid_Layout);
        gui_podcastName.setPreferredSizeStr("46.359016mm 5.9271803mm");
        gui_podcastName.setText("PodtastyPodcast");
                gui_podcastName.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastName.setName("podcastName");
        gui_podcastViews.setText("120 views");
                gui_podcastViews.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastViews.setName("podcastViews");
        gui_podcastDesc.setPreferredSizeStr("50.59272mm 6.5622354mm");
        gui_podcastDesc.setText("This is a podcast description");
                gui_podcastDesc.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastDesc.setName("podcastDesc");
                gui_Grid_Layout_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Grid_Layout_1.setName("Grid_Layout_1");
        gui_Grid_Layout.addComponent(gui_podcastName);
        gui_Grid_Layout.addComponent(gui_podcastViews);
        gui_Grid_Layout.addComponent(gui_podcastDesc);
        gui_Grid_Layout.addComponent(gui_Grid_Layout_1);
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
                gui_playStopButton.setInlineStylesTheme(resourceObjectInstance);
        gui_playStopButton.setName("playStopButton");
        com.codename1.ui.FontImage.setMaterialIcon(gui_playStopButton,"\ue038".charAt(0));
        gui_Label_1.setText(" ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Grid_Layout_1.addComponent(gui_Label);
        gui_Grid_Layout_1.addComponent(gui_playStopButton);
        gui_Grid_Layout_1.addComponent(gui_Label_1);
        gui_Box_Layout_Y.addComponent(gui_Label_2);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X_1);
        gui_Label_3.setPreferredSizeStr("32.811176mm inherit");
        gui_Label_3.setText(" ");
                gui_Label_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3.setName("Label_3");
        gui_Flow_Layout.setPreferredSizeStr("54.82642mm 22.861982mm");
                gui_Flow_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Flow_Layout.setName("Flow_Layout");
        gui_Box_Layout_X_1.addComponent(gui_Label_3);
        gui_Box_Layout_X_1.addComponent(gui_Flow_Layout);
                gui_searchInput.setInlineStylesTheme(resourceObjectInstance);
        gui_searchInput.setName("searchInput");
                gui_Border_Layout.setInlineStylesTheme(resourceObjectInstance);
        gui_Border_Layout.setName("Border_Layout");
        gui_Label_4.setPreferredSizeStr("51.862827mm 6.35055mm");
        gui_Label_4.setText(" ");
                gui_Label_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_4.setName("Label_4");
        gui_Flow_Layout.addComponent(gui_searchInput);
        gui_Flow_Layout.addComponent(gui_Border_Layout);
        gui_ScaleImageButton.setUIID("Container");
                gui_ScaleImageButton.setInlineStylesTheme(resourceObjectInstance);
        gui_ScaleImageButton.setName("ScaleImageButton");
        gui_Label_3_1.setPreferredSizeStr("19.475021mm 5.9271803mm");
        gui_Label_3_1.setText(" ");
                gui_Label_3_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_3_1.setName("Label_3_1");
        gui_editComButt.setPreferredSizeStr("10.372565mm 6.5622354mm");
        gui_editComButt.setText("Edit");
                gui_editComButt.setInlineStylesTheme(resourceObjectInstance);
        gui_editComButt.setName("editComButt");
        gui_deleteComButt.setPreferredSizeStr("13.547841mm 6.9856052mm");
        gui_deleteComButt.setText("Delete");
                gui_deleteComButt.setInlineStylesTheme(resourceObjectInstance);
        gui_deleteComButt.setName("deleteComButt");
        gui_Border_Layout.addComponent(gui_ScaleImageButton);
        gui_Border_Layout.addComponent(gui_Label_3_1);
        gui_Border_Layout.addComponent(gui_editComButt);
        gui_Border_Layout.addComponent(gui_deleteComButt);
        gui_Flow_Layout.addComponent(gui_Label_4);
        gui_Box_Layout_Y.addComponent(gui_addComInput);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_Y_1);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "5.211685mm 5.8467402mm 8.877928% 4.1532598mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public  com.codename1.ui.Component create_Custom() {
        //return your own custom component from this method
        return new com.codename1.ui.Label("Custom Component");
    }

}
