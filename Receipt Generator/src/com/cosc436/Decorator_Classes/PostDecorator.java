package com.cosc436.Decorator_Classes;

import com.cosc436.Abstract_Classes.Decorator;
import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Interfaces.AddOn;
import com.cosc436.Interfaces.Receipt;

import java.util.Calendar;

public class PostDecorator extends Decorator {

    private AddOn a;

    public PostDecorator(AddOn a, Receipt r) {
        super(r);
        this.a = a;
    }

    public void prtReceipt() {
        callTrailer();
        System.out.println(a.getLines());
    }

    @Override
    public void setDate(Calendar date) {

    }

    @Override
    public void setTaxComputation(TaxComputation taxComputationsObj) {

    }
}