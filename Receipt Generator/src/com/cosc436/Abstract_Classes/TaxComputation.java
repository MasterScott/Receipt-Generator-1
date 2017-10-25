package com.cosc436.Abstract_Classes;

import com.cosc436.Items_And_Receipts.PurchasedItems;

import java.util.Calendar;


public abstract class TaxComputation {
    public abstract double computeTax(PurchasedItems items, Calendar date);

    protected abstract boolean taxHoliday(Calendar date);
}
