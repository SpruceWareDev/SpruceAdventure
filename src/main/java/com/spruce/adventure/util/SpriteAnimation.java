package com.spruce.adventure.util;

import java.awt.image.BufferedImage;

public class SpriteAnimation {

    private int delay;
    private BufferedImage[] frames;
    private int index;

    private Timer timer;

    public SpriteAnimation(int changeDelay, BufferedImage[] frames){
        this.delay = changeDelay;
        this.frames = frames;
        index = 0;

        timer = new Timer();
    }

    public void tick(){
        if(timer.hasTimeElapsed(delay, true)){
            index++;
            if(index >= frames.length){
                index = 0;
            }
        }
    }

    public void setFrames(BufferedImage[] frames){
        this.frames = frames;
    }

    public void setDelay(int delay){
        this.delay = delay;
    }

    public BufferedImage getCurrentSprite(){
        if(index >= frames.length){
            return frames[0];
        }else {
            return frames[index];
        }
    }
}
