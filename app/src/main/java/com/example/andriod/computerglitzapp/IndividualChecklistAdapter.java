package com.example.andriod.computerglitzapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

/**
 * Created by Clare on 4/7/2018.
 */

public class IndividualChecklistAdapter extends Adapter<IndividualChecklistAdapter.MyViewHolder> {
static class MyViewHolder extends RecyclerView.ViewHolder{
    public TextView mMytextview;
    public CheckBox mMainCheckbox;
    public CheckBox mCollapsableCheckbox;
    public IndividualChecklistItem item;

    private int mIndent;

    public interface IndividualChecklistAdapterListener {
        void onCheckBoxClick(IndividualChecklistItem item, boolean checked);
    }
/*
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        listener.onCheckBoxClick(item, isChecked);
    }
  */

    public MyViewHolder(View itemView, final IndividualChecklistAdapterListener listener) {
        super(itemView);
        mMytextview = itemView.findViewById(R.id.view_holder_textview);
        mMainCheckbox = itemView.findViewById(R.id.view_holder_collapeser_checkbox);
        mCollapsableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    listener.onCheckBoxClick(item, isChecked);
                }});
        //Save Test
        mIndent = (int) itemView.getContext().getResources().getDimension(R.dimen.activity_checklist_indent);
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_individual_checklist_item, parent, false);
        return new MyViewHolder(root, individualChecklistAdapterListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        IndividualChecklistItem item = IndividualChecklistData.mIndividualChecklist.get(position);
        holder.item = item;
        holder.mCollapsableCheckbox.setChecked(item.ismIsChecked());
        holder.mMytextview.setText(item.getmText());
        holder.itemView.setPadding(holder.mIndent * item.getmIndent(), 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return IndividualChecklistData.mIndividualChecklist.size();
    }

    private MyViewHolder.IndividualChecklistAdapterListener individualChecklistAdapterListener;

    public IndividualChecklistAdapter(MyViewHolder.IndividualChecklistAdapterListener individualChecklistAdapterListener) {
        this.individualChecklistAdapterListener = individualChecklistAdapterListener;
    }
}
