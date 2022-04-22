package com.spruce.adventure.entity.component.components;

import com.spruce.adventure.entity.component.Component;
import com.spruce.adventure.input.KeyInput;

import java.awt.event.KeyEvent;

public class MovementController extends Component {

    private float x, y, speed;

    public MovementController(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void start() {
        System.out.println("Movement system started!");
    }

    @Override
    public void tick() {
        if(KeyInput.isKeyPressed(KeyEvent.VK_W)){
            this.y-=speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_S)){
            this.y+=speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_A)){
            this.x-=speed;
        }
        if(KeyInput.isKeyPressed(KeyEvent.VK_D)){
            this.x+=speed;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
