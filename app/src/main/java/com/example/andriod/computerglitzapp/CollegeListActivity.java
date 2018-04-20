package com.example.andriod.computerglitzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by Ashley on 4/20/2018.
 */

public class CollegeListActivity extends AppCompatActivity
{


    private RecyclerView mRecycler;
    private CollegeListItemAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(CollegeListActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(CollegeListActivity.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(CollegeListActivity.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(CollegeListActivity.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);
        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new CollegeListItemAdapter();
        mRecycler.setAdapter(mAdapter);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_checkmark);
        b.setChecked(true);
    }

}
