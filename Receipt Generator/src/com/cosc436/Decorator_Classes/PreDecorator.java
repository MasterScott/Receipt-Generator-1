package com.cosc436.Decorator_Classes;

import com.cosc436.Abstract_Classes.Decorator;
import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Interfaces.AddOn;
import com.cosc436.Interfaces.Receipt;

import java.util.Calendar;

public class PreDecorator extends Decorator {
    private AddOn a;

    public PreDecorator(AddOn a, Receipt r) {
        super(r);
        this.a = a;
    }

    public void prtReceipt() {
        System.out.println(a.getLines());
        callTrailer();
    }

    @Override
    public void setDate(Calendar date) {

    }

    @Override
    public void setTaxComputation(TaxComputation taxComputationsObj) {

    }
}

