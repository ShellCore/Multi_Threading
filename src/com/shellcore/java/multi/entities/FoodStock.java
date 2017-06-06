package com.shellcore.java.multi.entities;

/**
 * Created by Cesar. 06/06/2017.
 */
public final class FoodStock {

    public static final String COOK = "cook";
    public static final String SELL = "sell";

    private static int burguer;
    private static int sandwich;
    private static int salad;

    public FoodStock() {
    }

    public static synchronized boolean cookSellBurguer(String action) {
        if (action.equals(COOK)) {
            burguer++;
            return true;
        } else if (action.equals(SELL)) {
            if (burguer > 0) {
                burguer--;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean cookSellSandwich(String action) {
        if (action.equals(COOK)) {
            sandwich++;
            return true;
        } else if (action.equals(SELL)) {
            if (sandwich > 0) {
                sandwich--;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean cookSellSalad(String action) {
        if (action.equals(COOK)) {
            salad++;
            return true;
        } else if (action.equals(SELL)) {
            if (salad > 0) {
                salad--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "\tFood stock {burguer: " + burguer
                + "sandwich: " + sandwich
                + "salad:" + salad
                + "}";
    }
}
