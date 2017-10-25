package com.cosc436.Tax_Classes;

import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Items_And_Receipts.PurchasedItems;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MATaxComputation extends TaxComputation {
    private final static double tax = .0625;

    public double computeTax(PurchasedItems items, Calendar date) { // done
        if (!taxHoliday(date)) {
            return (tax * items.getTotalCost());
        }
        return 0;
    }

    // 08/13 - 08/14
    protected boolean taxHoliday(Calendar date) { // done
        Calendar taxHoliday1 = new GregorianCalendar(2016, 7, 13);
        Calendar taxHoliday2 = new GregorianCalendar(2016, 7, 14);

        return date.compareTo(taxHoliday1) == 0 || date.compareTo(taxHoliday2) == 0;
    }

}