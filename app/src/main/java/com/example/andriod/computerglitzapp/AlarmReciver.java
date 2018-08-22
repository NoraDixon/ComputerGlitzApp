package com.example.andriod.computerglitzapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
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

        // Register the channel with the system
        String test = intent.getStringExtra("text");
        if(intent.getData() != null) {
            test = intent.getData().getSchemeSpecificPart();
        }
        if (Build.VERSION.SDK_INT > 25) {
            NotificationChannel channel = new NotificationChannel("Channel", name, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
        Notification.Builder builder = new Notification.Builder(context)
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp)
                .setContentTitle("Hands On") //title
                .setContentText(intent.getStringExtra("text")) //text
                .setPriority(Notification.PRIORITY_DEFAULT);
        notificationManager.notify(0,builder.build());


    }
}
