package com.cosc436.Items_And_Receipts;

import java.util.ArrayList;

public class PurchasedItems {
    private ArrayList<StoreItem> items;

    public PurchasedItems() {
        items = new ArrayList();
    }

    public void addItem(StoreItem item) { //done
        items.add(item);
    }

    public double getTotalCost() { //done
        double total = 0.0;
        for (StoreItem object : items) {
            total += object.getItemPrice();
        }
        return total;
    }

    public boolean containsItem(int itemCode) {
        for (StoreItem object : items) {
            if (itemCode == object.getItemCode()) {
                return true;
            }
        }
        return false;
    }

    public void printItems() {
        for (StoreItem s : items) {
            System.out.println(s.getItemDescription() + "...........$" + s.getItemPrice());
        }
    }
}
