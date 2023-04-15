////package com.example.crossroad;
////import org.junit.runner.RunWith;
////import static org.junit.Assert.*;
////import static org.mockito.Mockito.*;
////
////import org.junit.Before;
////import org.junit.Test;
//package com.example.crossroad;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.example.crossroad.entities.Boat;
//import com.example.crossroad.entities.GameObstacles;
//import com.example.crossroad.entities.TurtleCharacter;
//import com.example.crossroad.map.TilesLayout;
//
//import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//
//
//@RunWith(RobolectricTestRunner.class)
//@Config(manifest = Config.NONE)
//public class GameScreenTest {
//    //    @Mock
//    private GameScreen gameScreen;
//    private ConfigScreen config;
//    //private TouchEvents event = new TouchEvents(gameScreen);
//    @Before
//    public void setUp() {
//        gameScreen = new GameScreen();
//    }
//    @Test
//    public void testSetDifficulty() {
//        String expectedDifficulty = "hard";
//        GameConstants.setDifficulty(expectedDifficulty);
//        String actualDifficulty = GameConstants.getDifficulty();
//        Assert.assertEquals(expectedDifficulty, actualDifficulty);
//    }
//    @Test
//    public void testSetIcon() {
//        String expectedIcon = "turtle";
//        GameConstants.setIcon(expectedIcon);
//        String actualIcon = GameConstants.getIcon();
//        Assert.assertEquals(expectedIcon, actualIcon);
//    }
//    @Test
//    public void testSetPlayer() {
//        String expectedPlayer = "John";
//        GameConstants.setPlayer(expectedPlayer);
//        String actualPlayer = GameConstants.getPlayer();
//        Assert.assertEquals(expectedPlayer, actualPlayer);
//    }
////    @Test
////    public void testUsernameDisplay() {
////        ConfigScreen conf = new ConfigScreen();
////        conf. = "Cat";
////        assertNotNull(conf.getName());
////        assertEquals("Cat", conf.getName());
////    }
//    @Test
//    public void testBoatGenerationSingleLane() {
//
//        Boat[] boats = new Boat[5];
//
//        boats[0] = new Boat(120, 1200, null);
//        boats[1] = new Boat(480, 1200, null);
//        boats[2] = new Boat(960, 1200, null);
//        boats[3] = new Boat(1320, 1200, null);
//        boats[4] = new Boat(1920, 1200, null);
//
//        assertNotEquals(boats[0], boats[1]);
//        assertNotEquals(boats[0], boats[2]);
//        assertNotEquals(boats[0], boats[3]);
//        assertNotEquals(boats[0], boats[4]);
//
//    }
//
//    @Test
//    public void testBoatGenerationAcrossLanes() {
//
//        Boat[] boats1 = new Boat[5];
//        Boat[] boats2 = new Boat[5];
//
//        boats1[0] = new Boat(120, 1200, null);
//        boats1[1] = new Boat(480, 1200, null);
//        boats1[2] = new Boat(960, 1200, null);
//        boats1[3] = new Boat(1320, 1200, null);
//        boats1[4] = new Boat(1920, 1200, null);
//
//        boats2[0] = new Boat(840, 1080, null);
//        boats2[1] = new Boat(240, 1080, null);
//        boats2[2] = new Boat(-120, 1080, null);
//        boats2[3] = new Boat(-600, 1080, null);
//        boats2[4] = new Boat(-960, 1080, null);
//
//        assertNotEquals(boats1[0], boats2[0]);
//        assertNotEquals(boats1[0].getBoatyPos(), boats2[0].getBoatyPos());
//        assertNotEquals(boats1[1].getBoatyPos(), boats2[1].getBoatyPos());
//        assertNotEquals(boats1[2].getBoatyPos(), boats2[2].getBoatyPos());
//        assertNotEquals(boats1[3].getBoatyPos(), boats2[3].getBoatyPos());
//        assertNotEquals(boats1[4].getBoatyPos(), boats2[4].getBoatyPos());
//
//    }
//
//    @Test
//    public void testBoatCollisionInLane() {
//
////        Bitmap boatImage1 = GameObstacles.PIRATE.getObstacleType();
////        GameObstacles gameObstacles = new GameObstacles();
////        Bitmap boatImage2 = GameObstacles.SAILBOAT.getObstacleType();
//
//        Boat[] boats = new Boat[5];
//
//        boats[0] = new Boat(120, 960, null);
//        boats[1] = new Boat(480, 960, null);
//        boats[2] = new Boat(960, 960, null);
//        boats[3] = new Boat(1320, 960, null);
//        boats[4] = new Boat(1920, 960, null);
//
//        assertNotEquals(boats[0].getBoatxPos(), boats[1].getBoatxPos());
//        assertNotEquals(boats[0].getBoatxPos(), boats[2].getBoatxPos());
//        assertNotEquals(boats[0].getBoatxPos(), boats[3].getBoatxPos());
//        assertNotEquals(boats[0].getBoatxPos(), boats[4].getBoatxPos());
//        assertEquals(boats[0].getBOAT_SPEED(), boats[1].getBOAT_SPEED());
//
//    }
//
//    @Test
//    public void testBoatCollisionAcrossLanes() {
//
//        Boat[] boats1 = new Boat[5];
//        Boat[] boats2 = new Boat[5];
//
//        boats1[0] = new Boat(120, 1200, null);
//        boats1[1] = new Boat(480, 1200, null);
//        boats1[2] = new Boat(960, 1200, null);
//        boats1[3] = new Boat(1320, 1200, null);
//        boats1[4] = new Boat(1920, 1200, null);
//
//        boats2[0] = new Boat(840, 1080, null);
//        boats2[1] = new Boat(240, 1080, null);
//        boats2[2] = new Boat(-120, 1080, null);
//        boats2[3] = new Boat(-600, 1080, null);
//        boats2[4] = new Boat(-960, 1080, null);
//
//        assertNotEquals(boats1[0], boats2[0]);
//        assertNotEquals(boats1[0].getBoatxPos(), boats2[0].getBoatxPos());
//        assertNotEquals(boats1[0].getBoatyPos(), boats2[0].getBoatyPos());
//        assertNotEquals(boats1[1].getBoatxPos(), boats2[1].getBoatxPos());
//        assertNotEquals(boats1[1].getBoatyPos(), boats2[1].getBoatyPos());
//        assertNotEquals(boats1[2].getBoatxPos(), boats2[2].getBoatxPos());
//        assertNotEquals(boats1[2].getBoatyPos(), boats2[2].getBoatyPos());
//        assertNotEquals(boats1[3].getBoatxPos(), boats2[3].getBoatxPos());
//        assertNotEquals(boats1[3].getBoatyPos(), boats2[3].getBoatyPos());
//        assertNotEquals(boats1[4].getBoatxPos(), boats2[4].getBoatxPos());
//        assertNotEquals(boats1[4].getBoatyPos(), boats2[4].getBoatyPos());
//    }
//
//    @Test
//    public void testBoatScreenSide() {
//        Boat[] boats = new Boat[5];
//
//        boats[0] = new Boat(120, 960, null);
//        boats[1] = new Boat(480, 960, null);
//        boats[2] = new Boat(960, 960, null);
//        boats[3] = new Boat(1320, 960, null);
//        boats[4] = new Boat(1920, 960, null);
//
//        assertTrue(boats[0].getBoatxPos() < GameConstants.getxScreen() / 2);
//        assertTrue(boats[1].getBoatxPos() < GameConstants.getxScreen() / 2);
//        assertTrue(boats[2].getBoatxPos() > GameConstants.getxScreen() / 2);
//        assertTrue(boats[3].getBoatxPos() > GameConstants.getxScreen() / 2);
//        assertTrue(boats[4].getBoatxPos() > GameConstants.getxScreen() / 2);
//
//    }
//
//    @Test
//    public void testBoatMovement() {
//        Boat[] boats = new Boat[5];
//
//        boats[0] = new Boat(120, 960, null);
//        boats[1] = new Boat(480, 960, null);
//        boats[2] = new Boat(960, 960, null);
//        boats[3] = new Boat(1320, 960, null);
//        boats[4] = new Boat(1920, 960, null);
//
//        assertNotNull(boats[0].getBOAT_SPEED());
//        assertNotNull(boats[1].getBOAT_SPEED());
//        assertNotNull(boats[2].getBOAT_SPEED());
//        assertNotNull(boats[3].getBOAT_SPEED());
//        assertNotNull(boats[4].getBOAT_SPEED());
//    }
//
//    @Test
//    public void testScoreIncrease() {
//        Boat[] boats = new Boat[5];
//
//        boats[0] = new Boat(120, 960, null);
//        boats[1] = new Boat(480, 960, null);
//        boats[2] = new Boat(960, 960, null);
//        boats[3] = new Boat(1320, 960, null);
//        boats[4] = new Boat(1920, 960, null);
//
//        int score = GameConstants.getScore();
//
//        assertEquals(score,0);
//        assertNotEquals(turtleMove(score),0);
//
//    }
//
//    public int turtleMove(int x) {
//        return x + 10;
//    }
//
//}
//
