package com.example.alki.comproyvendo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addProduct(new Product("Comics", 200));
        db.addProduct(new Product("Donuts", 150));
        db.addProduct(new Product("Pizza", 456));
        db.addProduct(new Product("Rolls Royce", 240000));

        // Reading all shops
        Log.d("Reading: ", "Reading all products..");
        List<Product> products = db.getAllProducts();

        for (Product product : products) {
            String log = "Id: " + product.getId() + " ,Name: " + product.getName() + " ,Address: "
                    + product.getPrice();
            // Writing shops  to log
            Log.d("Product: : ", log);
        }
    }

    public void openActivity(View view) {
        int viewId = view.getId();
        Intent intent = null;
        String button = getResources().getResourceEntryName(viewId);
        switch (button) {
            case ("button1"):
                intent = new Intent(this, Activity1.class);
                startActivity(intent);
            case ("button2"):
                Log.d("Id:", "value: " + button);
            case ("button3"):
                Log.d("Id:", "value: " + button);
        }
    }
}