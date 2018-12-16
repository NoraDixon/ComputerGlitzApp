package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class IndividsualChecklist extends AppCompatActivity implements IndividualChecklistAdapter.MyViewHolder.IndividualChecklistAdapterListener {

    public RecyclerView mRecycler;
    private IndividualChecklistAdapter mAdapter;

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(IndividsualChecklist.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(IndividsualChecklist.this, IndividsualChecklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(IndividsualChecklist.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(IndividsualChecklist.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_checklist);
        final MNCollege mnCollege = (MNCollege) getIntent().getSerializableExtra("CollegeSelected");


        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new IndividualChecklistAdapter(this);
        mRecycler.setAdapter(mAdapter);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_checkmark);
        b.setChecked(true);

    }

    private void getCheckItemData() {
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        for (ChecklistItem item : ChecklistData.mChecklist
                ) {
            boolean isChecked = sharedPreferences.getBoolean(item.getKey(), false);
            item.setmIsChecked(isChecked);
        }
    }

    @Override
    public void onCheckBoxClick(IndividualChecklistItem item, boolean checked) {
        item.setmIsChecked(checked);
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(item.getKey(), item.ismIsChecked());
        editor.apply();
    }

}
