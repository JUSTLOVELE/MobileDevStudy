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

    View colorSquare2;

    View colorSquare3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        colorSquare = findViewById(R.id.colorSquare);
        button = findViewById(R.id.randomButton);
        colorSquare2 = findViewById(R.id.colorSquare2);
        colorSquare3 = findViewById(R.id.colorSquare3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorSquare.setVisibility(View.VISIBLE);
                Random rand = new Random();
                colorSquare.setBackgroundColor(Color.rgb( rand.nextInt(256),  rand.nextInt(256),  rand.nextInt(256)));
                colorSquare2.setBackgroundColor(Color.rgb( rand.nextInt(256),  rand.nextInt(256),  rand.nextInt(256)));
                colorSquare3.setBackgroundColor(Color.rgb( rand.nextInt(256),  rand.nextInt(256),  rand.nextInt(256)));

            }
        });
    }
}
