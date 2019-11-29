package com.soni.myproject.model;

import java.util.ArrayList;

public class DataTV {
    private int id;
    private int airedSeason;
    private String episodeName;
    private String firstAired;
    private ArrayList<GuestStar> guestStars;
    private String director;
    private double rating;
    private int img;
    private String imgUrl;


    public DataTV() {
    }

    public DataTV(int id, int airedSeason, String episodeName, String firstAired, ArrayList<GuestStar> guestStars, String director, double rating, int img) {
        this.id = id;
        this.airedSeason = airedSeason;
        this.episodeName = episodeName;
        this.firstAired = firstAired;
        this.guestStars = guestStars;
        this.director = director;
        this.rating = rating;
        this.img = img;
    }

    public DataTV(int id, int airedSeason, String episodeName, String firstAired, ArrayList<GuestStar> guestStars, String director, double rating, int img, String imgUrl) {
        this.id = id;
        this.airedSeason = airedSeason;
        this.episodeName = episodeName;
        this.firstAired = firstAired;
        this.guestStars = guestStars;
        this.director = director;
        this.rating = rating;
        this.img = img;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "DataTV{" +
                "id=" + id +
                ", airedSeason=" + airedSeason +
                ", episodeName='" + episodeName + '\'' +
                ", firstAired='" + firstAired + '\'' +
                ", guestStars=" + guestStars +
                ", director='" + director + '\'' +
                ", rating=" + rating +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAiredSeason() {
        return airedSeason;
    }

    public void setAiredSeason(int airedSeason) {
        this.airedSeason = airedSeason;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public void setEpisodeName(String episodeName) {
        this.episodeName = episodeName;
    }

    public String getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(String firstAired) {
        this.firstAired = firstAired;
    }

    public ArrayList<GuestStar> getGuestStars() {
        return guestStars;
    }

    public void setGuestStars(ArrayList<GuestStar> guestStars) {
        this.guestStars = guestStars;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public String getEachGuestStars()
    {
        String GS = "";
        for (GuestStar gs :  guestStars) 
            GS +=gs.getName()+", ";
        return GS;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
