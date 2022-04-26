package com.spruce.adventure.entity.player;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.util.SpriteAnimation;
import com.spruce.adventure.util.Timer;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private String name;
    private float speed = 3f;

    private SpriteAnimation playerAnimation;

    private float moveX, moveY;

    public Player(String name, float x, float y) {
        super(name, EntityType.LIVING, x, y, 60, 100);
        this.name = name;

        playerAnimation = new SpriteAnimation(80, Assets.playerIdle);
    }

    public void tick(){
        playerAnimation.tick();
        handleMovement();
    }

    private void handleMovement(){
        moveX = 0;
        moveY = 0;

        if(!isMoving()){
            playerAnimation.setDelay(500);
            playerAnimation.setFrames(Assets.playerIdle);
        }

        if(KeyInput.isKeyPressed(KeyEvent.VK_W)){
            playerAnimation.setDelay(80);
            playerAnimation.setFrames(Assets.playerWalk);
            moveY = - speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_S)){
            playerAnimation.setDelay(80);
            playerAnimation.setFrames(Assets.playerWalk);
            moveY = speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_A)){
            playerAnimation.setDelay(80);
            moveX = - speed;
            playerAnimation.setFrames(Assets.playerWalkLeft);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_D)){
            playerAnimation.setDelay(80);
            moveX = speed;
            playerAnimation.setFrames(Assets.playerWalk);
        }

        setY(getY() + moveY);
        setX(getX() + moveX);
    }

    public boolean isMoving(){
        return !(moveX == 0) && !(moveY == 0);
    }

    public BufferedImage getSprite(){
        return playerAnimation.getCurrentSprite();
    }
}
