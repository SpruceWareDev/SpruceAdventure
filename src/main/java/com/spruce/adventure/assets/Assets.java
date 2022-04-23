package com.spruce.adventure.assets;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Assets {

    public static BufferedImage floor, player, smallGrass;

    public static void init(){
        floor = loadImage("assets/sprites/floor1.png");
        player = loadImage("assets/sprites/knight1.png");
        smallGrass = loadImage("assets/sprites/smallgrass1.png");
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
