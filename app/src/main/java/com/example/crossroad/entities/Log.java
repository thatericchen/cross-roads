package com.example.crossroad.entities;

import android.graphics.Bitmap;

public class Log {

    private Bitmap logImage;
    private static final int LOG_SPEED = 3;
    private int logxPos;
    private int logyPos;

    public Log(int logxPos, int logyPos, Bitmap logImage) {

        this.logImage = logImage;
        this.logxPos = logxPos;
        this.logyPos = logyPos;
    }

    public Bitmap getLogImage() {
        return logImage;
    }

    public static int getLogSpeed() {
        return LOG_SPEED;
    }

    public int getLogxPos() {
        return logxPos;
    }

    public void setLogxPos(int logxPos) {
        this.logxPos = logxPos;
    }

    public int getLogyPos() {
        return logyPos;
    }
}
