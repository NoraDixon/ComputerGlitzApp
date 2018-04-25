//Noras Screen

package com.example.andriod.computerglitzapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(MainActivity.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(MainActivity.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(MainActivity.this, Favorites.class));
                    return true;

            }
            return false;

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                if(position == 0) {
                    startActivity(new Intent(MainActivity.this, Checklist.class));
                }
                else if(position == 1) {
                    startActivity(new Intent(MainActivity.this, Favorites.class));
                }
                else if(position == 2) {
                    startActivity(new Intent(MainActivity.this, CollegeListActivity.class));
                }
                else if(position == 3) {
                    startActivity(new Intent(MainActivity.this, TrendingJobs.class));
                }
                else if(position == 4) {
                    startActivity(new Intent(MainActivity.this, Skills.class));
                }
                else if(position == 5) {
                    startActivity(new Intent(MainActivity.this, FinancailInfo.class));
                }
            }
        });
                MNCollegeLoader mnCollegeLoader=new MNCollegeLoader();
                List<MNCollege> collegeList = mnCollegeLoader.loadMNColleges(getApplicationContext());
                MNCollegeDataHolder mnCollegeDataHolder = MNCollegeDataHolder.getInstance();
                mnCollegeDataHolder.setCollegeData(collegeList);
                FavoritesDataHolder favoritesDataHolder = FavoritesDataHolder.getInstance();
                favoritesDataHolder.setCollegeData(new ArrayList<MNCollege>());

//            BroadcastReceiver br = new AlarmReciver();
//            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
//            filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
//            this.registerReceiver(br, filter);
    }
}
