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
public class addChannel extends Form {

    Form current;

    public addChannel(Form previous) {
        current =this;
        Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        User userConnected =new User();
        userConnected.setId(5);
        TextField channelname = new TextField();
        TextField channelDescritpion = new TextField();
        Button add = new Button("add");
        c1.add(channelname);
        c1.add(channelDescritpion);
        c1.add(add);
        add(c1);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Channel c = new Channel(channelname.getText(), channelDescritpion.getText());
                if (ServiceChannel.getInstance().addChannel(c,userConnected.getId())) {
                    Dialog.show("Success", "Channel added", new Command("OK"));
                    new Menu().show();
                } else {
                    Dialog.show("ERROR", "Server error", new Command("OK"));
                }
            }
        });
               getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

    }

}
