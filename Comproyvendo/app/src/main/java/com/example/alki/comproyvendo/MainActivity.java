package com.example.alki.comproyvendo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openActivityOne(View view) {
        int viewId = view.getId();
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }

    public void openActivityThree(View view) {
        int viewId = view.getId();
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}