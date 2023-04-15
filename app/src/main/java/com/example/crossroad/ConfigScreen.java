package com.example.crossroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class ConfigScreen extends AppCompatActivity {
    private String difficulty;
    private String icon;
    private EditText editName;
    private Button saveButton;

    public ConfigScreen() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_screen);

        Objects.requireNonNull(getSupportActionBar()).hide();

        editName = findViewById(R.id.editName);
        saveButton = findViewById(R.id.saveButton);
        RadioGroup modeGroup = findViewById(R.id.difficulty);
        RadioGroup iconGroup = findViewById(R.id.icons);

        saveButton.setOnClickListener(view -> {
            if (noErrors()) {
                Bundle settings = new Bundle();
                settings.putString("username", editName.getText().toString().strip());
                settings.putString("difficulty", difficulty);
                settings.putString("icon", icon);

                openGame(settings);
            } else {
                Snackbar.make(saveButton, "Invalid Username", Snackbar.LENGTH_LONG).show();
            }
        });

        modeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.easyMode:
                    difficulty = "Easy";
                    break;
                case R.id.mediumMode:
                    difficulty = "Medium";
                    break;
                case R.id.hardMode:
                    difficulty = "Hard";
                    break;
                default:
                    break;
            }
        });

        iconGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.turtle1:
                    icon = "selectturtle1";
                    break;
                case R.id.turtle2:
                    icon = "selectturtle2";
                    break;
                case R.id.turtle3:
                    icon = "selectturtle3";
                    break;
                default:
                    break;
            }
        });
    }

    private void openGame(Bundle settings) {
        Intent intent = new Intent(this, GameScreen.class);
        intent.putExtras(settings);
        finishAffinity();
        startActivity(intent);
    }

    private boolean noErrors() {
        return editName.getText().toString().length() != 0
                && !editName.getText().toString().isEmpty()
                && !editName.getText().toString().isBlank();
    }
}