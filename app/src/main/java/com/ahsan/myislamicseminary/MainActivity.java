package com.ahsan.myislamicseminary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
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

                if (TextUtils.isEmpty(nameText)) {
                    name.setError("Please enter name");
                    name.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(ageText)) {
                    age.setError("Please enter age");
                    age.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(classsText)) {
                    classs.setError("Please enter class");
                    classs.requestFocus();
                    return;
                }
                boolean checkInData=db.insertUserData(nameText,ageText,classsText);
                if(checkInData){
                    Toast.makeText(MainActivity.this, "Student Added Successfully", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    age.setText("");
                    classs.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "Student Is Not Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnGithub = findViewById(R.id.btnGithub);
        btnGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Uri object to represent the GitHub link you want to open
                Uri uri = Uri.parse("https://github.com/Ahsan-507/"); // Replace with the GitHub link you want to open

                // Create an Intent with the ACTION_VIEW action and the Uri object, and start the browser activity
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}