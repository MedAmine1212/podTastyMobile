/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.podtasty.services.ServiceReclamation;
import com.podtasty.entities.Reclamation;
import com.podtasty.entities.UserHolder;
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
        this.setTitle("Report");
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

////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Label gui_Label = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.RadioButton gui_Radio_Button = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_1 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_2 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_3 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_4 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextArea gui_Text_Area  = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Button gui_sumbitReport = new com.codename1.ui.Button();
    protected com.codename1.ui.Button gui_cancelReport = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_sumbitReport.addActionListener(callback);
        gui_cancelReport.addActionListener(callback);
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

            if(sourceComponent == gui_sumbitReport) {
                onsumbitReportActionEvent(ev);
            }
            if(sourceComponent == gui_cancelReport) {
                oncancelReportActionEvent(ev);
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
        setTitle("AddRec");
        setName("AddRec");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        addComponent(gui_Box_Layout_Y);
        gui_Label.setText("  ");
                gui_Label.setInlineStylesTheme(resourceObjectInstance);
        gui_Label.setName("Label");
        gui_Label_1.setText("Report This Podcast  ");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setInlineAllStyles("font:5.0mm; alignment:center;");
        gui_Label_1.setName("Label_1");
        gui_Radio_Button.setText("Sexual Content");
                gui_Radio_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
        gui_Radio_Button.setName("Radio_Button");
        gui_Radio_Button_1.setText("Violent or Bloody Content");
                gui_Radio_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_1.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
        gui_Radio_Button_1.setName("Radio_Button_1");
        gui_Radio_Button_2.setText("Violent or Hateful Content");
                gui_Radio_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_2.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
        gui_Radio_Button_2.setName("Radio_Button_2");
        gui_Radio_Button_3.setText("Dangerous or Pernicious Acts");
                gui_Radio_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_3.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
        gui_Radio_Button_3.setName("Radio_Button_3");
        gui_Radio_Button_4.setText("Spam or Misleading Content");
                gui_Radio_Button_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_4.setInlineAllStyles("alignment:center; margin:5.0mm inherit inherit inherit;");
        gui_Radio_Button_4.setName("Radio_Button_4");
        gui_Text_Area .setHint("Report description ");
        gui_Text_Area .setText(" ");
                gui_Text_Area .setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area .setInlineAllStyles("margin:5.0mm inherit inherit inherit;");
        gui_Text_Area .setName("Text_Area ");
        gui_Text_Area .setColumns(8);
        gui_Text_Area .setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue3c9".charAt(0), gui_Text_Area .getUnselectedStyle()));
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setInlineAllStyles("alignment:center; margin:10.0mm inherit inherit inherit;");
        gui_Box_Layout_X.setName("Box_Layout_X");
        gui_Box_Layout_Y.addComponent(gui_Label);
        gui_Box_Layout_Y.addComponent(gui_Label_1);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button_1);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button_2);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button_3);
        gui_Box_Layout_Y.addComponent(gui_Radio_Button_4);
        gui_Box_Layout_Y.addComponent(gui_Text_Area );
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_X);
        gui_sumbitReport.setText("Sumbit report");
                gui_sumbitReport.setInlineStylesTheme(resourceObjectInstance);
        gui_sumbitReport.setInlineAllStyles("margin:inherit 10.0mm inherit inherit;");
        gui_sumbitReport.setName("sumbitReport");
        gui_cancelReport.setText("Cancel");
                gui_cancelReport.setInlineStylesTheme(resourceObjectInstance);
        gui_cancelReport.setName("cancelReport");
        gui_Box_Layout_X.addComponent(gui_sumbitReport);
        gui_Box_Layout_X.addComponent(gui_cancelReport);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_Y.getParent().getLayout()).setInsets(gui_Box_Layout_Y, "5.0mm 5.0mm 5.0mm 5.0mm").setReferenceComponents(gui_Box_Layout_Y, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_Y, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    private void backToPodcastCom() {
        this.deinitialize();
        PodcastComments.getInstance().show();
    }
    
    public void onsumbitReportActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
                    
       
       
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
            report.setPodcastIdId(PodcastComments.getCurrentPodcast());
            report.setUserIdId(UserHolder.getInstance().getUser());
            srRec.ajoutReclamation(report);
             
          Dialog.show("Alert" , "Report added successfully",new Command("OK"));
          
          backToPodcastCom();
           }catch (Exception ex){
             ex.printStackTrace();
          }   
       }
    }

    public void oncancelReportActionEvent(com.codename1.ui.events.ActionEvent ev) {
        backToPodcastCom();
    }

}
       
    



