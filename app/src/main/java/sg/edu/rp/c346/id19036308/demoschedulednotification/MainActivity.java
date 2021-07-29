package sg.edu.rp.c346.id19036308.demoschedulednotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    int reqCode = 12345;
    Button btnSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSchedule = findViewById(R.id.btnSchedule);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //launch notification here
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 5);
                Intent i = new Intent(MainActivity.this, ScheduledNotificationReceiver.class);
                PendingIntent pIntent = PendingIntent.getBroadcast(MainActivity.this, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pIntent);
            }
        });
    }
}