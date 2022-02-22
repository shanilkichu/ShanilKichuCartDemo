package com.myapp.shanilkichu.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.myapp.shanilkichu.R;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class MainCategory_Adapter extends RecyclerView.Adapter<MainCategory_Adapter.MyViewHolder> {
    Context context;
    private Activity activity;
    List<String> categoryList;
    public MainCategory_Adapter(List<String> categoryList, Context context) {

        this.categoryList=categoryList;
        this.context=context;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_cat_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.catTxt.setText(categoryList.get(position));
        holder.bannerImg.setImageResource(R.drawable.circle);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
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
