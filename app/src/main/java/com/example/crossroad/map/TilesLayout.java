package com.example.crossroad.map;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.crossroad.GameConstants;
import com.example.crossroad.entities.Boat;
import com.example.crossroad.entities.GameObstacles;
import com.example.crossroad.entities.Log;

public class TilesLayout {

    private int[][] mapLayout;
    private Boat[] boatsOne = new Boat[5];
    private Boat[] boatsTwo = new Boat[5];
    private Boat[] boatsThree = new Boat[2];
    private Boat[] boatsFour = new Boat[5];

    private Log[] logs1 = new Log[2];
    private Log[] logs3 = new Log[2];
    private Log[] logs2 = new Log[4];
    private Log[] logs4 = new Log[4];

    public TilesLayout() {

        initializeTileMap();

        boatsOne[0] = new Boat(120, 1200, GameObstacles.SAILBOAT.getObstacleType());
        boatsOne[1] = new Boat(480, 1200, GameObstacles.SAILBOAT.getObstacleType());
        boatsOne[2] = new Boat(960, 1200, GameObstacles.SAILBOAT.getObstacleType());
        boatsOne[3] = new Boat(1320, 1200, GameObstacles.SAILBOAT.getObstacleType());
        boatsOne[4] = new Boat(1920, 1200, GameObstacles.SAILBOAT.getObstacleType());

        boatsTwo[0] = new Boat(840, 1080, GameObstacles.PIRATE.getObstacleType());
        boatsTwo[1] = new Boat(240, 1080, GameObstacles.PIRATE.getObstacleType());
        boatsTwo[2] = new Boat(-120, 1080, GameObstacles.PIRATE.getObstacleType());
        boatsTwo[3] = new Boat(-600, 1080, GameObstacles.PIRATE.getObstacleType());
        boatsTwo[4] = new Boat(-960, 1080, GameObstacles.PIRATE.getObstacleType());

        boatsThree[0] = new Boat(360, 960, GameObstacles.SHIP.getObstacleType());
        boatsThree[1] = new Boat(840, 960, GameObstacles.SHIP.getObstacleType());

        boatsFour[0] = new Boat(960, 840, GameObstacles.PIRATE.getObstacleType());
        boatsFour[1] = new Boat(480, 840, GameObstacles.PIRATE.getObstacleType());
        boatsFour[2] = new Boat(0, 840, GameObstacles.PIRATE.getObstacleType());
        boatsFour[3] = new Boat(-360, 840, GameObstacles.PIRATE.getObstacleType());
        boatsFour[4] = new Boat(-840, 840, GameObstacles.PIRATE.getObstacleType());

        logs1[0] = new Log(0, 600, GameObstacles.LOGLONG.getObstacleType());
        logs1[1] = new Log(700, 600, GameObstacles.LOGLONG.getObstacleType());

        logs3[0] = new Log(100, 360, GameObstacles.LOGLONG.getObstacleType());
        logs3[1] = new Log(700, 360, GameObstacles.LOGLONG.getObstacleType());

        logs2[0] = new Log(100, 480, GameObstacles.LOGSHORT.getObstacleType());
        logs2[1] = new Log(500, 480, GameObstacles.LOGSHORT.getObstacleType());
        logs2[2] = new Log(1000, 480, GameObstacles.LOGSHORT.getObstacleType());
        logs2[3] = new Log(1350, 480, GameObstacles.LOGSHORT.getObstacleType());

        logs4[0] = new Log(0, 240, GameObstacles.LOGSHORT.getObstacleType());
        logs4[1] = new Log(450, 240, GameObstacles.LOGSHORT.getObstacleType());
        logs4[2] = new Log(900, 240, GameObstacles.LOGSHORT.getObstacleType());
        logs4[3] = new Log(1250, 240, GameObstacles.LOGSHORT.getObstacleType());

    }

    public boolean checkForCollision(int xPos, int yPos) {

        for (Boat b: boatsOne) {
            if (yPos == b.getBoatyPos()) {
                if (b.getBoatxPos() >= xPos && b.getBoatxPos() <= xPos + 100) {
                    return true;
                } else if (b.getBoatxPos() + 120 >= xPos && b.getBoatxPos() + 120 <= xPos + 100) {
                    return true;
                }
            }
        }

        for (Boat b: boatsTwo) {
            if (yPos == b.getBoatyPos()) {
                if (b.getBoatxPos() >= xPos && b.getBoatxPos() <= xPos + 100) {
                    return true;
                } else if (b.getBoatxPos() + 120 >= xPos && b.getBoatxPos() + 120 <= xPos + 100) {
                    return true;
                }
            }
        }

        for (Boat b: boatsThree) {
            if (yPos == b.getBoatyPos()) {
                if (b.getBoatxPos() >= xPos && b.getBoatxPos() <= xPos + 100) {
                    return true;
                } else if (b.getBoatxPos() + 240 >= xPos && b.getBoatxPos() + 240 <= xPos + 100) {
                    return true;
                }
            }
        }

        for (Boat b: boatsFour) {
            if (yPos == b.getBoatyPos()) {
                if (b.getBoatxPos() >= xPos && b.getBoatxPos() <= xPos + 100) {
                    return true;
                } else if (b.getBoatxPos() + 120 >= xPos && b.getBoatxPos() + 120 <= xPos + 100) {
                    return true;
                }
            }
        }

        if (yPos == logs1[0].getLogyPos()) {
            if ((xPos >= logs1[0].getLogxPos() - 60 && xPos <= logs1[0].getLogxPos() + 360)
                    || xPos >= logs1[1].getLogxPos() - 60 && xPos <= logs1[1].getLogxPos() + 360) {
                if (GameConstants.getxPos() > GameConstants.getxScreen() - 60) {
                    return true;
                }
                GameConstants.setxPos(xPos + Log.getLogSpeed());
                return false;
            } else {
                return true;
            }
        }

        if (yPos == logs2[0].getLogyPos()) {
            if ((xPos >= logs2[0].getLogxPos() - 60 && xPos <= logs2[0].getLogxPos() + 200)
                    || xPos >= logs2[1].getLogxPos() - 60 && xPos <= logs2[1].getLogxPos() + 200
                    || xPos >= logs2[2].getLogxPos() - 60 && xPos <= logs2[2].getLogxPos() + 200
                    || xPos >= logs2[3].getLogxPos() - 60 && xPos <= logs2[3].getLogxPos() + 200) {
                if (GameConstants.getxPos() < -60) {
                    return true;
                }
                GameConstants.setxPos(xPos - Log.getLogSpeed());
                return false;
            } else {
                return true;
            }
        }

        if (yPos == logs3[0].getLogyPos()) {
            if ((xPos >= logs3[0].getLogxPos() - 60 && xPos <= logs3[0].getLogxPos() + 360)
                    || xPos >= logs3[1].getLogxPos() - 60 && xPos <= logs3[1].getLogxPos() + 360) {
                if (GameConstants.getxPos() > GameConstants.getxScreen() - 60) {
                    return true;
                }
                GameConstants.setxPos(xPos + Log.getLogSpeed() + 2);
                return false;
            } else {
                return true;
            }
        }

        if (yPos == logs4[0].getLogyPos()) {
            if ((xPos >= logs4[0].getLogxPos() - 60 && xPos <= logs4[0].getLogxPos() + 200)
                    || xPos >= logs4[1].getLogxPos() - 60 && xPos <= logs4[1].getLogxPos() + 200
                    || xPos >= logs4[2].getLogxPos() - 60 && xPos <= logs4[2].getLogxPos() + 200
                    || xPos >= logs4[3].getLogxPos() - 60 && xPos <= logs4[3].getLogxPos() + 200) {
                if (GameConstants.getxPos() < -60) {
                    return true;
                }
                GameConstants.setxPos(xPos - (Log.getLogSpeed() + 1));
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public void createMap(Canvas c) {
        c.drawColor(Color.BLACK);
        for (int i = 0; i < mapLayout.length; i++) {
            for (int j = 0; j < mapLayout[i].length; j++) {
                if (mapLayout[i][j] == 0) {
                    c.drawBitmap(Tiles.FINISH_TILE.getTileType(),
                            null, new Rect(j * 120, i * 120,
                                    (j + 1) * 120, (i + 1) * 120), null);
                } else if (mapLayout[i][j] == 1) {
                    c.drawBitmap(Tiles.SAFE_TILE.getTileType(),
                            null, new Rect(j * 120, i * 120,
                                    (j + 1) * 120, (i + 1) * 120), null);
                } else if (mapLayout[i][j] == 2) {
                    c.drawBitmap(Tiles.WATER_TILE.getTileType(),
                            null, new Rect(j * 120, i * 120,
                                    (j + 1) * 120, (i + 1) * 120), null);
                } else if (mapLayout[i][j] == 3) {
                    c.drawBitmap(Tiles.OIL_TILE.getTileType(),
                            null, new Rect(j * 120, i * 120,
                                    (j + 1) * 120, (i + 1) * 120), null);
                } else {
                    c.drawBitmap(Tiles.GREEN_TILE.getTileType(),
                            null, new Rect(j * 120, i * 120,
                                    (j + 1) * 120, (i + 1) * 120), null);
                }
            }
        }
      
        for (Boat boat : boatsOne) {
            Rect rect = new Rect(
                    boat.getBoatxPos(), boat.getBoatyPos(),
                    boat.getBoatxPos() + 120, boat.getBoatyPos() + 120);
            c.drawBitmap(boat.getBoatImage(), null, rect, null);
        }
        for (Boat boat : boatsTwo) {
            Rect rect = new Rect(
                    boat.getBoatxPos(), boat.getBoatyPos(),
                    boat.getBoatxPos() + 120, boat.getBoatyPos() + 120);
            c.drawBitmap(boat.getBoatImage(), null, rect, null);
        }
        for (Boat boat : boatsThree) {
            Rect rect = new Rect(
                    boat.getBoatxPos(), boat.getBoatyPos(),
                    boat.getBoatxPos() + 240, boat.getBoatyPos() + 120);
            c.drawBitmap(boat.getBoatImage(), null, rect, null);
        }
        for (Boat boat : boatsFour) {
            Rect rect = new Rect(
                    boat.getBoatxPos(), boat.getBoatyPos(),
                    boat.getBoatxPos() + 120, boat.getBoatyPos() + 120);
            c.drawBitmap(boat.getBoatImage(), null, rect, null);
        }
        for (Log log : logs1) {
            Rect rect = new Rect(
                    log.getLogxPos(), log.getLogyPos() + 5,
                    log.getLogxPos() + 480, log.getLogyPos() + 130);
            c.drawBitmap(log.getLogImage(), null, rect, null);
        }
        for (Log log : logs2) {
            Rect rect = new Rect(
                    log.getLogxPos(), log.getLogyPos(), log.getLogxPos() + 240,
                    log.getLogyPos() + 120);
            c.drawBitmap(log.getLogImage(), null, rect, null);
        }
        for (Log log : logs3) {
            Rect rect = new Rect(
                    log.getLogxPos(), log.getLogyPos() + 5, log.getLogxPos() + 480,
                    log.getLogyPos() + 130);
            c.drawBitmap(log.getLogImage(), null, rect, null);
        }
        for (Log log : logs4) {
            Rect rect = new Rect(
                    log.getLogxPos(), log.getLogyPos(), log.getLogxPos() + 240,
                    log.getLogyPos() + 120);
            c.drawBitmap(log.getLogImage(), null, rect, null);
        }
    }

    public void updateGameObstacles() {
        for (Boat boat : boatsOne) {
            boat.setBoatxPos(boat.getBoatxPos() - (int) (Boat.getBoatSpeed()));
            if (boat.getBoatxPos() < -120) {
                boat.setBoatxPos(2160);
            }
        }
        for (Boat boat : boatsTwo) {
            boat.setBoatxPos(boat.getBoatxPos() + (int) (Boat.getBoatSpeed() + 2));
            if (boat.getBoatxPos() > 2160) {
                boat.setBoatxPos(-120);
            }
        }
        for (Boat boat : boatsThree) {
            boat.setBoatxPos(boat.getBoatxPos() - (int) (Boat.getBoatSpeed() + 1));
            if (boat.getBoatxPos() < -240) {
                boat.setBoatxPos(1080);
            }
        }
        for (Boat boat : boatsFour) {
            boat.setBoatxPos(boat.getBoatxPos() + (int) (Boat.getBoatSpeed() + 3));
            if (boat.getBoatxPos() > 2160) {
                boat.setBoatxPos(-120);
            }
        }
        for (Log log : logs1) {
            log.setLogxPos(log.getLogxPos() + (int) (Log.getLogSpeed()));
            if (log.getLogxPos() > 1200) {
                log.setLogxPos(-480);
            }
        }
        for (Log log : logs2) {
            log.setLogxPos(log.getLogxPos() - (int) (Log.getLogSpeed()));
            if (log.getLogxPos() < -240) {
                log.setLogxPos(1500);
            }
        }
        for (Log log : logs3) {
            log.setLogxPos(log.getLogxPos() + (int) (Log.getLogSpeed() + 2));
            if (log.getLogxPos() > 1200) {
                log.setLogxPos(-480);
            }
        }
        for (Log log : logs4) {
            log.setLogxPos(log.getLogxPos() - (int) (Log.getLogSpeed() + 1));
            if (log.getLogxPos() < -240) {
                log.setLogxPos(1500);
            }
        }
    }

    private void initializeTileMap() {
        mapLayout = new int[][] {
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3, 3, 3, 3, 3},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
                {4, 4, 4, 4, 4, 4, 4, 4, 4},
        };
    }

    public Boat[] getBoatsOne() {
        return boatsOne;
    }

    public Boat[] getBoatsTwo() {
        return boatsTwo;
    }

    public Boat[] getBoatsThree() {
        return boatsThree;
    }

    public Boat[] getBoatsFour() {
        return boatsFour;
    }
}