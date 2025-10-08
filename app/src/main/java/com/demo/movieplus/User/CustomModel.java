package com.demo.movieplus.User;

public class CustomModel {

    private String name;
    private String desc;
    private String title;
    private int image_url;

    public CustomModel(String name, String desc, String title, int image_url) {
        this.name = name;
        this.desc = desc;
        this.title = title;
        this.image_url = image_url;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
