package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationPage extends AppCompatActivity {
EditText fname,tmail,tpass,tphone;
Button btnReg;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        fname = findViewById(R.id.editTextName);
        tmail = findViewById(R.id.editTextEmail);
        tphone = findViewById(R.id.editTextPhone);
        tpass = findViewById(R.id.editTextPass);
        btnReg = findViewById(R.id.buttonRegister);
        getSupportActionBar().hide();
 auth = FirebaseAuth.getInstance();
 if(auth.getCurrentUser()!=null){
     startActivity(new Intent(getApplicationContext(),MainActivity.class));
 }
 btnReg.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         String email = tmail.getText().toString().trim();
         String pass = tpass.getText().toString().trim();

         if(TextUtils.isEmpty(email)){
             tmail.setError("Email can't be empty!");
         }
         if(TextUtils.isEmpty(pass)){
             tpass.setError("PassWord can't be empty!");
         }
         if((pass.length()<5)){
             tpass.setError("PassWord is too short!Please use at least 8 characters");
         }
auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Toast.makeText(RegistrationPage.this,"User Created Successfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }else
            Toast.makeText(RegistrationPage.this, "An error occured" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
    }
});
     }
 });

    }
}
