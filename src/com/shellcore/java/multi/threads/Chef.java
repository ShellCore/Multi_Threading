package com.shellcore.java.multi.threads;

import com.shellcore.java.multi.entities.FoodStock;

import java.util.Random;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Chef extends Thread {

    private static final int BURGUER = 0;
    private static final int SANDWICH = 1;
    private static final int SALAD = 2;

    Random randomGenerator = new Random();

    private boolean threadAlive = true;

    public Chef() {
    }

    public void end() {
        this.threadAlive = false;
    }

    @Override
    public void run() {
        int timeToCook = 0;
        int wichFood = 0;
        while (this.threadAlive) {
            timeToCook = 2000 + (1000 * randomGenerator.nextInt(3));

            try {
                this.sleep(timeToCook);

                wichFood = randomGenerator.nextInt(3);
                System.out.print("Chef on " + (timeToCook / 1000) + " seconds cooked a ");
                switch (wichFood) {
                    case BURGUER :
                        FoodStock.cookSellBurguer(FoodStock.COOK);
                        System.out.println("burguer");
                        break;
                    case SANDWICH :
                        FoodStock.cookSellSandwich(FoodStock.COOK);
                        System.out.println("sandwich");
                        break;
                    case SALAD :
                        FoodStock.cookSellSalad(FoodStock.COOK);
                        System.out.println("salad");
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println("Chef interrupted");
            }
        }
    }
}
