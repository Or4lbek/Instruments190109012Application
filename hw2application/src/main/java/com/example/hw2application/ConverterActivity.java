package com.example.hw2application;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {
    private Button buttonConvert;
    private RadioGroup radioGroup;
    private EditText editTextCurrencyValue;

    //textViews
    private TextView textViewDollar;
    private TextView textViewEuro;
    private TextView textViewYen;
    private TextView textViewRuble;
    private TextView textViewTenge;
    private double currency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        buttonConvert = (Button) findViewById(R.id.buttonConvert);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_currencies);
        editTextCurrencyValue = (EditText) findViewById(R.id.editTextCurrencyValue);

        textViewDollar = (TextView) findViewById(R.id.textViewDollars);
        textViewEuro = (TextView) findViewById(R.id.textViewEuros);
        textViewYen = (TextView) findViewById(R.id.textViewYens);
        textViewRuble = (TextView) findViewById(R.id.textViewRubles);
        textViewTenge = (TextView) findViewById(R.id.textViewTenges);


    }

    public void setTextViewText(double[] values){
        textViewDollar.setText(String.format("%.2f"+" $",values[0]));
        textViewEuro.setText(String.format("%.2f"+" €",values[1]));
        textViewYen.setText(String.format("%.2f"+" ¥",values[2]));
        textViewRuble.setText(String.format("%.2f"+" ₽",values[3]));
        textViewTenge.setText(String.format("%.2f"+" ₸",values[4]));
    }

    //convert functions
    public double[] getCurrenciesWhenDollar(double value){
        double[] arrValues = new double[5];
        arrValues[0] = value;
        arrValues[1] = value*0.87;
        arrValues[2] = value*112.91;
        arrValues[3] = value*71.61;
        arrValues[4] = value*425.02;
        return arrValues;
    }

    public double[] getCurrenciesWhenEuro(double value){
        double[] arrValues = new double[5];
        arrValues[0] = value*1.16;
        arrValues[1] = value;
        arrValues[2] = value*130.55;
        arrValues[3] = value*82.79;
        arrValues[4] = value*491.31 ;
        return arrValues;
    }

    public double[] getCurrenciesWhenYen(double value){
        double[] arrValues = new double[5];
        arrValues[0] = value*0.0089;
        arrValues[1] = value*0.0077 ;
        arrValues[2] = value;
        arrValues[3] = value*0.63;
        arrValues[4] = value*3.76;
        return arrValues;
    }

    public double[] getCurrenciesWhenRuble(double value){
        double[] arrValues = new double[5];
        arrValues[0] = value*0.014;
        arrValues[1] = value*0.012 ;
        arrValues[2] = value*1.58;
        arrValues[3] = value;
        arrValues[4] = value*5.93;
        return arrValues;
    }

    public double[] getCurrenciesWhenTenge(double value){
        double[] arrValues = new double[5];
        arrValues[0] = value*0.0024;
        arrValues[1] = value*0.0020 ;
        arrValues[2] = value*0.27;
        arrValues[3] = value*0.17;
        arrValues[4] = value;
        return arrValues;
    }


    @SuppressLint({"NonConstantResourceId", "DefaultLocale"})
    public void onClickButtonConvert(View view) {
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
//        Toast.makeText(this,radioButton.getText()+" ",Toast.LENGTH_SHORT).show();
        if (editTextCurrencyValue.getText().toString().equals("")){
            Toast.makeText(this,R.string.no_user_input,Toast.LENGTH_SHORT).show();
        }
        else{
            currency = Double.parseDouble(editTextCurrencyValue.getText().toString());
//            Toast.makeText(this,currency+" ",Toast.LENGTH_SHORT).show();
            double[] values;
            switch (radioButton.getId()){
                case R.id.radio_dollar:{
                    values = getCurrenciesWhenDollar(currency);
                    setTextViewText(values);
                    break;
                }
                case R.id.radio_euro:{
                    values = getCurrenciesWhenEuro(currency);
                    setTextViewText(values);
                    break;
                }
                case R.id.radio_ruble:{
                    values = getCurrenciesWhenRuble(currency);
                    setTextViewText(values);
                    break;
                }
                case R.id.radio_yen:{
                    values = getCurrenciesWhenYen(currency);
                    setTextViewText(values);
                    break;
                }
                case R.id.radio_tenge:{
                    values = getCurrenciesWhenTenge(currency);
                    setTextViewText(values);
                    break;
                }
            }
        }

    }
}