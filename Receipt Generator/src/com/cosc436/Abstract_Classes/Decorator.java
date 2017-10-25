package com.cosc436.Abstract_Classes;

import com.cosc436.Interfaces.Receipt;

public abstract class Decorator implements Receipt {
    private Receipt trailer;

    protected Decorator(Receipt r) {
        trailer = r;
    }

    protected void callTrailer() {
        trailer.prtReceipt();
    }

    public abstract void prtReceipt();
}
