package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Clare on 4/7/2018.
 */

public class ChecklistAdapter extends Adapter<ChecklistAdapter.MyViewHolder> {
static class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView mMytextview;
    private CheckBox mMainCheckbox;
    private CheckBox mCollapsableCheckbox;

    private int mIndent;
    public MyViewHolder(View itemView) {
        super(itemView);
        mMytextview = itemView.findViewById(R.id.view_holder_textview);
        mMainCheckbox = itemView.findViewById(R.id.view_holder_checkbox);
        mCollapsableCheckbox = itemView.findViewById(R.id.view_holder_collapeser_checkbox);
        mIndent = (int) itemView.getContext().getResources().getDimension(R.dimen.activity_checklist_indent);
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_checklist_item, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
ChecklistItem item = ChecklistData.mChecklist.get(position);
holder.mMytextview.setText(item.getmText());
holder.itemView.setPadding(holder.mIndent*item.getmIndent(),0,0,0);
    }

    @Override
    public int getItemCount() {
        return ChecklistData.mChecklist.size();
    }
}
