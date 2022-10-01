package com.spruce.adventure.entity;

import com.spruce.adventure.Game;
import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.input.MouseInput;
import com.spruce.adventure.tile.Tile;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {

    private World world;

    public EntityManager(World world){
        this.world = world;
    }

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

    public List<Entity> getEntities() {
        return entities;
    }

    public void tick(){
        for(Entity e : entities){
            e.tick();
        }
    }

    public void drawEntities(Graphics g){
        for(Entity e : entities){
            if (!(e instanceof Player)){
               g.drawImage(e.getSprite(), (int) (e.getX() - world.camera.getxOffset()), (int) (e.getY() - world.camera.getyOffset()), (int) e.getWidth(), (int) e.getHeight(), null);
            }
        }

        for(Entity e : entities){
            if(e instanceof Player){
                Player player = (Player)e;
                g.drawImage(e.getSprite(), (int) (e.getX() - world.camera.getxOffset()), (int) (e.getY() - world.camera.getyOffset()), (int) e.getWidth(), (int) e.getHeight(), null);
                player.renderAttack(g);
            }
        }
    }
}
