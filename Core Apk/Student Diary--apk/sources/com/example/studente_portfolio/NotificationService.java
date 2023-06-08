package com.example.studente_portfolio;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;

public class NotificationService extends IntentService {
    private static int NOTIFICATION_ID = 1;
    private NotificationManager notifManager;
    Notification notification;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;

    public NotificationService() {
        super("IntentService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        createNotification("You got event / Activities today, check it out!");
    }

    public void createNotification(String aMessage) {
        NotificationCompat.Builder builder;
        String str = aMessage;
        if (this.notifManager == null) {
            this.notifManager = (NotificationManager) getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.notifManager.getNotificationChannel("my_package_channel_1") == null) {
                NotificationChannel mChannel = new NotificationChannel("my_package_channel_1", "my_package_channel", 4);
                mChannel.setDescription("my_package_first_channel");
                mChannel.enableVibration(true);
                mChannel.setLightColor(-16711936);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                this.notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(this, "my_package_channel_1");
            Intent intent = new Intent(this, ScheduleActivity.class);
            intent.setFlags(603979776);
            PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 0, intent, 134217728);
            builder.setContentTitle(str).setSmallIcon(17301598).setContentText(getString(R.string.app_name)).setDefaults(-1).setAutoCancel(true).setContentIntent(pendingIntent2).setTicker(str).setWhen(System.currentTimeMillis()).setFullScreenIntent(pendingIntent2, true).setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        } else {
            builder = new NotificationCompat.Builder(this);
            Intent intent2 = new Intent(this, ScheduleActivity.class);
            intent2.setFlags(603979776);
            builder.setContentTitle(str).setSmallIcon(17301598).setContentText(getString(R.string.app_name)).setDefaults(-1).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 0, intent2, 134217728)).setTicker(str).setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400}).setPriority(1);
        }
        this.notifManager.notify(PointerIconCompat.TYPE_HAND, builder.build());
    }
}
