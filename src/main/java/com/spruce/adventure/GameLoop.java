package com.spruce.adventure;

import com.spruce.adventure.ui.font.FontRenderer;

public class GameLoop implements Runnable{

    private Game game;

    public static boolean running;
    private final double tickRate = 1.0d/60.0d;

    private int fps = 0, tps = 0;
    private double nextUpdateTime = 0;

    private static int debugFPS = 0, debugTPS = 0;

    private static Thread gameThread;

    public GameLoop(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        double accumulator = 0;
        long currentTime, lastTick = System.currentTimeMillis();
        nextUpdateTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeSeconds = (currentTime - lastTick) / 1000d;
            accumulator += lastRenderTimeSeconds;
            lastTick = currentTime;

            if(accumulator >= tickRate) {
                while (accumulator >= tickRate) {
                    tick();
                    tps++;
                    accumulator -= tickRate;
                }
            }
            render();
            fps++;

            if(currentTime > nextUpdateTime) {
                System.out.println(String.format("FPS: %d  TPS: %d", fps, tps));
                debugFPS = fps;
                debugTPS = tps;
                fps = 0;
                tps = 0;
                nextUpdateTime = System.currentTimeMillis() + 1000;
            }
        }
    }

    private void tick(){
        game.tick();
    }

    private void render(){
        game.render();
    }

    public static int getFps() {
        return debugFPS;
    }

    public static int getDebugTPS(){return debugTPS;}

    public synchronized void start(){
        if(running)
            return;
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try{
            gameThread.join();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }

    public static void exitGame(){
        if(!running)
            return;
        running = false;
        try{
            gameThread.join();
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
