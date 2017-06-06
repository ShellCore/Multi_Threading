package com.shellcore.java.multi.entities;

/**
 * Created by Cesar. 06/06/2017.
 */
public class Customer {
    public int id;
    public int timeToDecide;
    public String desiredFood;

    public Customer(int id, int timeToDecide, String desiredFood) {
        this.id = id;
        this.timeToDecide = timeToDecide;
        this.desiredFood = desiredFood;
    }

    @Override
    public String toString() {
        return "Customer #" + this.id;
    }
}
