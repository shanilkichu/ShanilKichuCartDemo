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

public class SubCategory_Adapter extends RecyclerView.Adapter<SubCategory_Adapter.MyViewHolder> {
    Context context;
    private Activity activity;
    List<String> subCatName;
    public SubCategory_Adapter(List<String> subCatName, Context context) {

        this.subCatName =subCatName;
        this.context=context;

    }


    @Override
    public SubCategory_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sub_cat_item, parent, false);
        return new SubCategory_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubCategory_Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.catTxt.setText(subCatName.get(position));
        holder.bannerImg.setImageResource(R.drawable.green_circle);
    }

    @Override
    public int getItemCount() {
        return subCatName.size();
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
