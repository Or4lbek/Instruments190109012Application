package com.example.hw2application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewLastname;
    private TextView textViewNumber;
    private ImageView imageViewIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        textViewName = findViewById(R.id.textViewName);
        textViewLastname = findViewById(R.id.textViewLastname);
        textViewNumber = findViewById(R.id.textViewNumber);
        imageViewIcon = findViewById(R.id.imageViewIcon);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String lastname = intent.getStringExtra("lastname");
        String number = intent.getStringExtra("number");
        int resId = intent.getIntExtra("resId", -1 );

        textViewName.setText(name);
        textViewLastname.setText(lastname);
        textViewNumber.setText(number);
        imageViewIcon.setImageResource(resId);


    }
}