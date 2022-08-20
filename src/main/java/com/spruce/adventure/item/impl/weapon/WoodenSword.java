package com.spruce.adventure.item.impl.weapon;

import com.spruce.adventure.assets.Assets;

import java.awt.image.BufferedImage;

public class WoodenSword extends Weapon{

    public WoodenSword() {
        super("Wooden Sword", "A basic wooden sword.", 15, 12);
    }

    public BufferedImage getGroundTexture(){
        return Assets.woodenSword;
    }

    public BufferedImage getInventoryTexture(){
        return Assets.woodenSword;
    }
}
