/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Minh Thanh
 */
public class Photographer {
    private String name;
    private String address;
    private String city;
    private String country;
    private int tel;
    private String email;
    private String aboutMe;
    private String map;
    private String feature_Image;
    private String title_Feature_Image;

    public Photographer() {
    }
    
    public Photographer(String name, String address, String city, String country, int tel, String email, String aboutMe, String map, String feature_Image, String title_Feature_Image) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.tel = tel;
        this.email = email;
        this.aboutMe = aboutMe;
        this.map = map;
        this.feature_Image = feature_Image;
        this.title_Feature_Image = title_Feature_Image;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
    
    

    public String getFeature_Image() {
        return feature_Image;
    }

    public void setFeature_Image(String feature_Image) {
        this.feature_Image = feature_Image;
    }

    public String getTitle_Feature_Image() {
        return title_Feature_Image;
    }

    public void setTitle_Feature_Image(String title_Feature_Image) {
        this.title_Feature_Image = title_Feature_Image;
    }
    
}
