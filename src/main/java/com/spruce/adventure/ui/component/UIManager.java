package com.spruce.adventure.ui.component;

import java.awt.*;
import java.util.ArrayList;

public class UIManager {

    public ArrayList<UIComponent> components = new ArrayList<>();

    public void addComponent(UIComponent comp){
        this.components.add(comp);
    }

    public void removeComponent(UIComponent comp){
        this.components.remove(comp);
    }

    public void tick(){
        components.forEach(UIComponent::tick);
    }

    public void render(Graphics g){
        components.forEach(comp -> comp.render(g));
    }
}
