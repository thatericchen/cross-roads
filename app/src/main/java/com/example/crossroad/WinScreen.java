package com.example.crossroad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class WinScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String scoreString;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_screen);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button restartButton = findViewById(R.id.playagain);
        Button quitButton = findViewById(R.id.quit);
        TextView score = findViewById(R.id.score2);

        scoreString = "Score: " + GameConstants.getScore();
        score.setText(scoreString);

        restartButton.setOnClickListener(view -> openConfig());
        GameConstants.setMaxScore(0);
        quitButton.setOnClickListener(v -> {
            finishAffinity();
            System.exit(0);
        });
    }

    private void openConfig() {
        Intent intent = new Intent(this, ConfigScreen.class);
        finishAffinity();
        startActivity(intent);
    }
}
