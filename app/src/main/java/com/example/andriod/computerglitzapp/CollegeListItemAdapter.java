package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by emspr on 4/8/2018.
 */

public class CollegeListItemAdapter extends RecyclerView.Adapter<CollegeListItemAdapter.MyViewHolder> {
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView collegeNameText;
        public MyViewHolder (View itemView){
            super (itemView);
            collegeNameText=itemView.findViewById(R.id.CollegeName);
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_list_item, parent, false);
        return new MyViewHolder(root);

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MNCollege item = MNCollegeDataHolder.getInstance().getFilteredCollegeData().get(position);
        holder.collegeNameText.setText(item.getName());

    }
    @Override
    public int getItemCount() {
        return MNCollegeDataHolder.getInstance().getFilteredCollegeData().size();
    }
}
