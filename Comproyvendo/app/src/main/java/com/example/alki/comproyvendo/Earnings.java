package com.example.alki.comproyvendo;

public class Earnings {
    private float total;
    private float average;
    private float percentage;

    public Earnings(float total, float average, float percentage){
        this.total = total;
        this.average = average;
        this.percentage = percentage;
    }
    public float getTotal() {
        return total;
    }

    public float getAverage() { return average; }

    public float getPercentage() { return percentage; }
}
