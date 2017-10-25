package com.cosc436.Add_On_Classes;

import com.cosc436.Items_And_Receipts.PurchasedItems;
import com.cosc436.Interfaces.AddOn;
import com.cosc436.Interfaces.Coupon;

public class Coupon100Get10Percent implements AddOn, Coupon { //done
    public boolean applies(PurchasedItems items) {
        return items.getTotalCost() >= 100;

    }

    public String getLines() {
        return "You Spent $100! Enjoy your 10 Percent Off!";
    }
}
