package com.example.crossroad;

import android.graphics.Bitmap;

public class GameConstants {
    private static String playerConst;
    private static String difficultyConst;
    private static String iconConst;
    private static int livesConst;
    private static int scoreConst;
    private static int xPos;
    private static int yPos;
    private static int minY = 1320;
    private static int turtleSize = 120;
    private static int xScreen = 1080;
    private static String joystickDirection;
    private static int frame;
    private static String turtleDirection = "up";
    private static Bitmap turtleCharacter;
    private static int maxScore = 0;

    public static String getPlayer() {
        return playerConst;
    }
    public static void setPlayer(String player) {
        playerConst = player;
    }
    public static String getDifficulty() {
        return difficultyConst;
    }
    public static void setDifficulty(String difficulty) {
        difficultyConst = difficulty;
    }
    public static String getIcon() {
        return iconConst;
    }
    public static void setIcon(String icon) {
        iconConst = icon;
    }
    public static int getLives() {
        return livesConst;
    }
    public static void setLives(int lives) {
        livesConst = lives;
    }
    public static int getScore() {
        return scoreConst;
    }
    public static void setScore(int score) {
        scoreConst = score;
    }
    public static void setxPos(int pos) {
        xPos = pos;
    }
    public static int getxPos() {
        return xPos;
    }
    public static void setyPos(int pos) {
        yPos = pos;
    }
    public static int getyPos() {
        return yPos;
    }
    public static void setMinY(int pos) {
        minY = pos;
    }
    public static int getMinY() {
        return minY;
    }
    public static int getTurtleSize() {
        return turtleSize;
    }
    public static int getxScreen() {
        return xScreen;
    }
    public static String getJoystickDirection() {
        return joystickDirection;
    }
    public static void setJoystickDirection(String direction) {
        joystickDirection = direction;
    }
    public static int getFrame() {
        return frame;
    }
    public static void setFrame(int count) {
        frame = count;
    }
    public static String getTurtleDirection() {
        return turtleDirection;
    }
    public static void setTurtleDirection(String rot) {
        turtleDirection = rot;
    }
    public static Bitmap getTurtleCharacter() {
        return turtleCharacter;
    }
    public static void setTurtleCharacter(Bitmap turtle) {
        turtleCharacter = turtle;
    }
    public static int getMaxScore() {
        return maxScore;
    }
    public static void setMaxScore(int score) {
        maxScore = score;
    }
}
