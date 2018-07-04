package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
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
    static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mMytextview;
        private CheckBox mMainCheckbox;
        private CheckBox mCollapsableCheckbox;
        private IndividualChecklistItem item;

        private int mIndent;

        public MyViewHolder(View itemView, final individualChecklistAdapterListener listener;) {
            super(itemView);
            mMytextview = itemView.findViewById(R.id.view_holder_textview);
            mCollapsableCheckbox = itemView.findViewById(R.id.view_holder_collapeser_checkbox);
            mIndent = (int) itemView.getContext().getResources().getDimension(R.dimen.activity_checklist_indent);

    private void getCheckItemData(){
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPreferencesFile, Context.MODE_PRIVATE);
        for (ChecklistItem item:ChecklistData.mChecklist);{
            boolean isChecked = sharedPreferences.getBoolean(item.getKey(),false);
            item.setmIsChecked(isChecked);
                }
            }
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_checklist_item, parent, false);
        return new MyViewHolder(root, individualChecklistAdapterListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        IndividualChecklistItem item = IndividualChecklistData.mIndividualChecklist.get(position);
        holder.mMytextview.setText(item.getmText());
        holder.mCollapsableCheckbox.setChecked(item.ismIsChecked());
        mCollapsableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()); {
            @Override
            public void onCheckBoxClick(IndividualChecklistItem item, Boolean checked) {
                item.setmIsChecked(checked);
                SharedPreferences sharedPreferences = getSharedPreferences (AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(item.getKey(), item.ismIsChecked());
                editor.apply();
            }

            public void onCheckedChanged (CompoundButton compoundButton, boolean b) {
                listener.onCheckBoxClick(item, b);
            }
        }
        holder.itemView.setPadding(holder.mIndent * item.getmIndent(), 0, 0, 0);
    }

    @Override
    public int getItemCount() {
        return IndividualChecklistData.mIndividualChecklist.size();

        private MyViewHolder.individualChecklistAdapterListener ();

       public IndividualChecklistAdapter(MyViewHolder.IndividualChecklistAdapterListener individualChecklistAdapterListener){
           this.individualChecklistAdapterListener = individualChecklistAdapterListener;
        }

        }
    }


