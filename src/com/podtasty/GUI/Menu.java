/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Lwiss
 */
public class Menu extends  Form {
    Form current;

    public Menu() {
        current = this; //Récupération de l'interface(Form) en cours

        setTitle("Home");
        setLayout(BoxLayout.y());
     

        add(new Label("Choose an option"));
        Button btnAllchannel = new Button("All channels");
        Button btnYourchannel = new Button("Your Channel");

        btnAllchannel.addActionListener(e -> new AllChannels(current).show());
        btnYourchannel.addActionListener(e -> new MyChannel(current).show());

        addAll(btnAllchannel, btnYourchannel);

    }
    
}
