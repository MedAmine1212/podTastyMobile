/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Channel;
import com.podtasty.entities.User;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Lwiss
 */
public class ServiceChannel {

    public ArrayList<Channel> Channels;

    public boolean resultOK;
    private static ServiceChannel instance = null;
    private ConnectionRequest req;

    private ServiceChannel() {
        req = new ConnectionRequest();
    }

    public static ServiceChannel getInstance() {
        if (instance == null) {
            instance = new ServiceChannel();
        }
        return instance;
    }

    
    public boolean  addChannel(Channel c,int iduser) {
        String url = Statics.BASE_URL + "/addChannel?channelName="+c.getChannel_Name()+"&channelDescription="+c.getChannel_Description()+"&iduser="+iduser;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String res = new String(req.getResponseData());

                //System.out.println("resaa: " + res);
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean  editChannel(Channel c,int idchannel) {
        String url = Statics.BASE_URL + "/updateChannel?channelName="+c.getChannel_Name()+"&channelDescription="+c.getChannel_Description()+"&idchannel="+idchannel;
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String res = new String(req.getResponseData());

                //System.out.println("resaa: " + res);
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    public ArrayList<Channel> getChannels() {
        String url = Statics.BASE_URL + "/getChannels";
        req.setUrl(url);
        System.out.println("hi url : " + url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String res = new String(req.getResponseData());

                Channels = parseChannell(res);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Channels;
    }
      public ArrayList<Channel> getChannelByuser(int iduser) {
        String url = Statics.BASE_URL + "/getChannel?iduser="+iduser;
        req.setUrl(url);
        System.out.println("hi url : " + url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String res = new String(req.getResponseData());
                    System.out.println("resultats: "+res);
                Channels = parseChannell(res);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Channels;
    }

    public ArrayList<Channel> parseChannell(String jsonText) {
        try {
            Channels = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche.               
            
            Le format Json impose que l'objet soit définit sous forme
            de clé valeur avec la valeur elle même peut être un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adéquate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Channel t = new Channel();
               if(obj.get("id")!=null)
               {
                    float id = Float.parseFloat(obj.get("id").toString());
                    t.setId((int) id);
               }
                   
                


                t.setChannel_Name(obj.get("ChannelName").toString());
                t.setChannel_Description(obj.get("ChannelDescription").toString());

        
                    t.setChannel_CreationDate(obj.get("ChannelCreationDate").toString());
               

                //Ajouter la tâche extraite de la réponse Json à la liste
                Channels.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex);

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
                String url = Statics.BASE_URL + "consultation/consultation/mobile";

         */
        return Channels;
    }
    public boolean deleteChannel(int id,int iduser) {
        String url = Statics.BASE_URL + "/deleteChannel/" + id+"?iduser="+iduser;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public Channel parseChannel(Map<String, Object> obj) throws IOException, ParseException {
        Channel channel = new Channel();
        float id = Float.parseFloat(obj.get("id").toString());
        channel.setId((int) id);
        channel.setChannel_Name(obj.get("ChannelName").toString());
        channel.setChannel_Description(obj.get("ChannelDescription").toString());
        float userId = Float.parseFloat(((Map<String, Object>) obj.get("UserId")).get("id").toString());
        ArrayList<User> users = ServiceUser.getInstance().getUserById((int) userId);
        channel.setUser(users.get(0));
        return channel;
    }

}
