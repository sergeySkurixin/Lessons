package ru.sbt.javaschool.lesson12_threads.thread2;

/**
 * Created by SBTJavastudent on 15.09.2016.
 */
public class AccountExample implements Runnable {
    private Account acct = new Account();

    public synchronized /* если убрать, будет больно */void makeWithdrawal(int amt) throws InterruptedException {
//        if (acct.getBalance() >= amt) {
//            Thread.sleep(100);
//            acct.withdraw(amt);
//        }
        synchronized (this) {
            if (acct.getBalance() >= amt) {
                Thread.sleep(100);
                acct.withdraw(amt);
            }
        }
    }

    @Override
    public void run() {
        for (int x = 0; x < 10; x++) {
            try {
                makeWithdrawal(10);
                if (acct.getBalance() < 0) {
                    System.out.println("account is overdrawn!");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
