package com.example.andriod.computerglitzapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Checklist extends AppCompatActivity {

    private RecyclerView mRecycler;
    private ChecklistAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(Checklist.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(Checklist.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(Checklist.this, Search.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(Checklist.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);
        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new ChecklistAdapter();
        mRecycler.setAdapter(mAdapter);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_checkmark);
        b.setChecked(true);
    }

}
