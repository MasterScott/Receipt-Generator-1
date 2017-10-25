package com.cosc436.Tax_Classes;

import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Items_And_Receipts.PurchasedItems;

import java.util.Calendar;

public class MDTaxComputation extends TaxComputation {
    private final static double tax = .06;

    public double computeTax(PurchasedItems items, Calendar date) {
        if (!taxHoliday(date)) {
            return (tax * items.getTotalCost());
        }
        return 0;
    }

    protected boolean taxHoliday(Calendar date) {
        return false;
    }

}