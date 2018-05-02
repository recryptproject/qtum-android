package org.recrypt.wallet.dataprovider.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.recrypt.wallet.RecryptApplication;
import org.recrypt.wallet.R;
import org.recrypt.wallet.ui.activity.main_activity.MainActivity;
import org.recrypt.wallet.utils.RecryptIntent;

public class RecryptFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (RecryptApplication.instance == null) {
            sendNotification("", "RECRYPT", remoteMessage.getNotification().getBody());
        }
    }

    private void sendNotification(String Ticker, String Title, String Text) {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(RecryptIntent.OPEN_FROM_NOTIFICATION);
        PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setTicker(Ticker)
                .setContentTitle(Title)
                .setContentText(Text)
                .setWhen(System.currentTimeMillis());

        if (android.os.Build.VERSION.SDK_INT <= 21) {
            builder.setSmallIcon(R.mipmap.ic_launcher);
        } else {
            builder.setSmallIcon(org.recrypt.wallet.R.drawable.logo);
        }
        Notification notification = builder.build();

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(108, notification);
    }
}
