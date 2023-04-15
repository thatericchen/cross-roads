package com.example.crossroad.entities;

import android.graphics.Bitmap;

public class Boat {

    private Bitmap boatImage;
    private static final int BOAT_SPEED = 1;
    private int boatxPos;
    private int boatyPos;

    public Boat(int boatxPos, int boatyPos, Bitmap boatImage) {
        this.boatImage = boatImage;
        this.boatxPos = boatxPos;
        this.boatyPos = boatyPos;
    }


    public Bitmap getBoatImage() {
        return boatImage;
    }

    public static int getBoatSpeed() {
        return BOAT_SPEED;
    }

    public int getBoatxPos() {
        return boatxPos;
    }

    public void setBoatxPos(int boatxPos) {
        this.boatxPos = boatxPos;
    }

    public int getBoatyPos() {
        return boatyPos;
    }

    public void setBoatyPos(int boatyPos) {
        this.boatyPos = boatyPos;
    }

}
