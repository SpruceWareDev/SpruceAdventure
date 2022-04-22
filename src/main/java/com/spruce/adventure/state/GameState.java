package com.spruce.adventure.state;

import com.spruce.adventure.Game;
import com.spruce.adventure.entity.player.Player;
import com.spruce.adventure.object.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameState extends State{

    private List<GameObject> gameObjects = new ArrayList<>();

    public GameState(){
        init();
    }

    private void init(){
        Player player = new Player(100, 100);
        addObjectToGame(player);

        for(GameObject go : gameObjects){
            go.start();
        }
    }

    @Override
    public void render(Graphics g) {
        for(GameObject go : gameObjects){
            go.drawObject(g);
        }
    }

    @Override
    public void tick() {
        for(GameObject go : gameObjects){
            go.tick();
        }
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void addObjectToGame(GameObject object){
        this.gameObjects.add(object);
    }
}
