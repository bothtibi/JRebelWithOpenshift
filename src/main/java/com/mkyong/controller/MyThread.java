package com.mkyong.controller;

/**
 * Created by tiborb on 10/11/16.
 */
public class MyThread implements Runnable{

    private int delay = 1000;

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread iteration: " + i + ", delay: " + delay);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
