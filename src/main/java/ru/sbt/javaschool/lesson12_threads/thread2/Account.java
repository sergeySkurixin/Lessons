package ru.sbt.javaschool.lesson12_threads.thread2;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }


}
