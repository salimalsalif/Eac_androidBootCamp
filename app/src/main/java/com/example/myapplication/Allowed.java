package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class Allowed extends AppCompatActivity {
TextView t1;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allowed);
        t1 = findViewById(R.id.textView5);
        getSupportActionBar().hide();
btn= findViewById(R.id.buttonShare);
        Date currentTime = Calendar.getInstance().getTime();
        t1.setText("Welcome!\n"+getIntent().getStringExtra("NAME")
                + "\tyou are  allowed to Enter\n "
                +"\n"+ getIntent().getStringExtra("NAME")+" \tis from \t" +getIntent().getStringExtra("City") + " ,"+getIntent().getStringExtra("Village")+"  "+getIntent().getStringExtra("Street")
                +"\nThis is Done on "+currentTime);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,t1.getText().toString());
                sendIntent.setType("text/plain");
                Intent.createChooser(sendIntent,"Share via");
                startActivity(sendIntent);
            }
        });
    }
}
