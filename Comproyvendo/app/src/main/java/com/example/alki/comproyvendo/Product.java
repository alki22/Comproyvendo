package com.example.alki.comproyvendo;

public class Product {

    private int id;
    private String name;
    private int buyPrice;
    private int sellPrice;
    private int quantity;

    public Product()
    {
    }

    public Product(int id, String name,int buyPrice, int sellPrice, int quantity)
    {
        this.id=id;
        this.name=name;
        this.buyPrice=buyPrice;
        this.sellPrice=sellPrice;
        this.quantity=quantity;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBuyPrice(int buyPrice) { this.buyPrice = buyPrice; }

    public void setSellPrice(int sellPrice) { this.sellPrice = sellPrice; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public int getId() {return id; }

    public String getName() {
        return name;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() { return sellPrice; }

    public int getQuantity() { return quantity; }

}