package com.spruce.adventure.item;

public class ItemCluster {

    public Item baseItem;
    public int stackSize;

    public ItemCluster(Item baseItem, int stackSize) {
        this.baseItem = baseItem;
        this.stackSize = stackSize;
    }

    public int getClusterWeight(){
        return baseItem.weight * stackSize;
    }

    public Item getBaseItem() {
        return baseItem;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }
}
