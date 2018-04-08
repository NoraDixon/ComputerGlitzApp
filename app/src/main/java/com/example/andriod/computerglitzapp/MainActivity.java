//Noras Screen

package com.example.andriod.computerglitzapp;

import android.content.Intent;
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
                    startActivity(new Intent(MainActivity.this, Search.class));
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
//        Menu a = navigation.getMenu();
//        MenuItem b = a.findItem(R.id.navigation_search);
//        b.setIcon(R.drawable.glass);

        GridView gridview = findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Toast.makeText(MainActivity.this, "" + position,
                //  Toast.LENGTH_SHORT).show();
                if(position == 0) {
                    startActivity(new Intent(MainActivity.this, Favorites.class));
                }
                else if(position == 1) {
                    startActivity(new Intent(MainActivity.this, Checklist.class));
                }
                else if(position == 2) {
                    startActivity(new Intent(MainActivity.this, Search.class));
                }
            }
        });
//        InitalLoader initialLoader = new InitalLoader();
//        List<CollegeData> colleges = initialLoader.LoadColleges(MainActivity.this);
//        for (int i = 0; i < colleges.size(); i++) {
//            //get the item at location "i".  This will be a college data
//            CollegeData college = colleges.get(i);
//            String name = college.getNameofCollege();
//            Log.d("glitz","name"+name);
//        }
    }
}

/*recomaendeation pathway
trending jobs
online quizes
intrest quizes
fafsa/ financal
about
*/
