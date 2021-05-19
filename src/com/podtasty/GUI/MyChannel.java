/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.podtasty.entities.Channel;
import com.podtasty.entities.User;
import com.podtasty.services.ServiceChannel;
import java.util.ArrayList;

/**
 *
 * @author Lwiss
 */
public class MyChannel extends Form {

    Form current;
    public static Channel Mychannelss;

    public MyChannel(Form previous) {
        current = this;
        User userConnected = new User();
        userConnected.setId(5);
        ArrayList<Channel> Channels;
        Channels = ServiceChannel.getInstance().getChannelByuser(userConnected.getId());
        if (Channels.size() != 0) {
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

            for (Channel Channel1 : Channels) {
                Mychannelss = Channel1;
                Label channelid = new Label("" + Channel1.getId());
                Label channelname = new Label("" + Channel1.getChannel_Name());
                Label channelDescription = new Label("" + Channel1.getChannel_Description());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                String date = dateFormat.format(Channel1.getChannel_CreationDate());
                Label channeldate = new Label(date);
                Button details = new Button("details");
                channelid.setVisible(false);
                c1.add(channelid);
                c1.add(channelname);
                c1.add(channelDescription);
                c1.add(channeldate);
                c1.add(details);
                details.addActionListener(e -> new DetailsMyChannel(current, Channel1).show());

            }
            add(c1);
        } else {

            Dialog.show("No Channel", "You didn't have a channel ", new Command("OK"));
            Label title = new Label("You didn't have a channel");
            Button addchannel = new Button("add channel");
            add(title);

            add(addchannel);
            addchannel.addActionListener(e -> new addChannel(current).show());

        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

}
