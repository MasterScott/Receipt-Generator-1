package com.cosc436.Add_On_Classes;

import com.cosc436.Items_And_Receipts.PurchasedItems;
import com.cosc436.Interfaces.AddOn;
import com.cosc436.Interfaces.SecondaryHeading;

public class HolidayGreeting implements AddOn, SecondaryHeading {
    public boolean applies(PurchasedItems items) {
        return true; // SecondaryHeading decorators always applied
    }

    public String getLines() {
        return "* Happy Holidays from Best Buy *";
    }
}
