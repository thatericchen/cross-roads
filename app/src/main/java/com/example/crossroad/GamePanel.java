package com.example.crossroad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.crossroad.entities.TurtleCharacter;
import com.example.crossroad.map.TilesLayout;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    private TilesLayout tileLayout = new TilesLayout();
    private Paint textPaint = new Paint();
    private Paint gameOverPaint = new Paint();
    private Paint winPaint = new Paint();
    private SurfaceHolder holder;
    private GameLoop gameLoop;
    private TouchEvents touchEvents;
    private boolean movePlayer;
    private GameScreen gameScreen = new GameScreen();

    public GamePanel(Context context) {
        super(context);
        holder = getHolder();
        holder.addCallback(this);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(70);
        gameOverPaint.setColor(Color.WHITE);
        gameOverPaint.setTextSize(100);
        gameOverPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        winPaint.setColor(Color.YELLOW);
        winPaint.setTextSize(100);
        winPaint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));

        GameConstants.setScore(0);
        GameConstants.setxPos(480);
        GameConstants.setyPos(1320);

        touchEvents = new TouchEvents(this);

        switch (GameConstants.getIcon()) {
            case "selectturtle1":
                GameConstants.setTurtleCharacter(TurtleCharacter.TURTLE1.getTurtleType());
                break;
            case "selectturtle2":
                GameConstants.setTurtleCharacter(TurtleCharacter.TURTLE2.getTurtleType());
                break;
            case "selectturtle3":
                GameConstants.setTurtleCharacter(TurtleCharacter.TURTLE3.getTurtleType());
                break;
            default:
                break;
        }

        switch (GameConstants.getDifficulty()) {
            case "Easy":
                GameConstants.setLives(7);
                break;
            case "Medium":
                GameConstants.setLives(5);
                break;
            case "Hard":
                GameConstants.setLives(3);
                break;
            default:
                break;
        }

        gameLoop = new GameLoop(this);
    }

    public boolean onTouchEvent(MotionEvent event) {
        return touchEvents.touchEvent(event);
    }

    public void render() {
        Canvas c = holder.lockCanvas();

        tileLayout.createMap(c);

        int x = GameConstants.getxPos();
        int y = GameConstants.getyPos();
        c.drawBitmap(GameConstants.getTurtleCharacter(),
                null, new Rect(x, y, x + 120, y + 120), null);
        c.drawText("SCORE:", 0, 100, textPaint);
        c.drawText(String.valueOf(GameConstants.getScore()), 250, 100, textPaint);
        c.drawText("MODE: ", 570, 100, textPaint);
        c.drawText(GameConstants.getDifficulty(), 800, 100, textPaint);
        c.drawText("PLAYER:", 0, 1750, textPaint);
        c.drawText(GameConstants.getPlayer(), 290, 1750, textPaint);
        c.drawText("LIVES:", 785, 1750, textPaint);
        c.drawText(String.valueOf(GameConstants.getLives()), 1000, 1750, textPaint);
        touchEvents.draw(c);

        holder.unlockCanvasAndPost(c);
    }

    public void update() {
        tileLayout.updateGameObstacles();
        boolean collided =
                tileLayout.checkForCollision(GameConstants.getxPos(), GameConstants.getyPos());
        if (collided) {
            if (GameConstants.getLives() > 0) {
                GameConstants.setLives(GameConstants.getLives() - 1);
                GameConstants.setxPos(480);
                GameConstants.setyPos(1320);
                GameConstants.setMaxScore(
                        Math.max(GameConstants.getMaxScore(), GameConstants.getScore()));
                GameConstants.setScore(0);
                GameConstants.setMinY(1320);
            }
            if (GameConstants.getLives() == 0) {
                gameScreen.gameOver(GameScreen.getGameContext());
            }
        } else {
            updateMovementAndScore();

            if (GameConstants.getyPos() <= 120) {
                gameScreen.win(GameScreen.getGameContext());
            }
        }
    }

    public void updateMovementAndScore() {
        GameConstants.setFrame(GameConstants.getFrame() + 1);
        if (GameConstants.getFrame() != 10) {
            return;
        }
        GameConstants.setFrame(0);

        if (!movePlayer) {
            return;
        }

        if (GameConstants.getxPos() >= 0
                && GameConstants.getxPos() <= GameConstants.getxScreen() - 120) {
            if (GameConstants.getJoystickDirection().equals("right")) {
                switch (GameConstants.getTurtleDirection()) {
                    case "up":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 90));
                        break;
                    case "down":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 270));
                        break;
                    case "left":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 180));
                        break;
                    default:
                        break;
                }
                GameConstants.setTurtleDirection("right");
                GameConstants.setxPos(Math.min(GameConstants.getxPos() + 120, 960));
            } else if (GameConstants.getJoystickDirection().equals("left")) {
                switch (GameConstants.getTurtleDirection()) {
                    case "up":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 270));
                        break;
                    case "down":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 90));
                        break;
                    case "right":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 180));
                        break;
                    default:
                        break;
                }
                GameConstants.setTurtleDirection("left");
                GameConstants.setxPos(Math.max(GameConstants.getxPos() - 120, 0));
            }
        }

        if (GameConstants.getyPos() >= GameConstants.getTurtleSize()
                && GameConstants.getyPos() <= 1380) {
            if (GameConstants.getJoystickDirection().equals("up")) {
                switch (GameConstants.getTurtleDirection()) {
                    case "down":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 180));
                        break;
                    case "right":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 270));
                        break;
                    case "left":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 90));
                        break;
                    default:
                        break;
                }
                GameConstants.setTurtleDirection("up");
                GameConstants.setyPos(Math.max(GameConstants.getyPos() - 120, 120));
            } else if (GameConstants.getJoystickDirection().equals("down")) {
                switch (GameConstants.getTurtleDirection()) {
                    case "up":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 180));
                        break;
                    case "right":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 90));
                        break;
                    case "left":
                        GameConstants.setTurtleCharacter(
                                rotateBitmap(GameConstants.getTurtleCharacter(), 270));
                        break;
                    default:
                        break;
                }
                GameConstants.setTurtleDirection("down");
                GameConstants.setyPos(Math.min(GameConstants.getyPos() + 120, 1320));
            }
        }

        if (GameConstants.getyPos() < GameConstants.getMinY()) {
            if (GameConstants.getyPos() < 780 && GameConstants.getyPos() > 660) {
                GameConstants.setScore(GameConstants.getScore() + 30);
            } else if (GameConstants.getyPos() < 1020 && GameConstants.getyPos() > 900) {
                GameConstants.setScore(GameConstants.getScore() + 20);
            } else if (GameConstants.getyPos() < 240) {
                GameConstants.setScore(GameConstants.getScore() + 100);
            } else {
                GameConstants.setScore(GameConstants.getScore() + 10);
            }
            GameConstants.setMinY(GameConstants.getyPos());
        }
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameLoop.startGameLoop();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    public void setPlayerMoveTrue(PointF lastTouchDiff) {
        movePlayer = true;
    }

    public void setPlayerMoveFalse() {
        movePlayer = false;
    }

    public Bitmap rotateBitmap(Bitmap turtle, float degrees) {
        int width = turtle.getWidth();
        int height = turtle.getHeight();

        Matrix matrix = new Matrix();
        matrix.preRotate(degrees);

        return Bitmap.createBitmap(turtle, 0, 0, width, height, matrix, true);
    }
}
