package com.spruce.adventure.state;

import java.awt.*;

public class GameState extends State{

    public GameState(){

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(100, 100, 200, 200);
    }

    @Override
    public void tick() {

    }
}
