package com.spruce.adventure.entity.environment;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;

import java.awt.image.BufferedImage;

public class Tree extends Entity {

    public Tree(float x, float y) {
        super("Tree", EntityType.GROUND, x, y, 128, 128);
    }

    public BufferedImage getSprite(){
        return Assets.tree1;
    }
}
