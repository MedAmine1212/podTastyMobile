/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;
import com.podtasty.entities.Channel;
import com.podtasty.entities.Playlist;
import com.podtasty.entities.PodcastComment;
import com.podtasty.entities.User;
import com.podtasty.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lwiss
 */
public class ServicePlaylist {

    public ArrayList<Playlist> Playlists;
    public boolean resultOK;
    private static ServicePlaylist instance = null;
    private ConnectionRequest req;

    public ServicePlaylist() {
        req = new ConnectionRequest();
    }

    public static ServicePlaylist getInstance() {
        if (instance == null) {
            instance = new ServicePlaylist();
        }
        return instance;
    }

    public boolean editPlaylist(Playlist p) {
        String url = Statics.BASE_URL + "/updatePlaylist/" + p.getId() + "?playlistName=" + p.getPlaylistName() + "&playlistDescription=" + p.getPlaylistDescription() + "&pic=" + p.getImageName();
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

    public ArrayList<Playlist> getPlaylistBychannel(int idchannel) {
        String url = Statics.BASE_URL + "/getOwnPlaylists?idchannel=" + idchannel;
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String res = new String(req.getResponseData());

                Playlists = parseChannell(res);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Playlists;
    }

    public ArrayList<Playlist> parseChannell(String jsonText) {
        try {
            Playlists = new ArrayList<>();
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
                Playlist t = new Playlist();
                if (obj.get("id") != null) {
                    float id = Float.parseFloat(obj.get("id").toString());
                    t.setId((int) id);
                }

                t.setPlaylistName(obj.get("PlaylistName").toString());
                t.setPlaylistDescription(obj.get("PlaylistDescription").toString());
                t.setPlaylistCreationDate(obj.get("PlaylistCreationDate").toString());
                if (obj.get("imageName") != null) {
                    t.setImageName(obj.get("imageName").toString());

                }

                //Ajouter la tâche extraite de la réponse Json à la liste
                Playlists.add(t);
            }

        } catch (IOException ex) {
            System.out.println(ex);

        }
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
                String url = Statics.BASE_URL + "consultation/consultation/mobile";

         */
        return Playlists;
    }

    @SuppressWarnings("deprecation")
    public boolean addPlaylist(Playlist p, String path, String name) {

        Channel c = new Channel();
        c.setId(1);

        String url = Statics.BASE_URL + "/addPlaylist";
        MultipartRequest req = new MultipartRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("playlistName", p.getPlaylistName());
        req.addArgument("playlistDescription", p.getPlaylistDescription());
        req.addArgument("idchannel", ""+p.getChannelIdId());
        try {
            req.addData("pic", path, "image/png");
            req.setFilename("fileUpload", name);
        } catch (IOException e) {
        }

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean EditPlaylist(Playlist p, String path, String name) {

        Channel c = new Channel();
        c.setId(1);
        System.out.println(p);
        String url = Statics.BASE_URL + "/updatePlaylist/" + p.getId();
        MultipartRequest req = new MultipartRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("playlistName", p.getPlaylistName());
        req.addArgument("playlistDescription", p.getPlaylistDescription());
        try {
            req.addData("pic", path, "image/png");
            req.setFilename("fileUpload", name);
        } catch (IOException e) {
        }
        System.out.println("url: " + url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean deletePlaylist(int id) {
        String url = Statics.BASE_URL + "/deletePlaylist/" + id;
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

}
