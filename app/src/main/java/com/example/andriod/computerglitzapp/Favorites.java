
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
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Favorites extends AppCompatActivity {

    private TextView mTextMessage;
    private RecyclerView mRecycler;
    private FavoritesAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(Favorites.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(Favorites.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(Favorites.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(Favorites.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_favorites);
        b.setChecked(true);

        FavoritesDataHolder.getInstance().resetFilteredCollegeData();
        List<MNCollege> allColleges = MNCollegeDataHolder.getInstance().getCollegeData();
        List<MNCollege> favortiedColleges = new ArrayList<MNCollege>();
        Set<String> favoriteID = retriveStringSetByID("favoritesList");
        for (MNCollege college: allColleges){
            if (favoriteID.contains(college.getUnitid())){
                favortiedColleges.add(college);
            }
        }
        FavoritesDataHolder.getInstance().setFilteredCollegeData(favortiedColleges);

        final Intent collegeView = new Intent(Favorites.this, SchoolInfo.class); //this
        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new FavoritesAdapter();
        mRecycler.setAdapter(mAdapter);
        mRecycler.addOnItemTouchListener(new RecycleOnClickListener(getBaseContext(), new RecycleOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                collegeView.putExtra("CollegeSelected", FavoritesDataHolder.getInstance().getFilteredCollegeData().get(position)); //this
                startActivity(collegeView); //this
            }

        }));
        mAdapter.notifyDataSetChanged();

    }

        public Set<String> retriveStringSetByID (String id){
            SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
            return sharedPreferences.getStringSet(id, new HashSet<String>());
        }
    }