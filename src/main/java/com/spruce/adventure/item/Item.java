package com.spruce.adventure.item;

import java.awt.image.BufferedImage;

public class Item {

    public String name, description;
    public int maxStackSize;
    public int weight;

    public Item(String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    // method is overwritten in individual item classes.
    public void interactWithItem(){}

    public boolean isStackable(){
        return maxStackSize > 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxStackSize() {
        return maxStackSize;
    }

    public void setMaxStackSize(int maxStackSize) {
        this.maxStackSize = maxStackSize;
    }

    public BufferedImage getInventoryTexture(){
        return null;
    }
}
