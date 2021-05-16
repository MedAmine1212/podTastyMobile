/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

/**
 * GUI builder created Form
 *
 * @author LENOVO
 */
public class Podcast extends com.codename1.ui.Form {

    public Podcast() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Podcast(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }
    
    

////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_podcastname = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_poddesc = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Btnupimage = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Btnupaudio = new com.codename1.ui.Button();
    protected com.codename1.ui.ComboBox gui_CBplaylist = new com.codename1.ui.ComboBox("Playlist","","","");
    protected com.codename1.ui.Button gui_BtnAjout = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Add details ");
        setName("Podcast");
        gui_Label.setPreferredSizeStr("110.49958mm 167.01947mm");
        gui_Label.setText("");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("transparency:70; opacity:255;");
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("82483820_1016345628721934_5629308034506293248_n.jpg"));
        gui_podcastname.setPreferredSizeStr("91.44793mm 10.160881mm");
        gui_podcastname.setHint("Podcast Name");
        gui_podcastname.setText("");
                gui_podcastname.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastname.setInlineAllStyles("font:4.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:ffffff;");
        gui_podcastname.setName("podcastname");
        gui_Label_1.setPreferredSizeStr("60.965282mm 8.255715mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgColor:ffffff;");
        gui_Label_1.setName("Label_1");
        gui_poddesc.setPreferredSizeStr("91.44793mm inherit");
        gui_poddesc.setHint("Add a description");
        gui_poddesc.setText("");
                gui_poddesc.setInlineStylesTheme(resourceObjectInstance);
        gui_poddesc.setInlineAllStyles("font:3.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:ffffff;");
        gui_poddesc.setName("poddesc");
        gui_poddesc.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue3c9".charAt(0), gui_poddesc.getUnselectedStyle()));
        gui_Btnupimage.setPreferredSizeStr("92.92972mm 7.8323455mm");
        gui_Btnupimage.setText("Upload image");
                gui_Btnupimage.setInlineStylesTheme(resourceObjectInstance);
        gui_Btnupimage.setName("Btnupimage");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Btnupimage,"\ue3f4".charAt(0));
        gui_Btnupaudio.setPreferredSizeStr("92.92972mm 6.35055mm");
        gui_Btnupaudio.setText("Upload Audio");
                gui_Btnupaudio.setInlineStylesTheme(resourceObjectInstance);
        gui_Btnupaudio.setName("Btnupaudio");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Btnupaudio,"\ue2c6".charAt(0));
        gui_CBplaylist.setPreferredSizeStr("96.31668mm inherit");
                gui_CBplaylist.setInlineStylesTheme(resourceObjectInstance);
        gui_CBplaylist.setInlineAllStyles("font:3.0mm; bgColor:ffffff; fgColor:ffffff;");
        gui_CBplaylist.setName("CBplaylist");
        gui_BtnAjout.setPreferredSizeStr("98.43353mm 6.1388655mm");
        gui_BtnAjout.setText("Add Podcast");
                gui_BtnAjout.setInlineStylesTheme(resourceObjectInstance);
        gui_BtnAjout.setName("BtnAjout");
        addComponent(gui_Label);
        addComponent(gui_podcastname);
        addComponent(gui_Label_1);
        addComponent(gui_poddesc);
        addComponent(gui_Btnupimage);
        addComponent(gui_Btnupaudio);
        addComponent(gui_CBplaylist);
        addComponent(gui_BtnAjout);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "auto auto 2.9635906mm auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_podcastname.getParent().getLayout()).setInsets(gui_podcastname, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_podcastname, "0 2 -1 2 ").setReferencePositions(gui_podcastname, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "3.3869598mm 5.0mm auto 5.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 0 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_poddesc.getParent().getLayout()).setInsets(gui_poddesc, "6.1388702mm 0.0mm auto 0.0mm").setReferenceComponents(gui_poddesc, "1 2 -1 2 ").setReferencePositions(gui_poddesc, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Btnupimage.getParent().getLayout()).setInsets(gui_Btnupimage, "46.30542% 0.0mm auto 0.0mm").setReferenceComponents(gui_Btnupimage, "1 2 5 2 ").setReferencePositions(gui_Btnupimage, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Btnupaudio.getParent().getLayout()).setInsets(gui_Btnupaudio, "77.798874% 0.0mm 0.8467422mm 0.0mm").setReferenceComponents(gui_Btnupaudio, "1 2 6 2 ").setReferencePositions(gui_Btnupaudio, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_CBplaylist.getParent().getLayout()).setInsets(gui_CBplaylist, "69.03178% 0.0mm 3.386956mm 0.0mm").setReferenceComponents(gui_CBplaylist, "3 1 7 1 ").setReferencePositions(gui_CBplaylist, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnAjout.getParent().getLayout()).setInsets(gui_BtnAjout, "48.06875% 0.0mm 45.525917% 0.0mm").setReferenceComponents(gui_BtnAjout, "1 1 -1 1 ").setReferencePositions(gui_BtnAjout, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
