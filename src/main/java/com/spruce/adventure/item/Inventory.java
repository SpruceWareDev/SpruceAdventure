package com.spruce.adventure.item;

import com.spruce.adventure.entity.player.Player;

public class Inventory implements ItemContainer{

    public Player player;
    public int maxWeight;

    public Inventory(Player player, int maxWeight){
        this.player = player;
        this.maxWeight = maxWeight;
    }

    public boolean addItemToInv(ItemCluster item){
        if(canInvFitItem(item)){
            items.add(item);
            return true;
        }else {
            return false;
        }
    }

    public boolean canInvFitItem(ItemCluster item){
        int current = 0;
        for(ItemCluster i : items){
            current+=i.getClusterWeight();
        }
        return current + item.getClusterWeight() <= this.maxWeight;
    }

    public int getCurrentWeight(){
        int current = 0;
        for(ItemCluster i : items){
            current+=i.getClusterWeight();
        }
        return current;
    }

    public float getCurrentWeightAsPercentage(){
        float current = 0;
        for(ItemCluster i : items){
            current+=i.getClusterWeight();
        }
        return (current/maxWeight) * 100;
    }
}
