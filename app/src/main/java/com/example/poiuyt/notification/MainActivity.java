package com.example.poiuyt.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText in_time, edtTittle, edtText;
    long[] pattern = {500, 1000, 1000, 500,100,500,100,500};
    Button btnOk;
    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in_time = (EditText) findViewById(R.id.in_time);
        edtText = (EditText) findViewById(R.id.edtText);
        edtTittle = (EditText) findViewById(R.id.edtTitle);
        btnOk = (Button) findViewById(R.id.btn_run);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Thread.sleep(Integer.parseInt(in_time.getText().toString())*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Notification noti = new Notification.Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.stat_sys_warning)
                        .setContentText(edtText.getText().toString())
                        .setVibrate(pattern)
                        .setSound(alarmSound)
                        .setContentTitle(edtTittle.getText().toString()).build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, noti);

            }
        });

    }
}
