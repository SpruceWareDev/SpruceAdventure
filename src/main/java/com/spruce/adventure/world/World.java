package com.spruce.adventure.world;

import com.spruce.adventure.entity.EntityManager;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.tile.Tile;
import com.spruce.adventure.util.Utils;

import java.awt.*;
import java.util.Arrays;

public class World {

    private int width, height;
    private int[][] tileMap;

    private int playerStartX, playerStartY;

    public EntityManager entityManager = new EntityManager();

    public World(String worldPath){
        loadWorld(worldPath);

        entityManager.addEntityToWorld(new Player("Test Player", playerStartX, playerStartY));
    }

    private void loadWorld(String path){
        //gets the world as a string, so it can be parsed
        String loadedWorld = Utils.loadFileAsString(path);
        String[] tokens = loadedWorld.split("\\s+");
        width = Utils.getIntFromString(tokens[0]);
        height = Utils.getIntFromString(tokens[1]);
        playerStartX = Utils.getIntFromString(tokens[2]);
        playerStartY = Utils.getIntFromString(tokens[3]);

        tileMap = new int[width][height];

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                tileMap[x][y] = Utils.getIntFromString(tokens[(x + y * width) + 4]);
            }
        }
    }

    public Tile getTileAtPos(int x, int y){
        Tile tile = Tile.tiles[tileMap[x][y]];
        if(tile == null){
            return Tile.floorTile;
        }
        return tile;
    }

    public void tick(){
        //tick entities
        entityManager.tick();
    }

    public void renderWorld(Graphics g){
        //render world
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                getTileAtPos(x, y).renderTexture(g, x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT);
            }
        }

        //render all entities in the world
        entityManager.drawEntities(g);
    }
}
