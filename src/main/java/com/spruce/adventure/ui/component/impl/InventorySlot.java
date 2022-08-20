package com.spruce.adventure.ui.component.impl;

import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.ui.component.UIComponent;
import com.spruce.adventure.util.ColorUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ListIterator;

public class InventorySlot extends UIComponent {

    public ItemCluster item;
    public boolean selected;
    public int id;

    public InventorySlot(ItemCluster item, boolean selected, int id, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.item = item;
        this.selected = selected;
        this.id = id;
    }

    public void render(Graphics g){
        if(selected) {
            Graphics2D g2d = (Graphics2D) g;
            Stroke stroke = new BasicStroke(6f);
            g2d.setColor(ColorUtil.setAlpha(180, ColorUtil.interpolateColorsBackAndForth(8, 1, new Color(0x00FFF5), new Color(0x0000FF), false)));
            g2d.setStroke(stroke);
            g2d.drawRect(x, y, width, height);
        }

        if(item == null)
            return;

        BufferedImage texture = item.baseItem.getInventoryTexture();
        g.drawImage(texture, x + width/2 - texture.getWidth()/2, y + height/2 - texture.getHeight()/2, null);
    }
}
