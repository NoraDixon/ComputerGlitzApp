package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Clare on 4/7/2018.
 */

public class SkillsAdapter extends Adapter<SkillsAdapter.MyViewHolder> {
static class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView mMytextview;
    private Button mMybutton;

    private int mIndent;
    public MyViewHolder(View itemView) {
        super(itemView);
        mMytextview = itemView.findViewById(R.id.view_holder_textview);
        mMybutton = itemView.findViewById(R.id.view_holder_button);
        mIndent = (int) itemView.getContext().getResources().getDimension(R.dimen.activity_skills_indent);
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_skills_item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
SkillsItem item = SkillsData.mButton.get(position);
holder.mMytextview.setText(item.getmText());
holder.mMybutton.setText(item.getmLink());
holder.itemView.setPadding(holder.mIndent*item.getmIndent(),0,0,0);
    }

    @Override
    public int getItemCount() {
        return SkillsData.mButton.size();
    }


}
