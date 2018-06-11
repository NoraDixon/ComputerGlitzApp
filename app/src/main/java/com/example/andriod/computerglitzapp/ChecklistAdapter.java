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

public class ChecklistAdapter extends Adapter<ChecklistAdapter.MyViewHolder> {
static class MyViewHolder extends RecyclerView.ViewHolder{
    private TextView mMytextview;
    private CheckBox mMainCheckbox;
    private CheckBox mCollapsableCheckbox;
    private ChecklistItem item;

    private int mIndent;
    public MyViewHolder(View itemView) {
        super(itemView);
        mMytextview = itemView.findViewById(R.id.view_holder_textview);
        mCollapsableCheckbox = itemView.findViewById(R.id.view_holder_collapeser_checkbox);
        mCollapsableCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listener.OnCheckBoxClick(item);
            }
        });
        mIndent = (int) itemView.getContext().getResources().getDimension(R.dimen.activity_checklist_indent);

    public interface ChecklistAdapterListener{
        void onCheckboxClick(ChecklistItem item, boolean checked);
    }

    public MyViewHolder(View itemView, final ChecklistAdapterListener listener; )
        super(itemView);
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_checklist_item, parent, false);
        return new MyViewHolder(root, checklistAdapterListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChecklistItem item = ChecklistData.mChecklist.get(position);
        holder.item = item;
        holder.mCollapsableCheckbox.setChecked(item.ismIsChecked());
        holder.mMytextview.setText(item.getmText());
        holder.itemView.setPadding(holder.mIndent*item.getmIndent(),0,0,0);
    }

    @Override
    public int getItemCount() {
    return ChecklistData.mChecklist.size();
    }
}
    private MyViewHolder.ChecklistAdapterListener checklistAdapterListener;

    public ChecklistAdapter ( MyViewHolder.ChecklistAdapterListener checklistAdapterListener ){
        this.checklistAdapterListener = checklistAdapterListener;
    }

    @Override


