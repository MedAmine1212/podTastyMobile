/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

/**
 * GUI builder created Form
 *
 * @author LENOVO
 */
public class Report_Pods extends com.codename1.ui.Form {

    public Report_Pods() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public Report_Pods(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    protected com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    protected com.codename1.ui.RadioButton gui_Radio_Button = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_1 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_2 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_3 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.RadioButton gui_Radio_Button_4 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.TextArea gui_Text_Area = new com.codename1.ui.TextArea();
    protected com.codename1.ui.Button gui_Button = new com.codename1.ui.Button();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Reclamation");
        setName("Reclamation");
        gui_Label_1.setPreferredSizeStr("58.21338mm 5.5038104mm");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        gui_Label_2.setText("Report Podcast");
                gui_Label_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_2.setInlineAllStyles("font:5.0mm native:MainRegular native:MainRegular; fgColor:0; alignment:center;");
        gui_Label_2.setName("Label_2");
        gui_Radio_Button.setPreferredSizeStr("86.1558mm inherit");
        gui_Radio_Button.setSelected(false);
        gui_Radio_Button.setText("sexual content");
                gui_Radio_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button.setInlineAllStyles("font:native:MainRegular native:MainRegular; bgColor:ffffff; fgColor:ffffff;");
        gui_Radio_Button.setGroup("Rbtn");
        gui_Radio_Button.setName("Radio_Button");
        gui_Radio_Button_1.setPreferredSizeStr("86.1558mm inherit");
        gui_Radio_Button_1.setText("violent or bloody content");
                gui_Radio_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_1.setGroup("Rbtn");
        gui_Radio_Button_1.setName("Radio_Button_1");
        gui_Radio_Button_2.setPreferredSizeStr("86.1558mm inherit");
        gui_Radio_Button_2.setSelected(false);
        gui_Radio_Button_2.setText("violent or hateful content");
                gui_Radio_Button_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_2.setGroup("Rbtn");
        gui_Radio_Button_2.setName("Radio_Button_2");
        gui_Radio_Button_3.setPreferredSizeStr("86.1558mm inherit");
        gui_Radio_Button_3.setSelected(false);
        gui_Radio_Button_3.setText("dangerous or pernicious acts");
                gui_Radio_Button_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_3.setGroup("Rbtn");
        gui_Radio_Button_3.setName("Radio_Button_3");
        gui_Radio_Button_4.setPreferredSizeStr("86.1558mm inherit");
        gui_Radio_Button_4.setText("spam or misleading content ");
                gui_Radio_Button_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Radio_Button_4.setGroup("Rbtn");
        gui_Radio_Button_4.setName("Radio_Button_4");
        gui_Text_Area.setPreferredSizeStr("92.08298mm 11.219306mm");
        gui_Text_Area.setHint("Report description");
        gui_Text_Area.setText("");
                gui_Text_Area.setInlineStylesTheme(resourceObjectInstance);
        gui_Text_Area.setInlineAllStyles("bgColor:110102; fgColor:0;");
        gui_Text_Area.setName("Text_Area");
        gui_Text_Area.setColumns(8);
        gui_Text_Area.setHintIcon(com.codename1.ui.FontImage.createMaterial("\ue3c9".charAt(0), gui_Text_Area.getUnselectedStyle()));
        gui_Button.setText("Report");
                gui_Button.setInlineStylesTheme(resourceObjectInstance);
        gui_Button.setName("Button");
        addComponent(gui_Label_1);
        addComponent(gui_Label_2);
        addComponent(gui_Radio_Button);
        addComponent(gui_Radio_Button_1);
        addComponent(gui_Radio_Button_2);
        addComponent(gui_Radio_Button_3);
        addComponent(gui_Radio_Button_4);
        addComponent(gui_Text_Area);
        addComponent(gui_Button);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_1.getParent().getLayout()).setInsets(gui_Label_1, "0.0mm 5.0mm 92.28972% 5.0mm").setReferenceComponents(gui_Label_1, "-1 -1 -1 -1").setReferencePositions(gui_Label_1, "0.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Label_2.getParent().getLayout()).setInsets(gui_Label_2, "0.0mm 5.0mm auto 5.0mm").setReferenceComponents(gui_Label_2, "0 0 -1 0 ").setReferencePositions(gui_Label_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button.getParent().getLayout()).setInsets(gui_Radio_Button, "2.328535mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button, "1 0 -1 0 ").setReferencePositions(gui_Radio_Button, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_1.getParent().getLayout()).setInsets(gui_Radio_Button_1, "2.328535mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_1, "2 0 -1 0 ").setReferencePositions(gui_Radio_Button_1, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_2.getParent().getLayout()).setInsets(gui_Radio_Button_2, "2.1168501mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_2, "3 0 -1 0 ").setReferencePositions(gui_Radio_Button_2, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_3.getParent().getLayout()).setInsets(gui_Radio_Button_3, "2.328535mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_3, "4 0 -1 0 ").setReferencePositions(gui_Radio_Button_3, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Radio_Button_4.getParent().getLayout()).setInsets(gui_Radio_Button_4, "2.1168501mm 0.0mm auto 0.0mm").setReferenceComponents(gui_Radio_Button_4, "5 0 -1 0 ").setReferencePositions(gui_Radio_Button_4, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Text_Area.getParent().getLayout()).setInsets(gui_Text_Area, "auto 0.0mm 58.29146% 0.0mm").setReferenceComponents(gui_Text_Area, "6 0 -1 0 ").setReferencePositions(gui_Text_Area, "1.0 0.0 0.0 0.0");
        ((com.codename1.ui.layouts.LayeredLayout)gui_Button.getParent().getLayout()).setInsets(gui_Button, "0.0mm 0.0mm auto auto").setReferenceComponents(gui_Button, "7 0 -1 -1").setReferencePositions(gui_Button, "1.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButtonActionEvent(com.codename1.ui.events.ActionEvent ev) {
        try  {
            if (gui_Radio_Button.isSelected() && gui_Radio_Button_1.isSelected() && gui_Text_Area.getText()=="" ){
                
            }
            
        }catch (Exception ex){
          ex.printStackTrace();
    }

}

}
