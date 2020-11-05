package com.example.myapplication;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.text.Html;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Entrance extends AppCompatActivity {
    EditText city, village, street, temperature,name;
    Button btnPermit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        city = findViewById(R.id.editTextCity);
        village = findViewById(R.id.editTextVillage);
        street = findViewById(R.id.editTextStreet);
        name = findViewById(R.id.textView3);
        temperature = (EditText) findViewById(R.id.editTextTemp);
        btnPermit = findViewById(R.id.buttonPermit);
        getSupportActionBar().hide();
       /// final String temper = temperature.getText().toString() ;
       btnPermit.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.O)
           @Override
           public void onClick(View v) {
               double temp = Double.parseDouble(temperature.getText().toString());
                if((temp<=37.5)&&(temp>=35)) {
                    String nameToPass = name.getText().toString();
                    String city1 = city.getText().toString();
                    String village1 =village.getText().toString();
                    String street1 = street.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),Allowed.class);
                    intent.putExtra("NAME",nameToPass);
                    intent.putExtra("City",city1);
                    intent.putExtra("Village",village1);
                    intent.putExtra("Street",street1);
                    //intent.putExtra("Temperature",temper);
                    startActivity(intent);
                    finish();
                }else{

Intent intent = new Intent(getApplicationContext(),IsolationNeed.class);
                    String nameToPass1 = name.getText().toString();
                    String city1 = city.getText().toString();
                    String village1 =village.getText().toString();
                    String street1 = street.getText().toString();
                    intent.putExtra("City",city1);
                    intent.putExtra("Village",village1);
                    intent.putExtra("Street",street1);
                    intent.putExtra("NAME",nameToPass1);
                   intent.putExtra("Temperature",temp);
startActivity(intent);
                }
               }
    });
}
    }