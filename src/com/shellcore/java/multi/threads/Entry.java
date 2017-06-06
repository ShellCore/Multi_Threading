package com.shellcore.java.multi.threads;

import com.shellcore.java.multi.entities.Customer;
import com.shellcore.java.multi.entities.CustomerQueue;

import java.util.Random;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Entry extends Thread {

    private static final int BURGER = 0;
    private static final int SANDWICH = 1;
    private static final int SALAD = 2;

    private static int ids;
    private boolean threadAlive = true;

    Random randomGenerator = new Random();

    public Entry() {
    }

    public void entry(int timeCustomerEnter) {
        int wichQueue = randomGenerator.nextInt(2);
        int wichFood = randomGenerator.nextInt(3);
        int timeToDecide = 1000 + (1000 * randomGenerator.nextInt(3));
        String foodName = "";

        switch (wichFood) {
            case BURGER :
                foodName = "burguer";
                break;
            case SANDWICH :
                foodName = "sandwich";
                break;
            case SALAD :
                foodName = "salad";
                break;
        }

        CustomerQueue.enterCustomer(wichQueue, new Customer(ids++, timeToDecide, foodName));

        String message = "Customer #" + ids +
                " enters " + (timeCustomerEnter / 1000) +
                " seconds later to queue " + (wichQueue + 1) +
                ".";

        System.out.println(message);
    }

    public void end() {
        this.threadAlive = false;
    }

    @Override
    public void run() {
        int timeCustomerEnter = 0;

        while (this.threadAlive) {
            timeCustomerEnter = 1000 + (1000 * randomGenerator.nextInt(3));

            try {
                this.sleep(timeCustomerEnter);
                this.entry(timeCustomerEnter);
            } catch (InterruptedException e) {
                System.out.println("Entry interrupted");
            }
        }
    }
}
