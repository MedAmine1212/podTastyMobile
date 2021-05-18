/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.File;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.ui.CN;
import static com.codename1.ui.CN.callSerially;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.util.ImageIO;
import com.podtasty.entities.Podcast;
import com.podtasty.services.ServicePodcast;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * GUI builder created Form
 *
 * @author LENOVO
 */
public class AddPodcast extends com.codename1.ui.Form {

    
    Podcast podcast ; 
    Image logo;
    String hi;
    String ext;
    
    String podcastImage ;
    String podcastSource ;
    
    public AddPodcast() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AddPodcast(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        podcast = new Podcast();
    }
    
        CheckBox multiSelect = new CheckBox("Multi-select");
        CheckBox multiSelected = new CheckBox("Multi-select");

       

////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_podcastname = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_poddesc = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_Btnupimage = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Btnupaudio = new com.codename1.ui.Button();
   // protected com.codename1.ui.ComboBox gui_CBplaylist = new com.codename1.ui.ComboBox("Playlist :","Playlist 1","Playlist 2");
    protected com.codename1.ui.Button gui_BtnAjout = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Btnupimage.addActionListener(callback);
        gui_Btnupaudio.addActionListener(callback);
        gui_BtnAjout.addActionListener(callback);
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

            if(sourceComponent == gui_Btnupimage) {
                onBtnupimageActionEvent(ev);
            }
            if(sourceComponent == gui_Btnupaudio) {
                onBtnupaudioActionEvent(ev);
            }
            if(sourceComponent == gui_BtnAjout) {
                onBtnAjoutActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableX(false);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Add details ");
        setName("Podcast");
        gui_Label.setPreferredSizeStr("294.24216mm 176.5453mm");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("transparency:70; opacity:255;");
        gui_Label.setName("Label");
        gui_Label.setIcon(resourceObjectInstance.getImage("82483820_1016345628721934_5629308034506293248_n.jpg"));
        gui_podcastname.setPreferredSizeStr("91.44793mm 10.160881mm");
        gui_podcastname.setHint("Podcast Name");
                gui_podcastname.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastname.setInlineAllStyles("font:4.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:110102;");
        gui_podcastname.setName("podcastname");
        gui_Label_1.setPreferredSizeStr("60.965282mm 8.255715mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("bgColor:ffffff;");
        gui_Label_1.setName("Label_1");
        gui_poddesc.setPreferredSizeStr("91.44793mm inherit");
        gui_poddesc.setHint("Add a description");
                gui_poddesc.setInlineStylesTheme(resourceObjectInstance);
        gui_poddesc.setInlineAllStyles("font:3.0mm native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:70101;");
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
       // gui_CBplaylist.setPreferredSizeStr("96.31668mm inherit");
         //       gui_CBplaylist.setInlineStylesTheme(resourceObjectInstance);
        //gui_CBplaylist.setInlineAllStyles("font:3.0mm; bgColor:ffffff; fgColor:ffffff;");
        //gui_CBplaylist.setName("CBplaylist");
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
      //  addComponent(gui_CBplaylist);
        addComponent(gui_BtnAjout);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 0.0mm 0.0mm 0.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_podcastname.getParent().getLayout()).setInsets(gui_podcastname, "5.0mm 0.0mm auto 0.0mm").setReferenceComponents(gui_podcastname, "0 2 -1 2 ").setReferencePositions(gui_podcastname, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "3.3869598mm 5.0mm auto 5.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 0 ").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_poddesc.getParent().getLayout()).setInsets(gui_poddesc, "6.1388702mm 0.0mm auto 0.0mm").setReferenceComponents(gui_poddesc, "1 2 -1 2 ").setReferencePositions(gui_poddesc, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Btnupimage.getParent().getLayout()).setInsets(gui_Btnupimage, "46.30542% 0.0mm auto 0.0mm").setReferenceComponents(gui_Btnupimage, "1 2 5 2 ").setReferencePositions(gui_Btnupimage, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Btnupaudio.getParent().getLayout()).setInsets(gui_Btnupaudio, "77.798874% 0.0mm 0.8467422mm 0.0mm").setReferenceComponents(gui_Btnupaudio, "1 2 6 2 ").setReferencePositions(gui_Btnupaudio, "1.0 0.0 1.0 0.0");
      //  ((com.codename1.ui.layouts.LayeredLayout)gui_CBplaylist.getParent().getLayout()).setInsets(gui_CBplaylist, "69.03178% 0.0mm 3.386956mm 0.0mm").setReferenceComponents(gui_CBplaylist, "3 1 7 1 ").setReferencePositions(gui_CBplaylist, "1.0 0.0 1.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BtnAjout.getParent().getLayout()).setInsets(gui_BtnAjout, "48.06875% 0.0mm 45.525917% 0.0mm").setReferenceComponents(gui_BtnAjout, "1 1 -1 1 ").setReferencePositions(gui_BtnAjout, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
  
    // traje3 esm l image elli bech nhotouha fel application
    protected String saveFileToDevice(String hi, String ext) throws IOException {
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath(); //bech yekhou l path taswira 
            int index = hi.lastIndexOf("/"); 
            hi = hi.substring(index + 1);  //hi hiya l file 
            return hi;
        } catch (URISyntaxException ex) {
        }
        return "hh";
    }

    
    public void onBtnAjoutActionEvent(com.codename1.ui.events.ActionEvent ev) {
     try {
         if (gui_podcastname.getText()=="" || gui_poddesc.getText()==""){
             Dialog.show("Alert" , "Please fill all the fields",new Command("OK"));
         }
         else {
             new Thread(()-> {
                 callSerially(() -> {
                   
                     ServicePodcast sr = ServicePodcast.getInstance();
                     this.podcast.setPodcastName(gui_podcastname.getText());
                     this.podcast.setPodcastDescription(gui_poddesc.getText());
                    // this.podcast.setPodcastImage();
                    // this.podcast.setPodcastSource();
                    this.podcast.setPodcastImage(podcastImage);
                    this.podcast.setPodcastSource(podcastSource);
                     sr.AjoutPodcast(podcast);
                 });
             }).start();
             //InfiniteProgress ip = new InfiniteProgress();
             //final Dialog iDialog = ip.showInfiniteBlocking();
             
             //ServicePodcast sr = ServicePodcast.getInstance();
            // Podcast podcast = new Podcast(gui_podcastname.getText(),gui_poddesc.getText(), podcastImage , podcastSource , gui_CBplaylist  );
             //if (ServicePodcast.getInstance().AjoutPodcast(podcast));
             //Pod.setPodcastName(gui_podcastname.getText());
             
         }
     }catch (Exception ex){
          ex.printStackTrace();
     }
        
    }

    public void onBtnupaudioActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        if (FileChooser.isAvailable()) {
         FileChooser.showOpenDialog(".mp3, .WAV, mp3/plain", (ActionEvent e2)-> {
         String file = (String)e2.getSource();
        if (file == null) {
            add("No file was selected");
            revalidate();
        } else {
           String extension = null;
           
           if ("mp3".equals(extension)) {
               FileSystemStorage fs = FileSystemStorage.getInstance();
               try {
                   InputStream fis = fs.openInputStream(file);
                   addComponent(new SpanLabel(Util.readToString(fis)));
               } catch (Exception ex) {
                   Log.e(ex);
               }
           }
           if (file.lastIndexOf(".") > 0) {
               extension = file.substring(file.lastIndexOf(".")+1);
                StringBuilder hi = new StringBuilder(file);
                if (file.startsWith("file://")) {
                    hi.delete(0, 7);
                }
                int lastIndexPeriod = hi.toString().lastIndexOf(".");
                            Log.p(hi.toString());
                            String ext = hi.toString().substring(lastIndexPeriod);
                            String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
           }
                try {
                String podcastSource = saveFileToDevice(file, ext);
                System.out.println(podcastSource);
                this.podcast.setPodcastSource(podcastSource);
                } catch (IOException ex) {
                            }
        }
        revalidate();
    });
}
    }
                    

    
 /*if (FileChooser.isAvailable()){
            FileChooser.setOpenFilesInPlace(true);
            FileChooser.showOpenDialog(".mp3, .WAV, .mp3/plain", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource()== null) {
                        add("No file was selected");
                        revalidate();
                        return;
                    }
                    if (multiSelected.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }
            String file = (String) e2.getSource();
                    if (file == null) {
                        add("No file was selected");
                        revalidate();*/
                   /* } else {
			//String hh = "c:/...";									
                        //Image logo;
                          String extension = null;
                            if (file.lastIndexOf(".") > 0) {
                           extension = file.substring(file.lastIndexOf(".")+1);
           }*/
                      /* try {
                            //logo = Image.createImage(file).scaledHeight(500);;
                           // add(logo);
                            String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "photo.png";

                            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                                System.out.println(imageFile);
                                ImageIO.getImageIO().save(logo, os, ImageIO.FORMAT_PNG, 1);
                            } catch (IOException err) {
                            }
                        } catch (IOException ex) { 
                        }*/
                       /* String extension = null;
                        if (file.lastIndexOf(".") > 0) {
                            extension = file.substring(file.lastIndexOf(".") + 1);
                            StringBuilder hi = new StringBuilder(file);
                            if (file.startsWith("file://")) {
                                hi.delete(0, 7);
                            }
                            int lastIndexPeriod = hi.toString().lastIndexOf(".");
                            Log.p(hi.toString());
                            String ext = hi.toString().substring(lastIndexPeriod);
                            String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
                            try {
                                String podcastSource = saveFileToDevice(file, ext);
                                System.out.println(podcastSource);
                                this.podcast.setPodcastSource(podcastSource);
                            } catch (IOException ex) {
                            }

                            revalidate();

                        
                    }
                        });
           
            }
                
                        
    }*/
    
   
    public void onBtnupimageActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        if (FileChooser.isAvailable()){
            FileChooser.setOpenFilesInPlace(true);
            FileChooser.showOpenDialog(multiSelect.isSelected(), ".jpg, .jpeg, .png/plain", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource() == null) {
                        add("No file was selected");
                        revalidate();
                        return;
                    }
                    if (multiSelect.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }
            String file = (String) e2.getSource();
                    if (file == null) {
                        add("No file was selected");
                        revalidate();
                    } else {
			String hh = "http://127.0.0.1:8000/Files/podcastFiles/";									
                        
                        try {
                            logo = Image.createImage(file).scaledHeight(100);;
                            add(logo);
                            String imageFile = FileSystemStorage.getInstance().getAppHomePath();

                            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                                System.out.println(imageFile);
                                ImageIO.getImageIO().save(logo, os, ImageIO.FORMAT_PNG, 1);
                            } catch (IOException err) {
                            }
                        } catch (IOException ex) {
                        }
                        String extension = null;
                        if (file.lastIndexOf(".") > 0) {
                            extension = file.substring(file.lastIndexOf(".") + 1);
                            StringBuilder hi = new StringBuilder(file);
                            if (file.startsWith("file://")) {
                                hi.delete(0, 7);
                            }
                            int lastIndexPeriod = hi.toString().lastIndexOf(".");
                            Log.p(hi.toString());
                            String ext = hi.toString().substring(lastIndexPeriod);
                            String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
                            try {
                                String podcastImage = saveFileToDevice(file, ext);
                                System.out.println(podcastImage);
                                this.podcast.setPodcastImage(podcastImage);
                            } catch (IOException ex) {
                            }

                            
                            
                            revalidate();

                        
                    }
                    }
                        });
            
            }
                
                        
        }


}
