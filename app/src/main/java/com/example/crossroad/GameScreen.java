package com.example.crossroad;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class GameScreen extends AppCompatActivity {

    private static Context gameContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameContext = this;

        Intent settings = getIntent();
        Bundle b = settings.getExtras();
        GameConstants.setPlayer(b.getString("username"));
        GameConstants.setDifficulty(b.getString("difficulty"));
        GameConstants.setIcon(b.getString("icon"));

        setContentView(new GamePanel(this));

        Objects.requireNonNull(getSupportActionBar()).hide();

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public static Context getGameContext() {
        return gameContext;
    }

    public void gameOver(Context context) {
        Intent intent = new Intent(context, GameOverScreen.class);
        finishAffinity();
        context.startActivity(intent);
    }

    public void win(Context context) {
        Intent intent = new Intent(context, WinScreen.class);
        finishAffinity();
        context.startActivity(intent);
    }
}