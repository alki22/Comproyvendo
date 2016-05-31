package com.example.alki.comproyvendo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // Opens activity for button1
    public void openActivityOne(View view) {
        int viewId = view.getId();
        Intent intent = new Intent(this, AddProduct.class);
        startActivity(intent);
    }
    // Opens activity for button2
    public void openActivityTwo(View view) {
        int viewId = view.getId();
        Intent intent = new Intent(this, ProductList.class);
        startActivity(intent);
    }
    // Opens activity for button3
    public void openActivityThree(View view) {
        int viewId = view.getId();
        Intent intent = new Intent(this, EarningData.class);
        startActivity(intent);
    }
}