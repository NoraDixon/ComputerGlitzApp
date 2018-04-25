package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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

        MNCollegeDataHolder.getInstance().resetFilteredCollegeData();
        final Intent collegeView = new Intent(CollegeListActivity.this, SchoolInfo.class); //this
        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
        mAdapter = new CollegeListItemAdapter();
        mRecycler.setAdapter(mAdapter);
        mRecycler.addOnItemTouchListener(new RecycleOnClickListener(getBaseContext(), new RecycleOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                collegeView.putExtra("CollegeSelected", MNCollegeDataHolder.getInstance().getFilteredCollegeData().get(position)); //this
                startActivity(collegeView); //this

            }
        }));
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu a = navigation.getMenu();
        MenuItem b = a.findItem(R.id.navigation_search);
        b.setChecked(true);
        Button searchButton = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editSearch);
        Button clearButton = findViewById(R.id.clear);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
            searchCollegeList(editText,textView);
                }
                return false;
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchCollegeList(editText, view);

            }
        });
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                MNCollegeDataHolder.getInstance().resetFilteredCollegeData();
                mAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });
    }
    private void searchCollegeList(EditText editText, View view){
        String searchText = editText.getText().toString().toLowerCase();
        List<MNCollege> foundCollege = new ArrayList<>();
        for (MNCollege mnCollege:MNCollegeDataHolder.getInstance().getCollegeData()
                ) {
            if (mnCollege.getName().toLowerCase().contains(searchText)){
                foundCollege.add(mnCollege);
            }
        }
        MNCollegeDataHolder.getInstance().setFilteredCollegeData(foundCollege);
        mAdapter.notifyDataSetChanged();
        editText.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
