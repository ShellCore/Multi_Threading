package com.shellcore.java.multi.threads;

import com.shellcore.java.multi.entities.Customer;
import com.shellcore.java.multi.entities.CustomerQueue;
import com.shellcore.java.multi.entities.FoodStock;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Attender extends Thread {

    private int wichQueue;
    private boolean threadAlive = true;

    public Attender(int wichQueue) {
        this.wichQueue = wichQueue;
    }

    public void attend(Customer customer) {
        boolean sold = true;
        int wait = 0;
        while (sold) {
            switch (customer.desiredFood) {
                case "burguer" :
                    if (FoodStock.cookSellBurguer(FoodStock.SELL)) {
                        sold = false;
                    }
                    break;
                case "sandwich" :
                    if (FoodStock.cookSellSandwich(FoodStock.SELL)) {
                        sold = false;
                    }
                    break;
                case "salad" :
                    if (FoodStock.cookSellSalad(FoodStock.SELL)) {
                        sold = false;
                    }
                    break;
            }
            if (sold) {
                try {
                    this.sleep(1000);
                    wait++;
                } catch (InterruptedException e) {
                    System.out.println("Attender interrupted wait food");
                }
            }
        }
        String message = "Customer #" + (customer.id + 1) +
                " buy a " + customer.desiredFood +
                " and in " + (customer.timeToDecide / 1000) +
                " seconds and wait for food " + wait +
                " seconds";
        System.out.println(message);
    }

    public void end() {
        this.threadAlive = false;
    }

    @Override
    public void run() {
        int timeToDecide = 0;
        Customer customer;

        while(this.threadAlive) {
            customer = CustomerQueue.attendCustomer(this.wichQueue);

            if (customer != null) {
                try {
                    this.sleep(customer.timeToDecide);
                    this.attend(customer);
                } catch (InterruptedException e) {
                    System.out.println("Attender interrupted");
                }
            } else {
                try {
                    this.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Attender interrupted");
                }
            }
        }
    }
}
