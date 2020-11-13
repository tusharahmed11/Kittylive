package com.kkdev.kittylive.model;

public class DashboardItem {
    private int typeIconId;
    private String typeTitle;
    private int image;
    private String name;
    private String title;
    private int followers;
    private int type;

    public DashboardItem(int typeIconId, String typeTitle, int image, String name, String title, int followers, int type) {
        this.typeIconId = typeIconId;
        this.typeTitle = typeTitle;
        this.image = image;
        this.name = name;
        this.title = title;
        this.followers = followers;
        this.type = type;
    }

    public int isType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public int getTypeIconId() {
        return typeIconId;
    }

    public void setTypeIconId(int typeIconId) {
        this.typeIconId = typeIconId;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}
