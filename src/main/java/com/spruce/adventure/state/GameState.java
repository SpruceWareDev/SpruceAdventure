package com.spruce.adventure.state;

import com.spruce.adventure.Game;
import com.spruce.adventure.input.MouseInput;
import com.spruce.adventure.ui.screen.GuiScreen;
import com.spruce.adventure.world.World;

import java.awt.*;

public class GameState extends State{

    private static World gameWorld;
    public static GuiScreen currentScreen = null;

    public GameState(Game game){
        gameWorld = new World(game, "assets/worlds/testworld.world");
    }

    @Override
    public void tick() {
        gameWorld.paused = currentScreen != null;
        gameWorld.tick();

        if(currentScreen != null){
            currentScreen.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        gameWorld.renderWorld(g);

        //draws the current screen if it's not null
        if(currentScreen != null){
            currentScreen.drawScreen(g, MouseInput.get().getMouseX(), MouseInput.get().getMouseY());
        }
    }

    public static void displayGuiScreen(GuiScreen screen){
        currentScreen = screen;
    }

    public static void closeCurrentScreen(){
        currentScreen = null;
    }

    public static World getGameWorld() {
        return gameWorld;
    }
}
