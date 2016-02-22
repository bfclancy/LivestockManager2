package com.example.asus.livestockmanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class StartUpActivity extends AppCompatActivity {

    SharedPreferences preferences = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        preferences = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        String username = preferences.getString("username", null);
        if(username != null){
            startActivity(new Intent("android.intent.action.MainActivity"));
        }
        else
            startActivity(new Intent("android.intent.action.Register"));
    }
}