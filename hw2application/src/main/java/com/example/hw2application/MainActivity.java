package com.example.hw2application;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{

    private TextView textViewHomePage;
    private Button btnChange;
    private Spinner spinnerLocalization;
    private EditText editTextRepeat;
    private Button buttonRepeat;
    private Button buttonStartTimer;
    private Button buttonConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        //change action bar title
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));


        textViewHomePage = (TextView) findViewById(R.id.textViewHomePage);
        btnChange = (Button) findViewById(R.id.buttonChange);
        spinnerLocalization = (Spinner) findViewById(R.id.spinnerLocalization);
        // edit text
        editTextRepeat = (EditText) findViewById(R.id.editTextRepeat);
        buttonRepeat = (Button) findViewById(R.id.buttonRepeat);
        buttonConvert = (Button) findViewById(R.id.buttonConverterSolve);


        //btn
        buttonStartTimer = (Button) findViewById(R.id.buttonStartTimer);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.localization_spinner));
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerLocalization.setAdapter(spinnerArrayAdapter);

        buttonStartTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(newIntent);
            }
        });

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent converterIntent = new Intent(MainActivity.this, ConverterActivity.class);
                startActivity(converterIntent);
            }
        });







    }

    private void setLocale(Activity activity, String langCode){
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);

        Resources resources = activity.getResources();
        Configuration config = resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_lang", langCode);
        editor.apply();
    }

    private void loadLocale(){
        SharedPreferences preferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lang = preferences.getString("My_lang","en");
        setLocale(this, lang);
    }   


    public void onClickBtnChange(View view) {
        String lang = String.valueOf(spinnerLocalization.getSelectedItem());
        setLocale(MainActivity.this,lang);
        Toast.makeText(this,"btn clicked ",Toast.LENGTH_SHORT).show();
        recreate();
    }

    public void onClickButtonRepeat(View view) {
        Intent intent = new Intent(MainActivity.this, ParrotActivity.class);
        String text = editTextRepeat.getText().toString();

        if (text.equals("")){
            System.out.println("Enter name!");
            Toast.makeText(MainActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
        }
        else {
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }

    public void onClickbuttonGoContacts(View view) {
        Intent contactIntent = new Intent(MainActivity.this, ContactsActivity.class);
        startActivity(contactIntent);
    }
}

//alf left + right