package com.example.studente_portfolio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class RevClass extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, NotificationService.class);
        service1.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        context.startService(service1);
    }
}
