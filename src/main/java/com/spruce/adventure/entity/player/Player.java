package com.spruce.adventure.entity.player;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.item.Inventory;
import com.spruce.adventure.util.SpriteAnimation;
import com.spruce.adventure.util.Timer;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private float speed = 3f;

    private SpriteAnimation playerAnimation;

    private float moveX, moveY;

    //can either be 0 or 180 (facing right and left)
    private int direction = 0;

    //inventory system
    public Inventory inventory;

    public Player(String name, float x, float y) {
        super(name, EntityType.LIVING, x, y, 60, 100);
        inventory = new Inventory(this, 100);

        playerAnimation = new SpriteAnimation(80, Assets.playerIdleRight);
    }

    @Override
    public void tick(){
        playerAnimation.tick();
        handleMovement();
    }

    private void handleMovement(){
        moveX = 0;
        moveY = 0;

        if(!isMoving()){
            playerAnimation.setDelay(500);
            if(direction == 0) {
                playerAnimation.setFrames(Assets.playerIdleRight);
            }else{
                playerAnimation.setFrames(Assets.playerIdleLeft);
            }
        }

        if(KeyInput.isKeyPressed(KeyEvent.VK_W)){
            playerAnimation.setDelay(80);
            playerAnimation.setFrames(direction == 0 ? Assets.playerWalk : Assets.playerWalkLeft);
            moveY = - speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_S)){
            playerAnimation.setDelay(80);
            playerAnimation.setFrames(direction == 0 ? Assets.playerWalk : Assets.playerWalkLeft);
            moveY = speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_A)){
            playerAnimation.setDelay(80);
            moveX = - speed;
            direction = 180;
            playerAnimation.setFrames(Assets.playerWalkLeft);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_D)){
            playerAnimation.setDelay(80);
            moveX = speed;
            direction = 0;
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
