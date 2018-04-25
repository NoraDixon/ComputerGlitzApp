package com.example.andriod.computerglitzapp;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.opencsv.stream.reader.LineReader;

import java.util.Calendar;

import static android.widget.Toast.LENGTH_LONG;

public class Notifications extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(Notifications.this, MainActivity.class));
                    return true;
                case R.id.navigation_checkmark:
                    startActivity(new Intent(Notifications.this, Checklist.class));
                    return true;
                case R.id.navigation_search:
                    startActivity(new Intent(Notifications.this, CollegeListActivity.class));
                    return true;

                case R.id.navigation_favorites:
                    startActivity(new Intent(Notifications.this, Favorites.class));
                    return true;

            }
            return false;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        final MNCollege mnCollege = (MNCollege)getIntent().getSerializableExtra("CollegeSelected");

        final LinearLayout mLayout = (LinearLayout) findViewById(R.id.layout);
       // final EditText mEditText = (EditText) findViewById(R.id.bodyText);
        final Button mDateButton = (Button) findViewById(R.id.dayButton);
        final Button mTimeButton = (Button) findViewById(R.id.timeButton);
        final Button mTextButton = (Button) findViewById(R.id.textButton);
        final TimePicker mTimePicker = (TimePicker) findViewById(R.id.timePicker);
        final DatePicker mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        final Button dateButton = findViewById(R.id.dayButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int day = mDatePicker.getDayOfMonth();
                int month = mDatePicker.getMonth() + 1;
                int year = mDatePicker.getYear();

                mDateButton.setVisibility(View.GONE);
                mDatePicker.setVisibility(View.GONE);
                mTimeButton.setVisibility(View.VISIBLE);
                mTimePicker.setVisibility(View.VISIBLE);
            }
        });
        mTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTimeButton.setVisibility(View.GONE);
                mTimePicker.setVisibility(View.GONE);
                mTextButton.setVisibility(View.VISIBLE);
                mLayout.setVisibility(View.VISIBLE);
            }
        });
        mTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText mEditText = (EditText) findViewById(R.id.bodyText);
                int hour = mTimePicker.getHour();
                int minute = mTimePicker.getMinute();

                int day = mDatePicker.getDayOfMonth();
                int month = mDatePicker.getMonth();
                int year = mDatePicker.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day, hour, minute);

                long test = calendar.getTimeInMillis();
                Intent intent = new Intent("Action", Uri.parse(mEditText.getText().toString()),getApplicationContext(), AlarmReciver.class); //set title and text
                intent.putExtra("text", mEditText.getText().toString()); //this
                //intent.putExtra("text", "Text"); //this

                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
                long timeToPassIn = calendar.getTimeInMillis();
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeToPassIn, pendingIntent);
                final Intent collegeView = new Intent(Notifications.this, SchoolInfo.class);
                collegeView.putExtra("CollegeSelected", mnCollege);
                startActivity(collegeView);

            }
        });


        //  mDatePicker.setOnDateChangedListener();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //trigger this for alarm when set
    }

}
