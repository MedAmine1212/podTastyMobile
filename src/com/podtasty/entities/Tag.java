/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.podtasty.entities;
import java.util.Collection;
import javafx.scene.image.ImageView;

/**
 *
 * @author khail
 */
public class Tag {

    private Integer id;
    private String name;
    private String tagStyle;
    private Collection<Podcast> podcastCollection;
    
    private ImageView tagColor;


    public Tag() {
    }

    public Tag(Integer id) {
        this.id = id;
    }

    public Tag(Integer id, String name, String tagStyle) {
        this.id = id;
        this.name = name;
        this.tagStyle = tagStyle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagStyle() {
        return tagStyle;
    }

    public void setTagStyle(String tagStyle) {
        this.tagStyle = tagStyle;
    }

    public Collection<Podcast> getPodcastCollection() {
        return podcastCollection;
    }

    public void setPodcastCollection(Collection<Podcast> podcastCollection) {
        this.podcastCollection = podcastCollection;
    }
    
    
    public ImageView getTagColor() {
        return tagColor;
    }

    public void setTagColor(ImageView tagColor) {
        this.tagColor = tagColor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tag_1[ id=" + id + " ]";
    }
    
}
