package com.ahsan.myislamicseminary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,age,classs;
    Button submit,view;

    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        age=findViewById(R.id.age);
        classs=findViewById(R.id.classs);

        submit=findViewById(R.id.btnSubmit);
        view=findViewById(R.id.btnViewAll);

        db=new DBHelper(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,UserList.class));
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText=name.getText().toString();
                String ageText=age.getText().toString();
                String classsText=classs.getText().toString();

                boolean checkInData=db.insertUserData(nameText,ageText,classsText);
                if(checkInData){
                    Toast.makeText(MainActivity.this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Student Is Not Added", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}