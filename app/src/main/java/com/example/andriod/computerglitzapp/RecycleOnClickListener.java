package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by christinecarroll on 4/20/18.
 */

public class RecycleOnClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener clickListener;

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);


    }
    GestureDetector gestureDetector;

    public RecycleOnClickListener(Context context, OnItemClickListener listener) {

        clickListener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });
    }

    @Override public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
        //find the item they are clicking on
        View childView = view.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            return true;
        }
        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
}
