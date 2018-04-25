package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by norad on 4/20/2018.
 */

public class TrendingJobsAdapter extends RecyclerView.Adapter<TrendingJobsAdapter.MyViewHolder> {
    static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView mTrendingViewJobs;
        private TextView mTrendingViewPay;

        private int mIndent;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTrendingViewPay = itemView.findViewById(R.id.TrendingViewPay);
            mTrendingViewJobs = itemView.findViewById(R.id.TrendingViewJobs);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TrendingJobsData item = TrendingJobsHolder.getInstance().getTrendingDatas().get(position);
        holder.mTrendingViewJobs.setText(item.getJob());
        holder.mTrendingViewPay.setText("$" + item.getPay());

    }

    @Override
    public int getItemCount() {
        return TrendingJobsHolder.getInstance().getTrendingDatas().size();
    }
}
