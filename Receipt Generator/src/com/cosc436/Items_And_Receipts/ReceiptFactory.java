package com.cosc436.Items_And_Receipts;

import com.cosc436.Abstract_Classes.TaxComputation;
import com.cosc436.Add_On_Classes.Coupon100Get10Percent;
import com.cosc436.Add_On_Classes.HolidayGreeting;
import com.cosc436.Add_On_Classes.Rebate1406;
import com.cosc436.Decorator_Classes.PostDecorator;
import com.cosc436.Decorator_Classes.PreDecorator;
import com.cosc436.Interfaces.*;
import com.cosc436.Tax_Classes.CATaxComputation;
import com.cosc436.Tax_Classes.MATaxComputation;
import com.cosc436.Tax_Classes.MDTaxComputation;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class ReceiptFactory {

    private String header;
    private String state_code;
    private TaxComputation[] taxComputationsObjs;
    private AddOn[] addOns;

    public ReceiptFactory() {

        TaxComputation CA = new CATaxComputation();
        TaxComputation MA = new MATaxComputation();
        TaxComputation MD = new MDTaxComputation();
        AddOn coupon100Get10Percent = new Coupon100Get10Percent();
        AddOn holidayGreeting = new HolidayGreeting();
        AddOn rebate1406 = new Rebate1406();
        taxComputationsObjs = new TaxComputation[]{CA, MA, MD};
        addOns = new AddOn[]{coupon100Get10Percent, holidayGreeting, rebate1406};

        readConfigFile();
    }

    public Receipt getReceipt(PurchasedItems items, Calendar date) {
        Receipt receipt = new BasicReceipt(header, state_code, items);

        receipt.setDate(date);

        switch (state_code) {
            case "CA":
                receipt.setTaxComputation(taxComputationsObjs[0]);
                break;
            case "MA":
                receipt.setTaxComputation(taxComputationsObjs[1]);
                break;
            case "MD":
                receipt.setTaxComputation(taxComputationsObjs[2]);
            default:
                System.out.println("ERROR: STATE CODE NOT RECOGNIZED");
                break;
        }

        for (AddOn a : addOns) {
            if (a.applies(items)) {
                if (a instanceof SecondaryHeading) {
                    receipt = new PreDecorator(a, receipt);
                }
                if (a instanceof Rebate || a instanceof Coupon) {
                    receipt = new PostDecorator(a, receipt);
                }
            }
        }
        return receipt;
    }

    private void readConfigFile() {

        try {
            Scanner configFile;
            configFile = new Scanner(new File(System.getProperty("user.dir") + "/" + "config.txt"));
            header = configFile.nextLine();
            state_code = configFile.nextLine();
            configFile.close();
        } catch (IOException i) {
            System.out.println("**READ CONFIG FILE ERROR**: " + i.getMessage());
        }
    }
}
