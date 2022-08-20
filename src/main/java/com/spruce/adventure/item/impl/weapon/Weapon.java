package com.spruce.adventure.item.impl.weapon;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Weapon extends Item {

    public int damage;

    public Weapon(String name, String description, int weight, int damage){
        super(name, description, weight);
        this.damage = damage;
    }
}
