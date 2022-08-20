package com.spruce.adventure.item;

import com.spruce.adventure.ui.component.impl.InventorySlot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotbarManager {

    public List<InventorySlot> slots = new ArrayList<>();
    public InventorySlot selected;

    public void addSlots(InventorySlot... slot) {
        slots.addAll(Arrays.asList(slot));
    }

    public void tick() {
        slots.forEach(InventorySlot::tick);
    }

    public void render(Graphics g) {
        slots.forEach(slot -> slot.render(g));
    }

    public void setSelected(int index){
        selected = slots.get(index);
        slots.forEach(slot -> slot.selected = false);
        selected.selected = true;
    }

    public InventorySlot[] getFreeSlots(){
        InventorySlot[] freeSlots = new InventorySlot[slots.size()];
        for(int i = 0; i < slots.size()-1; i++){
            if(slots.get(i).item == null){
                freeSlots[i] = slots.get(i);
            }
        }
        return freeSlots;
    }
}
