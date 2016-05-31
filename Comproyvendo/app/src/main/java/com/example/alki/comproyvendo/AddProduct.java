package com.example.alki.comproyvendo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;



public class AddProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);
    }

    public int putIfNum(EditText field) {
        // Checks if the input is a number, if not sends a toast.
        try {
            int entry = Integer.parseInt(field.getText().toString());
            return entry;
        } catch (NumberFormatException e) {
            Context context = getApplicationContext();
            String toastText = field.getHint().toString() + " no es un número";
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
            return -1;
        }
    }

    public String putIfNotEmpty(EditText field) {
        // Shows a toast if the name field is empty.
        String word = field.getText().toString();
        if (word.length() == 0) {
            Context context = getApplicationContext();
            String toastText = "El nombre está vacío";
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
        }
        return word;
    }

    public void addProduct(View view) {
        // Gets the activity's EditText fields.
        EditText nameField = (EditText)findViewById(R.id.name);
        EditText buyPriceField = (EditText)findViewById(R.id.buyPrice);
        EditText sellPriceField = (EditText)findViewById(R.id.sellPrice);
        EditText quantityField = (EditText)findViewById(R.id.quantity);
        // Gets values from EditText fields, showing a toast if any of them is wrong.
        String name = putIfNotEmpty(nameField);
        int buyPrice = putIfNum(buyPriceField);
        int sellPrice = putIfNum(sellPriceField);
        int quantity = putIfNum(quantityField);
        // Ends execution if any parameter is wrong.
        if(name.length() == 0 || buyPrice == -1 || sellPrice == -1 || quantity == -1)
            return;
        // Gets access to the database.
        DBHandler db = new DBHandler(this);
        // Creates a new product
        Product product = new Product(db.getProductsCount()+1, name, buyPrice, sellPrice, quantity);
        // Adds the product to the db.
        db.addProduct(product);
        // Ends the activity.
        Toast.makeText(getApplicationContext(), "Producto agregado", Toast.LENGTH_SHORT);
        finish();
    }
}
