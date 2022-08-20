package com.spruce.adventure.ui.screen.screens;

import com.spruce.adventure.GameLoop;
import com.spruce.adventure.display.Display;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.Button;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.ui.screen.GuiScreen;
import com.spruce.adventure.util.ColorUtil;

import java.awt.*;

public class PausedScreen extends GuiScreen {

    private UIManager uiManager = new UIManager();

    public PausedScreen(){
        uiManager.addComponent(new Button("Quit Game", Display.startWidth/2-22, Display.startHeight/2, 44, 22,
                Color.gray, GameLoop::exitGame));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void drawScreen(Graphics g, int mouseX, int mouseY){
        g.setColor(ColorUtil.setAlpha(100, new Color(0)));
        g.fillRect(0,0, Display.startWidth, Display.startHeight);

        FontRenderer.drawCenteredString(g, "Paused", Display.startWidth/2, Display.startHeight/2 - 22, Color.white, Fonts.font40);

        uiManager.render(g);
    }
}
