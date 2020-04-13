package com.lec2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    View colorSquare;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorSquare = findViewById(R.id.colorSquare);
        button = findViewById(R.id.randomButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                colorSquare.setBackgroundColor(Color.rgb( rand.nextInt(256),  rand.nextInt(256),  rand.nextInt(256)));
            }
        });
    }
}
