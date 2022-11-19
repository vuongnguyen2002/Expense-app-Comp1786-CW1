package com.example.myappfirst;

public class Listperson {
    private  int id;
    private String name;
    private int dateofupload;
    private String imageurl ;
    private String nametriplocation;
    private String descriptiontrip;
    private String teamatefriend;
    private  boolean SwitchActive;

    /*public Listperson(int id, String name, int dateofupload, String imageurl, String nametriplocation, String descriptiontrip, String teamatefriend) {
        this.id = id;
        this.name = name;
        this.dateofupload = dateofupload;
        this.imageurl = imageurl;
        this.nametriplocation = nametriplocation;
        this.descriptiontrip = descriptiontrip;
        this.teamatefriend = teamatefriend;
    }*/

    public Listperson(int id, String name, int dateofupload, String imageurl, String nametriplocation, String descriptiontrip, String teamatefriend, boolean switchActive) {
        this.id = id;
        this.name = name;
        this.dateofupload = dateofupload;
        this.imageurl = imageurl;
        this.nametriplocation = nametriplocation;
        this.descriptiontrip = descriptiontrip;
        this.teamatefriend = teamatefriend;
        this.SwitchActive = switchActive;
    }


    @Override
    public String toString() {
        return "Listperson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateofupload=" + dateofupload +
                ", imageurl='" + imageurl + '\'' +
                ", nametriplocation='" + nametriplocation + '\'' +
                ", descriptiontrip='" + descriptiontrip + '\'' +
                ", teamatefriend='" + teamatefriend + '\'' +
                ", SwitchActive=" + SwitchActive +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateofupload() {
        return dateofupload;
    }

    public void setDateofupload(int dateofupload) {
        this.dateofupload = dateofupload;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getNametriplocation() {
        return nametriplocation;
    }

    public void setNametriplocation(String nametriplocation) {
        this.nametriplocation = nametriplocation;
    }

    public String getDescriptiontrip() {
        return descriptiontrip;
    }

    public void setDescriptiontrip(String descriptiontrip) {
        this.descriptiontrip = descriptiontrip;
    }

    public String getTeamatefriend() {
        return teamatefriend;
    }

    public void setTeamatefriend(String teamatefriend) {
        this.teamatefriend = teamatefriend;
    }

    public boolean isSwitchActive() {
        return SwitchActive;
    }

    public void setSwitchActive(boolean switchActive) {
        SwitchActive = switchActive;
    }
}
