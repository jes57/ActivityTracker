package com.garufa.activitytracker;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Jason on 11/8/2014.
 */
public class QuoteScreen extends Activity {

    private TextView    textView_quote;
    private Button      button_close;

    private int rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.quote_layout);

        textView_quote  = (TextView)    findViewById(R.id.textView_quote);
        button_close    = (Button)      findViewById(R.id.button_close);

        button_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Resources res = getResources();
        String[] quotes = res.getStringArray(R.array.quote_array);

        Random random = new Random();
        rand = random.nextInt(4);
        Log.i("Quote Screen", "random = " + rand);
        textView_quote.setText(quotes[rand]);


    }

//    public void onCloseButtonClick(View view) {
//        finish();
//    }
}
