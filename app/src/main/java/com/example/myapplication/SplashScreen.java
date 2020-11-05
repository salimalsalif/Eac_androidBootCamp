package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class SplashScreen extends AppCompatActivity {
VideoView videoView;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        videoView = findViewById(R.id.video);
        btn = findViewById(R.id.button);
        getSupportActionBar().hide();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
        String path = new StringBuilder("android.resource://")
                .append(getPackageName())
                .append("/raw/prevention").toString();
        videoView.setVideoPath(path);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(i);
                    }
                },60000);
            }
        });
        videoView.start();
    }
    }

