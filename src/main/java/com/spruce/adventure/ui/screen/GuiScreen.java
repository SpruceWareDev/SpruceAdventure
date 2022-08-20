package com.spruce.adventure.ui.screen;

import java.awt.*;

public abstract class GuiScreen {

    public abstract void tick();
    public abstract void drawScreen(Graphics g, int mouseX, int mouseY);
}
