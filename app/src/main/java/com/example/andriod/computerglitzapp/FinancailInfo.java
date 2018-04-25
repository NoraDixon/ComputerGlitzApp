package com.example.andriod.computerglitzapp;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FinancailInfo extends AppCompatActivity {

    private RecyclerView mRecycler;
    private FinancailInfoAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(FinancailInfo.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(FinancailInfo.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(FinancailInfo.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(FinancailInfo.this, Favorites.class));
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financail_info);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

//        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
//        mAdapter = new FinancailInfoAdapter();
//        mRecycler.setAdapter(mAdapter);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_home);
        b.setChecked(true);

//        final MNCollege mnCollege = (MNCollege) getIntent().getSerializableExtra("CollegeSelected");
//        final Button websiteButton = (Button) findViewById(R.id.view_holder_button);
//        websiteButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mnCollege.getWebsite()));
//                startActivity(browserIntent);
//
//            }
//        });\

        final Button thingsButton = findViewById(R.id.thingsButton);
        thingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://blog.ed.gov/2017/09/12-common-fafsa-mistakes-2/"));
                startActivity(intent);
            }
        });

        final Button fafsaButton = findViewById(R.id.fafsaButton);
        fafsaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://fafsa.ed.gov/ "));
                startActivity(intent);
            }
        });

        final Button scholorshipButton = findViewById(R.id.scholorshipButton);
        scholorshipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.scholarships.com/"));
                startActivity(intent);
            }
        });

        final EditText financailInfo = (EditText) findViewById(R.id.finacalText);
        financailInfo.setText(retriveByID("financailNotes"));
        financailInfo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                saveFinancial(editable.toString());
            }
        });
    }

    private void saveFinancial (String notes){

        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("financailNotes", notes);
        editor.apply();
    }
    public String retriveByID (String id){
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        return sharedPreferences.getString(id, "");
    }
    }


