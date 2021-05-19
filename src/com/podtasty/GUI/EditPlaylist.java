/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Playlist;
import com.podtasty.services.ServicePlaylist;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Lwiss
 */
public class EditPlaylist extends com.codename1.ui.Form {

    Form current;
    private Image img = null;
    private String fileName = "";
    private String filePath = "";
    Image imgg = null;
    ImageViewer iv = null;
    EncodedImage ec;
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_playlistName = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_playlistDescription = new com.codename1.ui.TextField();
    protected com.codename1.ui.Container gui_Container = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Button gui_btnUpload = new com.codename1.ui.Button();
    protected com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Button gui_btnAdd = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_btnCancel = new com.codename1.ui.Button();
    protected com.codename1.components.ImageViewer gui_cover = new com.codename1.components.ImageViewer();
    Playlist plalistt = new Playlist();

    public EditPlaylist(Form previous, Playlist p) {

        this(com.codename1.ui.util.Resources.getGlobalResources());
        setTitle("Update your Playlist");
        gui_Label.setText("Update this Playlist");
        gui_btnAdd.setText("Update");
        current = this;
        plalistt = p;
        gui_playlistName.setText(p.getPlaylistName());
        gui_playlistDescription.setText(p.getPlaylistDescription());
        String url = "http://localhost/Pod-Tasty-web/public/images/playlist/" + p.getImageName();
        int deviceWidth = Display.getInstance().getDisplayWidth();
        Image placeholder = Image.createImage(deviceWidth, deviceWidth / 2, 0xbfc9d2);
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
        imgg = URLImage.createToStorage(encImage, url, url, URLImage.RESIZE_SCALE);

        gui_cover.setImage(imgg);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

    public EditPlaylist(com.codename1.ui.util.Resources resourceObjectInstance) {
        gui_cover.setHeight(850);
        gui_cover.setWidth(1120);
        initGuiBuilderComponents(resourceObjectInstance);

    }

//////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_btnUpload.addActionListener(callback);
        gui_btnAdd.addActionListener(callback);
        gui_btnCancel.addActionListener(callback);
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

            if (sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if (sourceComponent == gui_btnUpload) {
                onbtnUploadActionEvent(ev);
            }
            if (sourceComponent == gui_btnAdd) {
                onbtnAddActionEvent(ev);
            }
            if (sourceComponent == gui_btnCancel) {
                onbtnCancelActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }

    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
        setInlineStylesTheme(resourceObjectInstance);
        setTitle("addPlaylist");
        setName("addPlaylist");
        gui_Label.setText("Add new Playlist");
        gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setInlineAllStyles("alignment:center;");
        gui_Label.setName("Label");
        gui_playlistName.setHint("Playlist Name");
        gui_playlistName.setInlineStylesTheme(resourceObjectInstance);
        gui_playlistName.setName("playlistName");
        gui_playlistDescription.setHint("Playlist Description");
        gui_playlistDescription.setInlineStylesTheme(resourceObjectInstance);
        gui_playlistDescription.setName("playlistDescription");
        gui_Container.setInlineStylesTheme(resourceObjectInstance);
        gui_Container.setName("Container");
        gui_Container_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_1.setInlineAllStyles("transparency:0;");
        gui_Container_1.setName("Container_1");
        gui_cover.setInlineStylesTheme(resourceObjectInstance);
        gui_cover.setName("cover");
        addComponent(gui_Label);
        addComponent(gui_playlistName);
        addComponent(gui_playlistDescription);
        addComponent(gui_Container);
        gui_btnUpload.setText("Upload Cover");
        gui_btnUpload.setInlineStylesTheme(resourceObjectInstance);
        gui_btnUpload.setName("btnUpload");
        gui_btnUpload.setPressedIcon(com.codename1.ui.FontImage.createMaterial("\ue439".charAt(0), gui_btnUpload.getPressedStyle()));
        gui_Container.addComponent(gui_btnUpload);
        addComponent(gui_Container_1);
        gui_btnAdd.setText("Create");
        gui_btnAdd.setInlineStylesTheme(resourceObjectInstance);
        gui_btnAdd.setName("btnAdd");
        gui_btnCancel.setText("Cancel");
        gui_btnCancel.setInlineStylesTheme(resourceObjectInstance);
        gui_btnCancel.setName("btnCancel");
        gui_Container_1.addComponent(gui_btnAdd);
        gui_Container_1.addComponent(gui_btnCancel);
        addComponent(gui_cover);
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onbtnAddActionEvent(com.codename1.ui.events.ActionEvent ev) {
        gui_cover.setHeight(850);
        gui_cover.setWidth(1120);
        if (gui_playlistName.getText().isEmpty() || gui_playlistDescription.getText().isEmpty() || img == null) {
            Dialog.show("Empty Alert", "Please Fill in All the Informations", "Ok", null);

            gui_cover.setHeight(850);
            gui_cover.setWidth(1120);
        } else {
            ServicePlaylist sp = ServicePlaylist.getInstance();

            plalistt.setPlaylistName(gui_playlistName.getText());
            plalistt.setPlaylistDescription(gui_playlistDescription.getText());
            if (sp.EditPlaylist(plalistt, filePath, fileName)) {
                Dialog.show("Success", "Playlist updated successfuly", "Ok", null);
                   new DetailsMyChannel(current, MyChannel.Mychannelss).show();
            }

        }
    }

    public void onbtnCancelActionEvent(com.codename1.ui.events.ActionEvent ev) {
    }

    public void onbtnUploadActionEvent(com.codename1.ui.events.ActionEvent ev) {

        Display.getInstance().openGallery(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (ev != null && ev.getSource() != null) {
                    filePath = (String) ev.getSource();
                    int fileNameIndex = filePath.lastIndexOf("/") + 1;
                    fileName = filePath.substring(fileNameIndex);

                    img = null;

                    try {
                        img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                        gui_cover.setHeight(850);
                        gui_cover.setWidth(1120);
                        gui_cover.setImage(img);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    // Do something, add to List
                }
            }

        }, Display.GALLERY_IMAGE);

    }

}
