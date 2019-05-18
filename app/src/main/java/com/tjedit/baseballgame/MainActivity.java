package com.tjedit.baseballgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         bindViews();
         setupEvents();
         setupValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setupValues() {

    }

    @Override
    public void bindViews() {
        setContentView(R.layout.activity_main);
    }
}
