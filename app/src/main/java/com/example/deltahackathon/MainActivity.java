package com.example.deltahackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_play,tv_ninjaRun, tv_highScore;
    String highScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        tv_play=findViewById(R.id.tv_play);
        tv_ninjaRun=findViewById(R.id.tv_ninjaRun);
        tv_highScore =findViewById(R.id.tv_highScore);

        tv_ninjaRun.setText("NINJA RUN");
        tv_play.setText("PLAY");

        tv_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs=this.getSharedPreferences("highScorePrefsKey",MODE_PRIVATE);
        highScore=String.valueOf(prefs.getInt("highScore",0));
        tv_highScore.setText("High Score: "+highScore);

    }

    public void onBackPressed() {
        finishAffinity();
    }

}