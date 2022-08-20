package com.spruce.adventure.ui.component.impl;

import com.spruce.adventure.input.MouseInput;
import com.spruce.adventure.ui.component.UIComponent;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;

import java.awt.*;

public class Button extends UIComponent {

    public String text;
    public Color color;
    public Runnable clickAction;

    private boolean ran = false;

    public Button(String text, int x, int y, int width, int height, Color color, Runnable clickAction) {
        super(x, y, width, height);
        this.text = text;
        this.color = color;
        this.clickAction = clickAction;
    }

    public void tick(){
        if(isInside(MouseInput.get().getMouseX(), MouseInput.get().getMouseY(), x, y, x+width, y+height)
                && MouseInput.get().leftPressed && !ran){
            clickAction.run();
            ran = true;
        }
        ran = MouseInput.get().leftPressed;
    }

    public void render(Graphics g){
        g.setColor(this.color);
        g.fillRect(x, y, width, height);
        FontRenderer.drawString(g, this.text, x + 2, y + 20, Color.black, Fonts.font22);
    }
}
