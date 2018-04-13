package com.jiyun.dell.mylianxi;

/**
 * Created by DELL zhanghuirong on 2017/9/30.
 */

public class Game {
    private String img;
    private String name;

    public Game(String img, String name) {
        this.img = img;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
