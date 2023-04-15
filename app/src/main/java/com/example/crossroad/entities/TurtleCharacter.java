package com.example.crossroad.entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.crossroad.GameScreen;
import com.example.crossroad.R;

public enum TurtleCharacter {
    TURTLE1(R.drawable.turtle1),
    TURTLE2(R.drawable.turtle2),
    TURTLE3(R.drawable.turtle3);

    private Bitmap turtleType;
    private BitmapFactory.Options options = new BitmapFactory.Options();
    TurtleCharacter(int resID) {
        options.inScaled = false;
        turtleType = BitmapFactory.decodeResource(
                GameScreen.getGameContext().getResources(), resID, options);
    }

    public Bitmap getTurtleType() {
        return turtleType;
    }

}
