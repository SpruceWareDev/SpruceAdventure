package com.spruce.adventure.world;

import com.spruce.adventure.Game;
import com.spruce.adventure.GameLoop;
import com.spruce.adventure.camera.Camera;
import com.spruce.adventure.display.Display;
import com.spruce.adventure.entity.EntityManager;
import com.spruce.adventure.entity.ground.Grass;
import com.spruce.adventure.entity.ground.Rock;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.tile.FloorTile;
import com.spruce.adventure.tile.LargeRockTile;
import com.spruce.adventure.tile.SmallGrassTile;
import com.spruce.adventure.tile.Tile;
import com.spruce.adventure.util.Utils;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class World {

    private int width, height;
    private int[][] tileMap;

    private int playerStartX, playerStartY;

    public EntityManager entityManager = new EntityManager(this);

    public Camera camera;

    private Player thePlayer;

    public World(Game game, String worldPath){
        loadWorld(worldPath);

        camera = new Camera(game, 0, 0);
        thePlayer = new Player("Test Player", playerStartX * Tile.TILEWIDTH, playerStartY * Tile.TILEHEIGHT);
        entityManager.addEntityToWorld(thePlayer);

        //testing ground generation
        generateGroundEntities();
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
        //tick entities
        camera.centerOnEntity(thePlayer);
        camera.tick();
        entityManager.tick();
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
    }

    //testing ground entity spawning
    private void generateGroundEntities(){
        Random random = new Random();
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int chance = random.nextInt(20);
                if(chance == 1){
                    if(!(getTileAtPos(x, y) instanceof FloorTile)) {
                        //adds random rocks to the world
                        entityManager.addEntityToWorld(new Rock(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, 32, 32));
                    }
                }else if(chance == 2 || chance == 3){
                    if((getTileAtPos(x, y) instanceof SmallGrassTile)){
                        entityManager.addEntityToWorld(new Grass(x * Tile.TILEWIDTH, y * Tile.TILEHEIGHT, 72, 72));
                    }
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
