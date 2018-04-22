package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by norad on 4/22/2018.
 */

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder> {
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView FavoritesSchoolsText;
        public MyViewHolder (View itemView){
            super (itemView);
            FavoritesSchoolsText=itemView.findViewById(R.id.FavoriteSchools);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item, parent, false);
        return new MyViewHolder(root);

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MNCollege item = FavoritesDataHolder.getInstance().getFilteredCollegeData().get(position);
        holder.FavoritesSchoolsText.setText(item.getName());

    }
    @Override
    public int getItemCount() {
        return FavoritesDataHolder.getInstance().getFilteredCollegeData().size();
    }
}
