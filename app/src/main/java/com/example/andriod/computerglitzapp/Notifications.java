package com.example.andriod.computerglitzapp;

import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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

        final DatePicker mDatePicker = (DatePicker) findViewById(R.id.datePicker);
        final Intent intent = new Intent(this, AlarmReciver.class); //set title and text
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        final Button dateButton = findViewById(R.id.dayButton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int day = mDatePicker.getDayOfMonth();
                int month = mDatePicker.getMonth() + 1;
                int year = mDatePicker.getYear();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                intent.putExtra("text", calendar.getTimeInMillis()); //this
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

                Toast.makeText(Notifications.this, "" + mDatePicker,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //  mDatePicker.setOnDateChangedListener();

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //trigger this for alarm when set
    }

}
