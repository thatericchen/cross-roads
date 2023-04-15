package com.example.crossroad;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;

public class TouchEvents {

    private GamePanel gamePanel;
    private float xCenter = 540;
    private float yCenter = 1565;
    private float radius = 90;
    private Paint circlePaint;
    private Paint yellowPaint;
    private float xTouch;
    private float yTouch;
    private boolean touchDown;

    public TouchEvents(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        circlePaint = new Paint();
        circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        circlePaint.setStrokeWidth(5);
        circlePaint.setColor(Color.BLACK);
        yellowPaint = new Paint();
        yellowPaint.setColor(Color.YELLOW);
    }

    public void draw(Canvas c) {
        c.drawCircle(xCenter, yCenter, radius, circlePaint);

        if (touchDown) {
            c.drawLine(xCenter, yCenter, xTouch, yTouch, yellowPaint);
        }
    }

    public boolean touchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float x = event.getX();
                float y = event.getY();

                float a = Math.abs(x - xCenter);
                float b = Math.abs(y - yCenter);
                float c = (float) Math.hypot(a, b);

                if (c <= radius) {
                    touchDown = true;
                    xTouch = x;
                    yTouch = y;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (touchDown) {
                    xTouch = event.getX();
                    yTouch = event.getY();

                    float xDiff = xTouch - xCenter;
                    float yDiff = yTouch - yCenter;

                    GameConstants.setJoystickDirection(getDirection(xDiff, yDiff));

                    float d = (float) Math.hypot(Math.abs(xDiff), Math.abs(yDiff));
                    if (d > radius) {
                        gamePanel.setPlayerMoveTrue(new PointF(xDiff, yDiff));
                    } else {
                        gamePanel.setPlayerMoveFalse();
                    }
                }
                break;

            case MotionEvent.ACTION_UP:
                touchDown = false;
                gamePanel.setPlayerMoveFalse();
                break;
            default:
                return true;
        }
        return true;
    }

    public String getDirection(float x, float y) {
        float z = Math.abs(y) / Math.abs(x);
        if (x > 0) {
            if (Math.atan(z) < (Math.PI / 4.0)) {
                return "right";
            } else if (y < 0) {
                return "up";
            } else {
                return "down";
            }
        } else {
            if (Math.atan(z) < (Math.PI / 4.0)) {
                return "left";
            } else if (y < 0) {
                return "up";
            } else {
                return "down";
            }
        }
    }
}
