package com.spruce.adventure.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static FloorTile floorTile = new FloorTile(0);
    public static SmallGrassTile smallGrassTile = new SmallGrassTile(1);

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;

    protected BufferedImage texture;
    protected final int id;

    public boolean solid = false;

    public Tile(BufferedImage texture, int id){
        this.id = id;
        this.texture = texture;

        this.tiles[id] = this;
    }

    public void tick(){

    }

    public void renderTexture(Graphics g, float x, float y){
        g.drawImage(texture, (int) x, (int) y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid(){
        return solid;
    }
}
