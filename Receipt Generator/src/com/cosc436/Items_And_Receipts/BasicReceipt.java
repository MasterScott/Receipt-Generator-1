package com.cosc436.Items_And_Receipts;

import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Interfaces.Receipt;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasicReceipt implements Receipt {
    private String header; // store number, store address, phone number
    private String stateCode; // MD, CA or MA
    private PurchasedItems items;
    private Calendar date;
    private TaxComputation tc;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public BasicReceipt(String header, String stateCode, PurchasedItems items) {
        this.header = header;
        this.stateCode = stateCode;
        this.items = items;
    }

    public void setTaxComputation(TaxComputation tc) {
        this.tc = tc;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void prtReceipt() { // done
        double subTotal = items.getTotalCost();
        double tax = tc.computeTax(items, date);
        double total = subTotal + tax;


        System.out.println(header);
        System.out.println("Date: " + sdf.format(date.getTime()));
        items.printItems();
        System.out.println("Sub Total...........$" + subTotal);
        System.out.println("Tax[" + stateCode + "]...........$" + tax);
        System.out.println("Total...........$" + total);
    }
}