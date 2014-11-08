package com.garufa.activitytracker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jason on 11/8/2014.
 */
public class QuoteScreen extends Activity {

    private TextView    textView_quote;
    private Button      button_close;

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


//        Resources res = getResources();
//        String[] q = res.getStringArray(R.array.quote_array);
    }

//    public void onCloseButtonClick(View view) {
//        finish();
//    }
}
