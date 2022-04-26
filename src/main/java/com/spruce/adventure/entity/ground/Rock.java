package com.spruce.adventure.entity.ground;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;

import java.awt.image.BufferedImage;

public class Rock extends Entity {

    public Rock(float x, float y, float width, float height) {
        super("Rock", EntityType.GROUND, x, y, width, height);
    }

    public BufferedImage getSprite(){
        return Assets.largeRock;
    }
}
