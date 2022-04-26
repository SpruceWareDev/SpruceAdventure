package com.spruce.adventure.camera;

import com.spruce.adventure.Game;
import com.spruce.adventure.entity.Entity;

public class Camera {

    private float xOffset, yOffset;

    private Game game;

    public Entity centeredEntity;

    public Camera(Game game, float xOffset, float yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.game = game;
    }

    public void move(float x, float y){
        xOffset += x;
        yOffset += y;
    }

    public void centerOnEntity(Entity e){
        centeredEntity = e;
        xOffset = e.getX() - game.getDisplay().getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - game.getDisplay().getHeight() / 2 + e.getHeight() / 2;
    }

    public void tick(){
        if(centeredEntity != null){
            centeredEntity.centered = true;
        }
    }

    public float getxOffset() {
        return xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }
}
