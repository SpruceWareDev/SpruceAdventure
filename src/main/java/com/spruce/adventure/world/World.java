package com.spruce.adventure.world;

import com.spruce.adventure.entity.EntityManager;
import com.spruce.adventure.entity.player.Player;

import java.awt.*;

public class World {

    private int width, height;
    private int[][] tileMap;

    public EntityManager entityManager = new EntityManager();

    public World(String worldPath){
        loadWorld(worldPath);

        entityManager.addEntityToWorld(new Player("Test Player", 100, 100));
    }

    private void loadWorld(String path){

    }

    public void tick(){
        entityManager.tick();
    }

    public void renderWorld(Graphics g){
        entityManager.drawEntities(g);
    }
}
