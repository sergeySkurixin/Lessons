package sbt.javaschool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by SBTJavastudent on 24.09.2016.
 */
public class ServletContainer {

    public static final int NUMBER_OF_THREADS = 1000;

    private ScheduledExecutorService executorService;
    private Servlet servlet = new Servlet();

    public static void main(String[] args) throws InterruptedException {
        ServletContainer container = new ServletContainer();
        container.start();

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            container.newUserRequest();
        }
        System.out.println("Started!");
        TimeUnit.SECONDS.sleep(5);
        container.stop();
        System.out.println(container.servlet.counter);
    }

    public void newUserRequest() {
        executorService.submit(servlet::handle);
    }

    public void stop() throws InterruptedException {
        //executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        executorService.shutdown();
    }

    private void start() {
//        executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        executorService = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
        executorService.scheduleWithFixedDelay(()-> System.out.println("tick"),0,1,TimeUnit.SECONDS);

    }
}

class Servlet {
    AtomicLong counter = new AtomicLong();

    public void handle() {
        //todo:
        //организовать счетчик, сколько клиентов к нам пришло

        //Вариант 1. Синхронизация


        //Вариант 2. Атомики
        counter.incrementAndGet();
    }
}
