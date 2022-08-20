package com.spruce.adventure.ui.screen.screens;

import com.spruce.adventure.display.Display;
import com.spruce.adventure.item.Inventory;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.InventorySlot;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.ui.screen.GuiScreen;
import com.spruce.adventure.util.ColorUtil;

import java.awt.*;

public class InventoryScreen extends GuiScreen {

    public UIManager uiManager = new UIManager();

    private Inventory inventory;

    public InventoryScreen(Inventory inventory){
        this.inventory = inventory;
    }

    @Override
    public void tick() {

    }

    @Override
    public void drawScreen(Graphics g, int mouseX, int mouseY) {
        //Render background
        g.setColor(Color.darkGray);
        g.fillRect(Display.startWidth/2-200, Display.startHeight/2-200, 400, 400);
        //Render inventory text
        FontRenderer.drawString(g, "Inventory", Display.startWidth/2-196, Display.startHeight/2-182, Color.white, Fonts.font22);

        //Render boxes for each inventory item
        int i = 0;
        for(ItemCluster item : this.inventory.getItems()){
            int x = Display.startWidth/2-196;
            int y = Display.startHeight/2-132 + (i * 24);
            g.setColor(Color.gray);
            g.fillRect(x, y, 392, 22);
            FontRenderer.drawString(g, item.baseItem.name + " - " + item.baseItem.description, x + 2, y + 18, Color.white, Fonts.font18);
            i++;
        }
    }
}
