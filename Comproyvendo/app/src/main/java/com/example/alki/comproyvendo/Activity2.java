package com.example.alki.comproyvendo;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Context;

public class Activity2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        DBHandler db = new DBHandler(this);
        db.getReadableDatabase();

        displayListView();
    }

    private void displayListView() {

        DBHandler db = new DBHandler(this);

        Cursor cursor = db.fetchAllProducts();

        // The desired columns to be bound
        String[] columns = new String[]{
                DBHandler.KEY_ID,
                DBHandler.KEY_NAME,
                DBHandler.KEY_SELLPRICE,
                DBHandler.KEY_QUANTITY
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[]{
                R.id.id,
                R.id.name,
                R.id.sellPrice,
                R.id.quantity
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information

        SimpleCursorAdapter dataAdapter;
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.product_info,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
    }
}