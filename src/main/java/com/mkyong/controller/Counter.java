package com.mkyong.controller;

/**
 * Created by tiborb on 10/5/16.
 */
public class Counter {

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Counter(int counter) {
        System.out.println("Counter constructor");
        this.counter = counter;
    }

    public void increase(){
        counter++;
    }
    private int counter;
}
