package com.spruce.adventure;

public class Launcher {

    public static void startGame(){
        new GameLoop(new Game()).start();
    }
}
