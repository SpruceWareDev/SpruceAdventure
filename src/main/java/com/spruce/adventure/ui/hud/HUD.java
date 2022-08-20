package com.spruce.adventure.ui.hud;

import com.spruce.adventure.Game;
import com.spruce.adventure.GameLoop;
import com.spruce.adventure.display.Display;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.item.HotbarManager;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.item.impl.test.TestItem;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.Bar;
import com.spruce.adventure.ui.component.impl.Button;
import com.spruce.adventure.ui.component.impl.InventorySlot;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.util.ColorUtil;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HUD {

    private World world;

    public UIManager uiManager = new UIManager();
    //Components
    private Bar playerHealthBar;
    private Bar inventoryWeightBar;

    //hotbar management
    public HotbarManager hotbarManager = new HotbarManager();
    private InventorySlot slot1;
    private InventorySlot slot2;

    public boolean debug = false;

    public HUD(World world){
        this.world = world;

        //test button to add an item to the inventory
        uiManager.addComponent(new Button("Add Item", 6, 60, 100, 22, Color.lightGray, ()->{
            if(!world.getThePlayer().inventory.addItemToInv(new ItemCluster(new TestItem(), 1))){
                System.out.println("Not enough inventory space!");
            }
        }));

        //Hotbar slots
        slot1 = new InventorySlot(null, true, 0, Display.startWidth - 74, 14, 60, 60);
        slot2 = new InventorySlot(null, false, 1, Display.startWidth - 74, 84, 60, 60);
        hotbarManager.addSlots(slot1, slot2);

        //health bar and inventory weight bars
        playerHealthBar = new Bar(6, 6, 100, 22, world.getThePlayer().health, Color.red, Color.black);
        inventoryWeightBar = new Bar(6, 30, 100, 22, (int) world.getThePlayer().inventory.getCurrentWeightAsPercentage(), Color.yellow, Color.black);
        uiManager.addComponent(playerHealthBar);
        uiManager.addComponent(inventoryWeightBar);
    }

    public void tick(){
        playerHealthBar.update(this.world.getThePlayer().health);
        inventoryWeightBar.update((int) this.world.getThePlayer().inventory.getCurrentWeightAsPercentage());
        uiManager.tick();
        hotbarManager.tick();
    }

    public void render(Graphics g){
        if(debug) {
            FontRenderer.drawString(g, "FPS " + GameLoop.getFps(), 6, 22, Color.BLACK, Fonts.font22);
            FontRenderer.drawString(g, "TPS " + GameLoop.getDebugTPS(), 6, 44, Color.BLACK, Fonts.font22);
        }

        uiManager.render(g);
        hotbar(g);
    }

    public void hotbar(Graphics g){
        //slot1
        g.setColor(ColorUtil.setAlpha(180, Color.black));
        g.fillRect(Display.startWidth - 84, 4, 80, 80);
        g.setColor(ColorUtil.setAlpha(180, Color.gray));
        g.fillRect(Display.startWidth - 74, 14, 60, 60);

        //slot2
        g.setColor(ColorUtil.setAlpha(180, Color.black));
        g.fillRect(Display.startWidth - 84, 84, 80, 70);
        g.setColor(ColorUtil.setAlpha(180, Color.gray));
        g.fillRect(Display.startWidth - 74, 84, 60, 60);

        if(KeyInput.isKeyPressed(KeyEvent.VK_1)){
            hotbarManager.setSelected(0);
        }
        else  if(KeyInput.isKeyPressed(KeyEvent.VK_2)){
            hotbarManager.setSelected(1);
        }
        else if(KeyInput.isKeyPressed(KeyEvent.VK_Q)){
            ItemCluster item = hotbarManager.selected.item;
            if(item != null) {
                world.dropItemOnGround(item);
                hotbarManager.selected.item = null;
            }
        }

        hotbarManager.render(g);
    }
}
