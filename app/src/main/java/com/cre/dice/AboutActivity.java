package com.cre.dice;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView AboutTitle=(TextView)findViewById(R.id.about_title);
        AboutTitle.setText(AboutTitle.getText().toString()+" "+BuildConfig.VERSION_NAME);
    }
}
