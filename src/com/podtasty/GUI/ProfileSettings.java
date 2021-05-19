/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
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
public class ProfileSettings extends com.codename1.ui.Form {

    public ProfileSettings() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }

    public ProfileSettings(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_Updateprofile = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_DesactiveAccount = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_LogOutBtn = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Updateprofile.addActionListener(callback);
        gui_DesactiveAccount.addActionListener(callback);
        gui_LogOutBtn.addActionListener(callback);
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

            if(sourceComponent == gui_Updateprofile) {
                onUpdateprofileActionEvent(ev);
            }
            if(sourceComponent == gui_DesactiveAccount) {
                onDesactiveAccountActionEvent(ev);
            }
            if(sourceComponent == gui_LogOutBtn) {
                onLogOutBtnActionEvent(ev);
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
        setTitle("ProfileSettings");
        setName("ProfileSettings");
        gui_Label.setText("   ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Updateprofile.setText("Update Profile");
                gui_Updateprofile.setInlineStylesTheme(resourceObjectInstance);
        gui_Updateprofile.setName("Updateprofile");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Updateprofile,"\ue853".charAt(0));
        gui_DesactiveAccount.setText("Desactive Account");
                gui_DesactiveAccount.setInlineStylesTheme(resourceObjectInstance);
        gui_DesactiveAccount.setName("DesactiveAccount");
        com.codename1.ui.FontImage.setMaterialIcon(gui_DesactiveAccount,"\ue14a".charAt(0));
        gui_DesactiveAccount.setPressedIcon(com.codename1.ui.FontImage.createMaterial("\ue88e".charAt(0), gui_DesactiveAccount.getPressedStyle()));
        gui_DesactiveAccount.setDisabledIcon(com.codename1.ui.FontImage.createMaterial("\ue88e".charAt(0), gui_DesactiveAccount.getDisabledStyle()));
        gui_LogOutBtn.setText("Logout");
                gui_LogOutBtn.setInlineStylesTheme(resourceObjectInstance);
        gui_LogOutBtn.setName("LogOutBtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_LogOutBtn,"\ue5c4".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_Updateprofile);
        addComponent(gui_DesactiveAccount);
        addComponent(gui_LogOutBtn);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm auto auto auto").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Updateprofile.getParent().getLayout()).setInsets(gui_Updateprofile, "6.878307mm auto auto auto").setReferenceComponents(gui_Updateprofile, "0 -1 -1 -1").setReferencePositions(gui_Updateprofile, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_DesactiveAccount.getParent().getLayout()).setInsets(gui_DesactiveAccount, "8.465609mm auto auto auto").setReferenceComponents(gui_DesactiveAccount, "0 -1 -1 -1").setReferencePositions(gui_DesactiveAccount, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LogOutBtn.getParent().getLayout()).setInsets(gui_LogOutBtn, "8.465609mm auto auto auto").setReferenceComponents(gui_LogOutBtn, "1 -1 -1 -1").setReferencePositions(gui_LogOutBtn, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onDesactiveAccountActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Dialog d = new Dialog();
        
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToProfile()));
        boolean i = d.show("Desactive Account", "Are you sure you want to desactiver youar account", "Sure", "No way");
        if (i) {
            ServiceUser su = new ServiceUser();
            UserHolder holder = UserHolder.getInstance();
            su.desactiveAccount(holder.getUser());
            if (su.desactiveAccount(holder.getUser())) {
                try {
                    new MyProfile().show();
                } catch (URISyntaxException ex) {
                    System.out.print(ex);
                } catch (IOException ex) {
                    System.out.print(ex);
                }
            }

        }
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
    private void backToHome() {
    this.deinitialize();
    HomeView.destroyFavViews();
    PodTasty.getHomeView().show();
}
    public void onLogOutBtnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Dialog d = new Dialog();

        boolean i = d.show("Log Out", "Are you sure you want to LogOut", "Sure", "No way");
        if (i) {
            UserHolder holder = UserHolder.getInstance();
            holder.setUser(null);
            PodTasty.getHomeView().setTheSideBar();
            backToHome();
          
        }
    }

    public void onUpdateprofileActionEvent(com.codename1.ui.events.ActionEvent ev) {
        new UpdateProfile().show();
    }

}
