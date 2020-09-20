package com.example.user.servicett;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout MyLayout = (RelativeLayout) findViewById(R.id.idDrawBallView);
        MyLayout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            public void onSwipeRight() {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
                finish();
            }


        });


    }
}