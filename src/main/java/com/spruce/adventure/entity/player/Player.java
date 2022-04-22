package com.spruce.adventure.entity.player;

import com.spruce.adventure.entity.component.Component;
import com.spruce.adventure.entity.component.components.MovementController;
import com.spruce.adventure.entity.component.components.SpriteRenderer;
import com.spruce.adventure.object.GameObject;

public class Player extends GameObject {

    private float x, y;

    private SpriteRenderer renderer;
    private MovementController controller;

    public Player(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void start() {
        renderer = new SpriteRenderer("assets/sprites/knight1.png", x, y, 5);
        controller = new MovementController(x, y, 3);
        addComponent(controller);
        addComponent(renderer);
    }

    @Override
    public void tick() {
        this.x = controller.getX();
        this.y = controller.getY();
        renderer.updatePos(x, y);
    }
}
