package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class IsolationNeed extends AppCompatActivity {
TextView t1;
Button btn,btn2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isolation_need);
        t1 = findViewById(R.id.getTest);
        btn = findViewById(R.id.buttonShare);
        getSupportActionBar().hide();
        Date currentTime = Calendar.getInstance().getTime();
        t1.setText("ALERT\tALERT!!\n"+getIntent().getStringExtra("NAME") + " has "
                +getIntent().getDoubleExtra("Temperature",0.00) +"  °C "
                + "Hence he's "+"not allowed to Enter,he must be tested from covid\n "
        +"\n"+ "He lives in " +getIntent().getStringExtra("City") + " ,"+getIntent().getStringExtra("Village")+"  "+getIntent().getStringExtra("Street")
        +"\nThis is Done on "+currentTime);
 btn2 = findViewById(R.id.button2);
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Uri number = Uri.parse("tel:117");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }
});
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
