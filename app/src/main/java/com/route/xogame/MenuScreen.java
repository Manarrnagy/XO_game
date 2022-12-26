package com.route.xogame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MenuScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        getSupportActionBar().hide();





    }

    public void Navigate(View view) {

        Intent i = new Intent(MenuScreen.this, Game.class);
        startActivity(i);// our current activity.
    }
}