package com.spruce.adventure.ui.hud;

import com.spruce.adventure.GameLoop;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.Button;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;

import java.awt.*;

public class HUD {

    public UIManager uiManager = new UIManager();

    public boolean debug = false;

    public HUD(){
        uiManager.addComponent(new Button("Joe Mama", 6, 6, 70, 22, Color.red, ()->{
            System.out.println("Ballsack!");
        }));
    }

    public void tick(){
        uiManager.tick();
    }

    public void render(Graphics g){
        if(debug) {
            FontRenderer.drawString(g, "FPS " + GameLoop.getFps(), 6, 22, Color.BLACK, Fonts.font22);
            FontRenderer.drawString(g, "TPS " + GameLoop.getDebugTPS(), 6, 44, Color.BLACK, Fonts.font22);
        }
        uiManager.render(g);
    }
}
