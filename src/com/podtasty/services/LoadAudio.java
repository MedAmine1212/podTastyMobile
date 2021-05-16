/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.BufferedInputStream;
import com.codename1.io.URL;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 *
 * @author khail
 */
public class LoadAudio extends Thread{
   
    private static LoadAudio instance;
    private String audioUrl;
    Media audio;
  
    public static LoadAudio getInstance() {
        if(instance == null){
            instance = new LoadAudio();
        }
        return instance;
    }
    
    public static void destroyInstance() {
        instance = null;
        System.out.println("audioLoader destroyed");
    }
    
    @Override
    public void run(){
          URL  url;
        try {
            System.out.println("fetching audio for: "+audioUrl);
            url = new URL(Statics.BASE_URL+"/Files/podcastFiles/"+audioUrl);
            URL.URLConnection httpcon = url.openConnection();
            InputStream stream = new BufferedInputStream(httpcon.getInputStream());
            audio = MediaManager.createMedia(stream, "audio",null);
        } catch (URISyntaxException ex) {
            System.out.println("Audio error 1: "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Audio error 2: "+ex.getMessage());
        }
       
    }
    public static void main(String[] args) {
        instance.start();
    }
    
    public void startAudio() {
        try{
        System.out.println("starting audio...");
        audio.play();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void pauseAudio() {
        try{
        System.out.println("pausing audio...");
        audio.pause();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void stopAudio() throws IOException {
       
        try{
        System.out.println("destroying audio...");
        audio.cleanup();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void setAudioUrl(String url) {
        audioUrl = url;
    }
    
    public void repeat() throws IOException {
       
    }
    
    public boolean isPlaying() {
        return audio.isPlaying();
    }
}
