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
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ashley on 4/20/2018.
 */

public class CollegeListActivity extends AppCompatActivity
{

    //
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //
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

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.PeanutButter);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

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

//super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.PeanutButter);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018// TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018  // TODO: 6/11/2018
            // TODO: 6/11/2018
            // TODO: 6/11/2018

























        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataHeader.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Search By Programs");

        // Adding child data
        List<String> Programs = new ArrayList<String>();
        Programs.add("Radio Host");

    }
}
        //


