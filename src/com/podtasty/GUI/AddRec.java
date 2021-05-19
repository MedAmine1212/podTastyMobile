/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.RadioButton;
import com.podtasty.services.ServiceReclamation;
import com.podtasty.entities.Reclamation;
import com.podtasty.entities.User;
import com.podtasty.entities.Podcast;
/**
 * GUI builder created Form
 *
 * @author LENOVO
 */
public class AddRec extends com.codename1.ui.Form {

    String rec="";
    
    
    Reclamation report ;
     
    
    
    

    public AddRec() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public AddRec(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        report = new Reclamation(); 
         
           gui_Radio_Button.addActionListener((e) -> {
                 rec = gui_Radio_Button.getText();
             });
               gui_Radio_Button_1.addActionListener((e) -> {
                 rec = gui_Radio_Button_1.getText();
             });
                gui_Radio_Button_2.addActionListener((e) -> {
                 rec = gui_Radio_Button_2.getText();
             });
                gui_Radio_Button_3.addActionListener((e) -> {
                rec = gui_Radio_Button_3.getText();
             });
                gui_Radio_Button_4.addActionListener((e) -> {
                 rec = gui_Radio_Button_4.getText();
             });

              new ButtonGroup(gui_Radio_Button, gui_Radio_Button_1, gui_Radio_Button_2, gui_Radio_Button_3, gui_Radio_Button_4);
        
    }

//////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.RadioButton gui_Radio_Button = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_1 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_2 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_3 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_4 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextArea gui_Text_Area = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button.addActionListener(callback);
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

            if(sourceComponent == gui_Button) {
                onButtonActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Report Podcast");
        setName("AddRec");
        gui_Label.setPreferredSizeStr("99.91533mm 4.8687553mm");
        gui_Label.setText("");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setPreferredSizeStr("89.75445mm inherit");
        gui_Label_1.setText("Report Podcast ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:6.0mm native:ItalicBold native:ItalicBold; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_Radio_Button.setPreferredSizeStr("89.96613mm inherit");
        gui_Radio_Button.setText("sexual content");
                gui_Radio_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button.setGroup("RBtn");
        gui_Radio_Button.setName("Radio_Button");
        gui_Radio_Button_1.setPreferredSizeStr("88.48434mm inherit");
        gui_Radio_Button_1.setText("violent or bloody content");
                gui_Radio_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_1.setGroup("RBtn");
        gui_Radio_Button_1.setName("Radio_Button_1");
        gui_Radio_Button_2.setPreferredSizeStr("89.75445mm inherit");
        gui_Radio_Button_2.setText("violent or hateful content");
                gui_Radio_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_2.setGroup("RBtn");
        gui_Radio_Button_2.setName("Radio_Button_2");
        gui_Radio_Button_3.setPreferredSizeStr("89.75445mm inherit");
        gui_Radio_Button_3.setText("dangerous or pernicious acts");
                gui_Radio_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_3.setGroup("RBtn");
        gui_Radio_Button_3.setName("Radio_Button_3");
        gui_Radio_Button_4.setPreferredSizeStr("89.75445mm inherit");
        gui_Radio_Button_4.setText("spam or misleading content");
                gui_Radio_Button_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_4.setGroup("RBtn");
        gui_Radio_Button_4.setName("Radio_Button_4");
        gui_Text_Area.setPreferredSizeStr("88.90771mm inherit");
        gui_Text_Area.setHint("Report description");
        gui_Text_Area.setText("");
                gui_Text_Area.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area.setInlineAllStyles("bgColor:110102; fgColor:110102;");
        gui_Text_Area.setName("Text_Area");
        gui_Text_Area.setColumns(8);
        gui_Text_Area.setRows(2);
        gui_Text_Area.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue3c9".charAt(0), gui_Text_Area.getUnselectedStyle()));
        gui_Button.setPreferredSizeStr("14.182896mm 8.255715mm");
        gui_Button.setText("Report");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        addComponent(gui_Label);
        addComponent(gui_Label_1);
        addComponent(gui_Radio_Button);
        addComponent(gui_Radio_Button_1);
        addComponent(gui_Radio_Button_2);
        addComponent(gui_Radio_Button_3);
        addComponent(gui_Radio_Button_4);
        addComponent(gui_Text_Area);
        addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label.getParent().getLayout()).setInsets(gui_Label, "5.0mm 5.0mm 93.0% 5.0mm").setReferenceComponents(gui_Label, "-1 -1 -1 -1").setReferencePositions(gui_Label, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "1.061007% 0.0mm auto 0.0mm").setReferenceComponents(gui_Label_1, "0 0 -1 0 ").setReferencePositions(gui_Label_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button.getParent().getLayout()).setInsets(gui_Radio_Button, "4.831625% 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_1.getParent().getLayout()).setInsets(gui_Radio_Button_1, "11.638723% 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_1, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_2.getParent().getLayout()).setInsets(gui_Radio_Button_2, "19.59937% 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_2, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_3.getParent().getLayout()).setInsets(gui_Radio_Button_3, "28.274284% 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_3, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_4.getParent().getLayout()).setInsets(gui_Radio_Button_4, "36.6706% 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_4, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Area.getParent().getLayout()).setInsets(gui_Text_Area, "auto 0.0mm 78.98146% 0.0mm").setReferenceComponents(gui_Text_Area, "6 0 -1 0 ").setReferencePositions(gui_Text_Area, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "2.5402205mm 0.0mm 77.95646% auto").setReferenceComponents(gui_Button, "7 0 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
          
                    
       
       
       if (rec==""){
                  Dialog.show("Alert" , "Please select report type",new Command("OK"));
                        }
       if ( gui_Text_Area.getText() ==""){
           Dialog.show("Alert" , "Please add your description",new Command("OK"));
            }
       else {    
           try {
          ServiceReclamation srRec = ServiceReclamation.getInstance();
            report.setType(rec);
          
          report.setDescription(gui_Text_Area.getText());

             Podcast pod = new Podcast();
          pod.setId(10);
                    User usr = new User();
            usr.setId(1);

            report.setPodcastIdId(pod);
            report.setUserIdId(usr);
          
          srRec.ajoutReclamation(report);
             
          Dialog.show("Alert" , "Report added successfully",new Command("OK"));
       
           }catch (Exception ex){
             ex.printStackTrace();
          }   
       }
    }
    
}
       
    



