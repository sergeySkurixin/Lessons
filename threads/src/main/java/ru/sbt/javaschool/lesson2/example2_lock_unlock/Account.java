package ru.sbt.javaschool.lesson2.example2_lock_unlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SBTJavastudent on 17.09.2016.
 */
public class Account {
    long balance;
    ReentrantLock lock = new ReentrantLock();

    public Account(long balance) {
        lock.lock();
//        lock.lockInterruptibly();

        try {
            this.balance = balance;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(long amount) {
        balance = balance - amount;
    }
}
