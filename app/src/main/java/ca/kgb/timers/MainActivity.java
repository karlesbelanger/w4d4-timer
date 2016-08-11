package ca.kgb.timers;

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
}
