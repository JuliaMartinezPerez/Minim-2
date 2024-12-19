package com.example.restclientservweb;

public class Badge {
    String name;
    String urlAvatar;

    public Badge(String name, String urlAvatar) {
        this();
        this.setName(name);
        this.setUrlAvatar(urlAvatar);
    }

    public Badge() {
    }

    public String getName() {
        return name;
    }

    public Badge setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public Badge setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
        return this;
    }
}
