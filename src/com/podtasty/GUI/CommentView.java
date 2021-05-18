/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.podtasty.entities.PodcastComment;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.podtasty.services.ServicePodcastComment;
import java.util.Objects;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class CommentView extends Form {
SimpleDateFormat simpleDateFormat;
PodcastComment comm;
PodcastComments parent;
    public CommentView(){
        
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public CommentView(com.codename1.ui.util.Resources resourceObjectInstance) {
        simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
        initGuiBuilderComponents(resourceObjectInstance);
    }
    public void setView(PodcastComment com, PodcastComments podView) throws URISyntaxException, IOException{
        parent = podView;
        this.comm = com;
        gui_userName.setText(com.getUserName());
        String date = simpleDateFormat.format(com.getCommentDate());  
        gui_commentDate.setText(date);
        gui_commentText.setText(com.getCommentText());
                
           try {
                   InputStream in = Display.getInstance().getResourceAsStream(null, "/avatar.jpg");
                   Image  loadImg = Image.createImage(in);
                   gui_userImg.setImage(loadImg);
                   
                    gui_userImg.addLongPressListener(e -> {
                               if (!Objects.equals(com.getUserIdId().getId(), HomeView.getCurrentUser().getId())) {
                                    Dialog.show("Comment details", "Owner: "+com.getUserName()+"\n\nDate: "+date, "Close", null);
                               } else {
                                   
                                   setDialog(com, date);
                               }
                                
                              });   
               } catch (IOException ex) {
                   System.out.println(ex.getMessage());
               }
             
               
    }
    
    public void setUserImg(Image img) {
        this.gui_userImg.setImage(img);
    }
public void setDialog(PodcastComment com, String date) {
     Button delButton = new Button();
    delButton.setText("Delete");
    Button editButton = new Button();
    editButton.setText("Edit");
   
    Button cancelButton = new Button();
    cancelButton.setText("Close");
    Container pn = new Container();
    Dialog d = new Dialog("Comment details");
    TextArea popupBody = new TextArea("Owner: "+com.getUserName()+"\n\nDate: "+date, 3, 20);
    popupBody.setEditable(false);
    popupBody.setEnabled(false);
    pn.addComponent(popupBody);
    pn.addComponent(editButton);
    pn.addComponent(delButton);
    pn.addComponent(cancelButton);
    d.setLayout(new BorderLayout());

    d.add(BorderLayout.CENTER, pn);
     
    editButton.addActionListener(e -> {
        showEdit(com, d);
        
    });
    
    delButton.addActionListener(e -> {
        delComment(com.getId());
        d.dispose();
    });
     cancelButton.addActionListener(e -> {
        d.dispose();
        
    });
    d.show();
}
public void delComment(int id) {
    ServicePodcastComment sr = ServicePodcastComment.getInstance();
    if (sr.deleteComment(id)) {
    parent.removeCommentView(this);
    } else {
        System.out.println("error");
    }
    
}

public void showEdit(PodcastComment com, Dialog par) {
        Dialog d = new Dialog("Edit comment");
        TextArea popupBody = new TextArea(com.getCommentText(), 3, 20);
        popupBody.setUIID("comText");
        d.setLayout(new BorderLayout());
        Button saveButton = new Button();
        saveButton.setText("Save");
        Button cancelButton = new Button();
        cancelButton.setText("Cancel");
        Container buttons = new Container();
        Container pn = new Container();
        buttons.add(saveButton);
        buttons.add(cancelButton);
        pn.add(popupBody);
        pn.add(buttons);
        d.setLayout(new BorderLayout());
        d.add(BorderLayout.CENTER, pn);
        cancelButton.addActionListener(e -> {
            d.dispose();
        
        });
        
        saveButton.addActionListener(e -> {
            if (!popupBody.getText().equals(com.getCommentText()) && popupBody.getText().length() > 0) {
                
            ServicePodcastComment sr = ServicePodcastComment.getInstance();
            if(sr.updateComment(com.getId(), popupBody.getText())) {
                
             com.setCommentText(popupBody.getText());
             this.gui_commentText.setText(com.getCommentText());
             d.dispose();
             par.dispose();
             parent.updateCommentView();
            }
            }
        
        });
        d.show();
};
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Container gui_Box_Layout_X = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.X_AXIS));
    protected com.codename1.ui.Container gui_Box_Layout_Y_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.ImageViewer gui_userImg = new com.codename1.components.ImageViewer();
    protected com.codename1.components.SpanLabel gui_commentDate = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Container gui_Box_Layout_Y = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.SpanLabel gui_userName = new com.codename1.components.SpanLabel();
    protected com.codename1.ui.Container gui_Box_Layout_Y_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.components.SpanLabel gui_commentText = new com.codename1.components.SpanLabel();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setScrollableY(false);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("");
        setName("CommentView");
        gui_Box_Layout_X.setPreferredSizeStr("124.89416mm 24.767147mm");
                gui_Box_Layout_X.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_X.setName("Box_Layout_X");
        addComponent(gui_Box_Layout_X);
                gui_Box_Layout_Y_2.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_2.setName("Box_Layout_Y_2");
        gui_Box_Layout_Y.setPreferredSizeStr("70.49111mm 33.02286mm");
                gui_Box_Layout_Y.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y.setName("Box_Layout_Y");
        gui_Box_Layout_X.addComponent(gui_Box_Layout_Y_2);
        gui_userImg.setPreferredSizeStr("18.416595mm 16.934801mm");
                gui_userImg.setInlineStylesTheme(resourceObjectInstance);
        gui_userImg.setName("userImg");
        gui_commentDate.setText("Span Label");
                gui_commentDate.setInlineStylesTheme(resourceObjectInstance);
        gui_commentDate.setInlineAllStyles("font:45px;");
        gui_commentDate.setName("commentDate");
        gui_Box_Layout_Y_2.addComponent(gui_userImg);
        gui_Box_Layout_Y_2.addComponent(gui_commentDate);
        gui_Box_Layout_X.addComponent(gui_Box_Layout_Y);
        gui_userName.setText("Span Label");
                gui_userName.setInlineStylesTheme(resourceObjectInstance);
        gui_userName.setInlineAllStyles("font:70px;");
        gui_userName.setName("userName");
        gui_Box_Layout_Y_1.setScrollableY(true);
                gui_Box_Layout_Y_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Box_Layout_Y_1.setName("Box_Layout_Y_1");
        gui_Box_Layout_Y.addComponent(gui_userName);
        gui_Box_Layout_Y.addComponent(gui_Box_Layout_Y_1);
        gui_commentText.setText("Span Label");
                gui_commentText.setInlineStylesTheme(resourceObjectInstance);
        gui_commentText.setInlineAllStyles("font:50px;");
        gui_commentText.setName("commentText");
        gui_Box_Layout_Y_1.addComponent(gui_commentText);
        ((com.codename1.ui.layouts.LayeredLayout)gui_Box_Layout_X.getParent().getLayout()).setInsets(gui_Box_Layout_X, "2.4233701mm 0.72988987mm 1.57663mm 3.2701101mm").setReferenceComponents(gui_Box_Layout_X, "-1 -1 -1 -1").setReferencePositions(gui_Box_Layout_X, "0.0 0.0 0.0 0.0");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
