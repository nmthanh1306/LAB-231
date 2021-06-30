/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author Minh Thanh
 */
public class Gallery {

    private int id;
    private String gallery_title;
    private String content;
    private String main_image;
    private List<Image> listImage;

    public Gallery() {
    }

    public Gallery(int id, String gallery_title, String content, String main_image) {
        this.id = id;
        this.gallery_title = gallery_title;
        this.content = content;
        this.main_image = main_image;
    }

    public Gallery(int id, String gallery_title, String content, String main_image, List<Image> listImage) {
        this.id = id;
        this.gallery_title = gallery_title;
        this.content = content;
        this.main_image = main_image;
        this.listImage = listImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGallery_title() {
        return gallery_title;
    }

    public void setGallery_title(String gallery_title) {
        this.gallery_title = gallery_title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public List<Image> getListImage() {
        return listImage;
    }

    public void setListImage(List<Image> listImage) {
        this.listImage = listImage;
    }
}
