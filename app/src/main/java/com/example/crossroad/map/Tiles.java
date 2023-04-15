package com.example.crossroad.map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.crossroad.GameScreen;
import com.example.crossroad.R;

public enum Tiles {
    FINISH_TILE(R.drawable.sand),
    SAFE_TILE(R.drawable.boardwalk),
    WATER_TILE(R.drawable.ocean),
    OIL_TILE(R.drawable.oilwater),
    GREEN_TILE(R.drawable.greensquare);

    private Bitmap tileType;
    private BitmapFactory.Options options = new BitmapFactory.Options();

    Tiles(int resID) {
        options.inScaled = false;
        tileType = BitmapFactory.decodeResource(
                GameScreen.getGameContext().getResources(), resID, options);
    }

    public Bitmap getTileType() {
        return tileType;
    }

}
