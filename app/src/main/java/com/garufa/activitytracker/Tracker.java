package com.garufa.activitytracker;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tracker extends Activity {

    // Create keys to save state when Android decides to kill your activity
    private static final String CREATE_KEY = "create";

    // String for LogCat documentation
    private final static String TAG = "Activity Tracker";

    // Variables for lifecycle tracking
    private int create = 0, start = 0, restart = 0, resume = 0, pause = 0, stop = 0, destroy = 0;

    private Button quoteButton;
    private TextView textView_create, textView_start, textView_restart, textView_resume,
                     textView_pause, textView_stop, textView_destroy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        quoteButton = (Button) findViewById(R.id.quote_button);

        textView_create = (TextView) findViewById(R.id.textView_create_value);
        textView_destroy = (TextView) findViewById(R.id.textView_destroy_value);
        textView_pause = (TextView) findViewById(R.id.textView_pause_value);
        textView_restart = (TextView) findViewById(R.id.textView_restart_value);
        textView_resume = (TextView) findViewById(R.id.textView_resume_value);
        textView_start = (TextView) findViewById(R.id.textView_start_value);
        textView_stop = (TextView) findViewById(R.id.textView_stop_value);
        textView_stop = (TextView) findViewById(R.id.textView_stop_value);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tracker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onQuoteButtonClick(View view) {
    }
}
