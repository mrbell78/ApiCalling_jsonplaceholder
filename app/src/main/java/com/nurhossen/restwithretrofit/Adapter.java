package com.nurhossen.restwithretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.customclass> {

    List<Post> datalist;
    Context context;

    public Adapter(List<Post> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public customclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.itemview,parent,false);
        return new customclass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull customclass holder, int position) {


        holder.id.setText(String.valueOf(datalist.get(position).getId()));
        holder.useid.setText(String.valueOf(datalist.get(position).getUserId()));
        holder.title.setText(datalist.get(position).getTitle());
        holder.body.setText(datalist.get(position).getText());


    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class customclass extends RecyclerView.ViewHolder {

        TextView id,useid,title,body;
        public customclass(@NonNull View itemView) {
            super(itemView);

            id=itemView.findViewById(R.id.id);
            useid=itemView.findViewById(R.id.userid);
            title=itemView.findViewById(R.id.title);
            body=itemView.findViewById(R.id.body);
        }
    }
}
