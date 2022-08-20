package com.spruce.adventure.ui.screen.screens;

import com.spruce.adventure.display.Display;
import com.spruce.adventure.ui.screen.GuiScreen;
import com.spruce.adventure.util.ColorUtil;

import java.awt.*;

public class InventoryScreen extends GuiScreen {

    @Override
    public void tick() {

    }

    @Override
    public void drawScreen(Graphics g, int mouseX, int mouseY) {
        g.setColor(Color.darkGray);
        g.fillRect(Display.startWidth/2-200, Display.startHeight/2-200, 400, 400);
    }
}
