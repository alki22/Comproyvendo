package com.example.alki.comproyvendo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class EarningData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        Earnings earnings = getEarnings();
        // Gets access to the TextViews where the data will be.
        TextView totalEarnings = (TextView) findViewById(R.id.totalEarnings);
        TextView averageEarnings = (TextView)findViewById(R.id.averageEarnings);
        TextView averagePercentage = (TextView)findViewById(R.id.averagePercentage);
        // Sets the strings to display the data.
        String totalString = "$" + Float.toString(earnings.getTotal());
        String averageString = "$" + Float.toString(earnings.getAverage());
        String percentageString = Float.toString(earnings.getPercentage()) + "%";
        // Inserts the strings into the TextViews.
        totalEarnings.setText(totalString);
        averageEarnings.setText(averageString);
        averagePercentage.setText(percentageString);

    }

    public Earnings getEarnings(){
        // Gets access to the database.
        DBHandler db = new DBHandler(this);
        // If database is empty, then return 0 for every data. Used to avoid NaNs.
        if (db.getProductsCount() == 0)
            return new Earnings(0,0,0);
        // Makes a list with all the products.
        List<Product> products = db.getAllProducts();

        float total, average, percentage;
        int numberOfProducts;
        total = percentage = 0;
        numberOfProducts = db.getProductsCount();
        // Calculates total earnings, average earnings and average earning percentage.
        for (Product product : products) {
            total += ((float)product.getSellPrice() - (float)product.getBuyPrice())
                    * (float)product.getQuantity();
            percentage += ((((float)product.getSellPrice() / (float)product.getBuyPrice()) - 1)
                    * 100);
            numberOfProducts += (product.getQuantity() - 1);
        }
        average = total / (float) numberOfProducts;
        percentage = percentage / (float) numberOfProducts;
        // Creates a new Earnings object.
        Earnings earnings = new Earnings(total, average, percentage);
        return earnings;
    }
}



