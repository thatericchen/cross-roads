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
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import android.graphics.Bitmap;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
////
////@RunWith(MockitoJUnitRunner.class)
////public class GameScreenTest {
////
//////    @Test
//////    public void testJunit() {
////////        GameScreen test = new GameScreen();
////////        int result = test.testJunit();
//////        assertEquals(5,GameScreen.testJunit());
//////    }
////
////}
//
//import android.os.Bundle;
//
//import android.widget.ImageView;
//import android.widget.Button;
//import android.content.Intent;
//import android.widget.TextView;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import android.widget.Button;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.Robolectric;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//
//@RunWith(RobolectricTestRunner.class)
//@Config(manifest = Config.NONE)
//public class GameScreenTest {
//    //    @Mock
//    private GameScreen gameScreen;
//    @Before
//    public void setUp() {
//        gameScreen = new GameScreen();
//    }
//
//    @Test
//    public void testScoreIncrement() {
//        GameScreen gameScreen = new GameScreen();
//        gameScreen.minYforScore = 1000;
//        gameScreen.intScore = 20;
//
//        // Click on the upButton to move the turtle up
//        gameScreen.upButton.performClick();
//
//        // Assert that the score has increased by 10
//        assertEquals(30, gameScreen.intScore);
//    }
//    @Test
//    public void size() {
//
//    }
//    @Test
//    public void testMinVal() {
//        GameScreen gameScreen = new GameScreen();
//        float min = gameScreen.minYforScore;
//        assertEquals(1350, min, 0);
//
//    }
//    @Test
//    public void testInitialScoreIsZero() {
//        GameScreen gameScreen = new GameScreen();
//        int score = gameScreen.getScore();
//        assertEquals(0, score);
//
//    }
//
//    @Test
//    public void numLives() {
//        GameScreen gameScreen = new GameScreen();
//        int lives = gameScreen.getLives();
//        assertEquals(0, lives);
//
//    }
//
//    @Test
//    public void testDifficultyDisplay() {
//        GameScreen gameScreen = new GameScreen();
//        TextView difficultyView = gameScreen.findViewById(R.id.difficulty);
//        assertNotEquals(difficultyView, "Easy");
////        assertEquals("Easy", difficultyView.getText().toString());
//    }
////    @Test
////    public void selectTurtle1Test() {
////        // Create the intent with the turtle icon name
////        Intent intent = new Intent();
////        Bundle bundle = new Bundle();
////        bundle.putString("icon", "selectturtle1");
////        intent.putExtras(bundle);
////
////        // Launch the activity with the intent
////        GameScreen activity = Robolectric.buildActivity(GameScreen.class, intent).create().resume().get();
////
////        // Check that the correct turtle image is displayed
////        ImageView turtleImage = activity.findViewById(R.id.icon);
////        assertEquals(R.drawable.selectturtle1, turtleImage.getDrawable().getConstantState().hashCode());
////    }
//
//
//
//    //
////    @Test
////    public void testMediumDifficulty() {
////        int lives1 = 3;
////        int lives2 = Difficulty.MEDIUM.getLives();
////        assertNotEquals(lives1, lives2);
////    }
////
////    @Test
////    public void testHardDifficulty() {
////        int lives1 = 3;
////        int lives2 = Difficulty.HARD.getLives();
////        assertNotEquals(lives1, lives2);
////    }
//////
//    @Test
//    public void testGetTurtle() {
//        GameScreen gameScreen = new GameScreen();
//        assertTrue(gameScreen.getTurtle() instanceof ImageView);
//    }
//
//
////
////    public void setUp() {
////        Intent intent = new Intent();
////        intent.putExtra("username", "Test User");
////        intent.putExtra("difficulty", "Easy");
////        intent.putExtra("icon", "selectturtle1");
////        gameScreen = Robolectric.buildActivity(GameScreen.class, intent).create().get();
////    }
////    @Test
////    public void testScoreIncreaseOnUp() {
////        GameScreen gameScreen2 = new GameScreen();
////        gameScreen.minYforScore = 1350;
////        gameScreen.intScore = 0;
////        gameScreen.turtle.setY(1350);
////        gameScreen.upButton.onClick();
////        assert(gameScreen2.intScore == 10);
////    }
////@Test
////public void testSailBoatCreation() {
////    Bitmap boatImage = GameObstacles.SAILBOAT.getObstacleType();
////    Boat boat = new Boat(0, 0,boatImage);
////    assertEquals(boat.getBoatImage(), GameObstacles.SAILBOAT.getObstacleType());
////}
////
////    @Test
////    public void testShipCreation() {
////        Bitmap boatImage = GameObstacles.SHIP.getObstacleType();
////        Boat boat = new Boat(0, 0,boatImage);
////        assertEquals(boat.getBoatImage(), GameObstacles.SHIP.getObstacleType());
////    }
////
////    @Test
////    public void testPirateShipCreation() {
////        Bitmap boatImage = GameObstacles.PIRATE.getObstacleType();
////        Boat boat = new Boat(0, 0,boatImage);
////        assertEquals(boat.getBoatImage(), GameObstacles.PIRATE.getObstacleType());
////    }
////@Test
////public void testTurtleMovesLeft() {
////    GameScreen gameScreen2 = new GameScreen();
////    gameScreen.turtle.setX(600);
////    gameScreen.leftButton.performClick();
////    assert(gameScreen2.turtle.getX() == 480);
////}
//
//    @Test
//    public void testUsernameDisplay() {
//        GameScreen gameScreen = new GameScreen();
//        gameScreen.name = "Cat";
//        assertNotNull(gameScreen.getName());
//        assertEquals("Cat", gameScreen.getName());
//    }
//
//    @Test
//    public void testTurtle() {
//        GameScreen gameScreen = new GameScreen();
//        Object turt = gameScreen.getTurtle();
//        assertNotNull(gameScreen.getName());
//        assertTrue(gameScreen.getTurtle() instanceof ImageView);
//
//    }
////
////    @Test
////    public void testIconDisplay() {
////        ImageView iconView = gameScreen.findViewById(R.id.icon);
////        assertNotNull(iconView);
////        assertEquals(R.drawable.selectturtle1, iconView.getDrawable().getConstantState().newDrawable().getConstantState());
////    }
//
//
//
//    @org.testng.annotations.Test
//    public void testLivesDisplay() {
//        TextView livesView = gameScreen.findViewById(R.id.levels);
//        assertNotNull(livesView);
//        assertEquals("7", livesView.getText().toString());
//    }
//
//    // Add more tests here to cover all the methods in the GameScreen class
//
//}
//
