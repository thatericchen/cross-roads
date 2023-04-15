package com.example.crossroad;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button startButton = findViewById(R.id.startButton);
        Button quitButton = findViewById(R.id.quitButton);

        startButton.setOnClickListener(view -> openConfig());

        quitButton.setOnClickListener(v -> {
            MainActivity.this.finish();
            System.exit(0);
        });
    }

    private void openConfig() {
        Intent intent = new Intent(this, ConfigScreen.class);
        finishAffinity();
        startActivity(intent);
    }
}