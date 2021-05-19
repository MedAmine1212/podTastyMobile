/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Playlist;
import com.podtasty.services.ServicePlaylist;
import java.util.ArrayList;

/**
 *
 * @author Lwiss
 */
public class DetailsChannel extends Form {

    Form current;
    Image imgg = null;
    ImageViewer iv = null;
    EncodedImage ec;

    public DetailsChannel(Form previous, Channel Channel1) {
        current = this;
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        Label channelid = new Label("" + Channel1.getId());
        Label channelname = new Label("" + Channel1.getChannel_Name());
        Label channelDescription = new Label("" + Channel1.getChannel_Description());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date = dateFormat.format(Channel1.getChannel_CreationDate());
        Label channeldate = new Label(date);
        channelid.setVisible(false);
        c1.add(channelid);
        c1.add(channelname);
        c1.add(channelDescription);
        c1.add(channeldate);
        add(c1);
        ArrayList<Playlist> Playlists;
        Playlists = ServicePlaylist.getInstance().getPlaylistBychannel(Channel1.getId());
        Label soustitle = new Label("                        PlayList");
        add(soustitle);
        for (Playlist Playlist1 : Playlists) {
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            Label playlistlid = new Label("" + Playlist1.getId());
            Label playlistname = new Label("" + Playlist1.getPlaylistName());
            Label playlistDescription = new Label("" + Playlist1.getPlaylistDescription());

            String datez = dateFormat.format(Playlist1.getPlaylistCreationDate());
            Label playlistdate = new Label(datez);
            String url = "http://localhost/Pod-Tasty-web/public/images/playlist/" + Playlist1.getImageName();
            int deviceWidth = Display.getInstance().getDisplayWidth();
            Image placeholder = Image.createImage(deviceWidth, deviceWidth / 2, 0xbfc9d2);
            EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
            imgg = URLImage.createToStorage(encImage, url, url, URLImage.RESIZE_SCALE);
            iv = new ImageViewer(imgg);

            playlistlid.setVisible(false);
            c2.add(playlistlid);
            c2.add(playlistname);
            c2.add(playlistDescription);
            c2.add(playlistdate);
            c2.add(iv);
            add(c2);
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
