package com.spruce.adventure;

import com.spruce.adventure.display.Display;
import com.spruce.adventure.input.KeyInput;
import com.spruce.adventure.state.GameState;
import com.spruce.adventure.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {

    private Display display;

    private BufferStrategy bs;
    private Graphics g;

    private State currentState;

    public Game(){
        init();
    }

    private void init(){
        display = new Display("Spruce Adventure [Development Build 1]", 1280, 720);
        display.getFrame().addKeyListener(KeyInput.get());
        currentState = new GameState();
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

        if(currentState != null) {
            currentState.render(g);
        }

        //end of drawing
        bs.show();
        g.dispose();
    }

    public void tick(){
        currentState.tick();
    }
}
