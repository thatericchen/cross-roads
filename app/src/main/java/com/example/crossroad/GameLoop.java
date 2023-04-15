package com.example.crossroad;

public class GameLoop implements Runnable {
    private Thread gameThread;
    private GamePanel gamePanel;
    public GameLoop(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        gameThread = new Thread(this);
    }
    @Override
    public void run() {
        while (true) {
            gamePanel.update();
            if (GameConstants.getLives() == 0) {
                break;
            }
            if (GameConstants.getyPos() <= 120) {
                break;
            }
            gamePanel.render();
        }
    }

    public void startGameLoop() {
        gameThread.start();
    }

}
