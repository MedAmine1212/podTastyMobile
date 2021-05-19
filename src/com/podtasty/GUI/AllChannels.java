/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.podtasty.entities.Channel;
import com.podtasty.services.ServiceChannel;
import java.util.ArrayList;

/**
 *
 * @author Lwiss
 */
public class AllChannels extends Form {

    Form current;

    public AllChannels(Form previous) {
        current=this;
        ArrayList<Channel> Channels;
        Channels = ServiceChannel.getInstance().getChannels();
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        for (Channel Channel1 : Channels) {
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
            details.addActionListener(e -> new DetailsChannel(current, Channel1).show());

        }
        add(c1);
                       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    }

}
