package com.spruce.adventure.state;

import com.spruce.adventure.Game;
import com.spruce.adventure.ui.component.UIManager;
import com.spruce.adventure.ui.component.impl.Button;

import java.awt.*;

public class MenuState extends State{

    private final UIManager uiManager;
    private Button playButton;

    public MenuState(Game game){
        uiManager = new UIManager();
        playButton = new Button("Play", (int)((game.getDisplay().getWidth() / 2.0f) - 60), (int)(game.getDisplay().getHeight() / 2.0f),
                120, 26, Color.lightGray, ()->{
            Game.stateManager.setCurrentState(new GameState(game));
        });
        uiManager.addComponent(playButton);
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }
}
