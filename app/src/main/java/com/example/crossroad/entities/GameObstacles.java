package com.example.crossroad.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.crossroad.GameScreen;
import com.example.crossroad.R;

public enum GameObstacles {

    SAILBOAT(R.drawable.sailboat),
    SHIP(R.drawable.ship),
    PIRATE(R.drawable.pirateship),
    LOGLONG(R.drawable.log1),
    LOGSHORT(R.drawable.log2);


    private BitmapFactory.Options options = new BitmapFactory.Options();
    private Bitmap obstacleType;

    GameObstacles(int resID) {
        options.inScaled = false;
        obstacleType = BitmapFactory.decodeResource(GameScreen.getGameContext().getResources(),
                resID, options);
    }

    public Bitmap getObstacleType() {
        return obstacleType;
    }

}