/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import static com.codename1.ui.TextArea.PASSWORD;
import com.codename1.ui.plaf.Style;
import com.podtasty.app.PodTasty;
import com.podtasty.entities.User;
import com.podtasty.entities.UserHolder;
import com.podtasty.entities.UserInfo;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.io.InputStream;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class Register extends com.codename1.ui.Form {
    
    public Register() throws IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Register(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException {
        initGuiBuilderComponents(resourceObjectInstance);
        
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToLogin()));
        InputStream in = Display.getInstance().getResourceAsStream(null, "/logo.png");
        Image logo = Image.createImage(in);
        this.gui_ImageContainer.setIcon(logo);
        this.gui_PWInput.setConstraint(PASSWORD);
        this.gui_CPWInput.setConstraint(PASSWORD);
        
        //    this.gui_PasswordInput.setConstraint(PASSWORD);

    }

private void backToLogin() {
    this.deinitialize();
    HomeView.destroyFavViews();
    PodTasty.getHomeView().show();
}
////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_emaillabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_EmailInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_FSLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_FSInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_LSLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_LSInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_PasswordLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_PWInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Label gui_ConfirmPasswordLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_CPWInput = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_RegisterBtn = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_Backtologinbtn = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_RegisterBtn.addActionListener(callback);
        gui_Backtologinbtn.addActionListener(callback);
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

            if(sourceComponent == gui_RegisterBtn) {
                onRegisterBtnActionEvent(ev);
            }
            if(sourceComponent == gui_Backtologinbtn) {
                onBacktologinbtnActionEvent(ev);
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
        setTitle("Register");
        setName("Register");
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_ImageContainer.setText(" ");
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setName("ImageContainer");
        gui_emaillabel.setPreferredSizeStr("23.280424mm inherit");
        gui_emaillabel.setText("Email");
                gui_emaillabel.setInlineStylesTheme(resourceObjectInstance);
        gui_emaillabel.setName("emaillabel");
        gui_EmailInput.setHint("Email");
                gui_EmailInput.setInlineStylesTheme(resourceObjectInstance);
        gui_EmailInput.setName("EmailInput");
        gui_EmailInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue0be".charAt(0), gui_EmailInput.getUnselectedStyle()));
        gui_FSLabel.setText("First Name");
                gui_FSLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_FSLabel.setName("FSLabel");
        gui_FSInput.setHint("First Name");
                gui_FSInput.setInlineStylesTheme(resourceObjectInstance);
        gui_FSInput.setName("FSInput");
        gui_FSInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_FSInput.getUnselectedStyle()));
        gui_LSLabel.setText("Last Name");
                gui_LSLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_LSLabel.setName("LSLabel");
        gui_LSInput.setHint("Last Name");
                gui_LSInput.setInlineStylesTheme(resourceObjectInstance);
        gui_LSInput.setName("LSInput");
        gui_LSInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_LSInput.getUnselectedStyle()));
        gui_PasswordLabel.setText("Password");
                gui_PasswordLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_PasswordLabel.setName("PasswordLabel");
        gui_PWInput.setHint("Password");
                gui_PWInput.setInlineStylesTheme(resourceObjectInstance);
        gui_PWInput.setName("PWInput");
        gui_PWInput.setColumns(20);
        gui_PWInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_PWInput.getUnselectedStyle()));
        gui_ConfirmPasswordLabel.setText("Confirm Password");
                gui_ConfirmPasswordLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_ConfirmPasswordLabel.setName("ConfirmPasswordLabel");
        gui_CPWInput.setHint("Confirm Password");
                gui_CPWInput.setInlineStylesTheme(resourceObjectInstance);
        gui_CPWInput.setName("CPWInput");
        gui_CPWInput.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_CPWInput.getUnselectedStyle()));
        gui_RegisterBtn.setText("Register");
                gui_RegisterBtn.setInlineStylesTheme(resourceObjectInstance);
        gui_RegisterBtn.setName("RegisterBtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_RegisterBtn,"\ue163".charAt(0));
        gui_Backtologinbtn.setText("Back to login");
                gui_Backtologinbtn.setInlineStylesTheme(resourceObjectInstance);
        gui_Backtologinbtn.setName("Backtologinbtn");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Backtologinbtn,"\ue5c4".charAt(0));
        addComponent(gui_Label);
        addComponent(gui_ImageContainer);
        addComponent(gui_emaillabel);
        addComponent(gui_EmailInput);
        addComponent(gui_FSLabel);
        addComponent(gui_FSInput);
        addComponent(gui_LSLabel);
        addComponent(gui_LSInput);
        addComponent(gui_PasswordLabel);
        addComponent(gui_PWInput);
        addComponent(gui_ConfirmPasswordLabel);
        addComponent(gui_CPWInput);
        addComponent(gui_RegisterBtn);
        addComponent(gui_Backtologinbtn);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "0.0mm 10.0% auto 10.0%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ImageContainer.getParent().getLayout()).setInsets(gui_ImageContainer, "0.0mm auto auto auto").setReferenceComponents(gui_ImageContainer, "0 -1 -1 -1").setReferencePositions(gui_ImageContainer, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_emaillabel.getParent().getLayout()).setInsets(gui_emaillabel, "0.0mm auto auto auto").setReferenceComponents(gui_emaillabel, "1 -1 -1 -1").setReferencePositions(gui_emaillabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_EmailInput.getParent().getLayout()).setInsets(gui_EmailInput, "0.0mm auto auto auto").setReferenceComponents(gui_EmailInput, "2 -1 -1 -1").setReferencePositions(gui_EmailInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FSLabel.getParent().getLayout()).setInsets(gui_FSLabel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_FSLabel, "3 -1 -1 2 ").setReferencePositions(gui_FSLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_FSInput.getParent().getLayout()).setInsets(gui_FSInput, "0.0mm auto auto auto").setReferenceComponents(gui_FSInput, "4 -1 -1 -1").setReferencePositions(gui_FSInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LSLabel.getParent().getLayout()).setInsets(gui_LSLabel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_LSLabel, "5 -1 -1 2 ").setReferencePositions(gui_LSLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_LSInput.getParent().getLayout()).setInsets(gui_LSInput, "0.0mm auto auto auto").setReferenceComponents(gui_LSInput, "6 -1 -1 -1").setReferencePositions(gui_LSInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_PasswordLabel.getParent().getLayout()).setInsets(gui_PasswordLabel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_PasswordLabel, "7 -1 -1 2 ").setReferencePositions(gui_PasswordLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_PWInput.getParent().getLayout()).setInsets(gui_PWInput, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_PWInput, "8 -1 -1 3 ").setReferencePositions(gui_PWInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ConfirmPasswordLabel.getParent().getLayout()).setInsets(gui_ConfirmPasswordLabel, "0.0mm auto auto 0.0mm").setReferenceComponents(gui_ConfirmPasswordLabel, "9 -1 -1 2 ").setReferencePositions(gui_ConfirmPasswordLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_CPWInput.getParent().getLayout()).setInsets(gui_CPWInput, "0.0mm auto auto auto").setReferenceComponents(gui_CPWInput, "10 -1 -1 -1").setReferencePositions(gui_CPWInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_RegisterBtn.getParent().getLayout()).setInsets(gui_RegisterBtn, "2.1164021mm auto auto 0.0mm").setReferenceComponents(gui_RegisterBtn, "11 -1 -1 4 ").setReferencePositions(gui_RegisterBtn, "1.0 0.0 0.0 1.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Backtologinbtn.getParent().getLayout()).setInsets(gui_Backtologinbtn, "0.0mm auto auto 1.3227539mm").setReferenceComponents(gui_Backtologinbtn, "12 -1 -1 3 ").setReferencePositions(gui_Backtologinbtn, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onRegisterBtnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        this.gui_emaillabel.setText("Email");
        this.gui_FSLabel.setText("First Name");
        this.gui_LSLabel.setText("Last Name");
        this.gui_ConfirmPasswordLabel.setText("Confirmation Password");
        this.gui_PasswordLabel.setText("Password");
        if (this.gui_EmailInput.getText().equals("") == false
                && this.gui_PWInput.getText().equals(this.gui_CPWInput.getText())
                && this.gui_FSInput.getText().equals("") == false
                && this.gui_LSInput.getText().equals("") == false) {
            ServiceUser su = new ServiceUser();
            
            if (su.checkMailExist(this.gui_EmailInput.getText()) == false) {
                System.out.print(su.checkMailExist(this.gui_emaillabel.getText()));
                User user = new User();
                user.setUserEmail(this.gui_EmailInput.getText());
                user.setUserPassword(this.gui_PWInput.getText());
                UserInfo info = new UserInfo();
                info.setUserFirstName(this.gui_FSInput.getText());
                info.setUserLastName(this.gui_LSInput.getText());
                 if(su.RegisterUser(user, info))
            {
                User currentuser = su.getUserByMail(user.getUserEmail()).get(0);
                UserHolder holder = UserHolder.getInstance();
                holder.setUser(currentuser);
                new ContinueReg().show();                
            }
            } else {
                this.gui_emaillabel.setText("Email : Already Exist");
            }
            
        } else {
            if (this.gui_EmailInput.getText().equals("")) {
                this.gui_emaillabel.setText("Email :required");
            }
            if (this.gui_FSInput.getText().equals("")) {
                this.gui_FSLabel.setText("First Name :required");
            }
            if (this.gui_LSInput.getText().equals("")) {
                this.gui_LSLabel.setText("Last Name : required");
            }
            if (this.gui_PWInput.getText().equals(this.gui_CPWInput.getText()) == false) {
                this.gui_ConfirmPasswordLabel.setText("Password :Dosent match");
            }
        }
        
    }
    
    public void onBacktologinbtnActionEvent(com.codename1.ui.events.ActionEvent ev) {
        try {
            new Login().show();
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }

}
