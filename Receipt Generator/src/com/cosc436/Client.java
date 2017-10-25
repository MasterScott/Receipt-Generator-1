package com.cosc436;

import com.cosc436.Interfaces.Receipt;
import com.cosc436.Items_And_Receipts.PurchasedItems;
import com.cosc436.Items_And_Receipts.ReceiptFactory;
import com.cosc436.Items_And_Receipts.StoreItem;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Client {
    private static PurchasedItems items;
    private static Calendar date;

    public static void main(String[] args) {
        String menuPrompt = "1 – Start New Receipt\n" + "2 – Add Items\n" + "3 – Display Receipt\n" + "0 – EXIT";
        String inputPrompt = "Please enter your option:";
        String monthPrompt = "Please enter the current month (1-12):";
        String dayPrompt = "Please enter the current day (1-31):";
        String yearPrompt = "Please enter the current year (YYYY):";
        String itemPrompt = "Select Item to add:";
        StoreItem phone = new StoreItem(1273, "Phone", 725.25);
        StoreItem computer = new StoreItem(1406, "Computer", 999.99);
        StoreItem mouse = new StoreItem(9759, "Mouse", 25.00);
        StoreItem keyboard = new StoreItem(6781, "Keyboard", 50.00);
        String itemsAvailable = "1 - Phone........$725.25\n2 - Computer.....$999.99\n3 - Mouse.........$25.00\n4 - Keyboard......$50.00\n0 - EXIT";
        Scanner console = new Scanner(System.in);

        ReceiptFactory factory = null;
        boolean exit = false;
        do {

            int selection = menu(menuPrompt, inputPrompt, 0, 8);
            switch (selection) {

                case 1: //1 – Start New Receipt
                    factory = new ReceiptFactory();
                    items = new PurchasedItems();
                    int month = (getIntRange(console, monthPrompt, 12, 1) - 1);
                    int day = getIntRange(console, dayPrompt, 31, 1);
                    int year = getIntRange(console, yearPrompt, 9999, 1900);
                    date = new GregorianCalendar(year, month, day);

                    break;

                case 2: //2 – Add Items
                    boolean itemExit = false;
                    do {
                        int itemSelection = menu(itemsAvailable, itemPrompt, 0, 4);
                        switch (itemSelection) {
                            case 1: //Phone
                                items.addItem(phone);
                                System.out.println("Phone Added");
                                break;

                            case 2: //Computer
                                items.addItem(computer);
                                System.out.println("Computer Added");
                                break;

                            case 3: // Mouse
                                items.addItem(mouse);
                                System.out.println("Mouse Added");
                                break;

                            case 4: // Keyboard
                                items.addItem(keyboard);
                                System.out.println("Keyboard Added");
                                break;

                            case 0:
                                itemExit = true;
                                break;

                        }

                    } while (!itemExit);

                    break;

                case 3: //3 – Display Receipt
                    if (factory != null) {
                        Receipt receipt = factory.getReceipt(items, date);
                        receipt.prtReceipt();
                    }
                    break;

                case 0: //0 - EXIT
                    exit = true;

                    break;
            }
        } while (!exit);

    }

    private static int getInt(Scanner input, String prompt) {
        System.out.println(prompt);
        while (!input.hasNextInt()) {
            input.next();//consume
            System.out.println("Not an integer. Try again!");
            System.out.println(prompt);
        }
        return input.nextInt();
    }

    private static int getIntRange(Scanner input, String prompt, int MAX, int LOW) {
        int x = getInt(input, prompt);
        while (x > MAX || x < LOW) {

            System.out.println("INPUT ERROR!!! Invalid Item.");
            x = getInt(input, prompt);
        }
        return x;
    }

    private static int menu(String menuOptions, String inputPrompt, int min, int max) {
        System.out.println("\nYour options are:\n-----------------");
        System.out.println(menuOptions);
        Scanner console = new Scanner(System.in);
        int input = getInt(console, inputPrompt);
        while (min > input || input > max) {
            System.out.println(input + " is not a valid option");
            input = getInt(console, inputPrompt);
        }
        return input;
    }
}