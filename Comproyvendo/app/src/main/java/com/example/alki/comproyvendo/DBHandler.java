package com.example.alki.comproyvendo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version.
    private static final int DATABASE_VERSION = 3;
    // Database Name.
    private static final String DATABASE_NAME = "ProductsINFO";
    // Products table name.
    private static final String TABLE_PRODUCTS = "products";
    // Products Table Columns names.
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_BUYPRICE ="buyPrice";
    public static final String KEY_SELLPRICE ="sellPrice";
    public static final String KEY_QUANTITY = "quantity";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY ," + KEY_NAME + " TEXT,"
                + KEY_BUYPRICE + " INTEGER," + KEY_SELLPRICE + " INTEGER,"
                + KEY_QUANTITY + " INTEGER" + ");";
        db.execSQL(CREATE_PRODUCTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
// Creating tables again.
        onCreate(db);
    }
    // Adding new product.
    public void addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName()); // Product's Name.
        values.put((KEY_BUYPRICE), String.valueOf(product.getBuyPrice())); // Product's buy price.
        values.put(KEY_SELLPRICE, String.valueOf(product.getSellPrice())); // Product's sell price.
        values.put(KEY_QUANTITY, String.valueOf(product.getQuantity()));

        // Inserting Row.
        db.insert(TABLE_PRODUCTS, null, values);
        // Closing database connection.
        db.close();
    }
    // Getting one product.
    public Product getProduct(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PRODUCTS, new String[]{KEY_ID,
                        KEY_NAME, KEY_BUYPRICE, KEY_SELLPRICE, KEY_QUANTITY}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Product product = new Product(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)), Integer.parseInt(cursor.getString(4)));
        cursor.close();
        // return product.
        return product;
    }
    // Getting All products.
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<Product>();
        // Select All Query.
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list.
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(Integer.parseInt(cursor.getString(0)));
                product.setName(cursor.getString(1));
                product.setBuyPrice(cursor.getInt(2));
                product.setSellPrice(cursor.getInt(3));
                product.setQuantity(cursor.getInt(4));
                // Adding product to list.
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // return product list.
        return productList;
    }
    // Getting products Count.
    public int getProductsCount() {
        String countQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        // closing cursor.
        cursor.close();
        // return count.
        return count;
    }
    // Updating a product
    public int updateProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(String.valueOf(KEY_BUYPRICE), product.getBuyPrice());
        values.put(String.valueOf(KEY_SELLPRICE), product.getSellPrice());
        values.put(String.valueOf(KEY_QUANTITY), product.getQuantity());

    // updating row.
        return db.update(TABLE_PRODUCTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
    }

    // Deleting a product.
    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE_PRODUCTS, KEY_ID +  "=" + id, null);
    }

    public Cursor fetchAllProducts() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor mCursor = db.query(TABLE_PRODUCTS, new String[] {KEY_ID,
                        KEY_NAME, KEY_BUYPRICE, KEY_SELLPRICE, KEY_QUANTITY},
                null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
}