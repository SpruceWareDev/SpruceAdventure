package com.spruce.adventure.entity.ground;

import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityType;
import com.spruce.adventure.item.ItemCluster;

import java.awt.image.BufferedImage;

public class GroundItem extends Entity {

    private ItemCluster item;

    public GroundItem(ItemCluster item, float x, float y, float width, float height) {
        super(item.baseItem.name, EntityType.GROUND, x, y, width, height);
        this.item = item;
    }

    public BufferedImage getSprite(){
        return item.baseItem.getGroundTexture();
    }
}
