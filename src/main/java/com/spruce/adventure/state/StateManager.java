package com.spruce.adventure.state;

import com.spruce.adventure.Game;

import java.awt.*;

public class StateManager {

    private State currentState;

    public StateManager(Game game){
        currentState = new MenuState(game);
    }

    public void tick(){
        currentState.tick();
    }

    public void render(Graphics g){
        currentState.render(g);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
