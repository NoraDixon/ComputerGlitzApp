package com.example.andriod.computerglitzapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Skills extends AppCompatActivity {

    private RecyclerView mRecycler;
    private SkillsAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(Skills.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(Skills.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(Skills.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(Skills.this, Favorites.class));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

//        mRecycler = (RecyclerView) findViewById(R.id.reclycler);
//        mAdapter = new SkillsAdapter();
//        mRecycler.setAdapter(mAdapter);
//        BottomNavigationView navigation = findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        Menu a = navigation.getMenu();
//        MenuItem b = a.findItem(R.id.navigation_home);
//        b.setChecked(true);

//        final MNCollege mnCollege = (MNCollege)getIntent().getSerializableExtra("CollegeSelected");
//        final Button websiteButton = (Button) findViewById(R.id.view_holder_button);
//        websiteButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mnCollege.getWebsite()));
//                startActivity(browserIntent);
//            }
//        });

        final Button interstButton = findViewById(R.id.intrestButton);
        interstButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://careerwise.minnstate.edu/careers/interestassessment.html"));
                startActivity(intent);
            }
        });

        final Button clusterButton = findViewById(R.id.clusterButton);
        clusterButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://careerwise.minnstate.edu/careers/clusterSurvey?do=0"));
                startActivity(intent);
            }
        });

        final Button seekButton = findViewById(R.id.seekButton);
        seekButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.iseek.org/careers/stem.html"));
                startActivity(intent);
            }
        });

        final Button gpsButton = findViewById(R.id.gpsButton);
        gpsButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://mygpslifeplan.org/"));
                startActivity(intent);
            }
        });

        final Button exploreButton = findViewById(R.id.exploreButton);
        exploreButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bls.gov/k12/content/students/careers/career-exploration.htm"));
                startActivity(intent);
            }
        });

        final Button adviceButton = findViewById(R.id.adviceButton);
        adviceButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.monster.com/career-advice/article/best-free-career-assessment-tools"));
                startActivity(intent);
            }
        });

        final Button top30Button = findViewById(R.id.top30Button);
        top30Button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.onlinecollegeplan.com/vocational-school-highest-paying-careers/"));
                startActivity(intent);
            }
        });

        final Button handbookButton = findViewById(R.id.handbookButton);
        handbookButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.bls.gov/ooh/"));
                startActivity(intent);
            }
        });

        final Button payButton = findViewById(R.id.payButton);
        payButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.trade-schools.net/articles/highest-paying-jobs-without-degree.asp"));
                startActivity(intent);
            }
        });

        final Button high43Button = findViewById(R.id.high43Button);
        high43Button.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.trade-schools.net/articles/trade-school-jobs.asp "));
                startActivity(intent);
            }
        });

        final Button americaButton = findViewById(R.id.americaButton);
        americaButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.trade-schools.net/articles/trade-school-jobs.asp"));
                startActivity(intent);
            }
        });

        final Button blueButton = findViewById(R.id.blueButton);
        blueButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.gcflearnfree.org/careers-without-college/is-a-bluecollar-career-right-for-you/1/"));
                startActivity(intent);
            }
        });


    }

}
