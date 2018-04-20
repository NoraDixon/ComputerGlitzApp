package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TrendingJobs extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(TrendingJobs.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(TrendingJobs.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(TrendingJobs.this, Search.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(TrendingJobs.this, Favorites.class));
                    return true;

            }
            return false;

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending_jobs);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
      //  mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        int row = 0;
        while (row < 46) {
            TrendingJobsLoader initialLoader = new TrendingJobsLoader();
            List<TrendingJobsData> Jobs = initialLoader.loadTrendingJobsData(TrendingJobs.this);
            List<TrendingJobsData> Pay = initialLoader.loadTrendingJobsData(TrendingJobs.this);
            final TrendingJobsData trendingJobsDataList = Jobs.get(row);
            // final TrendingJobsData trendingJobsDataList = Pay.get(row);
            if (row == 0) {
               // TextView mJob1 = (TextView) findViewById(R.id.Job1);
                //mJob1.setText(trendingJobsDataList.getJob());
            }
            row++;
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }}

