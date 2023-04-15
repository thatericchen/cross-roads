package com.example.crossroad;


import com.example.crossroad.entities.Boat;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.junit.Test;
import android.graphics.Bitmap;
import org.junit.Before;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class sprint4test {
    private Boat boat;
    //    int resID = R.drawable.my_image;
    @Before
    public void setUp() {
        Bitmap boatImage = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
        boat = new Boat(0, 0, boatImage);
    }
    @Test
    public void testGetBOAT_SPEED() {
        assertEquals(2, Boat.getBoatSpeed());
    }

    @Test
    public void testCreateBoatImage() {
        assertNotNull(boat.getBoatImage());
    }

    @Test
    public void testBoatImageInitialization() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat2 = new Boat(0, 0, boatImage);
        assertEquals(boatImage, boat2.getBoatImage());
    }

    @Test
    public void testBoatyPosInitialization() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(0, 75, boatImage);
        assertEquals(75, boat.getBoatyPos());
    }

    @Test
    public void testSetBoatxPos() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(0, 0, boatImage);
        boat.setBoatxPos(50);
        assertEquals(50, boat.getBoatxPos());
    }

    @Test
    public void testSetBoatyPos() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(0, 0, boatImage);
        boat.setBoatyPos(75);
        assertEquals(75, boat.getBoatyPos());
    }

    @Test
    public void testGetBoatxPos() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(50, 0, boatImage);
        assertEquals(50, boat.getBoatxPos());
    }

    @Test
    public void testGetBoatyPos() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(0, 75, boatImage);
        assertEquals(75, boat.getBoatyPos());
    }

    @Test
    public void testGetBoatImage() {
        Bitmap boatImage = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Boat boat = new Boat(0, 0, boatImage);
        assertEquals(boatImage, boat.getBoatImage());
    }

    @Test
    public void testSetBoatxPosWithNegativeValue() {
        Boat boat = new Boat(0, 0, null);
        boat.setBoatxPos(-5);
        assertEquals(-5, boat.getBoatxPos());
    }
    @Test
    public void testSetBoatyPosWithNegativeValue() {
        Boat boat = new Boat(0, 0, null);
        boat.setBoatyPos(-5);
        assertEquals(-5, boat.getBoatyPos());
    }

}
