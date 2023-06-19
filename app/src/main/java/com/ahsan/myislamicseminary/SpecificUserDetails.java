package com.ahsan.myislamicseminary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpecificUserDetails extends AppCompatActivity {

    TextView dateTxt,sabaqTxt,sabaqiTxt,manzilTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_user_details);
        dateTxt=findViewById(R.id.datetxt);
        sabaqTxt=findViewById(R.id.sabaqtxt);
        sabaqiTxt=findViewById(R.id.sabaqitxt);
        manzilTxt=findViewById(R.id.manziltxt);

        Intent intent=getIntent();
        dateTxt.setText(intent.getStringExtra("date"));
        sabaqTxt.setText(intent.getStringExtra("sabaq"));
        sabaqiTxt.setText(intent.getStringExtra("sabaqi"));
        manzilTxt.setText(intent.getStringExtra("manzil"));
    }
}