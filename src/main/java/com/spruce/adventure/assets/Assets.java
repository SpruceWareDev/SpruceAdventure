package com.spruce.adventure.assets;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Assets {

    public static BufferedImage floor, player, smallGrass, largeRock, grass1;

    //player sprites
    public static BufferedImage[] playerIdleRight = new BufferedImage[2];
    public static BufferedImage[] playerIdleLeft = new BufferedImage[2];
    public static BufferedImage[] playerWalk = new BufferedImage[4];
    public static BufferedImage[] playerWalkLeft = new BufferedImage[4];

    public static void init(){
        floor = loadImage("assets/sprites/floor1.png");
        player = loadImage("assets/sprites/knight1.png");
        smallGrass = loadImage("assets/sprites/smallgrass1.png");

        //player sprites
        playerIdleRight[0] = loadImage("assets/sprites/player/knight_idle_1.png");
        playerIdleRight[1] = loadImage("assets/sprites/player/knight_idle_2.png");

        playerIdleLeft[0] = loadImage("assets/sprites/player/knight_idle_1l.png");
        playerIdleLeft[1] = loadImage("assets/sprites/player/knight_idle_2l.png");

        playerWalk[0] = loadImage("assets/sprites/player/knight_walk_1.png");
        playerWalk[1] = loadImage("assets/sprites/player/knight_walk_2.png");
        playerWalk[2] = loadImage("assets/sprites/player/knight_walk_3.png");
        playerWalk[3] = loadImage("assets/sprites/player/knight_walk_4.png");

        playerWalkLeft[0] = loadImage("assets/sprites/player/knight_walk_1_left.png");
        playerWalkLeft[1] = loadImage("assets/sprites/player/knight_walk_2_left.png");
        playerWalkLeft[2] = loadImage("assets/sprites/player/knight_walk_3_left.png");
        playerWalkLeft[3] = loadImage("assets/sprites/player/knight_walk_4_left.png");

        //ground sprites
        largeRock = loadImage("assets/sprites/ground/stone_large.png");
        grass1 = loadImage("assets/sprites/ground/grass1.png");
    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
