package com.spruce.adventure.object;

import com.spruce.adventure.Game;
import com.spruce.adventure.entity.component.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {

    private List<Component> components = new ArrayList<>();

    public void addComponent(Component component){
        this.components.add(component);
        if(!component.running){
            component.start();
        }
    }

    public void removeComponent(Component component){
        this.components.remove(component);
    }

    public void start(){
        for(Component c : components){
            c.start();
            c.running = true;
        }
    }

    public void tick(){

    }

    public void drawObject(Graphics g){
        for(Component c : components){
            c.draw(g);
        }
    }

    public List<Component> getComponents(){
        return components;
    }
}
