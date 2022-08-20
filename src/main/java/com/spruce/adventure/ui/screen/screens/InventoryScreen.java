package com.spruce.adventure.ui.screen.screens;

import com.spruce.adventure.display.Display;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.item.Inventory;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.item.impl.weapon.Weapon;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.InventorySlot;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.ui.hud.HUD;
import com.spruce.adventure.ui.screen.GuiScreen;
import com.spruce.adventure.util.ColorUtil;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.awt.event.KeyEvent;

public class InventoryScreen extends GuiScreen {

    public UIManager uiManager = new UIManager();

    private Inventory inventory;
    private World world;

    public InventoryScreen(World world, Inventory inventory){
        this.world = world;
        this.inventory = inventory;
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void drawScreen(Graphics g, int mouseX, int mouseY) {
        //Render background
        g.setColor(Color.darkGray);
        g.fillRect(Display.startWidth/2-200, Display.startHeight/2-200, 400, 400);
        //Render inventory text
        FontRenderer.drawString(g, "Inventory", Display.startWidth/2-196, Display.startHeight/2-182, Color.white, Fonts.font22);

        //Render boxes for each inventory item and their names
        int i = 0;
        for(ItemCluster item : this.inventory.getItems()){
            handleItem(g, item, i, mouseX, mouseY);
            i++;
        }

        uiManager.render(g);
    }

    private void handleItem(Graphics g, ItemCluster item, int i, int mouseX, int mouseY){
        int x = Display.startWidth/2-196;
        int y = Display.startHeight/2-132 + (i * 24);
        boolean hovered = isInside(mouseX, mouseY, x, y, x + 392, y + 22);
        g.setColor(!hovered ? new Color(0x898989) : new Color(0x8989B4));
        g.fillRect(x, y, 392, 22);
        FontRenderer.drawString(g, item.baseItem.name + " - " + item.baseItem.description, x + 2, y + 18, Color.white, Fonts.font18);
        if(hovered && KeyInput.isKeyPressed(KeyEvent.VK_1)){
            if(world.hud.hotbarManager.getSlot(0).item == null){
                if(item.baseItem instanceof Weapon){
                    world.hud.hotbarManager.getSlot(0).item = item;
                    this.inventory.removeItem(item);
                }
            }
        }
        else if(hovered && KeyInput.isKeyPressed(KeyEvent.VK_2)){
            if(world.hud.hotbarManager.getSlot(1).item == null){
                world.hud.hotbarManager.getSlot(1).item = item;
                this.inventory.removeItem(item);
            }
        }
    }
}
