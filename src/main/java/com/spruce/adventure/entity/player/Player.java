package com.spruce.adventure.entity.player;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.input.KeyInput;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private String name;
    private float speed = 2.0f;

    public Player(String name, float x, float y) {
        super(name, x, y, 80, 150);
        this.name = name;
    }

    public void tick(){
        if(KeyInput.isKeyPressed(KeyEvent.VK_W)){
            setY(getY() - speed);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_S)){
            setY(getY() + speed);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_A)){
            setX(getX() - speed);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_D)){
            setX(getX() + speed);
        }
    }

    public BufferedImage getSprite(){
        return Assets.player;
    }
}
