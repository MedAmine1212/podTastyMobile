/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Command;
import com.codename1.ui.FontImage;
import com.codename1.ui.plaf.Style;
import com.podtasty.entities.User;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class UpdateProfile extends com.codename1.ui.Form {

    public UpdateProfile() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public UpdateProfile(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);

        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToProfile()));
        UserHolder holder = UserHolder.getInstance();
        User u = holder.getUser();
        if (u.getUserInfoIdId().getUserFirstName() == null) {
            this.gui_FNInput.setText("");

        } else {
            this.gui_BioInput.setText(u.getUserInfoIdId().getUserBio());
        }

        this.gui_FNInput.setText(u.getUserInfoIdId().getUserFirstName());
        this.gui_LNInput.setText(u.getUserInfoIdId().getUserLastName());
    }
    public void backToProfile() {
    this.deinitialize();
    MyProfile pr;
        try {
            pr = new MyProfile();
    pr.show();
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
//////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_FNLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_FNInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_LNLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_LNInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_BioLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_BioInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_UpdateBtn = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_UpdateBtn.addActionListener(callback);
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

            if(sourceComponent == gui_UpdateBtn) {
                onUpdateBtnActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(true);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("UpdateProfile");
        setName("UpdateProfile");
        gui_Label.setText("   ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_FNLabel.setText("First Name");
                gui_FNLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_FNLabel.setName("FNLabel");
        gui_FNInput.setText("TextField");
                gui_FNInput.setInlineStylesTheme(resourceObjectInstance);
        gui_FNInput.setName("FNInput");
        gui_FNInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_FNInput.getUnselectedStyle()));
        gui_LNLabel.setText("Last Name");
                gui_LNLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_LNLabel.setName("LNLabel");
        gui_LNInput.setText("TextField");
                gui_LNInput.setInlineStylesTheme(resourceObjectInstance);
        gui_LNInput.setName("LNInput");
        gui_BioLabel.setText("Bio");
                gui_BioLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_BioLabel.setName("BioLabel");
        gui_BioInput.setText("TextField");
                gui_BioInput.setInlineStylesTheme(resourceObjectInstance);
        gui_BioInput.setName("BioInput");
        gui_BioInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue23c".charAt(0), gui_BioInput.getUnselectedStyle()));
        gui_UpdateBtn.setText("Update");
                gui_UpdateBtn.setInlineStylesTheme(resourceObjectInstance);
        gui_UpdateBtn.setName("UpdateBtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_UpdateBtn,"\ue163".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_FNLabel);
        addComponent(gui_FNInput);
        addComponent(gui_LNLabel);
        addComponent(gui_LNInput);
        addComponent(gui_BioLabel);
        addComponent(gui_BioInput);
        addComponent(gui_UpdateBtn);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FNLabel.getParent().getLayout()).setInsets(gui_FNLabel, "6.878307mm auto auto auto").setReferenceComponents(gui_FNLabel, "0 -1 -1 -1").setReferencePositions(gui_FNLabel, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FNInput.getParent().getLayout()).setInsets(gui_FNInput, "6.878307mm auto auto auto").setReferenceComponents(gui_FNInput, "0 -1 -1 -1").setReferencePositions(gui_FNInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LNLabel.getParent().getLayout()).setInsets(gui_LNLabel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LNLabel, "2 -1 -1 1 ").setReferencePositions(gui_LNLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LNInput.getParent().getLayout()).setInsets(gui_LNInput, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LNInput, "3 -1 -1 2 ").setReferencePositions(gui_LNInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BioLabel.getParent().getLayout()).setInsets(gui_BioLabel, "0.0mm auto auto auto").setReferenceComponents(gui_BioLabel, "4 -1 -1 -1").setReferencePositions(gui_BioLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BioInput.getParent().getLayout()).setInsets(gui_BioInput, "0.0mm auto auto auto").setReferenceComponents(gui_BioInput, "5 -1 -1 -1").setReferencePositions(gui_BioInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_UpdateBtn.getParent().getLayout()).setInsets(gui_UpdateBtn, "3.1746025mm auto auto auto").setReferenceComponents(gui_UpdateBtn, "6 -1 -1 -1").setReferencePositions(gui_UpdateBtn, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onUpdateBtnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        if (this.gui_FNInput.getText().equals("") == false
                && this.gui_LNInput.getText().equals("") == false
                && this.gui_BioInput.getText().equals("") == false) {
            ServiceUser su = new ServiceUser();
            UserHolder holder = UserHolder.getInstance();
            User u = holder.getUser();
            su.updateProfile(u.getId(), this.gui_FNInput.getText(), this.gui_LNInput.getText(), this.gui_BioInput.getText());
            if (su.updateProfile(u.getId(), this.gui_FNInput.getText(), this.gui_LNInput.getText(), this.gui_BioInput.getText())) {
                holder.getUser().getUserInfoIdId().setUserBio(this.gui_BioInput.getText());
                holder.getUser().getUserInfoIdId().setUserFirstName(this.gui_FNInput.getText());
                holder.getUser().getUserInfoIdId().setUserLastName(this.gui_LNInput.getText());
                try {
                    new MyProfile().show();
                } catch (URISyntaxException ex) {
                    System.out.print(ex);
                } catch (IOException ex) {
                    System.out.print(ex);
                }
            }
        } else {
            if (this.gui_FNInput.getText().equals("")) {
                this.gui_FNLabel.setText("First Name : required");
            }
            if (this.gui_LNInput.getText().equals("")) {
                this.gui_LNLabel.setText("Last Name : required");
            }
            if (this.gui_BioInput.getText().equals("")) {
                this.gui_BioLabel.setText("Bio : required");
            }
        }
    }

}
