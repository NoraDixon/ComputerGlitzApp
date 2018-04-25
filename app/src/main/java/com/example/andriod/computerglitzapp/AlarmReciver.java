package com.example.andriod.computerglitzapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import java.nio.channels.Channel;


/**
 * Created by norad on 4/22/2018.
 */

public class AlarmReciver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        CharSequence name = "Channel";
        String description = "ChannelDescription";
        int importance = NotificationManagerCompat.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel("Channel", name, NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription(description);
        // Register the channel with the system
        String test = intent.getStringExtra("text");
        if(intent.getData() != null) {
            test = intent.getData().getSchemeSpecificPart();
        }
        notificationManager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "Channel")
                .setSmallIcon(R.drawable.ic_home_black_24dp)
                .setContentTitle("Hands On") //title
                .setContentText(intent.getStringExtra("text")) //text
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        notificationManager.notify(0,builder.build());


    }
}
