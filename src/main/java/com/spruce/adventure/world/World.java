package com.spruce.adventure.world;

import com.spruce.adventure.Game;
import com.spruce.adventure.camera.Camera;
import com.spruce.adventure.display.Display;
import com.spruce.adventure.entity.Entity;
import com.spruce.adventure.entity.EntityManager;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.item.ItemCluster;
import com.spruce.adventure.tile.Tile;
import com.spruce.adventure.ui.hud.HUD;
import com.spruce.adventure.util.Size;
import com.spruce.adventure.util.Utils;

import java.awt.*;
import java.util.Random;

public class World {

    private int width, height;
    private int[][] tileMap;

    private int playerStartX, playerStartY;

    public EntityManager entityManager = new EntityManager(this);

    public Camera camera;
    public HUD hud;

    private Player thePlayer;

    public boolean paused = false;

    public World(Game game, String worldPath){
        loadWorld(worldPath);

        camera = new Camera(game, 0, 0);
        thePlayer = new Player(this, "Test Player", playerStartX * Tile.TILEWIDTH, playerStartY * Tile.TILEHEIGHT);
        entityManager.addEntityToWorld(thePlayer);
        hud = new HUD(this);
    }

    private void loadWorld(String path){
        //gets the world as a string, so it can be parsed
        String loadedWorld = Utils.loadFileAsString(path);
        String[] tokens = loadedWorld.split("\\s+");
        this.width = Utils.getIntFromString(tokens[0]);
        this.height = Utils.getIntFromString(tokens[1]);
        this.playerStartX = Utils.getIntFromString(tokens[2]);
        this.playerStartY = Utils.getIntFromString(tokens[3]);

        this.tileMap = new int[width][height];

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
        if (paused)
            return;

        //tick entities
        camera.centerOnEntity(thePlayer);
        camera.tick();
        entityManager.tick();
        hud.tick();
    }

    public void renderWorld(Graphics g){
        //render efficiency (only renders visible tiles)
        int xStart = (int) Math.max(0, camera.getxOffset() / Tile.TILEWIDTH), xEnd = (int) Math.min(width, (camera.getxOffset() + Display.startWidth) / Tile.TILEWIDTH + 1),
                yStart = (int) Math.max(0, camera.getyOffset() / Tile.TILEHEIGHT), yEnd = (int) Math.min(height, (camera.getyOffset() + Display.startHeight) / Tile.TILEHEIGHT + 1);


        //render world
        for(int y = yStart; y < yEnd; y++){
            for(int x = xStart; x < xEnd; x++){
                getTileAtPos(x, y).renderTexture(g, x * Tile.TILEWIDTH - camera.getxOffset(), y * Tile.TILEHEIGHT - camera.getyOffset());
            }
        }

        //render all entities in the world
        entityManager.drawEntities(g);
        hud.render(g);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getThePlayer(){
        return thePlayer;
    }
}
