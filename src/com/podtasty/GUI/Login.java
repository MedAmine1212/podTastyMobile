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
import com.podtasty.entities.UserHolder;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class Login extends com.codename1.ui.Form {

    public Login() throws IOException {
        this(com.codename1.ui.util.Resources.getGlobalResources());

    }

    public Login(com.codename1.ui.util.Resources resourceObjectInstance) throws IOException {
        initGuiBuilderComponents(resourceObjectInstance);
        
        Style style = this.getAllStyles();
        this.getToolbar().setBackCommand(Command.create("", FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, style) , (e) -> backToHome()));
        InputStream in = Display.getInstance().getResourceAsStream(null, "/logo.png");
        Image logo = Image.createImage(in);
        this.gui_ImageContainer.setIcon(logo);
        this.gui_Password.setConstraint(PASSWORD);

    }
private void backToHome() {
    this.deinitialize();
    HomeView.destroyFavViews();
    PodTasty.getHomeView().show();
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_ImageContainer = new com.codename1.ui.Label();
    protected com.codename1.ui.TextField gui_Email = new com.codename1.ui.TextField();
    protected com.codename1.ui.TextField gui_Password = new com.codename1.ui.TextField();
    protected com.codename1.ui.Button gui_ButtonLogin = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Button gui_ButtonReg = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_error = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_ButtonLogin.addActionListener(callback);
        gui_ButtonReg.addActionListener(callback);
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

            if(sourceComponent == gui_ButtonLogin) {
                onButtonLoginActionEvent(ev);
            }
            if(sourceComponent == gui_ButtonReg) {
                onButtonRegActionEvent(ev);
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
        setTitle("Login");
        setName("Login");
        gui_Label.setPreferredSizeStr("12.433863mm inherit");
        gui_Label.setText(" ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_ImageContainer.setText(" ");
                gui_ImageContainer.setInlineStylesTheme(resourceObjectInstance);
        gui_ImageContainer.setName("ImageContainer");
        gui_Email.setPreferredSizeStr("84.65608mm inherit");
        gui_Email.setHint("Email");
                gui_Email.setInlineStylesTheme(resourceObjectInstance);
        gui_Email.setName("Email");
        gui_Email.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue7fd".charAt(0), gui_Email.getUnselectedStyle()));
        gui_Password.setPreferredSizeStr("84.65608mm inherit");
        gui_Password.setHint("Password");
                gui_Password.setInlineStylesTheme(resourceObjectInstance);
        gui_Password.setName("Password");
        gui_Password.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue897".charAt(0), gui_Password.getUnselectedStyle()));
        gui_ButtonLogin.setPreferredSizeStr("85.71429mm inherit");
        gui_ButtonLogin.setText("Login");
                gui_ButtonLogin.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonLogin.setName("ButtonLogin");
        gui_Label_1.setPreferredSizeStr("81.48148mm inherit");
        gui_Label_1.setText("You don't have an account");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:4.0mm; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_ButtonReg.setPreferredSizeStr("81.216934mm inherit");
        gui_ButtonReg.setText("Register");
                gui_ButtonReg.setInlineStylesTheme(resourceObjectInstance);
        gui_ButtonReg.setName("ButtonReg");
        gui_error.setText(" ");
        gui_error.setUIID("error");
                gui_error.setInlineStylesTheme(resourceObjectInstance);
        gui_error.setInlineAllStyles("bgColor:ff0000; fgColor:ff0000;");
        gui_error.setName("error");
        addComponent(gui_Label);
        addComponent(gui_ImageContainer);
        addComponent(gui_Email);
        addComponent(gui_Password);
        addComponent(gui_ButtonLogin);
        addComponent(gui_Label_1);
        addComponent(gui_ButtonReg);
        addComponent(gui_error);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "1.5873017mm 10.0% auto 10.0%").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ImageContainer.getParent().getLayout()).setInsets(gui_ImageContainer, "0.0mm auto auto auto").setReferenceComponents(gui_ImageContainer, "0 0 -1 0 ").setReferencePositions(gui_ImageContainer, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Email.getParent().getLayout()).setInsets(gui_Email, "1.3227501mm auto auto auto").setReferenceComponents(gui_Email, "1 0 -1 0 ").setReferencePositions(gui_Email, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Password.getParent().getLayout()).setInsets(gui_Password, "0.0mm auto auto auto").setReferenceComponents(gui_Password, "2 0 -1 0 ").setReferencePositions(gui_Password, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonLogin.getParent().getLayout()).setInsets(gui_ButtonLogin, "2.380951mm auto auto auto").setReferenceComponents(gui_ButtonLogin, "3 -1 -1 -1").setReferencePositions(gui_ButtonLogin, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "4.4973545mm auto auto auto").setReferenceComponents(gui_Label_1, "4 0 -1 -1").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_ButtonReg.getParent().getLayout()).setInsets(gui_ButtonReg, "3.4391534mm auto auto auto").setReferenceComponents(gui_ButtonReg, "5 5 -1 0 ").setReferencePositions(gui_ButtonReg, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_error.getParent().getLayout()).setInsets(gui_error, "auto auto 0.0mm auto").setReferenceComponents(gui_error, "4 1 5 5 ").setReferencePositions(gui_error, "0.0 1.0 1.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonRegActionEvent(com.codename1.ui.events.ActionEvent ev) {
            Register RegForm=null;
        try {
            RegForm = new Register();
        } catch (IOException ex) {
            System.out.print(ex); 
        }
            RegForm.show();         
    }

    public void onButtonLoginActionEvent(com.codename1.ui.events.ActionEvent ev) {
            ServiceUser su = new ServiceUser();
            if (su.Validate(this.gui_Email.getText(), this.gui_Password.getText()) == false) {
                this.gui_error.setText("Login failed");
            } else {
                this.gui_error.setText(" ");
            }
            UserHolder holder = UserHolder.getInstance();
            holder.setUser(su.getUserByMail(this.gui_Email.getText()).get(0));
            PodTasty.getHomeView().setTheSideBar();
            backToHome();
            System.out.print(su.Validate(this.gui_Email.getText(), this.gui_Password.getText()));
        
    }

}
