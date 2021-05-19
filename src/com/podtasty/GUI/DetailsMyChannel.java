/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Playlist;
import com.podtasty.entities.User;
import com.podtasty.services.ServiceChannel;
import com.podtasty.services.ServicePlaylist;
import java.util.ArrayList;

/**
 *
 * @author Lwiss
 */
public class DetailsMyChannel extends Form {

    Form current;
    Image imgg = null;
    ImageViewer iv = null;
    EncodedImage ec;

    public DetailsMyChannel(Form previous, Channel Channel1) {
        current = this;
        User userConnected = new User();
        userConnected.setId(5);
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label channelid = new Label("" + Channel1.getId());
        Label channelname = new Label("" + Channel1.getChannel_Name());
        Label channelDescription = new Label("" + Channel1.getChannel_Description());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date = dateFormat.format(Channel1.getChannel_CreationDate());
        Label channeldate = new Label(date);
        Button Edit = new Button("Edit");
        Button delete = new Button("Delete");
        c3.add(Edit);
        c3.add(delete);
        channelid.setVisible(false);
        c1.add(channelid);
        c1.add(channelname);
        c1.add(channelDescription);
        c1.add(channeldate);
        Edit.addActionListener(e -> new EditChannel(current, Channel1).show());
        System.out.println(Channel1);
        c1.add(c3);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (ServiceChannel.getInstance().deleteChannel(Channel1.getId(), userConnected.getId())) {
                    Dialog.show("Success", "Channel deleted", new Command("OK"));
                    new MyChannel(current).show();
                } else {
                    Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            }
        });
        add(c1);
        ArrayList<Playlist> Playlists;
        Playlists = ServicePlaylist.getInstance().getPlaylistBychannel(Channel1.getId());

        Label soustitle = new Label("                        PlayList");
        Button AddPlayslist = new Button("Add New Playslist");
        Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        c5.add(soustitle);
        c5.add(AddPlayslist);
        AddPlayslist.addActionListener(e -> new addPlaylist(current).show());

        add(c5);
        for (Playlist Playlist1 : Playlists) {
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Label playlistlid = new Label("" + Playlist1.getId());
            Label playlistname = new Label("" + Playlist1.getPlaylistName());
            Label playlistDescription = new Label("" + Playlist1.getPlaylistDescription());
           DateFormat dateFormatz = new SimpleDateFormat("yyyy-MM-dd");

            String datez = dateFormatz.format(Playlist1.getPlaylistCreationDate());
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
            Button Editplaylist = new Button("Edit");
            Button deleteplaylist = new Button("Delete");
            c4.add(Editplaylist);
            c4.add(deleteplaylist);
            c2.add(c4);
            Editplaylist.addActionListener(e -> new EditPlaylist(current,Playlist1).show());
            deleteplaylist.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    if (ServicePlaylist.getInstance().deletePlaylist(Integer.parseInt(playlistlid.getText()))) {
                        Dialog.show("Success", "Playlist deleted", new Command("OK"));
                        new DetailsMyChannel(previous,Channel1).show();
                    } else {
                        Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                }
            });
            add(c2);
        }
               getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

               
    }

}
