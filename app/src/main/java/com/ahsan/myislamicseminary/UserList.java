package com.ahsan.myislamicseminary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> name,age,classs;
    DBHelper dbh;
    MyAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        dbh=new DBHelper(this);
        name=new ArrayList<>();
        age=new ArrayList<>();
        classs=new ArrayList<>();
        rv=findViewById(R.id.recyclerView);
        adp=new MyAdapter(this,name,age,classs);
        rv.setAdapter(adp);
        rv.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private void displayData() {
        Cursor cr=dbh.getData();
        if(cr.getCount()==0){
            Toast.makeText(this, "No Student Found!", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cr.moveToNext()){
                name.add(cr.getString(0));
                age.add(cr.getString(1));
                classs.add(cr.getString(2));
            }
        }
    }
}