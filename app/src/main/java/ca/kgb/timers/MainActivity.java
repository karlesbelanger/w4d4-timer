package ca.kgb.timers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar)findViewById(R.id.a_main_progress_bar);
    }

    public void DoMagic(View view) {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public int counter = 0;
            TextView textView = (TextView)findViewById(R.id.number);
            @Override
            public void run() {
                //Log.d(TAG, "run: " + Thread.currentThread());
               // mProgressBar.setVisibility(View.INVISIBLE);
                handler.postDelayed(this, 1000);
                counter++;
                textView.setText(counter + "/" + 100);
                mProgressBar.setProgress(counter);
            }
        }, 1000);
    }

    public void doAlarm(View view) {
        Intent intent  = new Intent(this, MyService.class);

        PendingIntent pendingIntent = PendingIntent.getService(this, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis(),
                5000,
                pendingIntent);
    }
}
