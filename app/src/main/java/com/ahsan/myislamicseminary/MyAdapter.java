package com.ahsan.myislamicseminary;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context ct;
    private ArrayList name_id, age_id, cls_id;

    public MyAdapter(Context ct,ArrayList name_id,ArrayList age_id,ArrayList cls_id) {
        this.ct=ct;
        this.name_id=name_id;
        this.age_id=age_id;
        this.cls_id=cls_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(ct).inflate(R.layout.userentery,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name_id.setText(String.valueOf(name_id.get(position)));
        holder.age_id.setText(String.valueOf(age_id.get(position)));
        holder.cls_id.setText(String.valueOf(cls_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return name_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name_id,age_id,cls_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name_id=itemView.findViewById(R.id.textname);
            age_id=itemView.findViewById(R.id.textage);
            cls_id=itemView.findViewById(R.id.textclass);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(ct,SpecificUserDetails.class);
                    intent.putExtra("date","Date: 20-06-2023");
                    intent.putExtra("sabaq","Sabaq: Surah=3 and verse 1-10");
                    intent.putExtra("sabaqi","Sabaqi: Surah=2");
                    intent.putExtra("manzil","Manzil: Para=1");
                    ct.startActivity(intent);
                }
            });
        }
    }
}
