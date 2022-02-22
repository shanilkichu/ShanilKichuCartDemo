package com.myapp.shanilkichu.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.myapp.shanilkichu.R;

import java.util.List;

public class TopCategory_Adapter extends RecyclerView.Adapter<MainCategory_Adapter.MyViewHolder> {
    Context context;
    private Activity activity;
    List<String> usernameList;
    public TopCategory_Adapter(List<String> usernameList, Context context) {

        this.usernameList=usernameList;
        this.context=context;

    }


    @Override
    public MainCategory_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.top_cat_item, parent, false);
        return new MainCategory_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MainCategory_Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.catTxt.setText(usernameList.get(position));
        holder.bannerImg.setImageResource(R.drawable.ic_person);
    }

    @Override
    public int getItemCount() {
        return usernameList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImg;
        TextView catTxt;
        public MyViewHolder(View view) {
            super(view);
            bannerImg = view.findViewById(R.id.imgCat);
            catTxt = view.findViewById(R.id.txtcatName);
        }
    }

}
