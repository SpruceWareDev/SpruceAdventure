package com.spruce.adventure.entity.component.components;

import com.spruce.adventure.entity.component.Component;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteRenderer extends Component {

    private String assetPath;

    public SpriteRenderer(String assetPath){
        this.assetPath = assetPath;
    }

    @Override
    public void start(){
        System.out.println("Started Sprite Render!");
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(100, 100, 200, 200);
    }
}
