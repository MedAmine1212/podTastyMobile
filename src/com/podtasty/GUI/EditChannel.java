/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.podtasty.entities.Channel;
import com.podtasty.entities.User;
import com.podtasty.services.ServiceChannel;

/**
 *
 * @author Lwiss
 */
public class EditChannel extends Form {

    Form current;

    public EditChannel(Form previous, Channel c) {
        current = this;
        System.out.println(c);
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        User userConnected = new User();
        userConnected.setId(5);
        TextField channelname = new TextField();
        channelname.setText(c.getChannel_Name());
        TextField channelDescritpion = new TextField();
        channelDescritpion.setText(c.getChannel_Description());
        Button edit = new Button("edit");
        c1.add(channelname);
        c1.add(channelDescritpion);
        c1.add(edit);
        add(c1);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Channel ch = new Channel(channelname.getText(), channelDescritpion.getText());
                System.out.println(c);
                if (ServiceChannel.getInstance().editChannel(ch, c.getId())) {
                    Dialog.show("Success", "Channel edited", new Command("OK"));
                    new MyChannel(previous).show();
                } else {
                    Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            }
        });
                       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    }

}
