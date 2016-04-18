package com.redrock.liye.mytext.ui.About;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.redrock.liye.mytext.R;

/**
 * Created by a on 2016/4/17.
 */
public class AboutActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().hide();
        textView = (TextView)findViewById(R.id.text_about);

    }
}
