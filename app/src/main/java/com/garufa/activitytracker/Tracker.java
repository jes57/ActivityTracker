package com.garufa.activitytracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Tracker extends Activity {
    private Button answerYesButton, answerNoButton;
    private EditText usersNameEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        answerYesButton = (Button) findViewById(R.id.answer_yes_button);
        answerNoButton = (Button) findViewById(R.id.answer_no_button);
        usersNameEditText = (EditText) findViewById(R.id.users_name_edit_text);

//        final TextView firstTextView = (TextView) findViewById(R.id.textView);
//
//        Button firstButton = (Button) findViewById(R.id.button);
//
//        firstButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                firstTextView.setText("You clicked!");
//            }
//        });
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

    public void onYesButtonClick(View view) {

        String usersName = String.valueOf(usersNameEditText.getText());

        String yourYesResponse = "That is great " + usersName;

        Toast.makeText(this, yourYesResponse, Toast.LENGTH_SHORT).show();

    }
    public void onNoButtonClick(View view) {

        String usersName = String.valueOf(usersNameEditText.getText());

        String yourNoResponse = "That is awful " + usersName;

        Toast.makeText(this, yourNoResponse, Toast.LENGTH_LONG).show();
    }

}
