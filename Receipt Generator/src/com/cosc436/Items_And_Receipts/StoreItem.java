package com.cosc436.Items_And_Receipts;

public class StoreItem {
    private int itemCode;
    private String itemDescription;
    private double itemPrice;

    public StoreItem(int itemCode, String itemDescription, double itemPrice) {
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public int getItemCode() {
        return itemCode;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
