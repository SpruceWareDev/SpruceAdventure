package com.spruce.adventure.item;

import java.util.concurrent.CopyOnWriteArrayList;

public interface ItemContainer {

    CopyOnWriteArrayList<ItemCluster> items = new CopyOnWriteArrayList<>();

    default void addItem(ItemCluster item){
        items.add(item);
    }

    default void removeItem(ItemCluster item){
        items.remove(item);
    }

    default CopyOnWriteArrayList<ItemCluster> getItems() {
        return items;
    }
}
