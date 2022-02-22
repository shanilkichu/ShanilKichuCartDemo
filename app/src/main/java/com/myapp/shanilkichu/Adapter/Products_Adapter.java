package com.myapp.shanilkichu.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myapp.shanilkichu.Model.ImageData;
import com.myapp.shanilkichu.R;

import java.util.ArrayList;
import java.util.List;

public class Products_Adapter extends RecyclerView.Adapter<Products_Adapter.MyViewHolder> {
    Context context;

    List<String> Km;
    List<String> List_OriginalPrice;
    List<String> List_OfferlPrice;
    List<String> List_Description;
    ArrayList<ImageData> data;
    public Products_Adapter(ArrayList<ImageData> data, Context context, List<String> km, List<String> list_description,
                             List<String> list_originalPrice, List<String> list_offerlPrice) {

        this.data=data;
        this.context=context;
        this.Km=km;
        this.List_Description=list_description;
        this.List_OfferlPrice=list_offerlPrice;
        this.List_OriginalPrice=list_originalPrice;
    }
    @NonNull
    @Override
    public Products_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.best_title_item, parent, false);
        return new Products_Adapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(Products_Adapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        ImageData allImages = data.get(position);
        holder.bannerImg.setImageResource(allImages.imageId);
        holder.txtKm.setText(Km.get(position));
        holder.txtOffer.setText("00%");
        if (List_OfferlPrice.get(position).equals("")){
            holder.txtOffer.setVisibility(View.GONE);
            holder.txtOriginalAmount.setVisibility(View.GONE);
        }else {
            holder.txtOriginalAmount.setVisibility(View.VISIBLE);
            holder.txtOriginalAmount.setText(List_OriginalPrice.get(position));
            holder.txtOriginalAmount.setPaintFlags( holder.txtOriginalAmount.getPaintFlags()
                    | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        holder.txtDesc.setText(List_Description.get(position));
        holder.txtOfferAmount.setText(List_OriginalPrice.get(position));
    }
    @Override
    public int getItemCount() {
        return Km.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView bannerImg;
        TextView txtKm,txtOriginalAmount,txtOfferAmount,txtDesc,txtOffer;
        public MyViewHolder(View view) {
            super(view);
            bannerImg = view.findViewById(R.id.imgCat);
            txtKm = view.findViewById(R.id.txtKm);
            txtOriginalAmount = view.findViewById(R.id.txtOriginalAmount);
            txtOfferAmount = view.findViewById(R.id.txtOfferAmount);
            txtDesc = view.findViewById(R.id.txtDescription);
            txtOffer = view.findViewById(R.id.txtoffer);
        }
    }

}
