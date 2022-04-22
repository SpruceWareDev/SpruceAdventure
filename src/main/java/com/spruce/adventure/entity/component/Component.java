package com.spruce.adventure.entity.component;

import java.awt.*;

public abstract class Component {

    public boolean running = false;

    public abstract void start();

    public abstract void tick();

    public void draw(Graphics g){

    }
}
