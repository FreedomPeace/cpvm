package com.example.mvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp.data.local.LogInfoLocalModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogFragment  fragment= new LogFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment)
                .commit();
        LogPresent logPresent = new LogPresent(
                new LogInfoLocalModel(this),
                fragment
        );
        fragment.setPresent(logPresent);
    }
}
