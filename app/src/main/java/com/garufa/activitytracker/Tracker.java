package com.garufa.activitytracker;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tracker extends Activity {

    // Create keys to save state when Android decides to kill your activity
    private static final String CREATE_KEY = "create", START_KEY = "start", RESTART_KEY = "restart",
                                RESUME_KEY = "resume", PAUSE_KEY = "pause", STOP_KEY = "stop",
                                DESTROY_KEY = "destroy";


    // String for LogCat documentation
    private final static String TAG = "Activity Tracker";

    // Variables for lifecycle tracking
    private int create_value = 0, start_value = 0, restart_value = 0, resume_value = 0,
                pause_value = 0, stop_value = 0, destroy_value = 0;

    private Button      quoteButton;
    private TextView    textView_create, textView_start, textView_restart, textView_resume,
                        textView_pause, textView_stop, textView_destroy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        if (savedInstanceState != null){
            create_value    = savedInstanceState.getInt(CREATE_KEY);
            start_value     = savedInstanceState.getInt(START_KEY);
            restart_value   = savedInstanceState.getInt(RESTART_KEY);
            resume_value    = savedInstanceState.getInt(RESUME_KEY);
            pause_value     = savedInstanceState.getInt(PAUSE_KEY);
            stop_value      = savedInstanceState.getInt(STOP_KEY);
            destroy_value   = savedInstanceState.getInt(DESTROY_KEY);
            Log.i(TAG, "State restored");
        } else {
            Log.i(TAG, "Unable to find previous state...");
        }


        quoteButton         = (Button)   findViewById(R.id.quote_button);
        textView_create     = (TextView) findViewById(R.id.textView_create_value);
        textView_destroy    = (TextView) findViewById(R.id.textView_destroy_value);
        textView_pause      = (TextView) findViewById(R.id.textView_pause_value);
        textView_restart    = (TextView) findViewById(R.id.textView_restart_value);
        textView_resume     = (TextView) findViewById(R.id.textView_resume_value);
        textView_start      = (TextView) findViewById(R.id.textView_start_value);
        textView_stop       = (TextView) findViewById(R.id.textView_stop_value);

        quoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quoteScreenIntent = new Intent(Tracker.this, QuoteScreen.class);
                startActivity(quoteScreenIntent);
            }
        });


        Log.i(TAG, "Entered the onCreate() method");
        create_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CREATE_KEY,     create_value    );
        outState.putInt(DESTROY_KEY,    destroy_value   );
        outState.putInt(PAUSE_KEY,      pause_value     );
        outState.putInt(RESTART_KEY,    restart_value   );
        outState.putInt(RESUME_KEY,     resume_value    );
        outState.putInt(START_KEY,      start_value     );
        outState.putInt(STOP_KEY,       stop_value      );
        Log.i(TAG, "Saving instance");
        super.onSaveInstanceState(outState);
    }

    public void displayLifeCycleCounts() {
        textView_create.setText(String.valueOf(create_value));
        textView_restart.setText(String.valueOf(restart_value));
        textView_pause.setText(String.valueOf(pause_value));
        textView_stop.setText(String.valueOf(stop_value));
        textView_start.setText(String.valueOf(start_value));
        textView_resume.setText(String.valueOf(resume_value));
        textView_destroy.setText(String.valueOf(destroy_value));
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

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered the onRestart() method");
        restart_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered the onStart() method");
        start_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered the onResume() method");
        resume_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered the onPause() method");
        pause_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered the onStop() method");
        stop_value++;
        displayLifeCycleCounts();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Entered the onDestroy() method");
        destroy_value++;
        displayLifeCycleCounts();
        super.onDestroy();
    }
}
