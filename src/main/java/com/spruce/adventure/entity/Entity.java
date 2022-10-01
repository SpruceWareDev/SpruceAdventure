package com.spruce.adventure.entity;

import com.spruce.adventure.util.MathUtils;
import com.spruce.adventure.util.Size;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Entity {

    private float x, y, width, height;
    private String name;

    private EntityType type;

    public boolean centered = false;

    public Entity(String name, EntityType type, float x, float y, float width, float height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    public void tick() {

    }

    public BufferedImage getSprite() {
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

    public EntityType getType() {
        return type;
    }

    public float getDistanceToEntity(Entity e){
        return (float) Math.sqrt(MathUtils.square(e.getX()-getX()) + MathUtils.square(e.getY()-getY()));
    }

    public Size getSize(){
        return new Size(x, y, width, height);
    }

    public Rectangle2D getSizeAsRect2D(){
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }
}
