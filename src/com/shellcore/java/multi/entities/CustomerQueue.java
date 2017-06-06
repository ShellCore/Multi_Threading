package com.shellcore.java.multi.entities;

import com.shellcore.java.multi.entities.Customer;

import java.util.LinkedList;

/**
 * Created by Cesar. 06/06/2017.
 */
public class CustomerQueue {
    private static LinkedList<Customer> customerQueue1 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue2 = new LinkedList<>();

    public CustomerQueue() {
    }

    public static void enterCustomer(int queue, Customer customer) {
        if (queue == 0) {
            customerQueue1.add(customer);
        } else {
            customerQueue2.add(customer);
        }
    }

    public static Customer attendCustomer(int queue) {
        if (queue == 0) {
            if (customerQueue1.size() > 0) {
                return customerQueue1.removeFirst();
            }
            return null;
        }
        if (customerQueue2.size() > 0) {
            return customerQueue2.removeFirst();
        }
        return null;
    }

    @Override
    public String toString() {
        return "\tQueue 1: " + customerQueue1
                + "\n\tQueue 2: " + customerQueue2;
    }
}
