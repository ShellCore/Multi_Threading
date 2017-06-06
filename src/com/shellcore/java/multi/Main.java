package com.shellcore.java.multi;

import com.shellcore.java.multi.threads.Attender;
import com.shellcore.java.multi.threads.Chef;
import com.shellcore.java.multi.threads.Entry;

import java.util.Scanner;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String useroutput;

        Chef chef = new Chef();
        Entry comingCustomers = new Entry();
        Attender attender1 = new Attender(0);
        Attender attender2 = new Attender(1);

        chef.start();
        comingCustomers.start();
        attender1.start();
        attender2.start();

        // Stop with any key, except just Enter
        while(true) {
            useroutput = input.next();
            chef.end();
            comingCustomers.end();
            attender1.end();
            attender2.end();
            System.exit(0);
        }
    }
}
