package com.example.alki.comproyvendo;

public class Product {

    private int id;
    private String name;
    private int price;

    public Product()
    {
    }

    public Product(int id,String name,int price)
    {
        this.id=id;
        this.name=name;
        this.price= price;
    }

    public Product(String name,int price)
    {
        this.name=name;
        this.price=price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(int price) {
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}