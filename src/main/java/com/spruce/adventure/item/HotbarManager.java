package com.spruce.adventure.item;

import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.ui.component.impl.InventorySlot;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotbarManager {

    public List<InventorySlot> slots = new ArrayList<>();
    public InventorySlot selected;

    private World world;

    public HotbarManager(World world){
        this.world = world;
    }

    public void addSlots(InventorySlot... slot) {
        slots.addAll(Arrays.asList(slot));
    }

    public void tick() {
        slots.forEach(InventorySlot::tick);
        handleHotbar();
    }

    public void render(Graphics g) {
        slots.forEach(slot -> slot.render(g));
    }

    public void setSelected(int id){
        slots.forEach(slot -> slot.selected = false);
        selected = getSlotByID(id);
        selected.selected = true;
    }

    public InventorySlot getSlot(int index){
        return slots.get(index);
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

    public InventorySlot getSlotByID(int id){
        for(InventorySlot i : slots){
            if(i.id == id){
                return i;
            }
        }
        return null;
    }

    public void handleHotbar(){
        if(KeyInput.isKeyPressed(KeyEvent.VK_1)){
            setSelected(0);
        }
        else if(KeyInput.isKeyPressed(KeyEvent.VK_2)){
            setSelected(1);
        }
        else if(KeyInput.isKeyPressed(KeyEvent.VK_R)){
            ItemCluster item = selected.item;
            if(item != null) {
                if(world.getThePlayer().inventory.addItemToInv(item)) {
                    selected.item = null;
                }
            }
        }
    }
}
