package com.spruce.adventure.item.impl.test;

import com.spruce.adventure.item.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TestItem extends Item {

    public TestItem(){
        super("Test Item", "An item used to test the inventory.", 10);
    }

    public BufferedImage getGroundTexture(){
        BufferedImage image = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.red);
        g2d.fillRect(0,0,20,20);
        g2d.dispose();
        return image;
    }

    public BufferedImage getInventoryTexture(){
        BufferedImage image = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.red);
        g2d.fillRect(0,0,20,20);
        g2d.dispose();
        return image;
    }
}
