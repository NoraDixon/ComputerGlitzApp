package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                    startActivity(new Intent(SchoolInfo.this, CollegeListActivity.class));
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
        final MNCollege mnCollege = (MNCollege)getIntent().getSerializableExtra("CollegeSelected");

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
        final ImageButton checkButton = findViewById(R.id.check);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent collegeView = new Intent(SchoolInfo.this, IndividsualChecklist.class);
                collegeView.putExtra("CollegeSelected", mnCollege);
                startActivity(collegeView);
            }
        });

        final ImageButton heartButton = findViewById(R.id.heart);
        Set<String> favoritesCheck = retriveStringSetByID("favoritesList");
        if (favoritesCheck.contains(mnCollege.getUnitid())){
            heartButton.setImageResource(R.drawable.ic_favorite_black_24dp);
            heartButton.setTag("1");
        }
        heartButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (heartButton.getTag().equals("0")) {
                    heartButton.setImageResource(R.drawable.ic_favorite_black_24dp);
                    heartButton.setTag("1");
                    favoritesSave(mnCollege.getUnitid(), true);
                }
                else if (heartButton.getTag().equals("1")) {
                    heartButton.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    heartButton.setTag("0");
                    favoritesSave(mnCollege.getUnitid(), false);
                }
            }
        });
        final ImageButton calendarButton = findViewById(R.id.calendar);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SchoolInfo.this, Notifications.class));
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        List<String> programList = mnCollege.getProgramList();
       String putItAllTogether = "";
       for (String program:programList){
           putItAllTogether += program;
           putItAllTogether += "\n";
       }
       TextView mTextProgramMessage = (TextView) findViewById(R.id.programs);
        mTextProgramMessage.setText(putItAllTogether);
        String collegeNotes = new String();
        EditText collegeNotesView = (EditText) findViewById(R.id.editText);
        collegeNotesView.setText(retriveByID(mnCollege.getUnitid() + "Notes"));
        //collegeNotes = collegeNotesView.getText().toString();
        //schoolInfoSave(mnCollege.getUnitid(), collegeNotes);

        collegeNotesView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                schoolInfoSave(mnCollege.getUnitid(), editable.toString());
            }
        });

//        final Intent collegeView = new Intent(SchoolInfo.this, IndividsualChecklist.class);
//        collegeView.putExtra("CollegeSelected", mnCollege); //this
//        startActivity(collegeView); //this
    }


   private void schoolInfoSave(String unitid, String notes){

       SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
       SharedPreferences.Editor editor = sharedPreferences.edit();
       editor.putString(unitid+"Notes", notes);
       editor.apply();
    }

    public String retriveByID (String id){
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        return sharedPreferences.getString(id, "");
    }

    public Set<String> retriveStringSetByID (String id){
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        return sharedPreferences.getStringSet(id, new HashSet<String>());
    }
    private void favoritesSave(String unitid, boolean toBeAdded){
        Set<String> favorites = retriveStringSetByID("favoritesList");
        if (toBeAdded){
            favorites.add(unitid);
        }
        else if (!toBeAdded){
            favorites.remove(unitid);
        }
        SharedPreferences sharedPreferences = getSharedPreferences(AppVaribles.sharedPrefrencesFile, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("favoritesList",favorites);
        editor.apply();
    }

}

