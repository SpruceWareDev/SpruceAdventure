package com.spruce.adventure.entity.player;

import com.spruce.adventure.entity.component.components.SpriteRenderer;
import com.spruce.adventure.object.GameObject;

public class Player extends GameObject {

    private float x, y;

    private SpriteRenderer renderer;

    public Player(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void start() {
        renderer = new SpriteRenderer("assets/sprites/knight1.png");
        addComponent(renderer);
    }

    @Override
    public void tick() {

    }
}
