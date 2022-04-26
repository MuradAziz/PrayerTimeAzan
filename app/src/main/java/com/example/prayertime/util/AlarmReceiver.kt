package com.example.prayertime.util

import android.app.Notification
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.prayertime.R


class AlarmReceiver: BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {

            val i= Intent(p0,DestActivity::class.java)
            p1!!.flags= Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            val pending= PendingIntent.getActivity(p0, 0, i, 0)

            val builder= NotificationCompat.Builder(p0!!,"azanandroid")
                .setSmallIcon(R.drawable.bellicon)
                .setContentTitle("Azanandroid")
                .setContentText("Azan vaxtı")
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(Notification.PRIORITY_HIGH)
                .setContentIntent(pending)

            val notificationManager= NotificationManagerCompat.from(p0)
            notificationManager.notify(123, builder.build() )

        }
    }
