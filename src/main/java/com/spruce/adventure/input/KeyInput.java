package com.spruce.adventure.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private static KeyInput instance;

    private static boolean[] keys;

    public KeyInput(){
        keys = new boolean[256];
    }

    public static KeyInput get(){
        if(instance == null){
            instance = new KeyInput();
        }
        return instance;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    public static boolean isKeyPressed(int keyCode){
        return keys[keyCode];
    }
}
