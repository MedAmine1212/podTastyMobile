/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.FileSystemStorage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.UserHolder;
import com.podtasty.services.ServiceUser;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Hashtable;

/**
 * GUI builder created Form
 *
 * @author Douiri Amine
 */
public class ContinueReg extends com.codename1.ui.Form {

    public ContinueReg() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public ContinueReg(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
//        this.gui_GenderInput
   //     this.gui_GenderInput.addItem("Male");
     //   this.gui_GenderInput.addItem("Female");
     this.gui_BirthdateInput.setType(Display.PICKER_TYPE_DATE);
    }

//////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.spinner.Picker gui_BirthdateInput = new com.codename1.ui.spinner.Picker();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_BDLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_GenderLabel = new com.codename1.ui.Label();
    protected com.codename1.ui.ComboBox gui_GenderInput = new com.codename1.ui.ComboBox("Male","Female");
    protected com.codename1.ui.Button gui_Register = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Register.addActionListener(callback);
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

            if(sourceComponent == gui_Register) {
                onRegisterActionEvent(ev);
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
        setTitle("ContinueReg");
        setName("ContinueReg");
        gui_BirthdateInput.setPreferredSizeStr("42.06349mm inherit");
        gui_BirthdateInput.setText("...");
                gui_BirthdateInput.setInlineStylesTheme(resourceObjectInstance);
        gui_BirthdateInput.setName("BirthdateInput");
        com.codename1.ui.FontImage.setMaterialIcon(gui_BirthdateInput,"\ue916".charAt(0));
        gui_BirthdateInput.setType(4);
        gui_Label_1.setPreferredSizeStr("100.5291mm 8.465609mm");
        gui_Label_1.setText("   ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_BDLabel.setText("BirthDate");
                gui_BDLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_BDLabel.setName("BDLabel");
        gui_GenderLabel.setText("Gender");
                gui_GenderLabel.setInlineStylesTheme(resourceObjectInstance);
        gui_GenderLabel.setName("GenderLabel");
                gui_GenderInput.setInlineStylesTheme(resourceObjectInstance);
        gui_GenderInput.setName("GenderInput");
        gui_Register.setText("Register");
                gui_Register.setInlineStylesTheme(resourceObjectInstance);
        gui_Register.setName("Register");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Register,"\ue163".charAt(0));
        addComponent(gui_BirthdateInput);
        addComponent(gui_Label_1);
        addComponent(gui_BDLabel);
        addComponent(gui_GenderLabel);
        addComponent(gui_GenderInput);
        addComponent(gui_Register);
        ((com.codename1.ui.layouts.LayeredLayout)gui_BirthdateInput.getParent().getLayout()).setInsets(gui_BirthdateInput, "0.0mm auto auto auto").setReferenceComponents(gui_BirthdateInput, "2 -1 -1 -1").setReferencePositions(gui_BirthdateInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 19.972067% auto 26.396648%").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_BDLabel.getParent().getLayout()).setInsets(gui_BDLabel, "0.0mm auto auto auto").setReferenceComponents(gui_BDLabel, "1 -1 -1 -1").setReferencePositions(gui_BDLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_GenderLabel.getParent().getLayout()).setInsets(gui_GenderLabel, "0.0mm auto auto auto").setReferenceComponents(gui_GenderLabel, "0 -1 -1 -1").setReferencePositions(gui_GenderLabel, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_GenderInput.getParent().getLayout()).setInsets(gui_GenderInput, "0.0mm auto auto auto").setReferenceComponents(gui_GenderInput, "3 -1 -1 -1").setReferencePositions(gui_GenderInput, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Register.getParent().getLayout()).setInsets(gui_Register, "0.0mm auto auto auto").setReferenceComponents(gui_Register, "4 -1 -1 -1").setReferencePositions(gui_Register, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        Display.getInstance().openGallery(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                if (ev != null && ev.getSource() != null) {
                    String filePath = (String) ev.getSource();
                    int fileNameIndex = filePath.lastIndexOf("/") + 1;
                    String fileName = filePath.substring(fileNameIndex);

                    Image img = null;
                    try {
                        img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            //        MultiList photoList = findPhotoList();
                    Hashtable tableItem = new Hashtable();
                    tableItem.put("icon", img.scaled(Display.getInstance().getDisplayHeight() / 10, -1));
                    tableItem.put("emblem", fileName);
              //      photoList.getModel().addItem(tableItem);
                    // Do something, add to List
                }
            }

        }, Display.GALLERY_IMAGE);
    }

    public void onRegisterActionEvent(com.codename1.ui.events.ActionEvent ev) {
        String s = this.gui_BirthdateInput.getDate().toString();
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(this.gui_BirthdateInput.getDate());
        String b = this.gui_GenderInput.getSelectedItem().toString();
        if(this.gui_BirthdateInput.getDate()!=null &&this.gui_GenderInput.getSelectedItem()!=null){
              UserHolder holder = UserHolder.getInstance();
              holder.getUser().getUserInfoIdId().setUserGender(b);
              holder.getUser().getUserInfoIdId().setUserBirthDate(date);
              ServiceUser su = new ServiceUser();
              su.ContinueReg(holder.getUser());
              if(su.ContinueReg(holder.getUser())){
                  try {
                      new MyProfile().show();
                  } catch (URISyntaxException | IOException ex) {
                      System.out.print(ex);
                  }
              }
        }else{
            
        }

    }

}
