package com.ahsan.myislamicseminary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,age,classs;
    Button submit,view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        classs=findViewById(R.id.classs);

        submit=findViewById(R.id.btnSubmit);
        view=findViewById(R.id.btnViewAll);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });
    }
}