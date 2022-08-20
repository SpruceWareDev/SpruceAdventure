package com.spruce.adventure.ui.hud;

import com.spruce.adventure.GameLoop;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.item.impl.test.TestItem;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.Bar;
import com.spruce.adventure.ui.component.impl.Button;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.world.World;

import java.awt.*;

public class HUD {

    private World world;

    public UIManager uiManager = new UIManager();
    //Components
    private Bar playerHealthBar;
    private Bar inventoryWeightBar;

    public boolean debug = false;

    public HUD(World world){
        this.world = world;
        uiManager.addComponent(new Button("Add Item", 6, 60, 100, 22, Color.lightGray, ()->{
            if(!world.getThePlayer().inventory.addItemToInv(new ItemCluster(new TestItem(), 1))){
                System.out.println("Not enough inventory space!");
            }
        }));

        playerHealthBar = new Bar(6, 6, 100, 22, world.getThePlayer().health, Color.red, Color.black);
        inventoryWeightBar = new Bar(6, 30, 100, 22, (int) world.getThePlayer().inventory.getCurrentWeightAsPercentage(), Color.yellow, Color.black);
        uiManager.addComponent(playerHealthBar);
        uiManager.addComponent(inventoryWeightBar);
    }

    public void tick(){
        playerHealthBar.update(this.world.getThePlayer().health);
        inventoryWeightBar.update((int) this.world.getThePlayer().inventory.getCurrentWeightAsPercentage());
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
