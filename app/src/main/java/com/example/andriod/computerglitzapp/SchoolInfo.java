package com.example.andriod.computerglitzapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SchoolInfo extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(SchoolInfo.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(SchoolInfo.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(SchoolInfo.this, Search.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(SchoolInfo.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_info);
        final MNCollege mnCollege=new MNCollege();
        mnCollege.setCity("Eagan");
        mnCollege.setName("U of Nora");
        mnCollege.setState("MN");
        mnCollege.setWebsite("https://www.google.com");
        TextView mTextNameMessage = (TextView) findViewById(R.id.name);
        mTextNameMessage.setText(mnCollege.getName());
        TextView mTextCityMessage = (TextView) findViewById(R.id.city);
        mTextCityMessage.setText(mnCollege.getCity());
        TextView mTextStateMessage = (TextView) findViewById(R.id.state);
        mTextStateMessage.setText(mnCollege.getState());
        final Button websiteButton = findViewById(R.id.website);
        websiteButton.setText(mnCollege.getWebsite());
        websiteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mnCollege.getWebsite()));
                startActivity(browserIntent);
            }

        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }



}

