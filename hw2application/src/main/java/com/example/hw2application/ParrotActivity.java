package com.example.hw2application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ParrotActivity extends AppCompatActivity {

    TextView textViewParrotSay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parrot);

        textViewParrotSay =  findViewById(R.id.textViewParrotSays);
        Intent intent = getIntent();
        String text = intent.getStringExtra("text");

        textViewParrotSay.setText(text);
    }
}