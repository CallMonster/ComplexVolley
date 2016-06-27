package com.restaurant.chaersi.complexvolley.act;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.restaurant.chaersi.complexvolley.R;

import butterknife.ButterKnife;

public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        ButterKnife.bind(this);
    }
}
