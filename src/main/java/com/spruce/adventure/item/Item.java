package com.spruce.adventure.item;

public class Item {

    public String name, description;
    public int maxStackSize;
    public int weight;

    public Item(String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

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
}
