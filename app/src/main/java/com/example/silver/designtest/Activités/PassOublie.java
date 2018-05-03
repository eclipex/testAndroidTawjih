package com.example.silver.designtest.Activités;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.silver.designtest.R;

public class PassOublie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_oublie);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}
