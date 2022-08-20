package com.spruce.adventure.ui.component.impl;

import com.spruce.adventure.ui.component.UIComponent;
import com.spruce.adventure.util.Timer;

import javax.swing.*;
import java.awt.*;

public class Bar extends UIComponent {

    public int percentage;
    public Color fillColor;
    public Color backgroundColor;

    public Bar(int x, int y, int width, int height, int percentage, Color fillColor, Color backgroundColor) {
        super(x, y, width, height);
        this.percentage = percentage;
        this.fillColor = fillColor;
        this.backgroundColor = backgroundColor;
    }

    public void update(int percentage){
        this.percentage = percentage;
    }

    public void render(Graphics g){
        g.setColor(this.backgroundColor);
        g.fillRect(x, y, width, height);
        g.setColor(this.fillColor);
        g.fillRect(x, y, (int) (width * (percentage * 0.01f)), height);
    }
}
