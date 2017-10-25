package com.cosc436.Interfaces;

import com.cosc436.Items_And_Receipts.PurchasedItems;

public interface AddOn {
    boolean applies(PurchasedItems items);

    String getLines();
}
