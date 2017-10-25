package com.cosc436.Interfaces;

import com.cosc436.Abstract_Classes.TaxComputation;

import java.util.Calendar;

public interface Receipt {
    void prtReceipt();

    void setDate(Calendar date);

    void setTaxComputation(TaxComputation taxComputationsObj);
}
