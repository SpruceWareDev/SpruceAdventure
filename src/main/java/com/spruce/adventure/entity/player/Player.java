package com.spruce.adventure.entity.player;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.item.Inventory;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.ui.hud.HUD;
import com.spruce.adventure.util.SpriteAnimation;
import com.spruce.adventure.util.Timer;
import com.spruce.adventure.util.Utils;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    public World world;

    private final SpriteAnimation playerAnimation;

    //movement variables
    private float moveX, moveY;
    private float speed = 3f;

    //can either be 0 or 180 (facing right and left)
    private int direction = 0;

    //sprinting variables
    public boolean sprinting = false;
    public int sprintTicks = 0;
    public int maxSprintTicks = 120;

    //health variable (0 - 100)
    public int health = 100;

    //inventory system
    public Inventory inventory;

    public Player(World world, String name, float x, float y) {
        super(name, EntityType.LIVING, x, y, 60, 100);
        this.world = world;
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
            moveY = -speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_S)){
            playerAnimation.setDelay(80);
            playerAnimation.setFrames(direction == 0 ? Assets.playerWalk : Assets.playerWalkLeft);
            moveY = speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_A)){
            playerAnimation.setDelay(80);
            moveX = -speed;
            direction = 180;
            playerAnimation.setFrames(Assets.playerWalkLeft);
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_D)){
            playerAnimation.setDelay(80);
            moveX = speed;
            direction = 0;
            playerAnimation.setFrames(Assets.playerWalk);
        }

        speed = handleSprinting();

        setY(getY() + moveY);
        setX(getX() + moveX);
    }

    private float handleSprinting(){
        boolean shouldSprint;
        float defaultSpeed = 3f;
        shouldSprint = KeyInput.isKeyPressed(KeyEvent.VK_SHIFT) && isMoving();
        if(shouldSprint && maxSprintTicks >= sprintTicks && sprintTicks > 0){
            sprintTicks--;
        }
        else if(sprintTicks == 0){
            shouldSprint = false;
        }
        if(!isMoving() && sprintTicks < maxSprintTicks){
            sprintTicks++;
        }
        setSprinting(shouldSprint);
        return isSprinting() ? 5f : defaultSpeed;
    }

    public float getSprintBarPercent(){
        return ((float)(sprintTicks) / (float)(maxSprintTicks)) * 100f;
    }

    public boolean isSprinting(){
        return sprinting;
    }

    public void setSprinting(boolean sprinting) {
        this.sprinting = sprinting;
    }

    public boolean isMoving(){
        return !(moveX == 0) || !(moveY == 0);
    }

    public BufferedImage getSprite(){
        return playerAnimation.getCurrentSprite();
    }
}
