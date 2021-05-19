    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.charts.util.ColorUtil;
import com.codename1.gif.GifImage;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.callSerially;
import static com.codename1.ui.CN.getResourceAsStream;
import com.codename1.ui.Command;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.podtasty.entities.Podcast;
import com.podtasty.entities.Tag;
import com.podtasty.entities.User;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.LoadImage;
import com.podtasty.services.ServiceFavorites;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class HomeView extends com.codename1.ui.Form {
    
    ArrayList<Podcast> podcasts;
    private Tag currentTag = new Tag();
    private static Favorites favView;
    private static PodcastComments podView;
    private static MyProfile profileView;
    private static Login loginView;
    
    Command openFav;
    Command openProfile;
    Command openLogin;
    ArrayList<Tag> tags;
    public HomeView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public HomeView(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        
        this.setTitle("PodTasty");
        
            setTheSideBar();
            
         Image loading;
        try {
            loading = GifImage.decode(getResourceAsStream("/spinner.gif"), 1177720);
            gui_loadingImg.setImage(loading);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void setTheSideBar() {
        for(Command com : this.getToolbar().getSideMenuCommands()) {
            this.getToolbar().removeCommand(com);
        }
        Style style = this.getAllStyles();
        openFav = Command.create("Favorites", FontImage.createMaterial(FontImage.MATERIAL_FAVORITE_BORDER, style) , (e) -> openFav());
        openLogin = Command.create("Login", FontImage.createMaterial(FontImage.MATERIAL_LOCK, style) , (e) -> openLogin());
        openProfile = Command.create("Profile", FontImage.createMaterial(FontImage.MATERIAL_ACCOUNT_CIRCLE, style) , (e) -> openProfile());
        if (UserHolder.getInstance().getUser() != null) {
            this.getToolbar().addCommandToLeftSideMenu(openProfile);
            this.getToolbar().addCommandToLeftSideMenu(openFav);
        } else {
            this.getToolbar().addCommandToLeftSideMenu(openLogin);
        }
        this.getToolbar().refreshTheme();
        this.refreshTheme();
    }
    public void openLogin() {
        try {
            loginView  = new Login();
        loginView.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void openProfile() {
        try {
            profileView  = new MyProfile();
        profileView.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Favorites geFavView() {
        return favView;
    }
    
    public static PodcastComments getPodView() {
        return podView;
    }
      public static void setPodView(PodcastComments view) {
        podView = view;
    }
     public static void destroyFavViews() {
         favView = null;
    }
    private void openFav() {
        
        
        favView  = new Favorites();
        favView.show();
        favView.setPodcasts(ServiceFavorites.getInstance().getUserFavorites(UserHolder.getInstance().getUser().getId()));
    }
       
        
    public void setPodcastsAndTags(ArrayList<Tag> tags, ArrayList<Podcast> podcasts) {
        this.podcasts = podcasts;
        this.tags = tags;
        setUpView();
    }
    private void setUpView(){
        
        gui_podcastContainer.setPreferredSizeStr("AUTO");
        gui_bigContainer.setPreferredSizeStr("AUTO");
        Button allTags = new Button("All");
        Tag all = new Tag();
        all.setId(-1);
        allTags.addActionListener((e) -> {
            refreshPods(all);
        });
        this.gui_tagsContainer.add(allTags);
          if (this.tags != null) {
            if (this.tags.size() > 0) {
                for(Tag tag: tags) {
                this.gui_tagsContainer.add(new Label("  "));
                Button newTag = new Button(tag.getName());
                newTag.addActionListener((e) -> {
                    refreshPods(tag);
                });
                this.gui_tagsContainer.add(newTag);
                }
            }
        }
          this.gui_tagsContainer.refreshTheme();
          gui_bigContainer.refreshTheme();
          this.refreshTheme();
           refreshPods(all);
    }
    
    private void addPodToView(Podcast pod) {
        PodcastView podView = new PodcastView();
        podView.setUpView(pod ,false);
        podView.getToolbar().hideToolbar();
        
        if (pod.getPodcastImage() != null) {
        new Thread(() -> {
            callSerially(() -> {
                LoadImage loader = new LoadImage(pod.getPodcastImage(), podView, false);
                loader.start();
                loader = null;
            });
       
        }).start();
        }
          if (pod.getPlaylistIdId().getChannelIdId().getUser().getUserInfoIdId().getUserImage() != null) {
        new Thread(() -> {
            callSerially(() -> {
                LoadImage loader = new LoadImage(pod.getPlaylistIdId().getChannelIdId().getUser().getUserInfoIdId().getUserImage(), podView, true);
                loader.start();
                loader = null;
            });
       
        }).start();
        }
        this.gui_podcastContainer.addComponent(TOP, podView);
         
    }
    private void refreshPods(Tag tag) {
        if (!Objects.equals(this.currentTag.getId(), tag.getId())) {
            this.currentTag = tag;
            int i =0;
            gui_podcastContainer.removeAll();
            this.gui_loadingImg.setVisible(true);
            this.gui_podcastContainer.refreshTheme();
            gui_bigContainer.refreshTheme();
            this.refreshTheme();
             if (this.podcasts != null) {
                if (this.podcasts.size() > 0) {
                    for(Podcast pod: podcasts) {
                        if(tag.getId() == -1) {
                            i++;
                            addPodToView(pod);
                        } else {
                            if (pod.getTagCollection().contains(tag)) {
                                i++;
                                addPodToView(pod);
                            }
                        }
                    }
                } else {
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(FlowLayout.encloseCenter(new Label("No podcasts to show")));
                 i++;
                }
            } else {
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(FlowLayout.encloseCenter(new Label("No podcasts to show")));
                 i++;
             }
             if (i == 0) {
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(new Label(" "));
                 gui_podcastContainer.add(FlowLayout.encloseCenter(new Label("No podcasts to show")));
             }

            this.gui_loadingImg.setVisible(false);
            this.gui_podcastContainer.refreshTheme();
            gui_bigContainer.refreshTheme();
            this.refreshTheme();
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_bigContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_tagsContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Container gui_podcastContainer = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_loadingImg = new com.codename1.components.ImageViewer();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("HomeView");
        setName("HomeView");
        gui_bigContainer.setPreferredSizeStr("71.97291mm 121.29551mm");
        gui_bigContainer.setScrollableY(false);
                gui_bigContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_bigContainer.setName("bigContainer");
        addComponent(gui_bigContainer);
        gui_tagsContainer.setScrollableX(true);
                gui_tagsContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_tagsContainer.setName("tagsContainer");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_podcastContainer.setPreferredSizeStr("98.01016mm 0.0mm");
        gui_podcastContainer.setScrollableY(true);
                gui_podcastContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_podcastContainer.setName("podcastContainer");
        gui_loadingImg.setPreferredSizeStr("28.154106mm 22.438612mm");
                gui_loadingImg.setInlineStylesTheme(resourceObjectInstance);
        gui_loadingImg.setName("loadingImg");
        gui_bigContainer.addComponent(gui_tagsContainer);
        gui_bigContainer.addComponent(gui_Box_Layout_X);
        gui_Label.setText("    ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setText("  ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:80px;");
        gui_Label_1.setName("Label_1");
        gui_Box_Layout_X.addComponent(gui_Label);
        gui_Box_Layout_X.addComponent(gui_Label_1);
        gui_bigContainer.addComponent(gui_podcastContainer);
        gui_bigContainer.addComponent(gui_loadingImg);
        ((com.codename1.ui.layouts.LayeredLayout)gui_bigContainer.getParent().getLayout()).setInsets(gui_bigContainer, "5.0mm 1.0mm 5.0mm 1.0mm").setReferenceComponents(gui_bigContainer, "-1 -1 -1 -1").setReferencePositions(gui_bigContainer, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
