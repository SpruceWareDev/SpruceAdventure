package com.spruce.adventure.entity.component.components;

import com.spruce.adventure.entity.component.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class SpriteRenderer extends Component {

    private String assetPath;

    private float x, y, scale;

    public SpriteRenderer(String assetPath, float x, float y, float scale){
        this.assetPath = assetPath;
        this.x = x;
        this.y = y;
        this.scale = scale;
    }

    @Override
    public void start(){
        System.out.println("Started Sprite Render!");
    }

    @Override
    public void tick() {

    }

    public void updatePos(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        Image image = Toolkit.getDefaultToolkit().getImage(assetPath);
        g2d.drawImage(image, Math.toIntExact((long) x), (int) y, (int) (image.getWidth(null) * scale), (int) (image.getHeight(null) * scale), null);
        g2d.dispose();
    }
}
