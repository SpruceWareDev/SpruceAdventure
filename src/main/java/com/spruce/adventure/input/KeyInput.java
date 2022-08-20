package com.spruce.adventure.input;

import com.spruce.adventure.Game;
import com.spruce.adventure.ui.screen.screens.InventoryScreen;
import com.spruce.adventure.ui.screen.screens.PausedScreen;
import org.ietf.jgss.GSSManager;

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

        switch (keyEvent.getKeyCode()){
            case KeyEvent.VK_ESCAPE:
                if(Game.currentScreen == null) {
                    Game.displayGuiScreen(new PausedScreen());
                }else{
                    Game.closeCurrentScreen();
                }
                break;

            case KeyEvent.VK_E:
                if(Game.currentScreen == null) {
                    Game.displayGuiScreen(new InventoryScreen(Game.gameWorld.getThePlayer().inventory));
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    public static boolean isKeyPressed(int keyCode){
        return keys[keyCode];
    }
}
