package com.spruce.adventure.ui.screen;

import java.awt.*;

public abstract class GuiScreen {

    public abstract void tick();
    public abstract void drawScreen(Graphics g, int mouseX, int mouseY);

    public boolean isInside(int mouseX, int mouseY, double x, double y, double x2, double y2) {
        return (mouseX > x && mouseX < x2) && (mouseY > y && mouseY < y2);
    }
}
