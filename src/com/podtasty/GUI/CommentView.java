/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.GUI;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.io.URL.URLConnection;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Image;
import com.podtasty.entities.PodcastComment;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * GUI builder created Form
 *
 * @author khail
 */
public class CommentView extends com.codename1.ui.Form {
SimpleDateFormat simpleDateFormat;
    public CommentView() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public CommentView(com.codename1.ui.util.Resources resourceObjectInstance) {
        simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
        initGuiBuilderComponents(resourceObjectInstance);
    }
    
    public void setView(PodcastComment com) throws URISyntaxException, IOException{
        gui_userName.setText(com.getUserName());
        String date = simpleDateFormat.format(com.getCommentDate());  
        gui_commentDate.setText(date);
        gui_commentText.setText(com.getCommentText());
        URL url = new URL("http://127.0.0.1:8000/Files/podcastFiles/"+com.getUserIdId().getUserInfoIdId().getUserImage());
          URLConnection httpcon = url.openConnection();
         InputStream stream = new BufferedInputStream(httpcon.getInputStream());
         Image img = Image.createImage(stream);
        gui_userImg.setImage(img);
        
    }

//////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!
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
