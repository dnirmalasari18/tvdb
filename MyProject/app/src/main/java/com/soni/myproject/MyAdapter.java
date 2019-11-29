package com.soni.myproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.soni.myproject.model.DataTV;
import com.soni.myproject.model.GuestStar;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<DataTV> dataTVList;
    private Context context;
    public MyAdapter(ArrayList<DataTV> dataTVList) {
        this.dataTVList = dataTVList;
    }

    public MyAdapter(ArrayList<DataTV> dataTVList, Context context) {
        this.dataTVList = dataTVList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.card_component,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DataTV tv = dataTVList.get(i);
        //viewHolder.cardImageHolder.setImageResource(tv.getImg());
        viewHolder.cardTitle.setText(tv.getEpisodeName());
        viewHolder.cardDetails.setText(tv.getAiredSeason()+"-"+tv.getFirstAired());
        viewHolder.cardDescription.setText(tv.getDirector()+"-"+tv.getRating());
        viewHolder.cardStar.setText(tv.getEachGuestStars());
        Glide.with(context).load(tv.getImgUrl())
                .into(viewHolder.cardImageHolder);
    }

    @Override
    public int getItemCount() {
        return dataTVList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImageHolder;
        public TextView cardDetails, cardTitle, cardDescription, cardStar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImageHolder = itemView.findViewById(R.id.cardImageHolder);
            cardTitle = itemView.findViewById(R.id.cardTitle);
            cardDescription = itemView.findViewById(R.id.cardDescription);
            cardStar = itemView.findViewById(R.id.cardStar);
            cardDetails = itemView.findViewById(R.id.cardDetails);
        }
    }
}
