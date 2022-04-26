package com.spruce.adventure.entity;

import java.awt.image.BufferedImage;

public class Entity {

    private float x, y, width, height;
    private String name;

    private EntityType type;

    public boolean centered = false;

    public Entity(String name, EntityType type, float x, float y, float width, float height){
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public void tick(){

    }

    public BufferedImage getSprite(){
        return null;
    }

    public String getName() {
        return name;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public EntityType getType() {return type;}
}
