package com.spruce.adventure;

import com.spruce.adventure.assets.Assets;
import com.spruce.adventure.display.Display;
import com.spruce.adventure.entity.EntityManager;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.input.MouseInput;
import com.spruce.adventure.ui.font.FontRenderer;
import com.spruce.adventure.ui.font.Fonts;
import com.spruce.adventure.ui.hud.HUD;
import com.spruce.adventure.world.World;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {

    private Display display;

    private BufferStrategy bs;
    private Graphics g;

    private World gameWorld;

    public Game(){
        init();
    }

    private void init(){
        display = new Display("Spruce Adventure [Development Build 1]", 1280, 720);
        display.getFrame().addKeyListener(KeyInput.get());
        display.getFrame().addMouseMotionListener(MouseInput.get());
        display.getFrame().addMouseListener(MouseInput.get());
        Assets.init();

        gameWorld = new World(this, "assets/worlds/testworld.world");
    }

    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        //Clear screen
        g.clearRect(0, 0, (int) display.getSize().getWidth(), (int) display.getSize().getHeight());

        //Things to draw

        gameWorld.renderWorld(g);

        //end of drawing
        bs.show();
        g.dispose();
    }

    public void tick(){
        gameWorld.tick();
    }

    public Display getDisplay() {
        return display;
    }
}
