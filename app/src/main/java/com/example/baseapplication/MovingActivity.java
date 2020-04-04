package com.example.baseapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MovingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moving);
        ConstraintLayout constraintLayout = findViewById(R.id.myLayout);
        final RabbitView rabbitView = new RabbitView(this);
        rabbitView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                rabbitView.bitMapX = event.getX();
                rabbitView.bitMapY = event.getY();
                rabbitView.invalidate();
                return true;
            }
        });
        constraintLayout.addView(rabbitView);
    }
}
