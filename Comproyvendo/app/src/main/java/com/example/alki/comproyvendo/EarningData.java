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

        TextView totalEarnings = (TextView) findViewById(R.id.totalEarnings);
        TextView averageEarnings = (TextView)findViewById(R.id.averageEarnings);
        TextView averagePercentage = (TextView)findViewById(R.id.averagePercentage);

        String totalString = "$" + Float.toString(earnings.getTotal());
        String averageString = "$" + Float.toString(earnings.getAverage());
        String percentageString = Float.toString(earnings.getPercentage()) + "%";

        totalEarnings.append(totalString);
        averageEarnings.append(averageString);
        averagePercentage.append(percentageString);

    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();

    }

    public Earnings getEarnings(){

        DBHandler db = new DBHandler(this);

        if (db.getProductsCount() == 0)
            return new Earnings(0,0,0);

        List<Product> products = db.getAllProducts();

        float total, average, percentage;
        int numberOfProducts;
        total = percentage = 0;
        numberOfProducts = db.getProductsCount();

        for (Product product : products) {
            total += ((float)product.getSellPrice() - (float)product.getBuyPrice())
                    * (float)product.getQuantity();
            percentage += ((((float)product.getSellPrice() / (float)product.getBuyPrice()) - 1)
                    * 100);
            numberOfProducts += (product.getQuantity() - 1);
        }

        average = total / (float) numberOfProducts;
        percentage = percentage / (float) numberOfProducts;

        Earnings earnings = new Earnings(total, average, percentage);
        return earnings;
    }
}



