package com.demo.movieplus.ui.Favorites;

public class Movie {
    private String name;
    private String imageUrl;
    private String videoUrl;  // For YouTube playback
    private String desc;  // For movie description


    public Movie(String name, String imageUrl, String videoUrl, String desc) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.desc = desc;

    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getDesc() {
        return desc;
    }



}