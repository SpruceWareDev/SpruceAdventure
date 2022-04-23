package com.spruce.adventure.entity;

import com.spruce.adventure.assets.Assets;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private List<Entity> entities = new ArrayList<>();

    public void addEntityToWorld(Entity e){
        this.entities.add(e);
    }

    public void removeEntityFromWorld(Entity e){
        this.entities.remove(e);
    }

    public void clearEntities(){
        this.entities.clear();
    }

    public void tick(){
        for(Entity e : entities){
            e.tick();
        }
    }

    public void drawEntities(Graphics g){
        for(Entity e : entities){
            g.drawImage(e.getSprite(), (int) e.getX(), (int) e.getY(), (int) e.getWidth(), (int) e.getHeight(), null);
        }
    }
}
